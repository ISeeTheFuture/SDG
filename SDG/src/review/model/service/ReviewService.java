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

	
	public List<Review> selectReviewList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Review> list= new ReviewDAO().selectReviewList(conn, cPage, numPerPage);
		close(conn);
		return list;
	}
	
	public int selectStarAvg(Review fieldNo) {
		Connection conn = getConnection();
		int totalreviewCount = new ReviewDAO().selectStarAvg(conn, fieldNo);
		close(conn);
		return totalreviewCount;
	}

	public int insertReview(Review review) {
		Connection conn = getConnection();
		int result = new ReviewDAO().insertReview(conn, review);
		
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

	public int insertReviewComment(ReviewComment reviewComment) {
		Connection conn = getConnection();
		int result = new ReviewDAO().insertReviewComment(conn, reviewComment);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		
		return result;
	}

	public int selectReviewCount(Review fieldNo) {
		Connection conn = getConnection();
		int totalBoardCount = new ReviewDAO().selectReviewCount(conn);
		close(conn);
		return totalBoardCount;
	}

	public Review selectOneReviewNo(String memId) {
		// TODO Auto-generated method stub
		return null;
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





