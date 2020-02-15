package space.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import common.MvcFileRenamePolicy;
import space.model.service.SpaceService;
import space.model.vo.Spaces;
import space.model.vo.SpacesCttImg;
import space.model.vo.SpacesDefault;
import space.model.vo.SpacesImg;
import space.model.vo.SpacesPrice;
import space.model.vo.SpacesTimeExp;
import space.model.vo.SpacesTimeTable;

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
		
		
		String saveDirectory = getServletContext().getRealPath("/upload");

		int maxPostSize = 1024 * 1024 * 10;
		
		
		String encoding = "utf-8";
		//4.fileRenamePolicy: 중복파일 리네임 정책 DefaultFileRenamePolicy a.txt, a1.txt, a2.txt,... 
		FileRenamePolicy fileRenamePolicy
//			= new DefaultFileRenamePolicy();
			= new MvcFileRenamePolicy();
		
		MultipartRequest multiReq 
			= new MultipartRequest(request, 
								   saveDirectory, 
								   maxPostSize, 
								   encoding, 
								   fileRenamePolicy);
		
		
//		String spcImgTitle = multiReq.getParameter(spcFileName);
//		String spcImgRoute = multiReq.getParameter(spcImgFileFullPath);
		
		//2.parameter handling
		//로그인한 아이디
		String memberId = multiReq.getParameter("memberId");
		//회사명
		String spcName = multiReq.getParameter("spcName");
		//회사주소
		String compAddr = multiReq.getParameter("compAddr");
		//회사소개
		String compContent = multiReq.getParameter("compContent");
		
		
		
		//방의 지역
		int regionNo = Integer.parseInt(multiReq.getParameter("region"));

		//방의 주소
		String addr = multiReq.getParameter("addr");
		//방의 소개글
		String spcContent = multiReq.getParameter("spcContent");
		int spcDetSize = Integer.parseInt(multiReq.getParameter("spcDetSize"));
		//방의 수용가능인원
		int spcDetStorable = Integer.parseInt(multiReq.getParameter("spcDetStorable"));
		int spcManMin = Integer.parseInt(multiReq.getParameter("spcManMin"));
		int spcManMax = Integer.parseInt(multiReq.getParameter("spcManMax"));
		int spcTimeMin = Integer.parseInt(multiReq.getParameter("spcTimeMin"));
		int spcTimeMax = Integer.parseInt(multiReq.getParameter("spcTimeMax"));
		String spcDateStart = multiReq.getParameter("spcDateStart");
		String spcDateEnd = multiReq.getParameter("spcDateEnd");
		String [] spcDays = multiReq.getParameterValues("spcDay");
		int spcHourStart = Integer.parseInt(multiReq.getParameter("spcHourStart"));
		int spcHourEnd = Integer.parseInt(multiReq.getParameter("spcHourEnd"));
		String spcDetSharing = multiReq.getParameter("spcDetSharing");
		String spcDetHoliday = multiReq.getParameter("spcDetHoliday");
		int cat = Integer.parseInt(multiReq.getParameter("cat"));
		
		//spaceExp
		
//		int spcDetNo = Integer.parseInt(request.getParameter("spcDetNo"));
		String spcExcDate = multiReq.getParameter("spcExcDate");
		int spcExcStart = Integer.parseInt(multiReq.getParameter("spcExcStart"));
		int spcExcEnd = Integer.parseInt(multiReq.getParameter("spcExcEnd"));
		
		//
		//spacePrice
		
		String spcDetName = multiReq.getParameter("spcDetName");
		String [] spcPriceDays = multiReq.getParameterValues("spcPriceDay");
		String spcPricePer = multiReq.getParameter("spcPricePer");
//		String spcPriceDayBool = request.getParameter("spcPriceDayBool");
		int spcPricePrice = Integer.parseInt(multiReq.getParameter("spcPricePrice"));
		
		
		//spaceImg
//		String spcImgTitle = request.getParameter("spcImgTitle");
//		String spcImgRoute = request.getParameter("spcImgRoute");
		
		//업로드 이미지 절대경로
		
		String spcImgTitle2 = multiReq.getFilesystemName("spcImgFile");
		String spcImgTitle = "'"+spcImgTitle2+"'";
		String spcImgRoute = "'"+saveDirectory +"/"+spcImgTitle2+"'";
		String spcImgText = "'"+spcImgTitle2+"'";
		
		String spcCttTitle2 = multiReq.getFilesystemName("spcCttFile");
		String spcCttTitle = "'"+spcImgTitle2+"'";
		String spcCttOldTitle = "'"+spcImgTitle2+"'";
		String spcCttText = "'"+spcImgTitle2+"'";
//		String spcFileName = multiReq.getFilesystemName("spcImgFile");
//		String spcImgFileFullPath = saveDirectory +"/"+spcFileName;
//		
//		
//		
//		String spcImgTitle = multiReq.getParameter(spcFileName);
//		String spcImgRoute = multiReq.getParameter(spcImgFileFullPath);
		
//		//사용자가 업로드한 파일명
//		String originalFileName = multiReq.getOriginalFileName("spcImgFile");
//		//실제 저장된 파일명
//		String renamedFileName = multiReq.getFilesystemName("spcImgFile");
		
		
		
		String spcDay = "";
		
		if(spcDays != null)
			spcDay = String.join(",", spcDays);
		
		Date spcDateStart_ = null;
		if(!"".equals(spcDateStart))
			spcDateStart_ = Date.valueOf(spcDateStart);
		
		Date spcDateEnd_ = null;
		if(!"".equals(spcDateEnd))
			spcDateEnd_ = Date.valueOf(spcDateEnd);
		
		SpacesDefault spDefault = new SpacesDefault(memberId, spcName, compAddr, compContent);
		int spcNo = 0;
		spcNo = new SpaceService().insertComp(spDefault);

		Spaces space = new Spaces(spcNo, cat, regionNo, spcContent, spcDetSharing.charAt(0), spcDetHoliday.charAt(0), spcDetSize, spcDetStorable, spcManMin, spcManMax, spcTimeMin, spcTimeMax, spcDateStart_, spcDateEnd_);
		
		//spc 넘버 받아오는 쿼리입니다.
		int spcDtlNo = 0;
		spcDtlNo = new SpaceService().insertSpace(space);
		
		//회사No 로 공간객체 가져오기
		//Spaces spcObj = new SpaceService().selectOneSpace(spcNo);
		SpacesTimeTable spacetimetable = new SpacesTimeTable(spcDtlNo, spcDay, spcHourStart, spcHourEnd);
		int result = 0;
		result = new SpaceService().insertSpaceTimeTable(spacetimetable);
		
		//spcExp : scpDetNo가져오기 
		
		Date spcExcDate_ = null;
		if(!"".equals(spcExcDate)) 
			spcExcDate_ = Date.valueOf(spcExcDate);
		
		SpacesTimeExp spacetimeexp = new SpacesTimeExp(spcDtlNo, spcExcDate_, spcExcStart, spcExcEnd);
		result += new SpaceService().insertSapceTimeExp(spacetimeexp);
		
		
//		System.out.println(spcObj.getSpcNo()+"@SpaceRegFormEndServlet");
		
		String spcPriceDay = "";
		
		if(spcPriceDays != null)
			spcPriceDay = String.join(",", spcPriceDays);

		
		SpacesPrice spaceprice = new SpacesPrice(spcDtlNo, spcDetName, spcPriceDay, spcPricePer.charAt(0), spcPricePrice);
		result += new SpaceService().insertPrice(spaceprice);
		
		//spcImg
		
		SpacesImg spaceimg = new SpacesImg(spcDtlNo, spcImgTitle, spcImgText,spcImgRoute, spcNo);
		SpacesCttImg spaceCttimg = new SpacesCttImg(spcDtlNo, spcCttTitle, spcCttText,spcNo, spcCttOldTitle);
		
		System.out.println("타이틀"+spcImgTitle);
		System.out.println("주소"+spcImgRoute);
		System.out.println("detno"+spcDtlNo);
		System.out.println("spcno"+spcNo);

		result += new SpaceService().insertImg(spaceimg);
		result += new SpaceService().insertCttImg(spaceCttimg);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
