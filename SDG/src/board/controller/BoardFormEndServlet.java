package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * 파일업로드
 */
@WebServlet("/board/boardFormEnd")
public class BoardFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFormEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.saveDirectory: 업로드한 파일의 절대경로
		
		//2.maxPostSize: 업로드한 파일 최대크기 10MB 1kb*1024*10
		
//		3.encoding: UTF-8
		String encoding = "utf-8";
		
		//4.fileRenamePolicy: 중복파일 리네임 정책 DefaultFileRenamePolicy a.txt, a1.txt, a2.txt,... 

//		MultipartRequest multiReq 
//			= new MultipartRequest(request, 
//					   
//					   encoding
//					   );
		
		//1.parameter
		//MultipartRequest를 사용한 경우, 
		//기존 HttpServletRequest에서는 사용자입력값을 가져올수 없다.
		String reviewTitle = request.getParameter("reviewTitle");
		System.out.println(request.getParameter("reviewTitle"));
		
		String memberId = request.getParameter("memberId");
		System.out.println(request.getParameter("memberId"));
		
		String reviewContent = request.getParameter("reviewContent");
		System.out.println(request.getParameter("reviewContent"));
		
		System.out.println("null인가 아닌가!!"+request.getParameter("reviewStar"));
		int reviewStar = Integer.parseInt(request.getParameter("reviewStar"));
		
		//XSS공격 대비 태그기호 치환
		//개행문자 \n => <br>
		reviewContent = reviewContent.replaceAll("<", "&lt;")
								   .replaceAll(">", "&gt;")
								   .replaceAll("\\n", "<br>");
		
		Board b = new Board(memberId, reviewStar, reviewTitle, reviewContent);
//		Board b = new Board(0, 0, memberId, 0, reviewStar, null, reviewTitle, reviewContent, null, null, null, 0, 0, null);
		System.out.println("board:before@servlet="+b);
		
		//2.업무로직
		int result = new BoardService().insertReview(b);
		System.out.println("board:after@servlet="+b);
		
		//3.뷰단 처리
		String msg = result>0?"게시글 등록 성공!":"게시글 등록 실패!";
		String loc = "/board/boardView?boardNo="+b.getReviewNo();
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp")
			   .forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
