package space.model.vo;

import java.util.Date;

public class SpacesTimeTable {

	private int spcDetNo;
	private String spcDay;
	private Date spcHourStart;
	private Date spcHourEnd;
	private char spcAvail;
	public SpacesTimeTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpacesTimeTable(int spcDetNo, String spcDay, Date spcHourStart, Date spcHourEnd, char spcAvail) {
		super();
		this.spcDetNo = spcDetNo;
		this.spcDay = spcDay;
		this.spcHourStart = spcHourStart;
		this.spcHourEnd = spcHourEnd;
		this.spcAvail = spcAvail;
	}
	public int getSpcDetNo() {
		return spcDetNo;
	}
	public void setSpcDetNo(int spcDetNo) {
		this.spcDetNo = spcDetNo;
	}
	public String getSpcDay() {
		return spcDay;
	}
	public void setSpcDay(String spcDay) {
		this.spcDay = spcDay;
	}
	public Date getSpcHourStart() {
		return spcHourStart;
	}
	public void setSpcHourStart(Date spcHourStart) {
		this.spcHourStart = spcHourStart;
	}
	public Date getSpcHourEnd() {
		return spcHourEnd;
	}
	public void setSpcHourEnd(Date spcHourEnd) {
		this.spcHourEnd = spcHourEnd;
	}
	public char getSpcAvail() {
		return spcAvail;
	}
	public void setSpcAvail(char spcAvail) {
		this.spcAvail = spcAvail;
	}
	
	
}
