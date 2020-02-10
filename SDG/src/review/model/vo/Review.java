package review.model.vo;

import java.sql.Date;

public class Review {
	private int reviewNo;
	private int spcNo;
	private String memId;
	private int reviewOriNo;
	private int reviewStar;
	private String reviewType;
	private String reviewTitle;
	private String reviewContent;
	private String reviewFile;
	private String reviewUpFile;
	private Date reviewDate;
	private int reviewReadCnt;
	private int reviewRecommend;
	private String reviewDelete;
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Review(int reviewNo, int spcNo, String memId, int reviewOriNo, int reviewStar, String reviewType,
			String reviewTitle, String reviewContent, String reviewFile, String reviewUpFile, Date reviewDate,
			int reviewReadCnt, int reviewRecommend, String reviewDelete) {
		super();
		this.reviewNo = reviewNo;
		this.spcNo = spcNo;
		this.memId = memId;
		this.reviewOriNo = reviewOriNo;
		this.reviewStar = reviewStar;
		this.reviewType = reviewType;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewFile = reviewFile;
		this.reviewUpFile = reviewUpFile;
		this.reviewDate = reviewDate;
		this.reviewReadCnt = reviewReadCnt;
		this.reviewRecommend = reviewRecommend;
		this.reviewDelete = reviewDelete;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getSpcNo() {
		return spcNo;
	}
	public void setSpcNo(int spcNo) {
		this.spcNo = spcNo;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
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
	public String getReviewUpFile() {
		return reviewUpFile;
	}
	public void setReviewUpFile(String reviewUpFile) {
		this.reviewUpFile = reviewUpFile;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getReviewReadCnt() {
		return reviewReadCnt;
	}
	public void setReviewReadCnt(int reviewReadCnt) {
		this.reviewReadCnt = reviewReadCnt;
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
	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", spcNo=" + spcNo + ", memId=" + memId + ", reviewOriNo=" + reviewOriNo
				+ ", reviewStar=" + reviewStar + ", reviewType=" + reviewType + ", reviewTitle=" + reviewTitle
				+ ", reviewContent=" + reviewContent + ", reviewFile=" + reviewFile + ", reviewUpFile=" + reviewUpFile
				+ ", reviewDate=" + reviewDate + ", reviewReadCnt=" + reviewReadCnt + ", reviewRecommend="
				+ reviewRecommend + ", reviewDelete=" + reviewDelete + "]";
	}
	
	

}
