package member.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberPointUpdateServlet
 */
@WebServlet(urlPatterns ="/member/memberPointUp",
name = "MemberPointUpdateServlet")
public class MemberPointUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPointUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.전송값에 한글이 있을 경우 인코딩처리해야함.

		request.setCharacterEncoding("UTF-8");//대소문자 상관없음. 요청한 view단의 charset값과 동일해야 한다.
		
		//2.전송값 꺼내서 변수에 기록하기, ID로 검색해서 포인트 올리기

		
		String memId = request.getParameter("memberId");
		
		Member member = new MemberService().selectOne(memId);
		
		System.out.println("멤아이디"+memId);
		
		//글쓰기등을 했을때 포인트가 10 증가.
		int Imempoint= member.getMemPoint()+10; 
				
		
		int memGradeName = 0;
		if(Imempoint==10) {
			memGradeName=1;
		}
		else if(Imempoint==20) {memGradeName=2;}
		else if(Imempoint==30) {memGradeName=3;}
		else if(Imempoint==40) {memGradeName=4;}
		else if(Imempoint==50) {memGradeName=5;}
		
		System.out.println("MemgardName@servlet"+memGradeName);
		
		 member = new Member(memId,Imempoint,memGradeName);
		//3.서비스로직호출
		int result = new MemberService().updateMemberPoint(member);  

		//4. 받은 결과에 따라 뷰페이지 내보내기
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		//javascript/html에서 사용할 url은 contextPath를 포함한다.
		String loc = "/";

		if(result>0){
			msg = "포인트가 올랐습니다.";
			
			request.getSession().setAttribute("memberLoggedIn", new MemberService().selectOne(memId));
		}
		else {
			msg = "포인트 올리기를 실패하였습니다.";				
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
