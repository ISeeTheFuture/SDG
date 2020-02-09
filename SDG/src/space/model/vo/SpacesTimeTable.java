package space.model.vo;

import java.io.Serializable;

public class SpacesTimeTable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int spcDetNo;
	private String spcDay;
	private int spcHourStart;
	private int spcHourEnd;
	private char spcAvail;
	public SpacesTimeTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpacesTimeTable(int spcDetNo, String spcDay, int spcHourStart, int spcHourEnd, char spcAvail) {
		super();
		this.spcDetNo = spcDetNo;
		this.spcDay = spcDay;
		this.spcHourStart = spcHourStart;
		this.spcHourEnd = spcHourEnd;
		this.spcAvail = spcAvail;
	}
	//AVAIL 제외
	public SpacesTimeTable(int spcDetNo, String spcDay, int spcHourStart, int spcHourEnd) {
		super();
		this.spcDetNo = spcDetNo;
		this.spcDay = spcDay;
		this.spcHourStart = spcHourStart;
		this.spcHourEnd = spcHourEnd;
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
	public int getSpcHourStart() {
		return spcHourStart;
	}
	public void setSpcHourStart(int spcHourStart) {
		this.spcHourStart = spcHourStart;
	}
	public int getSpcHourEnd() {
		return spcHourEnd;
	}
	public void setSpcHourEnd(int spcHourEnd) {
		this.spcHourEnd = spcHourEnd;
	}
	public char getSpcAvail() {
		return spcAvail;
	}
	public void setSpcAvail(char spcAvail) {
		this.spcAvail = spcAvail;
	}
	
	
}
