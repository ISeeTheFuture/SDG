package review.model.vo;

import java.sql.Date;

public class CmmtRpt {
	private int commentReport;
	private int commentNo;
	private String commentReportReason;
	private Date commentReportDate;
	public CmmtRpt() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CmmtRpt(int commentReport, int commentNo, String commentReportReason, Date commentReportDate) {
		super();
		this.commentReport = commentReport;
		this.commentNo = commentNo;
		this.commentReportReason = commentReportReason;
		this.commentReportDate = commentReportDate;
	}
	public int getCommentReport() {
		return commentReport;
	}
	public void setCommentReport(int commentReport) {
		this.commentReport = commentReport;
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
		return "CmmtRpt [commentReport=" + commentReport + ", commentNo=" + commentNo + ", commentReportReason="
				+ commentReportReason + ", commentReportDate=" + commentReportDate + "]";
	}

	
}
