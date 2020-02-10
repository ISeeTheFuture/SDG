package res.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import res.model.vo.Res;
import res.model.vo.ResGrp;
import res.model.vo.ResView;

public class ResDAO {

	private Properties prop = new Properties();
	public ResDAO() {
		
		String fileName = ResDAO.class.getResource("/sql/res/res-query.properties").getPath();
		

		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertRes(Connection conn, Res res) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertRes");
		int result = 0;
		
		try {
			// 1. pstmt 객체 생성
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1,  res.getMemberId());
			pstmt.setInt(2,  res.getSpcNo());
			pstmt.setInt(3,  res.getResMany());
			pstmt.setString(4,  res.getResName());
			pstmt.setString(5,  res.getResPhone());
			pstmt.setString(6,  res.getResEmail());
			pstmt.setString(7,  res.getResContent());
						
			// 2. 실행
			result = pstmt.executeUpdate();
//			System.out.println("insertRes@ResDao="+result);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 3. 자원반납
			close(pstmt);
		}
		
		return result;
	}


	public int insertResGrp(Connection conn, List<ResGrp> list) {

		
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertResGrp");
		int result = 0;
		
		System.out.println("리스트 받아라~"+list.toString());
		try {
			for(int i = 0; i < list.size(); i++) {
				// 1. pstmt 객체 생성
				pstmt = conn.prepareStatement(query);
				
				pstmt.setInt(1,  list.get(i).getResGroupNo());
				pstmt.setTimestamp(2, list.get(i).getResTime());
				
				// 2. 실행
				result += pstmt.executeUpdate();
//				System.out.println("insertResGrp@ResDao="+result);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 3. 자원반납
			close(pstmt);
		}
		
		if(result == list.size()) result = 1;
		else result = 0;
		
		return result;
		
	}

	public int selectLastResGrpNo(Connection conn) {
		int resGrpNo = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectResGrpNo");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next())
				resGrpNo = rset.getInt("RESGRPNO");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return resGrpNo;
	}

	public List<ResView> selectResView(Connection conn, int spcNo) {
		List<ResView> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectResView");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, spcNo);
			rset = pstmt.executeQuery();
			
			ResView rv = new ResView();
			ResView rvTmp = new ResView();
			int onehang = 0; // 자료가 행이 바뀌지 않고 끝나는지 확인
			rvTmp.setResGroupNo(-1);
			
			while(rset.next()) {
				if(rvTmp.getResGroupNo()==-1) { // 완전히 자료의 시작일 때
					rv.setResGroupNo(rset.getInt("res_group_no"));
					rv.setMemId(rset.getString("mem_id"));
					rv.setResMany(rset.getInt("res_many"));
					rv.setResName(rset.getString("res_name"));
					rv.setResPhone(rset.getString("res_phone"));
					rv.setResEmail(rset.getString("res_email"));
					rv.setResContent(rset.getString("res_content"));
					rv.setResTimeStart(rset.getTimestamp("res_time"));
					rv.setResTimeEnd(rset.getTimestamp("res_time")); // +한시간 필요
					
					rvTmp.setResGroupNo(rset.getInt("res_group_no"));
//					System.out.println("1번말~~");
				}
						
				else if(rvTmp.getResGroupNo()!=rv.getResGroupNo()) { //행이 바뀌었을 때
					rv.setResTimeEnd(rvTmp.getResTimeEnd());
					list.add(rv);
//					System.out.println("list@ResDAO : "+list.toString());
					rv = new ResView();
					rv.setResGroupNo(rset.getInt("res_group_no"));
					rv.setMemId(rset.getString("mem_id"));
					rv.setResMany(rset.getInt("res_many"));
					rv.setResName(rset.getString("res_name"));
					rv.setResPhone(rset.getString("res_phone"));
					rv.setResEmail(rset.getString("res_email"));
					rv.setResContent(rset.getString("res_content"));
					Timestamp resTimeStart = rset.getTimestamp("res_time");
					rv.setResTimeStart(resTimeStart);
					
					Calendar cal = Calendar.getInstance();
					cal.setTimeInMillis(resTimeStart.getTime());
					cal.add(Calendar.SECOND, 3600);
					
					Timestamp resTimeEnd = new Timestamp(cal.getTime().getTime()); 
					rv.setResTimeEnd(resTimeEnd);
					 
					rvTmp.setResGroupNo(rset.getInt("res_group_no")); // 임시 객체에 그룹넘버 저장
					
					onehang++;
					
//					System.out.println("2번말~~");

				} else { // 첫 행이 아닐때
					rvTmp.setResTimeEnd(rv.getResTimeEnd());
					Timestamp resTimeStart = rset.getTimestamp("res_time");
					Calendar cal = Calendar.getInstance();
					cal.setTimeInMillis(resTimeStart.getTime());
					cal.add(Calendar.SECOND, 3600);
					Timestamp resTimeEnd = new Timestamp(cal.getTime().getTime());
					
					rv.setResTimeEnd(resTimeEnd);
					rvTmp.setResGroupNo(rset.getInt("res_group_no")); // 임시 객체에 그룹넘버 저장
					
//					System.out.println("3번말~~");
					onehang = 0;
				}
				
				
			}
			if(onehang==0) {
				list.add(rv);
//				System.out.println("4번말~~");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
//		System.out.println("list@ResDAO : "+list.toString());
		return list;
	}
		

}
