package member.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import member.model.vo.Member;

import member.model.vo.MemberBusi;
import review.model.vo.ReviewRpt;

public class MemberDAO {
	
	private Properties prop = new Properties();
	
	public MemberDAO() {
		
		String fileName = MemberDAO.class.getResource("/sql/member/member-query.properties")
										 .getPath();
		System.out.println("fileName@MemberDAO="+fileName);
				
		try {
			
			prop.load(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public Member selectOne(Connection conn, String memberId) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectOne");
		System.out.println("query="+query);
		
		try {
			//1.미완성쿼리객체 생성
			pstmt = conn.prepareStatement(query);
			//2.미완성쿼리 값대입
			pstmt.setString(1, memberId);
			
			//3.실행
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				m = new Member();
				m.setMemId(rset.getString("mem_id"));
				m.setMemPass(rset.getString("mem_pass"));
				m.setMemName(rset.getString("mem_name"));
				m.setMemRole(rset.getString("mem_role"));
				m.setMemAdmin(rset.getString("mem_admin"));
				m.setMemPoint(rset.getInt("mem_point"));
				m.setMemGender(rset.getInt("mem_gender"));
				m.setMemBirth(rset.getDate("mem_birth"));
				m.setMemEmail(rset.getString("mem_email"));
				m.setMemPhone(rset.getString("mem_phone"));
				m.setMemAddr(rset.getString("mem_addr"));
				m.setMemDate(rset.getDate("mem_date"));
				m.setMemRest(rset.getDate("mem_rest"));
				m.setMemLastLogin(rset.getDate("mem_lastLogin"));
				m.setMemGradeName(rset.getInt("mem_grade_name"));
				m.setIgnoreOn(rset.getInt("mem_grade_name"));

			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		} 
		
		return m;
	}

	public int insertMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemId());
			pstmt.setString(2, member.getMemPass());
			pstmt.setString(3, member.getMemName());
			pstmt.setInt(4, member.getMemGender());
			pstmt.setDate(5, member.getMemBirth());
			pstmt.setString(6, member.getMemEmail());
			pstmt.setString(7, member.getMemPhone());
			pstmt.setString(8, member.getMemAddr());

			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	

	public int updateMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateMember"); 

		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성:패스워드 암호화 이후
			pstmt.setString(1, member.getMemName());
			pstmt.setInt(2, member.getMemGender());
			
			pstmt.setString(3, member.getMemEmail());
			pstmt.setString(4, member.getMemPhone());
			pstmt.setString(5, member.getMemAddr());
			pstmt.setString(6, member.getMemId());
			
			//쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			//DML은 executeUpdate()
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	

	public int updatePassword(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updatePassword"); 

		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
			pstmt.setString(1, member.getMemPass());
			pstmt.setString(2, member.getMemId());
			
			//쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			//DML은 executeUpdate()
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	public int updatePoint(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updatePoint"); 
System.out.println(query);
		try {

			pstmt = conn.prepareStatement(query);
	
				
			pstmt.setInt(1, member.getMemGradeName());
			pstmt.setInt(2, member.getMemPoint());
			pstmt.setString(3, member.getMemId());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	

	public int insertMemberBusi(Connection conn, MemberBusi memberBusi) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertMemberBusi");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberBusi.getMemId());
			pstmt.setInt(2, memberBusi.getMemBusiNo());
			pstmt.setString(3, memberBusi.getMemBusiAddr());
			pstmt.setString(4, memberBusi.getMemBusiPhone());
			pstmt.setString(5, memberBusi.getMemBusiAllow());
						
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertReviewRpt(Connection conn, ReviewRpt reviewRpt) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertReviewRpt");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewRpt.getReviewReportNo());
			pstmt.setInt(2, reviewRpt.getReviewNo());
			pstmt.setString(3, reviewRpt.getReviewReportReason());
			pstmt.setDate(4, reviewRpt.getReviewReportDate());
			pstmt.setInt(5, reviewRpt.getReviewNo());
						
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
