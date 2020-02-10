package res.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
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
import res.model.vo.ResView;

/**
 * Servlet implementation class ResViewServlet
 */
@WebServlet("/res/resUpdateView.do")
public class ResUpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResUpdateViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memId = request.getParameter("memberId");
		List<ResView> list = new ResService().selectResUpdateView(memId);	
		JSONArray jsonArr = new JSONArray();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		
		for(ResView r : list) {
			JSONObject resView = new JSONObject();
			resView.put("_id", r.getResGroupNo());
			resView.put("title", r.getMemId());
			resView.put("decription", r.getResContent());
			resView.put("start", sdf.format(r.getResTimeStart()));
			resView.put("end", sdf.format(r.getResTimeEnd()));
			resView.put("type", "카테고리1");
			resView.put("username", r.getResName());
			resView.put("resMany", r.getResMany());
			resView.put("backgroundColor", "#D25565");
			resView.put("textColor", "#ffffff");
			resView.put("allDay", false);
			
			jsonArr.add(resView);
		}
		
		
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
