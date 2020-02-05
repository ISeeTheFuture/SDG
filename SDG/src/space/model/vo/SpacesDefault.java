package space.model.vo;

import java.util.Date;

public class SpacesDefault {

	private int spc_no;
	private String member_id;
	private String spc_name;
	private String spc_addr;
	private String spc_content;
	private char spc_avail;
	private Date spc_date;
	public SpacesDefault() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpacesDefault(int spc_no, String member_id, String spc_name, String spc_addr, String spc_content,
			char spc_avail, Date spc_date) {
		super();
		this.spc_no = spc_no;
		this.member_id = member_id;
		this.spc_name = spc_name;
		this.spc_addr = spc_addr;
		this.spc_content = spc_content;
		this.spc_avail = spc_avail;
		this.spc_date = spc_date;
	}
	public int getSpc_no() {
		return spc_no;
	}
	public void setSpc_no(int spc_no) {
		this.spc_no = spc_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getSpc_name() {
		return spc_name;
	}
	public void setSpc_name(String spc_name) {
		this.spc_name = spc_name;
	}
	public String getSpc_addr() {
		return spc_addr;
	}
	public void setSpc_addr(String spc_addr) {
		this.spc_addr = spc_addr;
	}
	public String getSpc_content() {
		return spc_content;
	}
	public void setSpc_content(String spc_content) {
		this.spc_content = spc_content;
	}
	public char getSpc_avail() {
		return spc_avail;
	}
	public void setSpc_avail(char spc_avail) {
		this.spc_avail = spc_avail;
	}
	public Date getSpc_date() {
		return spc_date;
	}
	public void setSpc_date(Date spc_date) {
		this.spc_date = spc_date;
	}
	
	
}
