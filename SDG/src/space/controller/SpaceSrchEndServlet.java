package space.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import space.model.service.SrchService;
import space.model.vo.SpacesSrch;


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
		response.setContentType("UTF-8");
		String srchWord = request.getParameter("srchWord")==null?"":request.getParameter("srchWord");
        int spcLoc = Integer.parseInt(request.getParameter("spcLoc"));
        int spcType = Integer.parseInt(request.getParameter("spcType"));
		
        // 일단 (spc+spc_dtl+ spc_img)테이블에서 srchWord, spcLoc, spcType 을 조건으로 spcDetNo, spcNo, spcName, spc_TypeNo, spc_LocNo,spc_price, spc_img 을 가져옴
        // 동시에 (spc_loc+spc_type) 테이블에서 spc_Detail_no를 조건으로 spc_type_name, spcLocationName 를 가져옴
		List<SpacesSrch> spcSrchList = new SrchService().selectSpcSrch(srchWord, spcLoc, spcType );
		
	
		//JSONArray(list)
		JSONArray jsonArr = new JSONArray();
		
		for(SpacesSrch s :  spcSrchList) {
			JSONObject srchJson = new JSONObject();
			srchJson.put("spcDetNo", s.getSpcDetNo());
			srchJson.put("spcNo", s.getSpcNo());
			srchJson.put("spcName", s.getSpcName());
			srchJson.put("spcTypeNo", s.getSpcTypeNo());
			srchJson.put("spcTypeName", s.getSpcTypeName());
			srchJson.put("spcLocNo", s.getSpcLocNo());
			srchJson.put("spcLocationName", s.getSpcLocationName());
			srchJson.put("spcPricePrice", s.getSpcPricePrice());
			String tmp = s.getSpcImgTitle();
			System.out.println(tmp);
			String[] tmpArr = null;
			if(tmp!=null) {
				tmpArr = tmp.split(",");
				srchJson.put("spcImgTitle", tmpArr[0]);
			}
			else {
				srchJson.put("spcImgTitle", null);
			}
			jsonArr.add(srchJson);
		}
//		System.out.println("확인"+jsonArr.toString());
		//응답객체에 쓰기
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
