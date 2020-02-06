package review.model.vo;

import java.io.Serializable;
import java.util.Date;

public class Review implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	private int reviewReport;//신고수
	private Boolean reviewDelete;//삭제여부
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(int reviewNo, int fieldNo, String memberId, int reviewOriNo, int reviewStar, String reviewType,
			String reviewTitle, String reviewContent, String reviewFile, String reviewUpfile, Date reviewDate,
			int reviewReadcnt, int reviewRecommend, int reviewReport, Boolean reviewDelete) {
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
		this.reviewReport = reviewReport;
		this.reviewDelete = reviewDelete;
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
	public int getReviewReport() {
		return reviewReport;
	}
	public void setReviewReport(int reviewReport) {
		this.reviewReport = reviewReport;
	}
	public Boolean getReviewDelete() {
		return reviewDelete;
	}
	public void setReviewDelete(Boolean reviewDelete) {
		this.reviewDelete = reviewDelete;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", fieldNo=" + fieldNo + ", memberId=" + memberId + ", reviewOriNo="
				+ reviewOriNo + ", reviewStar=" + reviewStar + ", reviewType=" + reviewType + ", reviewTitle="
				+ reviewTitle + ", reviewContent=" + reviewContent + ", reviewFile=" + reviewFile + ", reviewUpfile="
				+ reviewUpfile + ", reviewDate=" + reviewDate + ", reviewReadcnt=" + reviewReadcnt
				+ ", reviewRecommend=" + reviewRecommend + ", reviewReport=" + reviewReport + ", reviewDelete="
				+ reviewDelete + "]";
	}

	
	
}
