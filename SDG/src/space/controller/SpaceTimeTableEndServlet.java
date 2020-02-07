package space.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.model.service.SpaceService;
import space.model.vo.SpacesTimeTable;

/**
 * Servlet implementation class SpaceTimeTableEndServlet
 */
@WebServlet("/space/spaceTimeTableEnd")
public class SpaceTimeTableEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpaceTimeTableEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.encoding
		request.setCharacterEncoding("utf-8");
		
		//2.parameter handling

		
		int spcDetNo = Integer.parseInt(request.getParameter("spcDetNo"));
		String spcDay = request.getParameter("spcDay");
		String spcHourStart = request.getParameter("spcHourStart");
		String spcHourEnd = request.getParameter("spcHourEnd");
		String spcAvail =request.getParameter("spcAvail");
		


		
		
		System.out.println("spc@scpTime  : " + spcDetNo);
		System.out.println("spc@scpTime  : " + spcDay);
		System.out.println("spc@scpTime  : " + spcHourStart);
		System.out.println("spc@scpTime  : " + spcHourEnd);
		System.out.println("spc@scpTime  : " + spcAvail);
		
		Date spcHourStart_ = null;
		if(!"".equals(spcHourStart)) 
			spcHourStart_ = Date.valueOf(spcHourStart);
		
		Date spcHourEnd_ = null;
		if(!"".equals(spcHourEnd)) 
			spcHourEnd_ = Date.valueOf(spcHourEnd);
		
		char spcAvail_ = ' '; 
		if(!"".equals(spcAvail))
			spcAvail_ = 'O';
		
		SpacesTimeTable spacestimetable = new SpacesTimeTable(spcDetNo, spcDay, spcHourStart_, spcHourEnd_,spcAvail_);
		
		System.out.println("SpacesTimeTable="+spacestimetable);
		
		//업무로직
		
		int result = new SpaceService().insertSpaceTimeTable(spacestimetable);
		System.out.println("result@servlet="+result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
