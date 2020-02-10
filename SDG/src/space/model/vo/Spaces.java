
package space.model.vo;

import java.sql.Date;

public class Spaces {

	private int spcDetNo;
	private int spcNo;
	private int spcTypeNo;
	private int spcLocNo;
	private char spcDetAvail;
	private String spcDetContent;
	private char spcDetSharing;
	private char spcDetHoliday;
	private int spcDetSize;
	private int spcDetCapacity;
	private int spcCapMin;
	private int spcCapMax;
	private int spcTimeMin;
	private int spcTimeMax;
	private Date spcDateStart;
	private Date spcDateEnd;
	public Spaces() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Spaces(int spcDetNo, int spcNo, int spcTypeNo, int spcLocNo, char spcDetAvail, String spcDetContent,
			char spcDetSharing, char spcDetHoliday, int spcDetSize, int spcDetCapacity, int spcCapMin, int spcCapMax,
			int spcTimeMin, int spcTimeMax, Date spcDateStart, Date spcDateEnd) {
		super();
		this.spcDetNo = spcDetNo;
		this.spcNo = spcNo;
		this.spcTypeNo = spcTypeNo;
		this.spcLocNo = spcLocNo;
		this.spcDetAvail = spcDetAvail;
		this.spcDetContent = spcDetContent;
		this.spcDetSharing = spcDetSharing;
		this.spcDetHoliday = spcDetHoliday;
		this.spcDetSize = spcDetSize;
		this.spcDetCapacity = spcDetCapacity;
		this.spcCapMin = spcCapMin;
		this.spcCapMax = spcCapMax;
		this.spcTimeMin = spcTimeMin;
		this.spcTimeMax = spcTimeMax;
		this.spcDateStart = spcDateStart;
		this.spcDateEnd = spcDateEnd;
	}
	//space 등록에 사용하는 파라미터 생성자
	public Spaces(int spcNo, int spcTypeNo, int spcLocNo, String spcDetContent, char spcDetSharing, char spcDetHoliday,
			int spcDetSize, int spcDetCapacity, int spcCapMin, int spcCapMax, int spcTimeMin, int spcTimeMax,
			Date spcDateStart, Date spcDateEnd) {
		super();
		this.spcNo = spcNo;
		this.spcTypeNo = spcTypeNo;
		this.spcLocNo = spcLocNo;
		this.spcDetContent = spcDetContent;
		this.spcDetSharing = spcDetSharing;
		this.spcDetHoliday = spcDetHoliday;
		this.spcDetSize = spcDetSize;
		this.spcDetCapacity = spcDetCapacity;
		this.spcCapMin = spcCapMin;
		this.spcCapMax = spcCapMax;
		this.spcTimeMin = spcTimeMin;
		this.spcTimeMax = spcTimeMax;
		this.spcDateStart = spcDateStart;
		this.spcDateEnd = spcDateEnd;
	}
	public int getSpcDetNo() {
		return spcDetNo;
	}
	public void setSpcDetNo(int spcDetNo) {
		this.spcDetNo = spcDetNo;
	}
	public int getSpcNo() {
		return spcNo;
	}
	public void setSpcNo(int spcNo) {
		this.spcNo = spcNo;
	}
	public int getSpcTypeNo() {
		return spcTypeNo;
	}
	public void setSpcTypeNo(int spcTypeNo) {
		this.spcTypeNo = spcTypeNo;
	}
	public int getSpcLocNo() {
		return spcLocNo;
	}
	public void setSpcLocNo(int spcLocNo) {
		this.spcLocNo = spcLocNo;
	}
	public char getSpcDetAvail() {
		return spcDetAvail;
	}
	public void setSpcDetAvail(char spcDetAvail) {
		this.spcDetAvail = spcDetAvail;
	}
	public String getSpcDetContent() {
		return spcDetContent;
	}
	public void setSpcDetContent(String spcDetContent) {
		this.spcDetContent = spcDetContent;
	}
	public char getSpcDetSharing() {
		return spcDetSharing;
	}
	public void setSpcDetSharing(char spcDetSharing) {
		this.spcDetSharing = spcDetSharing;
	}
	public char getSpcDetHoliday() {
		return spcDetHoliday;
	}
	public void setSpcDetHoliday(char spcDetHoliday) {
		this.spcDetHoliday = spcDetHoliday;
	}
	public int getSpcDetSize() {
		return spcDetSize;
	}
	public void setSpcDetSize(int spcDetSize) {
		this.spcDetSize = spcDetSize;
	}
	public int getSpcDetCapacity() {
		return spcDetCapacity;
	}
	public void setSpcDetCapacity(int spcDetCapacity) {
		this.spcDetCapacity = spcDetCapacity;
	}
	public int getSpcCapMin() {
		return spcCapMin;
	}
	public void setSpcCapMin(int spcCapMin) {
		this.spcCapMin = spcCapMin;
	}
	public int getSpcCapMax() {
		return spcCapMax;
	}
	public void setSpcCapMax(int spcCapMax) {
		this.spcCapMax = spcCapMax;
	}
	public Date getSpcDateStart() {
		return spcDateStart;
	}
	public void setSpcDateStart(Date spcDateStart) {
		this.spcDateStart = spcDateStart;
	}
	public Date getSpcDateEnd() {
		return spcDateEnd;
	}
	public void setSpcDateEnd(Date spcDateEnd) {
		this.spcDateEnd = spcDateEnd;
	}
	public int getSpcTimeMin() {
		return spcTimeMin;
	}
	public void setSpcTimeMin(int spcTimeMin) {
		this.spcTimeMin = spcTimeMin;
	}
	public int getSpcTimeMax() {
		return spcTimeMax;
	}
	public void setSpcTimeMax(int spcTimeMax) {
		this.spcTimeMax = spcTimeMax;
	}
	
	


	
	


	
}

