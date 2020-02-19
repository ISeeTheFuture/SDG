package review.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.Review;

/**
 * 파일업로드
 */
@WebServlet("/review/reviewFormEnd")
public class ReviewFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewFormEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Calendar cal = Calendar.getInstance();
		
		//1. 파라미터 
//		int resGroupNo = Integer.parseInt(request.getParameter("resGroupNo"));
		String memId = request.getParameter("memId");
		System.out.println("memId="+memId);
		String reviewTitle = request.getParameter("reviewTitle");
		
		int reviewStar = Integer.parseInt(request.getParameter("reviewStar"));
		String reviewContent = request.getParameter("reviewContent");
		String comp = request.getParameter("spcNo");
		Date reviewDate = null;
		
		int a= Integer.parseInt(comp);
		
		Review review = new Review(a, memId, reviewTitle, reviewStar, reviewContent);
		int result =  new ReviewService().insertReview(review);
		
		//3.뷰단 처리
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		String loc = "/review/reviewList?spcNo="+comp;
		
		if(result > 0)
			msg = "게시물 등록 성공!";
		else 
			msg = "게시물 등록 실패!";
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
			   .forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
