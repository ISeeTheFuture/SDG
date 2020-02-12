package res.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResViewServlet
 */
@WebServlet("/res/resInsert")
public class ResInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		Enumeration params = request.getParameterNames();
//		System.out.println("----------------------------");
//		while (params.hasMoreElements()){
//		    String name = (String)params.nextElement();
//		    System.out.println(name + " : " +request.getParameter(name));
//		}
//		System.out.println("----------------------------");
		
		Calendar startTime = Calendar.getInstance();
		Calendar endTime = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		
		
		try {
			startTime.setTime(sdf.parse(request.getParameter("startTime")));
			endTime.setTime(sdf.parse(request.getParameter("endTime")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String resStartDate = startTime.get(Calendar.YEAR)+"-"+(((startTime.get(Calendar.MONTH)+1)<10)?"0"+(startTime.get(Calendar.MONTH)+1):(startTime.get(Calendar.MONTH)+1))+"-"+startTime.get(Calendar.DAY_OF_MONTH);
		String resEndDate = endTime.get(Calendar.YEAR)+"-"+(((endTime.get(Calendar.MONTH)+1)<10)?"0"+(endTime.get(Calendar.MONTH)+1):(endTime.get(Calendar.MONTH)+1))+"-"+endTime.get(Calendar.DAY_OF_MONTH);
		String resStartTime = startTime.get(Calendar.HOUR_OF_DAY)<10?"0"+startTime.get(Calendar.HOUR_OF_DAY):startTime.get(Calendar.HOUR_OF_DAY)+"";
		String resEndTime = endTime.get(Calendar.HOUR_OF_DAY)<10?"0"+endTime.get(Calendar.HOUR_OF_DAY):endTime.get(Calendar.HOUR_OF_DAY)+"";
		
		request.setAttribute("memberId", request.getParameter("memberId"));
		request.setAttribute("resMany", request.getParameter("resMany"));
		request.setAttribute("resStartDate", resStartDate);
		request.setAttribute("resStartTime", resStartTime);
		request.setAttribute("resEndDate", resEndDate);
		request.setAttribute("resEndTime", resEndTime);
		request.setAttribute("resContent", request.getParameter("resContent"));
		
		
//		request.getRequestDispatcher("/WEB-INF/views/res/res.jsp").forward(request, response);
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/WEB-INF/views/res/resInsert.jsp");
        dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
