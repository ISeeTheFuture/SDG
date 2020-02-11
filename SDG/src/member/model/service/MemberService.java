package member.model.service;

import java.sql.Connection;

import member.model.dao.MemberDAO;
import member.model.vo.Member;
import static common.JDBCTemplate.*;




import java.sql.Connection;

import member.model.dao.MemberDAO;
import member.model.vo.Member;

import member.model.vo.MemberBusi;


import static common.JDBCTemplate.*;

public class MemberService {

	public static final String USER_MEMBER_ROLE = "U";
	public static final String ADMIN_MEMBER_ROLE = "A";

	public Member selectOne(String memberId) {
		Connection conn = getConnection();
		Member m = new MemberDAO().selectOne(conn, memberId);
		close(conn);
		return m;
	}

	public int insertMember(Member member) {
		Connection conn = getConnection();
		int result = new MemberDAO().insertMember(conn, member);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	public int updateMember(Member member) {
		Connection conn = getConnection();
		int result = new MemberDAO().updateMember(conn, member);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int updatePassword(Member member) {
		Connection conn = getConnection();
		int result = new MemberDAO().updatePassword(conn, member);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	//수정용
//	public int updatePoint(Member member) {
//		Connection conn = getConnection();
//		int result = new MemberDAO().updatePoint(conn, member);
//		if (result > 0)
//			commit(conn);
//		else
//			rollback(conn);
//		close(conn);
//		return result;
//	}

	public int updateMemberPoint(Member member) {
		Connection conn = getConnection();
		int result = new MemberDAO().updatePoint(conn, member);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);

		return result;
	}


	public int insertMemberBusi(MemberBusi memberBusi) {
		Connection conn = getConnection();
		int result = new MemberDAO().insertMemberBusi(conn, memberBusi);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	
	

	public int banMember(String ignoId, String ignReason) {
		Connection conn = getConnection();
		
		
		System.out.println("ignoId@Service="+ignoId);
		System.out.println("ignReason@Service="+ignReason);
		int result = new MemberDAO().banMember(conn,ignoId, ignReason);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);

		return result;
	}

	public int RoleUpdate(String memRoleId) {
		Connection conn = getConnection();
		
		
		int result = new MemberDAO().RoleUpMember(conn,memRoleId);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);

		return result;

	}
	
	
	public static String IgnoreCheckselectOne(String memberId) {
		Connection conn = getConnection();
		String m = new MemberDAO().IgnoreCheckselectOne(conn, memberId);
	
		
		
		close(conn);
		return m;
	}
	
	
	
	
	
}

=======
package member.model.service;

import java.sql.Connection;

import member.model.dao.MemberDAO;
import member.model.vo.Member;
import static common.JDBCTemplate.*;




import java.sql.Connection;

import member.model.dao.MemberDAO;
import member.model.vo.Member;

import member.model.vo.MemberBusi;
import review.model.vo.ReviewRpt;

import static common.JDBCTemplate.*;

public class MemberService {

	public static final String USER_MEMBER_ROLE = "U";
	public static final String ADMIN_MEMBER_ROLE = "A";

	public Member selectOne(String memberId) {
		Connection conn = getConnection();
		Member m = new MemberDAO().selectOne(conn, memberId);
		close(conn);
		return m;
	}

	public int insertMember(Member member) {
		Connection conn = getConnection();
		int result = new MemberDAO().insertMember(conn, member);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	public int updateMember(Member member) {
		Connection conn = getConnection();
		int result = new MemberDAO().updateMember(conn, member);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	public int updatePassword(Member member) {
		Connection conn = getConnection();
		int result = new MemberDAO().updatePassword(conn, member);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);
		return result;
	}

	//수정용
//	public int updatePoint(Member member) {
//		Connection conn = getConnection();
//		int result = new MemberDAO().updatePoint(conn, member);
//		if (result > 0)
//			commit(conn);
//		else
//			rollback(conn);
//		close(conn);
//		return result;
//	}

	public int updateMemberPoint(Member member) {
		Connection conn = getConnection();
		int result = new MemberDAO().updatePoint(conn, member);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);

		return result;
	}


	public int insertMemberBusi(MemberBusi memberBusi) {
		Connection conn = getConnection();
		int result = new MemberDAO().insertMemberBusi(conn, memberBusi);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}

	public int insertReviewRpt(ReviewRpt reviewRpt) {
		Connection conn = getConnection();
		int result = new MemberDAO().insertReviewRpt(conn, reviewRpt);

		if (result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);

		return result;
	}
	
	
	

	public int banMember(String ignoId, String ignReason) {
		Connection conn = getConnection();
		
		
		System.out.println("ignoId@Service="+ignoId);
		System.out.println("ignReason@Service="+ignReason);
		int result = new MemberDAO().banMember(conn,ignoId, ignReason);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);

		return result;
	}

	public int RoleUpdate(String memRoleId) {
		Connection conn = getConnection();
		
		
		int result = new MemberDAO().RoleUpMember(conn,memRoleId);
		if (result > 0)
			commit(conn);
		else
			rollback(conn);
		close(conn);

		return result;

	}
	
	
	public static String IgnoreCheckselectOne(String memberId) {
		Connection conn = getConnection();
		String m = new MemberDAO().IgnoreCheckselectOne(conn, memberId);
	
		
		
		close(conn);
		return m;
	}
	
	
	
	
	
}
