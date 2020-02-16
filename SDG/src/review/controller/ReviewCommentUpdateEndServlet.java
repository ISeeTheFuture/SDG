package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.ReviewComment;

/**
 * 게시물 수정 시나리오
 * 
 * 1. 첨부파일이 있는 경우
 * 	- 파일을 새로 첨부한 경우
 *  - 파일을 첨부하지 않은 경우 (X)
 * 2. 첨부파일이 없는 경우
 * 
 */
@WebServlet("/review/reviewCommentUpdateEnd")
public class ReviewCommentUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewCommentUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		
		
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		System.out.println("commentNo="+commentNo);
		String commentContent = request.getParameter("commentContent");
		String memId = request.getParameter("memId");
		
		
		//XSS공격 대비 태그기호 치환
		//개행문자 \n => <br>
		/*
		 * boardContent = boardContent.replaceAll("<", "&lt;") .replaceAll(">", "&gt;")
		 * .replaceAll("\\n", "<br>");
		 */
		
		
		ReviewComment r = new ReviewComment(commentNo,  commentContent, memId);

		
		
		//2.업무로직
		int result = new ReviewService().updateCommentReview(r);
		
		//3.뷰단 처리
		String msg = result>0?"댓글 수정 성공!":"댓글 수정 실패!";
		String loc = "/review/reviewList?reviewNo="+r.getReviewNo();
		
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
