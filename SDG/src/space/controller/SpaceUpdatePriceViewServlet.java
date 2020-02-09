package space.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.model.service.SpaceService;
import space.model.vo.SpacesPrice;

/**
 * Servlet implementation class SpaceUpdatePriceViewServlet
 */
@WebServlet(urlPatterns = "/space/UpdateSpacePrice",
name = "SpaceUpdatePriceViewServlet")
public class SpaceUpdatePriceViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpaceUpdatePriceViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		int spcDetNo = Integer.parseInt(request.getParameter("spcDetNo"));
		
		SpacesPrice spaceprice = new SpaceService().selectOnePrice(spcDetNo);
		
		String view = "";
		if(spaceprice != null) {
			view = "/WEB-INF/views/member/UpdateSpacePrice.jsp";
			
			request.setAttribute("spaceprice", spaceprice);
		}
		else {
			view = "/WEB-INF/views/common/msg.jsp";
			
			String loc = "/";
			String msg = "해당 번호에 등록된 가격표가 없습니다.";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
		}
		RequestDispatcher reqDispatcher = request.getRequestDispatcher(view);
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
