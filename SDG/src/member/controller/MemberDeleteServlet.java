package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/member/deleteMember")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("UTF-8");
		
		
		String memId = request.getParameter("memberId");
		
		
		
		
	int result=	MemberService.deleteMember(memId);
		
		
	String view = "/WEB-INF/views/common/msg.jsp";
	String msg = "";
	//javascript/html에서 사용할 url은 contextPath를 포함한다.
	String loc = "/";

	if(result>0){
		msg = "성공적으로 회원탈퇴 했습니다.";
		
	
	}
	else {
		msg = "회원탈퇴에 실패했습니다.";				
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
