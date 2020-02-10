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
		int spcHourStart = Integer.parseInt(request.getParameter("spcHourStart"));
		int spcHourEnd = Integer.parseInt(request.getParameter("spcHourEnd"));
		String spcAvail =request.getParameter("spcAvail");
		


		
		
		System.out.println("spc@scpTime  : " + spcDetNo);
		System.out.println("spc@scpTime  : " + spcDay);
		System.out.println("spc@scpTime  : " + spcHourStart);
		System.out.println("spc@scpTime  : " + spcHourEnd);
		System.out.println("spc@scpTime  : " + spcAvail);
		
		
		char spcAvail_ = ' '; 
		if(!"".equals(spcAvail))
			spcAvail_ = 'X';
		else
			spcAvail_ = 'O';
		
		SpacesTimeTable spacestimetable = new SpacesTimeTable(spcDetNo, spcDay, spcHourStart, spcHourEnd,spcAvail_);
		
		System.out.println("SpacesTimeTable="+spacestimetable);
		
		//업무로직
		
		int result = new SpaceService().insertSpaceTimeTable(spacestimetable);
		System.out.println("result@servlet="+result);
		
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
