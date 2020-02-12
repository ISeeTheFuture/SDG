package space.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.model.service.SpaceService;
import space.model.vo.Spaces;
import space.model.vo.SpacesDefault;
import space.model.vo.SpacesImg;
import space.model.vo.SpacesPrice;
import space.model.vo.SpacesTimeExp;
import space.model.vo.SpacesTimeTable;
import space.model.vo.SpacesImg;

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
		
		//회사명
		String spcName = request.getParameter("spcName");
		//회사주소
		String compAddr = request.getParameter("compAddr");
		//회사소개
		String compContent = request.getParameter("compContent");
		
		
		
		//방의 지역
		int regionNo = Integer.parseInt(request.getParameter("region"));
		//방의 주소
		String addr = request.getParameter("addr");
		//방의 소개글
		String spcContent = request.getParameter("spcContent");
		int spcDetSize = Integer.parseInt(request.getParameter("spcDetSize"));
		//방의 수용가능인원
		int spcDetStorable = Integer.parseInt(request.getParameter("spcDetStorable"));
		int spcManMin = Integer.parseInt(request.getParameter("spcManMin"));
		int spcManMax = Integer.parseInt(request.getParameter("spcManMax"));
		int spcTimeMin = Integer.parseInt(request.getParameter("spcTimeMin"));
		int spcTimeMax = Integer.parseInt(request.getParameter("spcTimeMax"));
		String spcDateStart = request.getParameter("spcDateStart");
		String spcDateEnd = request.getParameter("spcDateEnd");
		String [] spcDays = request.getParameterValues("spcDay");
		int spcHourStart = Integer.parseInt(request.getParameter("spcHourStart"));
		int spcHourEnd = Integer.parseInt(request.getParameter("spcHourEnd"));
		String spcDetSharing = request.getParameter("spcDetSharing");
		String spcDetHoliday = request.getParameter("spcDetHoliday");
		int cat = Integer.parseInt(request.getParameter("cat"));
		
		//spaceExp
		
//		int spcDetNo = Integer.parseInt(request.getParameter("spcDetNo"));
		String spcExcDate = request.getParameter("spcExcDate");
		int spcExcStart = Integer.parseInt(request.getParameter("spcExcStart"));
		int spcExcEnd = Integer.parseInt(request.getParameter("spcExcEnd"));
		
		//spacePrice
		
		String spcDetName = request.getParameter("spcDetName");
		String [] spcPriceDays = request.getParameterValues("spcPriceDay");
		String spcPricePer = request.getParameter("spcPricePer");
//		String spcPriceDayBool = request.getParameter("spcPriceDayBool");
		int spcPricePrice = Integer.parseInt(request.getParameter("spcPricePrice"));
		
		
		//spaceImg
		String spcImgTitle = request.getParameter("spcImgTitle");
		String spcImgText = request.getParameter("spcImgText");
		String spcImgRoute = request.getParameter("spcImgRoute");
		
		String spcDay = "";
		
		if(spcDays != null)
			spcDay = String.join(",", spcDays);
		
		Date spcDateStart_ = null;
		if(!"".equals(spcDateStart))
			spcDateStart_ = Date.valueOf(spcDateStart);
		
		Date spcDateEnd_ = null;
		if(!"".equals(spcDateEnd))
			spcDateEnd_ = Date.valueOf(spcDateEnd);
		
		SpacesDefault spDefault = new SpacesDefault("testid", spcName, compAddr, compContent);
		int result = new SpaceService().insertComp(spDefault);

		SpacesDefault comp = new SpaceService().selectOneComp("testid");
		Spaces space = new Spaces(comp.getSpcNo(), cat, regionNo, spcContent, spcDetSharing.charAt(0), spcDetHoliday.charAt(0), spcDetSize, spcDetStorable, spcManMin, spcManMax, spcTimeMin, spcTimeMax, spcDateStart_, spcDateEnd_);
		
		result += new SpaceService().insertSpace(space);
		
		
		System.out.println("spc@scpcomt =" + comp);

		
		
		//회사No 로 공간객체 가져오기
		Spaces spcObj = new SpaceService().selectOneSpace(comp.getSpcNo());
		SpacesTimeTable spacetimetable = new SpacesTimeTable(spcObj.getSpcDetNo(), spcDay, spcHourStart, spcHourEnd);
		result += new SpaceService().insertSpaceTimeTable(spacetimetable);

		
		System.out.println("spc@scpcomt =" + spcObj);
		
		//spcExp : scpDetNo가져오기 
		
		Date spcExcDate_ = null;
		if(!"".equals(spcExcDate)) 
			spcExcDate_ = Date.valueOf(spcExcDate);
		
		SpacesTimeExp spacetimeexp = new SpacesTimeExp(spcObj.getSpcDetNo(), spcExcDate_, spcExcStart, spcExcEnd);
		result += new SpaceService().insertSapceTimeExp(spacetimeexp);
		
		
//		System.out.println(spcObj.getSpcNo()+"@SpaceRegFormEndServlet");
		
		String spcPriceDay = "";
		
		if(spcPriceDays != null)
			spcPriceDay = String.join(",", spcPriceDays);
		
		SpacesPrice spaceprice = new SpacesPrice(spcObj.getSpcDetNo(), spcDetName, spcPriceDay, spcPricePer.charAt(0), spcPricePrice);
		result += new SpaceService().insertPrice(spaceprice);
		
		//spcImg
		
		SpacesImg spaceimg = new SpacesImg(spcObj.getSpcDetNo(), spcImgTitle, spcImgText, spcImgRoute, comp.getSpcNo());
		result += new SpaceService().insertImg(spaceimg);
		
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
