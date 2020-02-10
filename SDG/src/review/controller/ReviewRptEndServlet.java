package review.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import review.model.vo.ReviewRpt;

/**
 * Servlet implementation class ReviewRptEndServlet
 */
@WebServlet("/review/reviewRptEnd")
public class ReviewRptEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewRptEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		
		//2. 파라미터 핸들링
		
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo")); 
//		String password = Utils.getSha512(request.getParameter("password"));
		
		String reviewReportReason = request.getParameter("reviewReportReason");//"2020-01-20" => java.sql.Date

			
		
		ReviewRpt reviewRpt = new ReviewRpt(0, reviewNo, reviewReportReason, null);
		
		
		//3. 업무로직
		int result = new MemberService().insertReviewRpt(reviewRpt);
		
		//4. 뷰단처리
		String msg = "";
		String loc = "/";
		
		if(result > 0)
			msg = "사업자 정보 입력 성공!";
		else 
			msg = "사업자 정보 입력 실패!";
		
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
