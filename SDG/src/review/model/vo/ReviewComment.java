package review.model.vo;

import java.io.Serializable;
import java.sql.Date;


public class ReviewComment implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int commentNo; //댓글번호
	private String memId;
	private int reviewNo;
	private int commentType;
	private String commentContent;
	private Date commentDate;
	private int commentRecommend;
	private boolean commentDelete;
	public ReviewComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewComment(int commentNo, String memId, int reviewNo, int commentType, String commentContent,
			Date commentDate, int commentRecommend, boolean commentDelete) {
		super();
		this.commentNo = commentNo;
		this.memId = memId;
		this.reviewNo = reviewNo;
		this.commentType = commentType;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.commentRecommend = commentRecommend;
		this.commentDelete = commentDelete;
	}
	public ReviewComment(int reviewNo, String memId, String commentContent) {
		this.memId = memId;
		this.reviewNo = reviewNo;
		this.commentContent = commentContent;
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
	public boolean isCommentDelete() {
		return commentDelete;
	}
	public void setCommentDelete(boolean commentDelete) {
		this.commentDelete = commentDelete;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ReviewComment [commentNo=" + commentNo + ", memId=" + memId + ", reviewNo=" + reviewNo
				+ ", commentType=" + commentType + ", commentContent=" + commentContent + ", commentDate=" + commentDate
				+ ", commentRecommend=" + commentRecommend + ", commentDelete=" + commentDelete + "]";
	}
	
	
}
