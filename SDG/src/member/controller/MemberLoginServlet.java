package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		//void javax.servlet.ServletRequest.setCharacterEncoding(String env) throws UnsupportedEncodingException
		request.setCharacterEncoding("utf-8");
		
		//2. 파라미터 핸들링
		String memberId = request.getParameter("memberId");
//		String password = Utils.getSha512(request.getParameter("password"));
		String password = request.getParameter("password");
		System.out.println("memberId@servlet="+memberId);
		System.out.println("password@servlet="+password);	
		
		//3. 업무로직
		//1.로그인성공: 올바른 아이디와 비밀번호
		//2.로그인실패: 비밀번호 오류
		//3.로그인실패: 존재하지 않는 아이디
		
		//DB에서 memberId로 member객체 조회!
		//1.조회된 member객체가 있는 경우: 
		//	비밀번호가 정확한 경우: 1.로그인 성공 
		//	비밀번호가 틀린 경우: 2.로그인실패
		//2.조회된 member객체가 없는 경우: 3.로그인실패
		
		Member m = new MemberService().selectOne(memberId);
		System.out.println("member@controller="+m);
		
		String msg = "";
		String loc = "/";
		
		//1.memberId로 조회된 회원이 있는 경우
		if(m != null) {
			
			//1.로그인 성공
			if(password.equals(m.getMemPass())) {
				msg = "로그인 성공!";
				
				//로그인한 사용자를 session객체에 memberLoggedIn속성으로 저장  
				HttpSession session = request.getSession();
				String sessionId = session.getId();
				System.out.println("sessionId@servlet="+sessionId);
				
				Member memberLoggedIn = m;
				
				session.setAttribute("memberLoggedIn", memberLoggedIn);
				
				//로그인한 사용자 세션객체 타임아웃설정(개별세션) : 초
				session.setMaxInactiveInterval(60*30);
				
				//아이디저장 쿠키관련
				String saveId = request.getParameter("saveId");
				System.out.println("saveId@servlet="+saveId);
				
				//도메인당 50개, 하나의 크기는 4kb가 넘지 않도록 해야 모든 브라우져에서 호환된다.
				Cookie c = new Cookie("saveId", memberId);
				c.setPath("/");//도메인 전역에서 쿠키사용(서버전송)
				if(saveId != null) {
					c.setMaxAge(7*24*60*60);//쿠키의 유효기간(초): 7일(영속쿠키)
				}
				else {
					c.setMaxAge(0);//쿠키 즉시삭제
								   //음수(혹은 생략): 브라우져 종료시 삭제(세션쿠키)
				}
				response.addCookie(c);
				
				//로그인후 인덱스페이지로 리다이렉트 처리
				//클라이언트로 하여금 이 url(/mvc)로 다시 요청하도록함.
//				response.sendRedirect(request.getContextPath());
				
				//사용자가 있었던 페이지로 리다이렉트한다.
				String referer = request.getHeader("Referer");//요청이 일어난 페이지주소
				String origin = request.getHeader("origin");//프로토콜+ip(도메인)+포트
				String url = request.getRequestURL().toString();//요청주소
				String uri = request.getRequestURI();//url에서 origin제거한 나머지 주소
				
				
				System.out.println("referer="+referer);
				System.out.println("origin="+origin);
				System.out.println("url="+url);
				System.out.println("uri="+uri);
				/*
				    referer=http://localhost:9090/mvc/board/boardView?boardNo=91
					origin=http://localhost:9090
					url=http://localhost:9090/mvc/member/login
					uri=/mvc/member/login
				 */
				
				
				response.sendRedirect(referer);
				
				return;	
			}
			//2.로그인실패: 비밀번호가 틀린 경우
			else {
				msg = "비밀번호가 틀렸습니다.";
			}

		}
		//2.memberId가 존재하지 않는 경우
		else {
			msg = "아이디가 존재하지 않습니다.";
		}
		System.out.println("msg="+msg);
		
		//4. view단 처리: forwarding
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		
		RequestDispatcher reqDispatcher 
			= request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
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
