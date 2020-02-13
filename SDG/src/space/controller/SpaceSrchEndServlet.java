package space.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 * Servlet implementation class JsonTest1Servlet
 */
@WebServlet("/space/spaceSrchEnd.do")
public class SpaceSrchEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpaceSrchEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Java객체 -> json문자열 변환 -> 응답객체
		// json-simple-library

	
		// 2. 배열
		List<Member> list = new ArrayList<>();
		list.add(new Member("줄리아 로버츠", "01012341234", "juliaRoberts.jpg"));
		list.add(new Member("박보검", "01012341234", "parkBogum.jpg"));
		list.add(new Member("천우희", "01012341234", "천우희.jpg"));
		list.add(new Member("맷 데이먼", "01012341234", "mattDamon.jpg"));
		list.add(new Member("day6", "01012341234", "day6.jpg"));
		list.add(new Member("차은우", "01012341234", "은우.jpg"));
		list.add(new Member("봉준호", "01012341234", "bongjunho.jpg"));
		
		
		//JSONArray(list)
		JSONArray jsonArr = new JSONArray();
		
		for(Member m : list) {
			JSONObject memberJson = new JSONObject();
			memberJson.put("name", m.getName());
			memberJson.put("phone", m.getPhone());
			memberJson.put("profile", m.getProfile());
			
			jsonArr.add(memberJson);
		}
		
		// 응답객체에 쓰기
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
