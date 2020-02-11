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
 * Servlet implementation class MemberViewServlet
 */
@WebServlet(urlPatterns = "/member/memberView",
			name = "MemberViewServlet")
public class MemberViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//회원정보 조회용 컨트롤러
		//1.한글관련 인코딩처리
		//void javax.servlet.ServletRequest.setCharacterEncoding(String arg0) throws UnsupportedEncodingException
		request.setCharacterEncoding("UTF-8");//대소문자 상관없음. 요청한 view단의 charset값과 동일해야 한다.
		
		//2.쿼리스트링값 가져오기
		String memberId = request.getParameter("memberId");
		
		//3.업무로직처리(해당id의 행 읽어오기)
		Member member = new MemberService().selectOne(memberId);
		
		//4.view단 선택시
		String view = "";

		if(member != null){
			//RequestDispatcher javax.servlet.ServletRequest.getRequestDispatcher(String arg0)
			view = "/WEB-INF/views/member/memberView.jsp";
			
			request.setAttribute("member", member);
		}
		else {
			view = "/WEB-INF/views/common/msg.jsp";
		
			String loc = "/";
			String msg = "해당회원이 없습니다.";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
		}
		
		RequestDispatcher reqDispatcher = request.getRequestDispatcher(view);
		reqDispatcher.forward(request, response);

		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
