package space.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.model.service.SpcViewService;
import space.model.vo.Spaces;
import space.model.vo.SpacesCttImg;
import space.model.vo.SpacesDefault;
import space.model.vo.SpacesImg;
import space.model.vo.SpacesPrice;

/**
 * Servlet implementation class SpaceViewServlet
 */
@WebServlet("/space/spaceView")
public class SpaceViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpaceViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int spcNo = Integer.parseInt(request.getParameter("spcNo"));
		SpacesDefault spc = new SpcViewService().selectSpc(spcNo);
		Spaces spcDtl = new SpcViewService().selectSpcDtl(spcNo);
		int spcDtlNo = spcDtl.getSpcDetNo();
		SpacesImg spcImg = new SpcViewService().selectSpcImg(spcDtlNo);
		String spcLoc = new SpcViewService().selectSpcLoc(spcDtl.getSpcLocNo());
		SpacesPrice spcPrice = new SpcViewService().selectSpcPrice(spcDtlNo);
		String spcType = new SpcViewService().selectSpcType(spcDtl.getSpcTypeNo());
		SpacesCttImg spcCttImg = new SpcViewService().selectSpcCttImg(spcDtlNo); 

		
		request.setAttribute("spcTitle", spc.getSpcName());
		request.setAttribute("spcLoc", spcLoc);
		request.setAttribute("spcType", spcType);
		request.setAttribute("spcPics", spcImg.getSpcImgTitle());
		request.setAttribute("spcText", spcDtl.getSpcDetContent());
		request.setAttribute("spcAddr", spc.getSpcAddr()==null?"":spc.getSpcAddr());
		request.setAttribute("spcTimeMin", spcDtl.getSpcTimeMin());
		request.setAttribute("spcTimeMax", spcDtl.getSpcTimeMax());
		request.setAttribute("spcManMin", spcDtl.getSpcCapMin());
		request.setAttribute("spcManMax", spcDtl.getSpcCapMax());
		request.setAttribute("spcPrice", spcPrice.getSpcPricePrice());
		request.setAttribute("spcImgs", spcImg.getSpcImgTitle());
		request.setAttribute("spcCttImgs", spcCttImg==null?"":spcCttImg.getSpcCttImgTitle());
		
		
		
		request.getRequestDispatcher("/WEB-INF/views/space/spaceView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
