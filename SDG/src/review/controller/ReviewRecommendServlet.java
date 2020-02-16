package review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.Review;
import review.model.vo.ReviewComment;

/**
 * 게시글페이지
 */
@WebServlet("/review/reviewRecommend")
public class ReviewRecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReviewService reviewService = new ReviewService();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewRecommendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
	
		//조회수 처리를 위한 쿠키조회
				
				//2.업무로직: review객체
				/* Review review = new ReviewService().selectOne(fieldNo, hasRead); */
				
				///////////조회수 끝/////////////
				int fieldNo = 42; //임의의 공간 no (spc_no)
				
				Review reviewNo1 = new ReviewService().selectOneFieldNo(fieldNo);
				int reviewNo =  (reviewNo1.getReviewNo());
				
				Cookie[] cookies = request.getCookies();
				String reviewCookieVal = "";
				boolean hasRead = false;
				
				//사이트첫방문 아무런 쿠키도 가지고 있지 않아 cookies=null이다.
				if(cookies != null) {
					
					for(Cookie c : cookies) {
						String name = c.getName();
						String value = c.getValue();
						
						if("reviewCookie".equals(name)) {
							reviewCookieVal = value;
							if(value.contains("|"+reviewNo+"|")) {
								hasRead = true;
								break;
							}
								
						}
					}
					
				}
				System.out.println("reviewCookieVal="+reviewCookieVal);
				System.out.println("hasRead="+hasRead);
				
				//쿠키 생성
				if(hasRead == false) {
					reviewCookieVal = reviewCookieVal + "|" + reviewNo + "|"; 
					Cookie reviewCookie = new Cookie("reviewCookie", reviewCookieVal);
					reviewCookie.setMaxAge(365*24*60*60);//영속쿠키
					reviewCookie.setPath(request.getContextPath()+"/review");
					response.addCookie(reviewCookie);
				}
				
			Review review = new ReviewService().updateReviewRcomd(reviewNo, hasRead);
		
		
		
		
		//3.view단 처리:
		//사용자가 잘못된 reviewNo를 입력했다면, review객체는 null이다.
		//msg.jsp를 view로 지정해서 "해당하는 게시글이 없습니다." => /review/reviewList
		String view = "";
		if(review == null){
			request.setAttribute("msg", "추천되었습니다!");
			request.setAttribute("loc", "/review/reviewList");
			view = "/WEB-INF/views/common/msg.jsp";
		}
		else {
			view = "/WEB-INF/views/review/reviewList.jsp";			
		}
		request.setAttribute("review", review);
		
		
		request.getRequestDispatcher(view)
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
