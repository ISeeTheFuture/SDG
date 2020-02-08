package board.model.service;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import board.model.dao.BoardDAO;
import board.model.vo.Board;
import board.model.vo.BoardComment;



public class BoardService {
	private BoardDAO boardDAO = new BoardDAO();

	public List<Board> selectBoardList() {
		Connection conn = getConnection();
		List<Board> list= new BoardDAO().selectBoardList(conn);
		close(conn);
		return list;
	}

	public int insertBoard(Board b) {
		Connection conn = getConnection();
		int result = new BoardDAO().insertBoard(conn, b);
		
		//새로 작성한 boardNo 가져오기
		//select seq_boardno.currval from dual;
		int boardNo = new BoardDAO().selectLastSeq(conn);
		b.setBoardNo(boardNo);
		
		//트랜잭션처리
		if(result > 0) commit(conn);
		else rollback(conn);
		
		//자원반납
		close(conn);
		return result;
	}
	
	public int selectBoardCount() {
		Connection conn = getConnection();
		int totalBoardCount = new BoardDAO().selectBoardCount(conn);
		close(conn);
		return totalBoardCount;
	}

	public List<Board> selectBoardList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Board> list= new BoardDAO().selectBoardList(conn, cPage, numPerPage);
		close(conn);
		return list;
	}
	
    public Board selectOne(int boardNo) {
		Connection conn = getConnection();
	
		Board board = new BoardDAO().selectOne(conn, boardNo);
		
		close(conn);
		return board;
	}

	public Board selectOne(int boardNo, boolean hasRead) {
		Connection conn = getConnection();
		int result = 0;
		//조회수 증가
		if(hasRead == false) {
			result = new BoardDAO().increaseReadCount(conn, boardNo);
		}
		
		Board board = new BoardDAO().selectOne(conn, boardNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return board;
	}
	

    public int deleteBoard(int board_no) {
		Connection conn = getConnection();
		int result = new BoardDAO().deleteBoard(conn, board_no);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		close(conn);
		
		return result;
	}
    
    public List<BoardComment> selectCommentList(int boardNo) {
		Connection conn = getConnection();
		List<BoardComment> list
			= new BoardDAO().selectCommentList(conn, boardNo);
		close(conn);
		return list;
	}

	public int updateBoard(Board b) {
		Connection conn = getConnection();
		int result = new BoardDAO().updateBoard(conn, b);

		if(result > 0)
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int insertBoardComment(BoardComment bc) {
		Connection conn = getConnection();
		int result = new BoardDAO().insertBoardComment(conn, bc);
		
		if(result>0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		
		return result;
	}

	public int deleteBoardComment(BoardComment bc) {
		Connection conn = getConnection();
		int result = new BoardDAO().deleteBoardComment(conn, bc);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		
		return result;
	}

}





