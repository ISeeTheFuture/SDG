package review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.model.service.ReviewService;
import review.model.vo.ReviewReport;

/**
 * Servlet implementation class ReviewReportServlet
 */
@WebServlet("/review/reviewRptEnd")
public class ReviewReportEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewReportEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String reviewReportNo=request.getParameter("reviewNo");
		System.out.println("리뷰넘버"+reviewReportNo);
		String reviewReportReason=request.getParameter("reviewReportReason");
		
		System.out.println("리뷰리즌"+reviewReportReason);
		
		
		int a = Integer.parseInt(reviewReportNo);
		
		ReviewReport RR= new ReviewReport(a, reviewReportReason);
		//3. 업무로직
		int result = new ReviewService().insertReviewReport(RR);
		
		//4. 뷰단처리
		String msg = "";
		String loc = "/";
		
		if(result > 0)
			msg = "신고 등록 성공!";
		else 
			msg = "신고 등록 실패!";
		
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
