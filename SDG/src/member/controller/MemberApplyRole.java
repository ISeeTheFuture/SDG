package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberApplyRole
 */
@WebServlet("/member/applyRole")
public class MemberApplyRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberApplyRole() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.setCharacterEncoding("UTF-8");
		
		
		
		
		
		String a = request.getParameter("memberid");
		

		int result = MemberService.ApplyRoleUp(a);
		
		
		
		
		//4. 받은 결과에 따라 뷰페이지 내보내기
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		//javascript/html에서 사용할 url은 contextPath를 포함한다.
		String loc = "/";

		
		
//		
//		
		if(result>0){
			msg = "신청이 완료되었습니다.";
			
//			request.getSession().setAttribute("memberLoggedIn", new MemberService().selectOne(memId));
		}
		else {
			msg = "신청이 실패하였습니다.";				
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
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
