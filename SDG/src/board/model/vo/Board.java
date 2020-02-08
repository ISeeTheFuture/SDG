package board.model.vo;

import java.io.Serializable;
import java.util.Date;

public class Board implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
<<<<<<< HEAD
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
=======
	private int reviewNo;//글번호
	private int fieldNo;//공간no
	private String memberId;//아이디
	private int reviewOriNo;//원본글번호
	private int reviewStar;//평점
	private String reviewType;//유형
	private String reviewTitle;//제목
	private String reviewContent;//내용
	private String reviewFile;//파일명
	private String reviewUpfile;//파일명 변경
	private Date reviewDate;//작성시간
	private int reviewReadcnt;//조회수
	private int reviewRecommend;//추천수
	private String reviewDelete;//삭제여부
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
//	public Board(String memberId, int reviewStar, String reviewTitle, String reviewContent) {
//		super();
//		this.memberId = memberId;
//		this.reviewStar = reviewStar;
//		this.reviewTitle = reviewTitle;
//		this.reviewContent = reviewContent;
//	}


	public Board(int reviewNo, int fieldNo, String memberId, int reviewOriNo, int reviewStar, String reviewType,
			String reviewTitle, String reviewContent, String reviewFile, String reviewUpfile, Date reviewDate,
			int reviewReadcnt, int reviewRecommend, String reviewDelete) {
		super();
		this.reviewNo = reviewNo;
		this.fieldNo = fieldNo;
		this.memberId = memberId;
		this.reviewOriNo = reviewOriNo;
		this.reviewStar = reviewStar;
		this.reviewType = reviewType;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewFile = reviewFile;
		this.reviewUpfile = reviewUpfile;
		this.reviewDate = reviewDate;
		this.reviewReadcnt = reviewReadcnt;
		this.reviewRecommend = reviewRecommend;
		this.reviewDelete = reviewDelete;
	}
	public Board(String memberId2, int reviewStar2, String reviewTitle2, String reviewContent2) {
		
	}


	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
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
	public int getReviewOriNo() {
		return reviewOriNo;
	}
	public void setReviewOriNo(int reviewOriNo) {
		this.reviewOriNo = reviewOriNo;
	}
	public int getReviewStar() {
		return reviewStar;
	}
	public void setReviewStar(int reviewStar) {
		this.reviewStar = reviewStar;
	}
	public String getReviewType() {
		return reviewType;
	}
	public void setReviewType(String reviewType) {
		this.reviewType = reviewType;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewFile() {
		return reviewFile;
	}
	public void setReviewFile(String reviewFile) {
		this.reviewFile = reviewFile;
	}
	public String getReviewUpfile() {
		return reviewUpfile;
	}
	public void setReviewUpfile(String reviewUpfile) {
		this.reviewUpfile = reviewUpfile;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getReviewReadcnt() {
		return reviewReadcnt;
	}
	public void setReviewReadcnt(int reviewReadcnt) {
		this.reviewReadcnt = reviewReadcnt;
	}
	public int getReviewRecommend() {
		return reviewRecommend;
	}
	public void setReviewRecommend(int reviewRecommend) {
		this.reviewRecommend = reviewRecommend;
	}
	public String getReviewDelete() {
		return reviewDelete;
	}
	public void setReviewDelete(String reviewDelete) {
		this.reviewDelete = reviewDelete;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Board [reviewNo=" + reviewNo + ", fieldNo=" + fieldNo + ", memberId=" + memberId + ", reviewOriNo="
				+ reviewOriNo + ", reviewStar=" + reviewStar + ", reviewType=" + reviewType + ", reviewTitle="
				+ reviewTitle + ", reviewContent=" + reviewContent + ", reviewFile=" + reviewFile + ", reviewUpfile="
				+ reviewUpfile + ", reviewDate=" + reviewDate + ", reviewReadcnt=" + reviewReadcnt
				+ ", reviewRecommend=" + reviewRecommend + ", reviewDelete=" + reviewDelete + "]";
	}
	
>>>>>>> branch 'master' of https://github.com/ISeeTheFuture/SDG.git
	
}
