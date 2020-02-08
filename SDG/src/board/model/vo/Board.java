package board.model.vo;

import java.io.Serializable;
import java.util.Date;

public class Board implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int boardNo;//글번호
	private int fieldNo;//공간no
	private String memberId;//아이디
	private int boardOriNo;//원본글번호
	private int boardStar;//평점
	private String boardType;//유형
	private String boardTitle;//제목
	private String boardContent;//내용
	private String boardFile;//파일명
	private String boardUpfile;//파일명 변경
	private Date boardDate;//작성시간
	private int boardReadcnt;//조회수
	private int boardRecommend;//추천수
	private int boardReport;//신고수
	private Boolean boardDelete;//삭제여부
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Board(int boardNo, int fieldNo, String memberId, int boardOriNo, int boardStar, String boardType,
			String boardTitle, String boardContent, String boardFile, String boardUpfile, Date boardDate,
			int boardReadcnt, int boardRecommend, int boardReport, Boolean boardDelete) {
		super();
		this.boardNo = boardNo;
		this.fieldNo = fieldNo;
		this.memberId = memberId;
		this.boardOriNo = boardOriNo;
		this.boardStar = boardStar;
		this.boardType = boardType;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardFile = boardFile;
		this.boardUpfile = boardUpfile;
		this.boardDate = boardDate;
		this.boardReadcnt = boardReadcnt;
		this.boardRecommend = boardRecommend;
		this.boardReport = boardReport;
		this.boardDelete = boardDelete;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getFieldNo() {
		return fieldNo;
	}
	public void setFieldNo(int fieldNo) {
		this.fieldNo = fieldNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getBoardOriNo() {
		return boardOriNo;
	}
	public void setBoardOriNo(int boardOriNo) {
		this.boardOriNo = boardOriNo;
	}
	public int getBoardStar() {
		return boardStar;
	}
	public void setBoardStar(int boardStar) {
		this.boardStar = boardStar;
	}
	public String getBoardType() {
		return boardType;
	}
	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardFile() {
		return boardFile;
	}
	public void setBoardFile(String boardFile) {
		this.boardFile = boardFile;
	}
	public String getBoardUpfile() {
		return boardUpfile;
	}
	public void setBoardUpfile(String boardUpfile) {
		this.boardUpfile = boardUpfile;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public int getBoardReadcnt() {
		return boardReadcnt;
	}
	public void setBoardReadcnt(int boardReadcnt) {
		this.boardReadcnt = boardReadcnt;
	}
	public int getBoardRecommend() {
		return boardRecommend;
	}
	public void setBoardRecommend(int boardRecommend) {
		this.boardRecommend = boardRecommend;
	}
	public int getBoardReport() {
		return boardReport;
	}
	public void setBoardReport(int boardReport) {
		this.boardReport = boardReport;
	}
	public Boolean getBoardDelete() {
		return boardDelete;
	}
	public void setBoardDelete(Boolean boardDelete) {
		this.boardDelete = boardDelete;
	}
	
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", fieldNo=" + fieldNo + ", memberId=" + memberId + ", boardOriNo="
				+ boardOriNo + ", boardStar=" + boardStar + ", boardType=" + boardType + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", boardFile=" + boardFile + ", boardUpfile=" + boardUpfile
				+ ", boardDate=" + boardDate + ", boardReadcnt=" + boardReadcnt + ", boardRecommend=" + boardRecommend
				+ ", boardReport=" + boardReport + ", boardDelete=" + boardDelete + "]";
	}
	
}
