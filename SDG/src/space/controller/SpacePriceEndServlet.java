package space.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;
import space.model.vo.SpacesTimeTable;

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
		
		String spcPriceNo = request.getParameter("spcPriceNo");
		String spcDetNo = request.getParameter("spcDetNo");
		String spcPriceName = request.getParameter("spcPriceName");
		String spcPriceDay = request.getParameter("spcPriceDay");
		String spcPriceStart = request.getParameter("spcPriceStart");
		String spcPriceEnd = request.getParameter("spcPriceEnd");
		String spcPricePeak = request.getParameter("spcPricePeak");
		String spcPricePer = request.getParameter("spcPricePer");
		String spcPriceDayBool = request.getParameter("spcPriceDayBool");
		String spcPricePrice = request.getParameter("spcPricePrice");
		
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPriceNo);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcDetNo);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPriceName);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPriceDay);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPriceStart);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPriceEnd);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPricePeak);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPricePer);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPriceDayBool);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPricePrice);
		
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
