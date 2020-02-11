package review.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import res.model.service.ResService;
import res.model.vo.Res;
import res.model.vo.ResGrp;
import review.model.service.ReviewService;
import review.model.vo.Review;
import space.model.service.SpaceService;
import space.model.vo.SpacesDefault;

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
		
		Calendar cal = Calendar.getInstance();
		
		//1. 파라미터 
//		int resGroupNo = Integer.parseInt(request.getParameter("resGroupNo"));
		String memId = request.getParameter("memId");
		String reviewTitle = request.getParameter("reviewTitle");
		
		int reviewStar = Integer.parseInt(request.getParameter("reviewStar"));
		String reviewContent = request.getParameter("reviewContent");
		SpacesDefault comp = new SpaceService().selectOneComp(memId);
		Date reviewDate = null;
		
		
		
		Review review = new Review(comp.getSpcNo(), memId, reviewTitle, reviewStar, reviewContent);
		int result =  new ReviewService().insertReview(review);
		
		//3.뷰단 처리
		String msg = "";
		String loc = "/";
		
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
