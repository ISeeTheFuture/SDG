package review.model.dao;

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

import review.model.vo.Review;
import review.model.vo.ReviewComment;
import review.model.vo.ReviewReport;
import space.model.vo.SpacesDefault;

public class ReviewDAO {


	private Properties prop = new Properties();
	
	public ReviewDAO() {
		try {
			String fileName = ReviewDAO.class.getResource("/sql/review/review-query.properties").getPath();
			prop.load(new FileReader(fileName));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	

	public int insertReview(Connection conn, Review review) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertReview");
		int result = 0;
		
		try {
			//1.pstmt객체생성
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, review.getFieldNo());
			pstmt.setString(2, review.getMemId());
			pstmt.setInt(3, review.getReviewStar());
			pstmt.setString(4, review.getReviewTitle());
			pstmt.setString(5, review.getReviewContent());
			
			//2.실행
			result = pstmt.executeUpdate();
			System.out.println("result@dao="+result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//3.자원반납
			close(pstmt);
		}
		return result;
	}
	

	public int selectReviewCount(Connection conn, Review fieldNo) {//게시물개수 구하기
		PreparedStatement pstmt = null;
		int totalMember = 0;
		ResultSet rset = null;
		String query = prop.getProperty("selectReviewCount");
		
		try{
			//미완성쿼리문을 가지고 객체생성. 
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, fieldNo.getFieldNo());
			//쿼리문실행
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				totalMember = rset.getInt("cnt");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return totalMember;
	}

	public int selectStarAvg(Connection conn, Review fieldNo) {//별점 평균
		PreparedStatement pstmt = null;
		int totalMember = 0;
		ResultSet rset = null;
		String query = prop.getProperty("selectStarAvg");
		
		try{
			//미완성쿼리문을 가지고 객체생성. 
			pstmt = conn.prepareStatement(query);
			
			//쿼리문실행
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				totalMember = rset.getInt("cnt");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		System.out.println("totalMember="+totalMember);
		return totalMember;
	}
//	public int insertReviewRpt(Connection conn, ReviewReport reviewRpt) {
//		int result = 0;
//		PreparedStatement pstmt = null;
//		String query = prop.getProperty("insertReviewRpt");
//		
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1, reviewRpt.getReviewReportNo());
//			pstmt.setInt(2, reviewRpt.getReviewNo());
//			pstmt.setString(3, reviewRpt.getReviewReportReason());
//			pstmt.setDate(4, reviewRpt.getReviewReportDate());
//			pstmt.setInt(5, reviewRpt.getReviewNo());
//						
//			result = pstmt.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		
//		return result;
//	}

	public List<Review> selectReviewList(Connection conn, int cPage, int numPerPage) {
		List<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectReviewList");
		
		try{
			//미완성쿼리문을 가지고 객체생성. 
			pstmt = conn.prepareStatement(query);
			
			//쿼리문실행
			//완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				Review b = new Review();
				//컬럼명은 대소문자 구분이 없다.
				b.setReviewNo(rset.getInt("review_no"));
				b.setReviewTitle(rset.getString("spc_no"));
				b.setMemId(rset.getString("mem_id"));
				b.setReviewOriNo(rset.getInt("review_ori_no"));
				b.setReviewStar(rset.getInt("review_star"));
				b.setReviewType(rset.getString("review_type"));
				b.setReviewTitle(rset.getString("review_title"));
				b.setReviewContent(rset.getString("review_content"));
				b.setReviewFile(rset.getString("review_file"));
				b.setReviewUpfile(rset.getString("review_upfile"));
				b.setReviewDate(rset.getDate("review_date"));
				b.setReviewReadcnt(rset.getInt("review_readcnt"));
				b.setReviewRecommend(rset.getInt("review_recommend"));
				b.setReviewDelete(rset.getString("review_delete"));
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



	

	public int insertReviewComment(Connection conn, ReviewComment reviewComment) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertReviewComment");
		//insert into board_comment
		//values ....
		
		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문 변수대입
			pstmt.setString(1, reviewComment.getMemId());
			pstmt.setInt(2, reviewComment.getReviewNo());
			pstmt.setString(3, reviewComment.getCommentContent());
			//댓글 참조: board_comment_ref
			//댓글 : null
			//대댓글: 참조하는 댓글의 board_comment_no
//			String bcRef 
//				=  reviewComment.getReviewNo()==0?null:""+reviewComment.getReviewNo();
//			pstmt.setString(5,bcRef);
//			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}



	public int selectReviewCount(Connection conn) {
		PreparedStatement pstmt = null;
		int totalMember = 0;
		ResultSet rset = null;
		String query = prop.getProperty("selectReviewCount");
		
		try{
			//미완성쿼리문을 가지고 객체생성. 
			pstmt = conn.prepareStatement(query);
			
			//쿼리문실행
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				totalMember = rset.getInt("cnt");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return totalMember;
	}



	public Review selectOneReviewNo(Connection conn, String memId) {
		Review reviewNo = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectOneReviewNo");
		System.out.println("query="+query);
		
		try {
			//1.미완성쿼리객체 생성
			pstmt = conn.prepareStatement(query);
			//2.미완성쿼리 값대입
			pstmt.setString(1, memId);
			
			//3.실행
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				reviewNo = new Review();
				reviewNo.setReviewNo(rset.getInt("review_no"));
				reviewNo.setMemId(rset.getString("mem_id"));
				reviewNo.setReviewTitle(rset.getString("review_title"));
				reviewNo.setReviewContent(rset.getString("review_content"));
				reviewNo.setReviewDate(rset.getDate("review_date"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		} 
		
		return reviewNo;
	}



	public int deleteReview(Connection conn, int reviewNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteReview"); 
		
		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
			pstmt.setInt(1, reviewNo);
			
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



	public int deleteReviewComment(Connection conn, ReviewComment rc) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteReviewComment");
		//insert into board_comment
		//values ....
		
		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문 변수대입
			pstmt.setString(1, rc.getMemId());
			pstmt.setInt(2, rc.getReviewNo());
			pstmt.setString(3, rc.getCommentContent());
			//댓글 참조: board_comment_ref
			//댓글 : null
			//대댓글: 참조하는 댓글의 board_comment_no
//			String bcRef 
//				=  reviewComment.getReviewNo()==0?null:""+reviewComment.getReviewNo();
//			pstmt.setString(5,bcRef);
//			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}



	public int insertReviewReport(Connection conn, ReviewReport reviewReport) {

		
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertReviewReport");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reviewReport.getReviewReportReason());
			pstmt.setInt(2,reviewReport.getReviewNo());

			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
		
		
		
		
		
		
		
	}
	
	
}







