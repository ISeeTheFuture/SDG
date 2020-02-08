package space.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.model.service.SpaceService;
import space.model.vo.SpacesTimeExp;

/**
 * Servlet implementation class spaceTimeExpEndServlet
 */
@WebServlet("/space/spaceTimeExpEnd")
public class spaceTimeExpEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public spaceTimeExpEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.encoding
		request.setCharacterEncoding("utf-8");
		//2.parameter 
		
		int spcDetNo = Integer.parseInt(request.getParameter("spcDetNo"));
		String spcExcDate = request.getParameter("spcExcDate");
		int spcExcStart = Integer.parseInt(request.getParameter("spcExcStart"));
		int spcExcEnd = Integer.parseInt(request.getParameter("spcExcEnd"));
		String spcAvail =request.getParameter("spcAvail");
		
		System.out.println("spc@scpExpTime  : " + spcDetNo);
		System.out.println("spc@scpExpTime  : " + spcExcDate);
		System.out.println("spc@scpExpTime  : " + spcExcStart);
		System.out.println("spc@scpExpTime  : " + spcExcEnd);
		System.out.println("spc@scpExpTime  : " + spcAvail);
		
		char spcAvail_ = ' '; 
		if(!"".equals(spcAvail))
			spcAvail_ = 'O';
		
		//spcExcDate="20010101";
		Date spcExcDate_ = null;
		if(!"".equals(spcExcDate)) 
			spcExcDate_ = Date.valueOf(spcExcDate);
		
		SpacesTimeExp spacetimeexp = new SpacesTimeExp(spcDetNo, spcExcDate_, spcExcStart, spcExcEnd, spcAvail_);
		int result = new SpaceService().insertSapceTimeExp(spacetimeexp);
		
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
