package space.model.vo;

import java.util.Date;

public class SpacesDefault {

	private int spcNo;
	private String memberId;
	private String spcName;
	private String spcAddr;
	private String spcContent;
	private char spcAvail;
	private Date spcDate;
	
	
	public SpacesDefault() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpacesDefault(String memberId, int spcNo) {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpacesDefault(int spcNo, String memberId, String spcName, String spcAddr, String spcContent, char spcAvail,
			Date spcDate) {
		super();
		this.spcNo = spcNo;
		this.memberId = memberId;
		this.spcName = spcName;
		this.spcAddr = spcAddr;
		this.spcContent = spcContent;
		this.spcAvail = spcAvail;
		this.spcDate = spcDate;
	}
	public int getSpcNo() {
		return spcNo;
	}
	public void setSpcNo(int spcNo) {
		this.spcNo = spcNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getSpcName() {
		return spcName;
	}
	public void setSpcName(String spcName) {
		this.spcName = spcName;
	}
	public String getSpcAddr() {
		return spcAddr;
	}
	public void setSpcAddr(String spcAddr) {
		this.spcAddr = spcAddr;
	}
	public String getSpcContent() {
		return spcContent;
	}
	public void setSpcContent(String spcContent) {
		this.spcContent = spcContent;
	}
	public char getSpcAvail() {
		return spcAvail;
	}
	public void setSpcAvail(char spcAvail) {
		this.spcAvail = spcAvail;
	}
	public Date getSpcDate() {
		return spcDate;
	}
	public void setSpcDate(Date spcDate) {
		this.spcDate = spcDate;
	}
	
	
	
	
}
