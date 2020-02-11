package review.model.vo;

import java.io.Serializable;
import java.sql.Date;


public class ReviewCommentReport implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int commentReportNo;
	private int commentNo;
	private String commentReportReason;
	private Date commentReportDate;
	
	
	public ReviewCommentReport() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReviewCommentReport(int commentReportNo, int commentNo, String commentReportReason, Date commentReportDate) {
		super();
		this.commentReportNo = commentReportNo;
		this.commentNo = commentNo;
		this.commentReportReason = commentReportReason;
		this.commentReportDate = commentReportDate;
	}


	public int getCommentReportNo() {
		return commentReportNo;
	}


	public void setCommentReportNo(int commentReportNo) {
		this.commentReportNo = commentReportNo;
	}


	public int getCommentNo() {
		return commentNo;
	}


	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}


	public String getCommentReportReason() {
		return commentReportReason;
	}


	public void setCommentReportReason(String commentReportReason) {
		this.commentReportReason = commentReportReason;
	}


	public Date getCommentReportDate() {
		return commentReportDate;
	}


	public void setCommentReportDate(Date commentReportDate) {
		this.commentReportDate = commentReportDate;
	}


	@Override
	public String toString() {
		return "ReviewCommentReport [commentReportNo=" + commentReportNo + ", commentNo=" + commentNo
				+ ", commentReportReason=" + commentReportReason + ", commentReportDate=" + commentReportDate + "]";
	}
	
	

}
