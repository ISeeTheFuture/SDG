package res.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import res.model.service.ResService;
import res.model.vo.Res;
import res.model.vo.ResGrp;
import res.model.vo.ResView;

/**
 * Servlet implementation class ResViewServlet
 */
@WebServlet("/res/resUpdateEnd")
public class ResUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		int resGroupNo = Integer.parseInt(request.getParameter("resGroupNo"));
		String memberId = request.getParameter("memberId");
		Timestamp resStart = null;
		Timestamp resEnd = null;
		int resMany = Integer.parseInt(request.getParameter("resMany"));
		String resDesc = request.getParameter("resDesc");
		
		try {
			resStart = new Timestamp(sdf.parse(request.getParameter("resStart")).getTime());
			resEnd = new Timestamp(sdf.parse(request.getParameter("resEnd")).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResView resGrp = new ResService().selectResOneGrp(resGroupNo);
		Res res = new ResService().selectResOne(resGroupNo);
//		System.out.println(resGroupNo);
//		System.out.println(memberId);
//		System.out.println(resStart);
//		System.out.println(resEnd);
//		System.out.println(resMany);
//		System.out.println(resDesc);
		
		int resultGrpDelete = new ResService().deleteResOneGrp(resGroupNo);
		if(resultGrpDelete>0) System.out.println("예약그룹 삭제 성공");
		int resultResDelete = new ResService().deleteResGrp(resGroupNo);
		if(resultResDelete>0) System.out.println("예약 삭제 성공");
		
		
		resGrp.setMemId(memberId);
		resGrp.setResTimeStart(resStart);
		resGrp.setResTimeEnd(resEnd);
		resGrp.setResMany(resMany);		
		res.setResContent(resDesc);
		int resultRes =  new ResService().insertRes(res);		
		if(resultRes > 0) System.out.println("예약 성공!");
		resGrp.setResGroupNo(resultRes);
		
		
		Calendar cal = Calendar.getInstance();
		List<ResGrp> list = new ArrayList<>();
		int diffTime = (int)(resEnd.getTime() - resStart.getTime())/(1000*60*60);
		
		for(int i = 0; i < diffTime; i++) {
			ResGrp rg = new ResGrp();
			cal.setTime(resStart);
			cal.add(Calendar.HOUR_OF_DAY, i);
			java.util.Date utilDate = cal.getTime();
			Timestamp input = new java.sql.Timestamp(utilDate.getTime());
			
			rg.setResGroupNo(resGrp.getResGroupNo());
			rg.setResTime(input);
			list.add(rg);
		}
		
		int resultResGrp = new ResService().insertResGrp(list);
		
		if(resultResGrp > 0) System.out.println("예약그룹 성공!");
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
