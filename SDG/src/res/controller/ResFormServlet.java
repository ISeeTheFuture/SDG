package res.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import res.model.service.ResService;
import res.model.vo.Res;
import res.model.vo.ResGrp;

/**
 * Servlet implementation class ResFormServlet
 */
@WebServlet("/res/resForm")
public class ResFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calendar cal = Calendar.getInstance();
		
		//1. 파라미터 
//		int resGroupNo = Integer.parseInt(request.getParameter("resGroupNo"));
		String memberId = request.getParameter("memberId");
		int spcNo = Integer.parseInt(request.getParameter("spcNo"));
		int resMany = Integer.parseInt(request.getParameter("resMany"));
		String resName = request.getParameter("resName");
		String resPhone = request.getParameter("resPhone");
		String resEmail = request.getParameter("resEmail");
		String resContent = request.getParameter("resContent");
		Date resApply = null;
		
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd HH");
		String startTime = request.getParameter("resStartDate")+" "+request.getParameter("resStartTime");
		String endTime = request.getParameter("resEndDate")+" "+request.getParameter("resEndTime");
		
		Timestamp resStartTime = null;
		Timestamp resEndTime = null;
		
		try {
			resStartTime = new java.sql.Timestamp(dateForm.parse(startTime).getTime());
			resEndTime = new java.sql.Timestamp(dateForm.parse(endTime).getTime());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int diffTime = (int)(resEndTime.getTime() - resStartTime.getTime())/(1000*60*60);
		
		
		List<ResGrp> list = new ArrayList<>();
		
		
		Res res = new Res(memberId, spcNo, resMany, resName, resPhone, resEmail, resContent);
		int resultRes =  new ResService().insertRes(res);
		
		if(resultRes > 0) {
			System.out.println("예약 성공!");
		}
		else {
			System.out.println("예약 실패!");			
		}
		
		for(int i = 0; i < diffTime; i++) {
			ResGrp rg = new ResGrp();
			cal.setTime(resStartTime);
			cal.add(Calendar.HOUR_OF_DAY, i);
			java.util.Date utilDate = cal.getTime();
			Timestamp input = new java.sql.Timestamp(utilDate.getTime());
			
			rg.setResGroupNo(resultRes);
			rg.setResTime(input);
			list.add(rg);
		}
		
		int resultResGrp = new ResService().insertResGrp(list);
		
		if(resultResGrp > 0) {
			System.out.println("예약그룹 성공!");
		}
		else {
			System.out.println("예약그룹 실패!");			
		}
		
		request.getRequestDispatcher("/res/resResult").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
