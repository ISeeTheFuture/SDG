package member.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import member.model.vo.Member;
import member.model.vo.MemberBusi;
import member.model.vo.Memberblk;
import review.model.vo.ReviewReport;

public class MemberDAO {

	private Properties prop = new Properties();

	public MemberDAO() {

		String fileName = MemberDAO.class.getResource("/sql/member/member-query.properties").getPath();
		System.out.println("fileName@MemberDAO=" + fileName);

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
		System.out.println("query=" + query);

		try {
			// 1.미완성쿼리객체 생성
			pstmt = conn.prepareStatement(query);
			// 2.미완성쿼리 값대입
			pstmt.setString(1, memberId);

			// 3.실행
			rset = pstmt.executeQuery();

			while (rset.next()) {
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
		System.out.println(query);
		try {
			// 미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			// 쿼리문미완성:패스워드 암호화 이후
			pstmt.setString(1, member.getMemName());
			pstmt.setInt(2, member.getMemGender());

			pstmt.setString(3, member.getMemEmail());
			pstmt.setString(4, member.getMemPhone());
			pstmt.setString(5, member.getMemAddr());
			pstmt.setString(6, member.getMemId());

			// 쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			// DML은 executeUpdate()
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
			// 미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			// 쿼리문미완성
			pstmt.setString(1, member.getMemPass());
			pstmt.setString(2, member.getMemId());

			// 쿼리문실행 : 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			// DML은 executeUpdate()
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
		String query = prop.getProperty("UpdateMemberBusi");
		System.out.println(query);
		try {

			// 사업자 등록 할때, 이미 insert를 한번 처리 해서, update로 교정함 김원재 2020 02 12 17:00
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberBusi.getMemBusiAddr());
			pstmt.setString(2, memberBusi.getMemBusiPhone());

			pstmt.setString(3, memberBusi.getMemId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println(result);
		return result;
	}

	public int banMember(Connection conn, String ignoId, String ignReason) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("MemberIgnore");
		System.out.println("ignoId@DAO=" + ignoId);
		System.out.println("ignoReason@DAO=" + ignReason);
		System.out.println("banMemberQuery@DAO=" + query);
		try {

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, ignoId);
			pstmt.setString(2, ignReason);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int RoleUpMember(Connection conn, String memRoleId) {

		int result = 0;
		PreparedStatement pstmt = null;

		String query = prop.getProperty("MemberRoleUp");
		String query2 = prop.getProperty("MemberRoleUpInMemberbusiTable");
		System.out.println(query);
		System.out.println("memROleId@DAO" + memRoleId);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memRoleId);
			pstmt = conn.prepareStatement(query2);
			pstmt.setString(1, memRoleId);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(pstmt);
		}
		return result;
	}

	public Memberblk IgnoreCheckselectOne(Connection conn, String memberId) {

		Memberblk mb = new Memberblk();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("IgnoreCheckselectOne");
		System.out.println("query=" + query);

		try {
			// 1.미완성쿼리객체 생성
			pstmt = conn.prepareStatement(query);
			// 2.미완성쿼리 값대입
			pstmt.setString(1, memberId);

			// 3.실행
			rset = pstmt.executeQuery();

			while (rset.next()) {

				mb.setMem_memo(rset.getString("block_memo"));
				mb.setMem_id(rset.getString("mem_id"));
				mb.setBlock_write(rset.getDate("block_write"));
				mb.setBlock_comment(rset.getDate("block_comment"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

//		if(ignoreReason==null) {
//			
//			ignoreReason="";
//		}

		return mb;
	}

	public MemberBusi SelectOneMemberBusi(Connection conn, String memberId) {
		MemberBusi m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectOneMemberBusi");
		System.out.println("query=" + query);

		try {
			// 1.미완성쿼리객체 생성
			pstmt = conn.prepareStatement(query);
			// 2.미완성쿼리 값대입
			pstmt.setString(1, memberId);

			// 3.실행
			rset = pstmt.executeQuery();

			while (rset.next()) {
				m = new MemberBusi();
				m.setMemId(rset.getString("mem_id"));
				m.setMemBusiAddr(rset.getString("mem_buis_addr"));
				m.setMemBusiPhone(rset.getString("mem_buis_phone"));
				m.setMemBusiNo(rset.getString("mem_buis_no"));
				m.setMemBusiAllow(rset.getString("mem_Buis_Allow"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return m;
	}

	public int ApplyRoleUp(Connection conn, String a) {

		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("ApplyRoleUp");
		System.out.println(query);
		try {

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, a);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public List<Member> selectApplyRoleupMember(Connection conn) {

		List<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = prop.getProperty("SelectApplyRoleUp");

		try {
			// 미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);

			// 시작 rownum과 마지막 rownum 구하는 공식

			// 쿼리문실행
			// 완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Member m = new Member();
				// 컬럼명은 대소문자 구분이 없다.
				m.setMemId(rset.getString("mem_id"));
				m.setMemName(rset.getString("mem_name"));
				m.setMemRole(rset.getString("mem_role"));
				m.setMemPoint(rset.getInt("mem_point"));
				m.setMemGradeName(rset.getInt("mem_grade_name"));
				m.setMemGender(rset.getInt("mem_gender"));
				m.setMemEmail(rset.getString("mem_email"));
				m.setMemPhone(rset.getString("mem_phone"));
				m.setMemAddr(rset.getString("mem_addr"));
				m.setMemDate(rset.getDate("mem_date"));
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;

	}

	public int PermitApplyRoleUp(Connection conn, String a) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("PermitApplyRoleUp");
		System.out.println(query);
		try {

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, a);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public List<Member> MemberSelectAll(Connection conn) {
		List<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectAllMember");
		
		try{
			//미완성쿼리문을 가지고 객체생성. 
			pstmt = conn.prepareStatement(query);
			
			//쿼리문실행
			//완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			rset = pstmt.executeQuery();
			System.out.println(query);
			System.out.println(rset);
			while(rset.next()){
				Member b = new Member();
//				System.out.println("DAO에서 나오나? 넘버"+b.getReviewNo());
				//컬럼명은 대소문자 구분이 없다.
				b.setMemId(rset.getString("mem_id"));
				b.setMemName(rset.getString("mem_name"));
				b.setMemRole(rset.getString("mem_role"));
				b.setMemAdmin(rset.getString("mem_admin"));
				b.setMemPoint(rset.getInt("mem_point"));
				b.setMemGender(rset.getInt("mem_gender"));
				b.setMemEmail(rset.getString("mem_email"));
				b.setMemPhone(rset.getString("mem_phone"));
				b.setMemAddr(rset.getString("mem_addr"));
				list.add(b);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		
		return list;
		
		


	}

}
