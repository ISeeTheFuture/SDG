package res.model.dao;

import static common.JDBCTemplate.*;

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
import res.model.vo.ResMeView;
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
		
//		System.out.println("list@ResDAO"+list.toString());
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
//		System.out.println("list@ResDAO : "+list.toString());
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
//		System.out.println("list@ResDAO : "+list.toString());
		return list;
	}

	public ResView selectResOneGrp(Connection conn, int resGroupNo) {
		List<ResView> list = new ArrayList<>();
		List<ResView> listTmp = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectResOneGrp");
		ResView resGrp = new ResView();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, resGroupNo);
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
			resGrp = list.get(0);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return resGrp;
	}

	public int deleteResOneGrp(Connection conn, int resGroupNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteResOneGrp");
		
		try {
			// 1. pstmt 객체 생성
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1,  resGroupNo);
						
			// 2. 실행
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 3. 자원반납
			close(pstmt);
		}
		
		return result;
	}

	public int deleteResOne(Connection conn, int resGroupNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteResOne");
		
		try {
			// 1. pstmt 객체 생성
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1,  resGroupNo);
						
			// 2. 실행
			result = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 3. 자원반납
			close(pstmt);
		}
		
		return result;
	}

	public Res selectResOne(Connection conn, int resGroupNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectResOne");
		Res res = new Res();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, resGroupNo);
			rset = pstmt.executeQuery();
			
			
			if(rset.next()) {
				res.setResGroupNo(rset.getInt("res_group_no"));
				res.setMemberId(rset.getString("mem_id"));
				res.setSpcNo(rset.getInt("spc_no"));
				res.setResName(rset.getString("res_name"));
				res.setResPhone(rset.getString("res_phone"));
				res.setResEmail(rset.getString("res_email"));
				res.setResContent(rset.getString("res_content"));
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return res;
	}

	public List<ResMeView> selectResMeView(Connection conn, String memId) {
		List<ResMeView> list = new ArrayList<>();
		List<ResMeView> listTmp = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectResMeView");
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memId);
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				ResMeView rvTmp = new ResMeView();
				rvTmp.setResGroupNo(rset.getInt("res_group_no"));
				rvTmp.setMemId(rset.getString("mem_id"));
				rvTmp.setResMany(rset.getInt("res_many"));
				rvTmp.setResName(rset.getString("res_name"));
				rvTmp.setResNo(rset.getInt("res_no"));
				rvTmp.setResCancle(rset.getInt("res_cancle"));

				Timestamp resTimeStart = rset.getTimestamp("res_time");
				rvTmp.setResTimeStart(resTimeStart);
				
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(resTimeStart.getTime());
				cal.add(Calendar.SECOND, 3600);
				
				Timestamp resTimeEnd = new Timestamp(cal.getTime().getTime()); 
				rvTmp.setResTimeEnd(resTimeEnd);
				
				rvTmp.setSpcPrice(rset.getInt("spc_price_price"));
				rvTmp.setSpcName(rset.getString("spc_name"));
				
				String tmpImgs = rset.getString("spc_img_title");
				String[] tmpImg = tmpImgs.split(",");
				rvTmp.setSpcImgTitle(tmpImg[0]);
				
				rvTmp.setSpcNo(rset.getInt("spc_no"));
				rvTmp.setSpcDtlNo(rset.getInt("spc_detail_no"));
				
				listTmp.add(rvTmp);
				
			}
			int idx = 0;
			
			for(int i = 0; i < listTmp.size(); i++) {
				if(i == 0) {
					list.add(listTmp.get(i));
				}
				else if(list.get(idx).getResGroupNo()==listTmp.get(i).getResGroupNo()) {
					ResMeView tmp = new ResMeView();
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
		System.out.println("resMeViewlist@ResDAO : "+list.toString());
		return list;
	}
		

}
