package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class CheckIdDuplicateServlet
 */
@WebServlet("/member/checkIdDuplicate")
public class CheckIdDuplicateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckIdDuplicateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.encoding
		request.setCharacterEncoding("utf-8");

		// 2.parameter handling
		String memberId = request.getParameter("memberId");

		System.out.println("멤버아이디" + memberId);
		// 3.business logic
		Member m = new MemberService().selectOne(memberId);
		boolean isUsable = m == null ? true : false;

		String a = null;
		if (isUsable)
			a = "아이디 사용 가능";
		else {
			a = "아이디 중복됨, 사용 불가";
		}
		// 4.view단처리
		/*
		 * request.setAttribute("isUsable", isUsable);
		 * 
		 * request.getRequestDispatcher("/WEB-INF/views/member/checkIdDuplicate.jsp")
		 * .forward(request, response);
		 */

		response.setContentType("text/csv; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(a);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
