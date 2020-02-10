package member.model.vo;

import java.util.Date;

public class MemberBlk {
	
	private String memId;
	private Date blockWrite;
	private Date blockComment;
	private String blockMemo;
	public MemberBlk() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberBlk(String memId, Date blockWrite, Date blockComment, String blockMemo) {
		super();
		this.memId = memId;
		this.blockWrite = blockWrite;
		this.blockComment = blockComment;
		this.blockMemo = blockMemo;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public Date getBlockWrite() {
		return blockWrite;
	}
	public void setBlockWrite(Date blockWrite) {
		this.blockWrite = blockWrite;
	}
	public Date getBlockComment() {
		return blockComment;
	}
	public void setBlockComment(Date blockComment) {
		this.blockComment = blockComment;
	}
	public String getBlockMemo() {
		return blockMemo;
	}
	public void setBlockMemo(String blockMemo) {
		this.blockMemo = blockMemo;
	}
	@Override
	public String toString() {
		return "MemberBlk [memId=" + memId + ", blockWrite=" + blockWrite + ", blockComment=" + blockComment
				+ ", blockMemo=" + blockMemo + "]";
	}
	
}
