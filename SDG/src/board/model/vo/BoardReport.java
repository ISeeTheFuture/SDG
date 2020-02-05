package board.model.vo;

import java.io.Serializable;
import java.util.Date;

public class BoardReport implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int boardReportNo;
	private int boardNo;
	private String boardReportReason;
	private Date boardReportDate;
	public BoardReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardReport(int boardReportNo, int boardNo, String boardReportReason, Date boardReportDate) {
		super();
		this.boardReportNo = boardReportNo;
		this.boardNo = boardNo;
		this.boardReportReason = boardReportReason;
		this.boardReportDate = boardReportDate;
	}
	public int getBoardReportNo() {
		return boardReportNo;
	}
	public void setBoardReportNo(int boardReportNo) {
		this.boardReportNo = boardReportNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardReportReason() {
		return boardReportReason;
	}
	public void setBoardReportReason(String boardReportReason) {
		this.boardReportReason = boardReportReason;
	}
	public Date getBoardReportDate() {
		return boardReportDate;
	}
	public void setBoardReportDate(Date boardReportDate) {
		this.boardReportDate = boardReportDate;
	}
	@Override
	public String toString() {
		return "BoardReport [boardReportNo=" + boardReportNo + ", boardNo=" + boardNo + ", boardReportReason="
				+ boardReportReason + ", boardReportDate=" + boardReportDate + "]";
	}

}
