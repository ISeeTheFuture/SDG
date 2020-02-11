package member.model.vo;

import java.sql.Date;

public class Memberblk {

	private String mem_id; 
	private Date block_write;
	private Date block_comment;
	private String mem_memo;
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public Date getBlock_write() {
		return block_write;
	}
	public void setBlock_write(Date block_write) {
		this.block_write = block_write;
	}
	public Date getBlock_comment() {
		return block_comment;
	}
	public void setBlock_comment(Date block_comment) {
		this.block_comment = block_comment;
	}
	public String getMem_memo() {
		return mem_memo;
	}
	public void setMem_memo(String mem_memo) {
		this.mem_memo = mem_memo;
	}
	@Override
	public String toString() {
		return "Memberblk [mem_id=" + mem_id + ", block_write=" + block_write + ", block_comment=" + block_comment
				+ ", mem_memo=" + mem_memo + "]";
	}
	public Memberblk(String mem_id, Date block_write, Date block_comment, String mem_memo) {
		super();
		this.mem_id = mem_id;
		this.block_write = block_write;
		this.block_comment = block_comment;
		this.mem_memo = mem_memo;
	}
	public Memberblk() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	
	
	
	
	
	
	
	
	
}
