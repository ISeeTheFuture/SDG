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
		List<ResView> listTmp = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectResView");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, spcNo);
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				ResView rvTmp = new ResView();
				rvTmp.setResGroupNo(rset.getInt("res_group_no"));
				rvTmp.setMemId(rset.getString("mem_id"));
				rvTmp.setResMany(rset.getInt("res_many"));
				rvTmp.setResName(rset.getString("res_name"));
				rvTmp.setResPhone(rset.getString("res_phone"));
				rvTmp.setResEmail(rset.getString("res_email"));
				rvTmp.setResContent(rset.getString("res_content"));
				Timestamp resTimeStart = rset.getTimestamp("res_time");
				rvTmp.setResTimeStart(resTimeStart);
				
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(resTimeStart.getTime());
				cal.add(Calendar.SECOND, 3600);
				
				Timestamp resTimeEnd = new Timestamp(cal.getTime().getTime()); 
				rvTmp.setResTimeEnd(resTimeEnd);
				
				listTmp.add(rvTmp);
				
			}
			int idx = 0;
			for(int i = 0; i < listTmp.size(); i++) {
				if(i == 0) {
					list.add(listTmp.get(i));
				}
				else if(list.get(idx).getResGroupNo()==listTmp.get(i).getResGroupNo()) {
					ResView tmp = new ResView();
					tmp = list.get(idx);
					tmp.setResTimeEnd(listTmp.get(i).getResTimeEnd());
					list.set(idx, tmp);
				}
				else {
					list.add(listTmp.get(i));
					idx++;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("list@ResDAO : "+list.toString());
		return list;
	}

	public List<ResView> selectResUpdateView(Connection conn, String memId) {
		List<ResView> list = new ArrayList<>();
		List<ResView> listTmp = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectResUpdateView");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memId);
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				ResView rvTmp = new ResView();
				rvTmp.setResGroupNo(rset.getInt("res_group_no"));
				rvTmp.setMemId(rset.getString("mem_id"));
				rvTmp.setResMany(rset.getInt("res_many"));
				rvTmp.setResName(rset.getString("res_name"));
				rvTmp.setResPhone(rset.getString("res_phone"));
				rvTmp.setResEmail(rset.getString("res_email"));
				rvTmp.setResContent(rset.getString("res_content"));
				Timestamp resTimeStart = rset.getTimestamp("res_time");
				rvTmp.setResTimeStart(resTimeStart);
				
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(resTimeStart.getTime());
				cal.add(Calendar.SECOND, 3600);
				
				Timestamp resTimeEnd = new Timestamp(cal.getTime().getTime()); 
				rvTmp.setResTimeEnd(resTimeEnd);
				
				listTmp.add(rvTmp);
				
			}
			int idx = 0;
			for(int i = 0; i < listTmp.size(); i++) {
				if(i == 0) {
					list.add(listTmp.get(i));
				}
				else if(list.get(idx).getResGroupNo()==listTmp.get(i).getResGroupNo()) {
					ResView tmp = new ResView();
					tmp = list.get(idx);
					tmp.setResTimeEnd(listTmp.get(i).getResTimeEnd());
					list.set(idx, tmp);
				}
				else {
					list.add(listTmp.get(i));
					idx++;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("list@ResDAO : "+list.toString());
		return list;
	}
		

}
