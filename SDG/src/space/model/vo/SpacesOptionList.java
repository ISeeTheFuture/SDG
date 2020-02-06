package space.model.vo;

import java.util.Date;

public class SpacesOptionList {

	private int spcOptionNo;
	private String spcOptionName;
	private String spcOptionIcon;
	private Date spcOptionDate;
	public SpacesOptionList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpacesOptionList(int spcOptionNo, String spcOptionName, String spcOptionIcon, Date spcOptionDate) {
		super();
		this.spcOptionNo = spcOptionNo;
		this.spcOptionName = spcOptionName;
		this.spcOptionIcon = spcOptionIcon;
		this.spcOptionDate = spcOptionDate;
	}
	public int getSpcOptionNo() {
		return spcOptionNo;
	}
	public void setSpcOptionNo(int spcOptionNo) {
		this.spcOptionNo = spcOptionNo;
	}
	public String getSpcOptionName() {
		return spcOptionName;
	}
	public void setSpcOptionName(String spcOptionName) {
		this.spcOptionName = spcOptionName;
	}
	public String getSpcOptionIcon() {
		return spcOptionIcon;
	}
	public void setSpcOptionIcon(String spcOptionIcon) {
		this.spcOptionIcon = spcOptionIcon;
	}
	public Date getSpcOptionDate() {
		return spcOptionDate;
	}
	public void setSpcOptionDate(Date spcOptionDate) {
		this.spcOptionDate = spcOptionDate;
	}
	
}
