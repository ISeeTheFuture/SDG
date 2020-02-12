package review.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import member.model.dao.MemberDAO;
import review.model.dao.ReviewDAO;
import review.model.vo.Review;
import review.model.vo.ReviewComment;
import review.model.vo.ReviewReport;


/**
 * 
 * 
 *
 */
public class ReviewService {
	private ReviewDAO reviewDAO = new ReviewDAO();

	public List<Review> selectReviewList() {
		Connection conn = getConnection();
		List<Review> list= new ReviewDAO().selectReviewList(conn);
		close(conn);
		return list;
	}

	
	public int selectReviewCount(Review fieldNo) {
		Connection conn = getConnection();
		int totalreviewCount = new ReviewDAO().selectReviewCount(conn, fieldNo);
		close(conn);
		return totalreviewCount;
	}

	public List<Review> selectReviewList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Review> list= new ReviewDAO().selectReviewList(conn, cPage, numPerPage);
		close(conn);
		return list;
	}
	
    public Review selectOne(int reviewNo) {
		Connection conn = getConnection();
	
		Review review = new ReviewDAO().selectOne(conn, reviewNo);
		
		close(conn);
		return review;
	}

	public Review selectOne(int reviewNo, boolean hasRead) {
		Connection conn = getConnection();
		int result = 0;
		//조회수 증가
		if(hasRead == false) {
			result = new ReviewDAO().increaseReadCount(conn, reviewNo);
		}
		
		Review review = new ReviewDAO().selectOne(conn, reviewNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return review;
	}
	

    public int deleteReview(int review_no) {
		Connection conn = getConnection();
		int result = new ReviewDAO().deleteReview(conn, review_no);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		close(conn);
		
		return result;
	}
    
    public List<ReviewComment> selectCommentList(int reviewNo) {
		Connection conn = getConnection();
		List<ReviewComment> list
			= new ReviewDAO().selectCommentList(conn, reviewNo);
		close(conn);
		return list;
	}

	public int updateReview(Review b) {
		Connection conn = getConnection();
		int result = new ReviewDAO().updateReview(conn, b);

		if(result > 0)
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int insertReviewComment(ReviewComment bc) {
		Connection conn = getConnection();
		int result = new ReviewDAO().insertReviewComment(conn, bc);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		
		return result;
	}

	public int deletereviewComment(ReviewComment bc) {
		Connection conn = getConnection();
		int result = new ReviewDAO().deleteReviewComment(conn, bc);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}

	
	public int selectStarAvg(Review fieldNo) {
		Connection conn = getConnection();
		int totalreviewCount = new ReviewDAO().selectStarAvg(conn, fieldNo);
		close(conn);
		return totalreviewCount;
	}

	public int insertReview(Review b) {
		Connection conn = getConnection();
		int result = new ReviewDAO().insertReview(conn, b);
		
		//새로 작성한 reviewNo 가져오기
		//select seq_reviewno.currval from dual;
//		int reviewNo = new reviewDAO().selectLastSeq(conn);
//		b.setReviewNo(reviewNo);
		
		//트랜잭션처리
		if(result > 0) commit(conn);
		else rollback(conn);
		
		//자원반납
		close(conn);
		return result;
	}

//	public int insertReviewRpt(ReviewReport reviewRpt) {
//		Connection conn = getConnection();
//		int result = new MemberDAO().insertReviewRpt(conn, reviewRpt);
//
//		if (result > 0)
//			commit(conn);
//		else
//			rollback(conn);
//
//		close(conn);
//
//		return result;
//	}
	
	
}





