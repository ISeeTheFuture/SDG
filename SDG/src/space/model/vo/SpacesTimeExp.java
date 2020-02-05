package space.model.vo;

import java.util.Date;

public class SpacesTimeExp {

	private int spcDetNo;
	private Date spcExcDate;
	private Date spcExcStart;
	private Date spcExcEnd;
	private char spcAvail;
	public SpacesTimeExp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpacesTimeExp(int spcDetNo, Date spcExcDate, Date spcExcStart, Date spcExcEnd, char spcAvail) {
		super();
		this.spcDetNo = spcDetNo;
		this.spcExcDate = spcExcDate;
		this.spcExcStart = spcExcStart;
		this.spcExcEnd = spcExcEnd;
		this.spcAvail = spcAvail;
	}
	public int getSpcDetNo() {
		return spcDetNo;
	}
	public void setSpcDetNo(int spcDetNo) {
		this.spcDetNo = spcDetNo;
	}
	public Date getSpcExcDate() {
		return spcExcDate;
	}
	public void setSpcExcDate(Date spcExcDate) {
		this.spcExcDate = spcExcDate;
	}
	public Date getSpcExcStart() {
		return spcExcStart;
	}
	public void setSpcExcStart(Date spcExcStart) {
		this.spcExcStart = spcExcStart;
	}
	public Date getSpcExcEnd() {
		return spcExcEnd;
	}
	public void setSpcExcEnd(Date spcExcEnd) {
		this.spcExcEnd = spcExcEnd;
	}
	public char getSpcAvail() {
		return spcAvail;
	}
	public void setSpcAvail(char spcAvail) {
		this.spcAvail = spcAvail;
	}
	
	
}
