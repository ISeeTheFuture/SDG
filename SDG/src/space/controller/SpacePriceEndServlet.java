package space.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;
import space.model.service.SpaceService;
import space.model.vo.SpacesPrice;
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
		
		int spcPriceNo = Integer.parseInt(request.getParameter("spcPriceNo"));
		int spcDetNo = Integer.parseInt(request.getParameter("spcDetNo"));
		String spcDetName = request.getParameter("spcDetName");
		String spcPriceDay = request.getParameter("spcPriceDay");
		int spcPriceStart = Integer.parseInt(request.getParameter("spcPriceStart"));
		int spcPriceEnd = Integer.parseInt(request.getParameter("spcPriceEnd"));
		String spcPricePeak = request.getParameter("spcPricePeak");
		String spcPricePer = request.getParameter("spcPricePer");
		String spcPriceDayBool = request.getParameter("spcPriceDayBool");
		int spcPricePrice = Integer.parseInt(request.getParameter("spcPricePrice"));
		
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPriceNo);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcDetNo);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcDetName);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPriceDay);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPriceStart);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPriceEnd);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPricePeak);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPricePer);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPriceDayBool);
		System.out.println("spcPriNoy@scpPriceformEndservlet  : " + spcPricePrice);
		
		char spcPricePeak_= ' ';
		if("".equals(spcPricePeak))
			spcPricePeak_ ='X';
		else
			spcPricePeak_ ='O';
		
		char spcPricePer_= ' ';
		if("".equals(spcPricePer))
			spcPricePer_ ='X';
		else
			spcPricePer_ ='O';
		
		char spcPriceDayBool_= ' ';
		if("".equals(spcPriceDayBool))
			spcPriceDayBool_ ='X';
		else
			spcPriceDayBool_ ='O';
		
		SpacesPrice spaceprice = new SpacesPrice(spcPriceNo, spcDetNo, spcDetName, spcPriceDayBool, spcPriceStart, spcPriceEnd, spcPricePeak_, spcPricePer_, spcPriceDayBool_, spcPricePrice);
		int result = new SpaceService().insertPrice(spaceprice);
		
		//view
		String msg = "";
		String loc = "/";
		
		if(result > 0)
			msg = "정보등록 성공!";
		else 
			msg = "정보등록 실패!";
		
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
