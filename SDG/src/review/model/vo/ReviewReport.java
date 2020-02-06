package review.model.vo;

import java.io.Serializable;
import java.util.Date;

public class ReviewReport implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int reviewReportNo;
	private int reviewNo;
	private String reviewReportReason;
	private Date reviewReportDate;
	public ReviewReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewReport(int reviewReportNo, int reviewNo, String reviewReportReason, Date reviewReportDate) {
		super();
		this.reviewReportNo = reviewReportNo;
		this.reviewNo = reviewNo;
		this.reviewReportReason = reviewReportReason;
		this.reviewReportDate = reviewReportDate;
	}
	public int getReviewReportNo() {
		return reviewReportNo;
	}
	public void setReviewReportNo(int reviewReportNo) {
		this.reviewReportNo = reviewReportNo;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getReviewReportReason() {
		return reviewReportReason;
	}
	public void setReviewReportReason(String reviewReportReason) {
		this.reviewReportReason = reviewReportReason;
	}
	public Date getReviewReportDate() {
		return reviewReportDate;
	}
	public void setReviewReportDate(Date reviewReportDate) {
		this.reviewReportDate = reviewReportDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ReviewReport [reviewReportNo=" + reviewReportNo + ", reviewNo=" + reviewNo + ", reviewReportReason="
				+ reviewReportReason + ", reviewReportDate=" + reviewReportDate + "]";
	}

	
}
