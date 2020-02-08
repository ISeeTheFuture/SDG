package space.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SpaceRegformEndServlet
 */
@WebServlet("/space/spaceRegformEnd")
public class SpaceRegformEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpaceRegformEndServlet() {
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
		String spcName = request.getParameter("spcName");
		String region = request.getParameter("region");
		String addr = request.getParameter("addr");
		String spcContent = request.getParameter("spcContent");
		String spcDetSize = request.getParameter("spcDetSize");
		String spcDetStorable = request.getParameter("spcDetStorable");
		String spcManMin = request.getParameter("spcManMin");
		String spcManMax = request.getParameter("spcManMax");
		String spcTimeMin = request.getParameter("spcTimeMin");
		String spcTimeMax = request.getParameter("spcTimeMax");
		String spcDateStart = request.getParameter("spcDateStart");
		String spcDateEnd = request.getParameter("spcDateEnd");
		String spcDay = request.getParameter("spcDay");
		String spcHourStart = request.getParameter("spcHourStart");
		String spcHourEnd = request.getParameter("spcHourEnd");
		String spcDetHoliday = request.getParameter("spcDetHoliday");
		String cat = request.getParameter("cat");
		
		
		System.out.println("spcDetHoliday@spaceregformendservlet  : " + spcDetHoliday);
		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
