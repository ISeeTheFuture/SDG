package space.model.vo;

import java.sql.Date;

public class SpacesTimeExp {

	private int spcDetNo;
	private Date spcExcDate;
	private int spcExcStart;
	private int spcExcEnd;
	private char spcAvail;
	public SpacesTimeExp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpacesTimeExp(int spcDetNo, Date spcExcDate, int spcExcStart, int spcExcEnd, char spcAvail) {
		super();
		this.spcDetNo = spcDetNo;
		this.spcExcDate = spcExcDate;
		this.spcExcStart = spcExcStart;
		this.spcExcEnd = spcExcEnd;
		this.spcAvail = spcAvail;
	}
	//exp전용 생성자
	public SpacesTimeExp(int spcDetNo, Date spcExcDate, int spcExcStart, int spcExcEnd) {
		super();
		this.spcDetNo = spcDetNo;
		this.spcExcDate = spcExcDate;
		this.spcExcStart = spcExcStart;
		this.spcExcEnd = spcExcEnd;
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
	public int getSpcExcStart() {
		return spcExcStart;
	}
	public void setSpcExcStart(int spcExcStart) {
		this.spcExcStart = spcExcStart;
	}
	public int getSpcExcEnd() {
		return spcExcEnd;
	}
	public void setSpcExcEnd(int spcExcEnd) {
		this.spcExcEnd = spcExcEnd;
	}
	public char getSpcAvail() {
		return spcAvail;
	}
	public void setSpcAvail(char spcAvail) {
		this.spcAvail = spcAvail;
	}
	
	
}
