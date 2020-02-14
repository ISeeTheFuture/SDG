package member.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import member.model.service.MemberService;
import member.model.vo.Member;
import member.model.vo.Memberblk;

/**
 * Servlet implementation class MemberViewServlet
 */
@WebServlet(urlPatterns = "/member/memberIgnoreCheck")
public class MemberIngnoreCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberIngnoreCheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		
		String ses = request.getParameter("memberId");		
		
		Member member = new MemberService().selectOne(ses);

		// 4.view단 선택시
		String view = "";

		if (member != null) {
			Memberblk mb = new Memberblk();
			mb = MemberService.IgnoreCheckselectOne(ses);
			if (ses.equals(mb.getMem_id())) {
				java.util.Date nowday = new java.util.Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // yyyy-MM-dd HH:mm:ss
				String format = formatter.format(nowday);

//				System.out.println("나우데이=	" + format);
//				System.out.println(mb.getBlock_comment());

				SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
				long diff = 0;
				try {
//				    Date date1 = myFormat.parse(mb.getBlock_comment());
					Date date2 = myFormat.parse(format);
					diff = mb.getBlock_comment().getTime() - date2.getTime();
//					System.out.println("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
//					System.out.println("날짜차이" + diff);
					if (diff > 0) {
//						System.out.println("diff>0 if문 확인용");

						view = "/WEB-INF/views/common/msg.jsp";
						String loc = "/";
						String msg = mb.getBlock_comment() + "까지 차단되셨습니다.";
						request.setAttribute("msg", msg);
						request.setAttribute("loc", loc);

						request.setAttribute("member", member);
					}
				} catch (ParseException | java.text.ParseException e) {
					e.printStackTrace();
				}

			}

		} else {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
