package space.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SpacePriceEndServlet
 */
@WebServlet("/space/spacePriceEnd")
public class SpacePriceEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpacePriceEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String spcPriNo = request.getParameter("spcPriNo");
		String spcDetNo = request.getParameter("spcDetNo");
		String spcPriName = request.getParameter("spcPriName");
		String spcPriDay = request.getParameter("spcPriDay");
		String spcPriStart = request.getParameter("spcPriStart");
		String spcPriEnd = request.getParameter("spcPriEnd");
		String spcPriPeak = request.getParameter("spcPriPeak");
		String spcPriperMan = request.getParameter("spcPriperMan");
		String spcPriDayBool = request.getParameter("spcPriDayBool");
		String spcPriPrice = request.getParameter("spcPriPrice");
		
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPriNo);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcDetNo);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPriName);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPriDay);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPriStart);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPriEnd);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPriPeak);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPriperMan);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPriDayBool);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPriPrice);
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
