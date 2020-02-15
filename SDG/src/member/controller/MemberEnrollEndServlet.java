package member.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import common.util.Utils;
import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberEnrollEndServlet
 */
@WebServlet("/member/memberEnrollEnd")
public class MemberEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEnrollEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		System.out.println(request.getParameter("memberId"));
		//2. 파라미터 핸들링
		String memId = request.getParameter("memberId");
//		String password = Utils.getSha512(request.getParameter("password"));
		String memPass = request.getParameter("password");
		String memName = request.getParameter("memberName");
//		char mem_role = request.getParameter("mem_role");
		//role,admin,point,gradename은 디폴트값으로 짚어넣을것.
		String memGender = request.getParameter("gender");
		String memBirth = request.getParameter("birthDay");//"2020-01-20" => java.sql.Date

		String memEmail = request.getParameter("email");
		String memPhone = request.getParameter("phone");
		String memAddr = request.getParameter("address");
		System.out.println(memBirth);
		
		//태어난날 Date 변환		
//		memBirth="20010101";
		Date birthDay_= null;
//		=  new java.sql.Date(new java.util.Date().getTime());
		if(!"".equals(memBirth)) 
			birthDay_ 
//			= Date.valueOf(memBirth);
			= java.sql.Date.valueOf(memBirth);

		//gender int로 변환. 남캐는0 여캐는 1
		int gender = 0;
		if("M".equals(memGender)) {
			gender=0;
		}else {
			gender=1;
		}
		
		Member member = new Member(memId, memPass, memName, 0, 0, gender, birthDay_, memEmail, memPhone, memAddr);
		System.out.println("member@servlet="+member);
		
		//3. 업무로직
		int result = new MemberService().insertMember(member);
		System.out.println("result@servlet="+result);
		
		//4. 뷰단처리
		String msg = "";
		String loc = "/";
		
		if(result > 0)
			msg = "회원가입 성공!";
		else 
			msg = "회원가입 실패!";
		
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
