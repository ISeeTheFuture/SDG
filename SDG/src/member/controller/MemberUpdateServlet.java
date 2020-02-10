package member.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet(name="MemberUpdateServlet", urlPatterns="/member/updateMember")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.전송값에 한글이 있을 경우 인코딩처리해야함.
		//void javax.servlet.ServletRequest.setCharacterEncoding(String arg0) throws UnsupportedEncodingException
		request.setCharacterEncoding("UTF-8");//대소문자 상관없음. 요청한 view단의 charset값과 동일해야 한다.
		
		//2.전송값 꺼내서 변수에 기록하기.

		
		String memId = request.getParameter("mem_id");
//		String password = Utils.getSha512(request.getParameter("password"));
		String memPass = request.getParameter("mem_pass");
		String memName = request.getParameter("mem_name");
//		char mem_role = request.getParameter("mem_role");
		//role,admin,point,gradename은 디폴트값으로 짚어넣을것.
		String memGender = request.getParameter("mem_gender");
		String memBirth = request.getParameter("mem_birth");//"2020-01-20" => java.sql.Date

		String memEmail = request.getParameter("mem_email");
		String memPhone = request.getParameter("mem_phone");
		String memAddr = request.getParameter("address");
		
		//태어난날 Date 변환
		Date birthDay_ = null;
		if(!"".equals(memBirth)) 
			birthDay_ = Date.valueOf(memBirth);
		//gender int로 변환. 남캐는0 여캐는 1
		int gender = 0;
		if("M".equals(memGender)) {
			gender=0;
		}else {
			gender=1;
		}
		
		
		Member member =  new Member(memId, memPass, memName, gender, birthDay_, memEmail, memPhone, memAddr);
		
		//Member member = new Member(memId, memPass, memName, 'F', 'F', 0, 0, gender, birthDay_, null, null, memEmail, memPhone, memAddr);
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		//체크박스같은 경우 선택된 복수의 값이 배열로 전달된다.
		//String[] javax.servlet.ServletRequest.getParameterValues(String arg0)
		String[] hobbies = request.getParameterValues("hobby");
		
		String hobby = "";
		//String java.lang.String.join(CharSequence delimiter, CharSequence... elements)
		//파라미터로 전달한 문자열배열이 null이면, NullPointerException유발.
		if(hobbies!=null) hobby = String.join(",", hobbies);

		Date birthDay_2 = null;
		if(!"".equals(memBirth)) birthDay_2 = Date.valueOf(memBirth);
		
//		Member member = new Member(memberId, null, memberName, memberRole, gender, birthDay_, email, phone, address, hobby, null);

		System.out.println("입력한 회원정보 : "+member);
		
		//3.서비스로직호출
		int result = new MemberService().updateMember(member);  

		//4. 받은 결과에 따라 뷰페이지 내보내기
		String view = "/WEB-INF/views/common/msg.jsp";
		String msg = "";
		//javascript/html에서 사용할 url은 contextPath를 포함한다.
		String loc = "/";

		if(result>0){
			msg = "성공적으로 회원정보를 수정했습니다.";
			
			request.getSession().setAttribute("memberLoggedIn", new MemberService().selectOne(memId));
		}
		else {
			msg = "회원정보수정에 실패했습니다.";				
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
