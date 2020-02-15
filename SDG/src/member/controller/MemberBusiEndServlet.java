package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.MemberBusi;

/**
 * Servlet implementation class MemberBlockServlet
 */
@WebServlet("/member/memberBusiEnd")
public class MemberBusiEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberBusiEndServlet() {
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
				String memId = request.getParameter("memId");
				String memBusiNo = request.getParameter("memBusiNo"); 
//				
				String memBusiAddr = request.getParameter("memBusiAddr");

				String memBusiPhone = request.getParameter("memBusiPhone");
				String memBusiAllow = request.getParameter("memBusiAllow");
				
				System.out.println("memId"+memId);
				System.out.println("memBusiNo="+memBusiNo);
				System.out.println("memphone"+memBusiPhone);
//				System.out.println("memBusiAllow"+memBusiAllow);
				
				
				MemberBusi memberBusi = new MemberBusi(memId, memBusiNo, memBusiAddr, memBusiPhone, memBusiAllow);
				
				
				//3. 업무로직
				int result = new MemberService().insertMemberBusi(memberBusi);
				
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
		// 
		doGet(request, response);
	}

}
