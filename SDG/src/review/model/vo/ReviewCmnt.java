package review.model.vo;

import java.sql.Date;

public class ReviewCmnt {
	
	private int commentNo;
	private String memId;
	private int reviewNo;
	private int commentType;
	private String commentContent;
	private Date commentDate;
	private int commentRecommend;
	private String commendDelete;
	public ReviewCmnt() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewCmnt(int commentNo, String memId, int reviewNo, int commentType, String commentContent,
			Date commentDate, int commentRecommend, String commendDelete) {
		super();
		this.commentNo = commentNo;
		this.memId = memId;
		this.reviewNo = reviewNo;
		this.commentType = commentType;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.commentRecommend = commentRecommend;
		this.commendDelete = commendDelete;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public int getCommentType() {
		return commentType;
	}
	public void setCommentType(int commentType) {
		this.commentType = commentType;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public int getCommentRecommend() {
		return commentRecommend;
	}
	public void setCommentRecommend(int commentRecommend) {
		this.commentRecommend = commentRecommend;
	}
	public String getCommendDelete() {
		return commendDelete;
	}
	public void setCommendDelete(String commendDelete) {
		this.commendDelete = commendDelete;
	}
	@Override
	public String toString() {
		return "ReviewCmnt [commentNo=" + commentNo + ", memId=" + memId + ", reviewNo=" + reviewNo + ", commentType="
				+ commentType + ", commentContent=" + commentContent + ", commentDate=" + commentDate
				+ ", commentRecommend=" + commentRecommend + ", commendDelete=" + commendDelete + "]";
	}
	
	
	

}
