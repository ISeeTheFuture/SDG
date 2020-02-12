package review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.ReviewComment;

/**
 * 댓글삭제
 */
@WebServlet("/review/reviewCommentDelete")
public class ReviewCommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewCommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		String memId = request.getParameter("memId");
		String commentContent = request.getParameter("commentContent");
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		
		/*
		 * ReviewComment rc = new ReviewComment(commentNo, memId, commentContent,
		 * reviewNo);
		 */
		
		/* int result = new ReviewService().deleteReviewComment(rc); */
		
		//3.view단처리: 댓글등록여부를 msg.jsp통해서 알림후, 
				//    		   /board/boardView로 이동
		/*
		 * String view = "/WEB-INF/views/common/msg.jsp"; String msg = "";
		 * //javascript/html에서 사용할 url은 contextPath를 포함한다. String loc =
		 * "/review/reviewView?reviewNo="+reviewNo;
		 * 
		 * if(result>0){ msg = "댓글 삭제 성공!"; } else { msg = "댓글 삭제 실패!"; }
		 * 
		 * request.setAttribute("msg", msg); request.setAttribute("loc", loc);
		 * 
		 * RequestDispatcher reqDispatcher = request.getRequestDispatcher(view);
		 * reqDispatcher.forward(request, response);
		 */
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
