package res.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import res.model.service.ResService;
import res.model.vo.ResMeView;
import res.model.vo.ResView;

/**
 * Servlet implementation class ResViewServlet
 */
@WebServlet("/res/resMeEnd.do")
public class ResMeEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResMeEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memId = request.getParameter("memberId");
		List<ResMeView> list = new ResService().selectResMeView(memId);	
		JSONArray jsonArr = new JSONArray();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		
		for(ResMeView r : list) {
			JSONObject resMeView = new JSONObject();
			resMeView.put("resGroupNo", r.getResGroupNo());
			resMeView.put("memId", r.getMemId());
			resMeView.put("resMany", r.getResMany());
			resMeView.put("resName", r.getResName());
			resMeView.put("resNo", r.getResNo());
			resMeView.put("resCancle", r.getResCancle());
			resMeView.put("resTimeStart", sdf.format(r.getResTimeStart()));
			resMeView.put("resTimeEnd", sdf.format(r.getResTimeEnd()));
			resMeView.put("spcPrice", r.getSpcPrice());
			resMeView.put("spcName", r.getSpcName());
			resMeView.put("spcImgTitle", r.getSpcImgTitle());
			resMeView.put("spcNo", r.getSpcNo());
			resMeView.put("spcDtlNo", r.getSpcDtlNo());
			
			jsonArr.add(resMeView);
		}
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(jsonArr.toJSONString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
