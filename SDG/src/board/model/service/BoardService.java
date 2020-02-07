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


/**
 * sdad
 * 
 *
 */
public class BoardService {
	private BoardDAO boardDAO = new BoardDAO();

	public List<Board> selectBoardList() {
		Connection conn = getConnection();
		List<Board> list= new BoardDAO().selectBoardList(conn);
		close(conn);
		return list;
	}

	
	public int selectBoardCount(Board fieldNo) {
		Connection conn = getConnection();
		int totalBoardCount = new BoardDAO().selectBoardCount(conn, fieldNo);
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
		//議고쉶�닔 利앷�
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

	
	public int selectStarAvg(Board fieldNo) {
		Connection conn = getConnection();
		int totalBoardCount = new BoardDAO().selectStarAvg(conn, fieldNo);
		close(conn);
		return totalBoardCount;
	}

	public int insertReview(Board b) {
		Connection conn = getConnection();
		int result = new BoardDAO().insertReview(conn, b);
		
		//�깉濡� �옉�꽦�븳 boardNo 媛��졇�삤湲�
		//select seq_boardno.currval from dual;
//		int reviewNo = new BoardDAO().selectLastSeq(conn);
//		b.setReviewNo(reviewNo);
		
		//�듃�옖�옲�뀡泥섎━
		if(result > 0) commit(conn);
		else rollback(conn);
		
		//�옄�썝諛섎궔
		close(conn);
		return result;
	}

}





