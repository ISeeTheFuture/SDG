package review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.Review;

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
		
		//1.파라미터핸들링
		final int numPerPage = 5;//한페이지당 수
		int cPage = 1;//요청페이지
		try{
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch(NumberFormatException e){
		
		}
		//2.업무로직
//		List<review> list = reviewService.selectreviewList();
		List<Review> list = reviewService.selectReviewList(cPage, numPerPage);
		System.out.println("list@servlet="+list);
		Review fieldNo = new Review();
		final int totalReviewCount = new ReviewService().selectReviewCount(fieldNo);
		final int AvgStar = new ReviewService().selectStarAvg(fieldNo);
		
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

		//3.뷰모델 처리
		request.setAttribute("list", list);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("totalReviewCount", totalReviewCount);
		request.setAttribute("AvgStar", AvgStar);
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
