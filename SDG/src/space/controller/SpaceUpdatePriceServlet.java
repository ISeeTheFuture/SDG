package space.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.model.service.SpaceService;
import space.model.vo.SpacesPrice;

/**
 * Servlet implementation class SpaceUpdatePriceServlet
 */
@WebServlet(name="SpaceUpdatePriceServlet",urlPatterns="/space/updaePrice")
public class SpaceUpdatePriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpaceUpdatePriceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩 처리
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
				
				SpacesPrice spaceprice = new SpacesPrice(spcPriceNo, spcDetNo, spcDetName, spcPriceDay, spcPriceStart, spcPriceEnd, spcPricePeak_, spcPricePer_, spcPriceDayBool_, spcPricePrice);
				
				
				
				int result = new SpaceService().updatePrice(spaceprice);
				//4. 뷰단처리
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
