package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.Review;
import review.model.vo.ReviewComment;

/**
 * 댓글삽입
 */
@WebServlet("/review/reviewCommentInsert")
public class ReviewCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewCommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//1.파라미터
//		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		String memId = request.getParameter("memId");
		System.out.println("memId="+memId);
		String commentContent = request.getParameter("commentContent");
		System.out.println("commentContent"+commentContent);
		
		Review reviewNo = new ReviewService().selectOneReviewNo(memId);
		System.out.println("reviewNo="+reviewNo);
		ReviewComment reviewComment = new ReviewComment(memId, reviewNo.getReviewNo(), commentContent);
		System.out.println("REVEIW="+reviewComment);
		
		//2.업무로직
		int result = new ReviewService().insertReviewComment(reviewComment);
		
		
		//3.view단처리: 댓글등록여부를 msg.jsp통해서 알림후, 
		//    		   /board/boardView로 이동
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/review/reviewList";

		if(result > 0)
			msg = "댓글 등록 성공!";
		else 
			msg = "댓글 등록 실패!";
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
			   .forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
