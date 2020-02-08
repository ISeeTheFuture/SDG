package space.model.vo;

import java.sql.Date;

public class SpacesDefault {

	private int spcNo;
	private String memberId;
	private String spcName;
	private String spcAddr;
	private String spcContent;
	private char spcAvail;
	
	
	public SpacesDefault() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpacesDefault(String memberId, int spcNo) {
		super();
		this.memberId = memberId;
		this.spcNo = spcNo;
	}
	public SpacesDefault(int spcNo, String memberId, String spcName, String spcAddr, String spcContent, char spcAvail) {
		super();
		this.spcNo = spcNo;
		this.memberId = memberId;
		this.spcName = spcName;
		this.spcAddr = spcAddr;
		this.spcContent = spcContent;
		this.spcAvail = spcAvail;
	}
	
	//spaceRegForm 에서 사용하는 생성자
	public SpacesDefault(String memberId, String spcName, String spcAddr, String spcContent) {
		super();
		this.memberId = memberId;
		this.spcName = spcName;
		this.spcAddr = spcAddr;
		this.spcContent = spcContent;
	}
	public SpacesDefault(String memberId, String spcName) {
		super();
		this.memberId = memberId;
		this.spcName = spcName;
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
	
}
