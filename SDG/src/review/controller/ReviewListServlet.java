package review.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
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
@WebServlet("/review/reviewList")
public class ReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReviewService reviewService = new ReviewService();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		
		//1.파라미터핸들링
		
		final int numPerPage = 5;//한페이지당 수
		int cPage = 1;//요청페이지
		try{
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch(NumberFormatException e){
		
		}
		
		
		//////////////공가안넘
		int fieldNo = 42; //임의의 공간 no (spc_no)
		
		
		
		///////////////조회수시작/////////////////////
		//조회수 처리를 위한 쿠키조회
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
					if(value.contains("|"+fieldNo+"|")) {
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
			reviewCookieVal = reviewCookieVal + "|" + fieldNo + "|"; 
			Cookie reviewCookie = new Cookie("reviewCookie", reviewCookieVal);
			reviewCookie.setMaxAge(365*24*60*60);//영속쿠키
			reviewCookie.setPath(request.getContextPath()+"/review");
			response.addCookie(reviewCookie);
		}
		
		
		Review reviewNo = new ReviewService().selectOneFieldNo(fieldNo);
		System.out.println(reviewNo);
		//2.업무로직: review객체
		/* Review review = new ReviewService().selectOne(fieldNo, hasRead); */
		List<ReviewComment> commentList 
		= new ArrayList<>();
		if(reviewNo!=null) {
//		List<ReviewComment>
		commentList 
			= new ReviewService().selectCommentList(reviewNo.getReviewNo());
		}
		///////////조회수 끝/////////////
		
		
		
		//2.업무로직

		List<Review> list = reviewService.selectReviewList(cPage, numPerPage);
		
		
		

		
		int totalReviewCount = new ReviewService().selectReviewCount();
		
		int AvgStar = new ReviewService().selectStarAvg(fieldNo);
		
		
		final int totalPage = (int)Math.ceil((double)totalReviewCount/numPerPage);
		
		
		String pageBar = "";	
		final int pageBarSize = 5;
		int pageStart = ((cPage - 1)/pageBarSize) * pageBarSize +1;
		int pageEnd = pageStart+pageBarSize-1;
		int pageNo = pageStart;
		
		//[이전] section
		if(pageNo == 1 ){
			pageBar += "<span>[이전]</span>"; 
		}
		else {
			pageBar += "<a href='"+request.getContextPath()+"/review/reviewList?cPage="+(pageNo-1)+"'>[이전]</a> ";
		}
			
		// pageNo section
		while(!(pageNo>pageEnd || pageNo > totalPage)){
			
			if(cPage == pageNo ){
				pageBar += "<span class='cPage'>"+pageNo+"</span> ";
			} 
			else {
				pageBar += "<a href='"+request.getContextPath()+"/review/reviewList?cPage="+pageNo+"'>"+pageNo+"</a> ";
			}
			pageNo++;
		}
		
		//[다음] section
		if(pageNo > totalPage){
			pageBar += "<span>[다음]</span>";
		} else {
			pageBar += "<a href='"+request.getContextPath()+"/review/reviewList?cPage="+pageNo+"'>[다음]</a>";
		}
		System.out.println("commentList="+commentList);
		//3.뷰모델 처리
		request.setAttribute("list", list);
		/* request.setAttribute("commentList", commentList); */
		request.setAttribute("pageBar", pageBar);
		 request.setAttribute("AvgStar", AvgStar); 
		 request.setAttribute("commentList", commentList);
		 request.setAttribute("totalReviewCount", totalReviewCount);
		request.getRequestDispatcher("/WEB-INF/views/review/reviewList.jsp")
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
