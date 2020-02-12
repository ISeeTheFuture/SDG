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
	
	public List<Review> selectReviewList(Connection conn) {
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
//				b.setReviewNo(rset.getInt("Review_no"));
//				b.setReviewTitle(rset.getString("Review_title"));
//				b.setReviewWriter(rset.getString("Review_writer"));
//				b.setReviewContent(rset.getString("Review_content"));
//				b.setOriginalFileName(rset.getString("Review_original_filename"));
//				b.setRenamedFileName(rset.getString("Review_renamed_filename"));
//				b.setReviewDate(rset.getDate("Review_date"));
//				b.setReadCount(rset.getInt("Review_readcount"));
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

	public int insertReview(Connection conn, Review b) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertReview");
		int result = 0;
		
		try {
			//1.pstmt객체생성
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getMemberId());
			pstmt.setInt(2, b.getReviewStar());
			pstmt.setString(3, b.getReviewTitle());
			pstmt.setString(4, b.getReviewContent());
			
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

	public List<Review> selectReviewList(Connection conn, int cPage, int numPerPage) {
		List<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectReviewList");
		
		try{
			//미완성쿼리문을 가지고 객체생성. 
			pstmt = conn.prepareStatement(query);
			
			//시작 rownum과 마지막 rownum 구하는 공식
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);
			
			//쿼리문실행
			//완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				Review b = new Review();
				//컬럼명은 대소문자 구분이 없다.
//				b.setReviewNo(rset.getInt("Review_no"));
//				b.setReviewTitle(rset.getString("Review_title"));
//				b.setReviewWriter(rset.getString("Review_writer"));
//				b.setReviewContent(rset.getString("Review_content"));
//				b.setOriginalFileName(rset.getString("Review_original_filename"));
//				b.setRenamedFileName(rset.getString("Review_renamed_filename"));
//				b.setReviewDate(rset.getDate("Review_date"));
//				b.setReadCount(rset.getInt("Review_readcount"));
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
	
	public Review selectOne(Connection conn, int ReviewNo) {
		Review review = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectOne");
		try{
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
			pstmt.setInt(1, ReviewNo);
			//쿼리문실행
			//완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			rset = pstmt.executeQuery();
			
			if(rset.next()){
//				Review = new Review();
//				Review.setReviewNo(rset.getInt("Review_no"));
//				Review.setReviewTitle(rset.getString("Review_title"));
//				Review.setReviewWriter(rset.getString("Review_writer"));
//				Review.setReviewContent(rset.getString("Review_content"));
//				Review.setReviewDate(rset.getDate("Review_date"));
//				Review.setOriginalFileName(rset.getString("Review_original_filename"));
//				Review.setRenamedFileName(rset.getString("Review_renamed_filename"));
//				Review.setReadCount(rset.getInt("Review_readcount"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return review;
	}

//	public int selectLastSeq(Connection conn) {
//		int ReviewNo = 0;
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		String query = prop.getProperty("selectLastSeq");
//		
//		try {
//			pstmt = conn.prepareStatement(query);
//			rset = pstmt.executeQuery();
//			if(rset.next())
//				ReviewNo = rset.getInt("Reviewno");
//			
//			System.out.println("ReviewNo@dao="+ReviewNo);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rset);
//			close(pstmt);
//		}
//		
//		return ReviewNo;
//	}

	public int increaseReadCount(Connection conn, int ReviewNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("increaseReadCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ReviewNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	

    public int deleteReview(Connection conn, int Review_no) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteReview"); 
		
		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문미완성
			pstmt.setInt(1, Review_no);
			
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

	public int updateReview(Connection conn, Review b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("updateReview");
		
		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, b.getReviewTitle());
//			pstmt.setString(2, b.getReviewContent());
//			pstmt.setString(3, b.getOriginalFileName());
//			pstmt.setString(4, b.getRenamedFileName());
//			pstmt.setInt(5, b.getReviewNo());

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	 public List<ReviewComment> selectCommentList(Connection conn, int ReviewNo) {
		List<ReviewComment> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectCommentList");
		
		try{
			//미완성쿼리문을 가지고 객체생성. 
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ReviewNo);
			
			//쿼리문실행
			//완성된 쿼리를 가지고 있는 pstmt실행(파라미터 없음)
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				ReviewComment bc = new ReviewComment();
				//컬럼명은 대소문자 구분이 없다.
//				bc.setReviewCommentNo(rset.getInt("Review_comment_no"));
//				bc.setReviewCommentLevel(rset.getInt("Review_comment_level"));
//				bc.setReviewCommentWriter(rset.getString("Review_comment_writer"));
//				bc.setReviewCommentContent(rset.getString("Review_comment_content"));
//				bc.setReviewRef(rset.getInt("Review_ref"));//null인 참조댓글필드는 0값이 대입됨.
//				bc.setReviewCommentRef(rset.getInt("Review_comment_ref"));
//				bc.setReviewCommentDate(rset.getDate("Review_comment_date"));
				list.add(bc);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}

	public int insertReviewComment(Connection conn, ReviewComment bc) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertReviewComment");
		//insert into Review_comment
		//values ....
		
		try {
			//미완성쿼리문을 가지고 객체생성.
			pstmt = conn.prepareStatement(query);
			//쿼리문 변수대입
//			pstmt.setInt(1, bc.getReviewCommentLevel()); 
//			pstmt.setString(2, bc.getReviewCommentWriter());
//			pstmt.setString(3, bc.getReviewCommentContent());
//			pstmt.setInt(4, bc.getReviewRef());
			//댓글 참조: Review_comment_ref
			//댓글 : null
			//대댓글: 참조하는 댓글의 Review_comment_no
//			String bcRef 
//				=  bc.getReviewCommentRef()==0?null:""+bc.getReviewCommentRef();
//			pstmt.setString(5,bcRef);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
		
		return result;
	}

	public int deleteReviewComment(Connection conn, ReviewComment bc) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteReviewComment");
		
		return result;
	}

	
	public int selectStarAvg(Connection conn, Review fieldNo) {//별점 평균
		PreparedStatement pstmt = null;
		int totalMember = 0;
		ResultSet rset = null;
		String query = prop.getProperty("selectStarAvg");
		
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
	
	
}







