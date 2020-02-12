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
@WebServlet("/res/resDeleteEnd")
public class ResDeleteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResDeleteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		int resGroupNo = Integer.parseInt(request.getParameter("resGroupNo"));
		
		int resultGrpDelete = new ResService().deleteResOneGrp(resGroupNo);
		if(resultGrpDelete>0) System.out.println("예약그룹 삭제 성공");
		int resultResDelete = new ResService().deleteResGrp(resGroupNo);
		if(resultResDelete>0) System.out.println("예약 삭제 성공");
		


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
