package res.model.vo;


import java.sql.Timestamp;

public class ResMeView{

	private int resGroupNo;
	private String memId;
	private int resMany;
	private String resName;
	private int resNo;
	private int resCancle;
	private Timestamp resTimeStart;
	private Timestamp resTimeEnd;
	private int spcPrice;
	private String spcName;
	private String spcImgTitle;
	private int spcNo;
	private int spcDtlNo;

	public ResMeView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResMeView(int resGroupNo, String memId, int resMany, String resName, int resNo, int resCancle,
			Timestamp resTimeStart, Timestamp resTimeEnd, int spcPrice, String spcName, String spcImgTitle, int spcNo,
			int spcDtlNo) {
		super();
		this.resGroupNo = resGroupNo;
		this.memId = memId;
		this.resMany = resMany;
		this.resName = resName;
		this.resNo = resNo;
		this.resCancle = resCancle;
		this.resTimeStart = resTimeStart;
		this.resTimeEnd = resTimeEnd;
		this.spcPrice = spcPrice;
		this.spcName = spcName;
		this.spcImgTitle = spcImgTitle;
		this.spcNo = spcNo;
		this.spcDtlNo = spcDtlNo;
	}
	public int getResGroupNo() {
		return resGroupNo;
	}
	public void setResGroupNo(int resGroupNo) {
		this.resGroupNo = resGroupNo;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public int getResMany() {
		return resMany;
	}
	public void setResMany(int resMany) {
		this.resMany = resMany;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public int getResNo() {
		return resNo;
	}
	public void setResNo(int resNo) {
		this.resNo = resNo;
	}
	public int getResCancle() {
		return resCancle;
	}
	public void setResCancle(int resCancle) {
		this.resCancle = resCancle;
	}
	public Timestamp getResTimeStart() {
		return resTimeStart;
	}
	public void setResTimeStart(Timestamp resTimeStart) {
		this.resTimeStart = resTimeStart;
	}
	public Timestamp getResTimeEnd() {
		return resTimeEnd;
	}
	public void setResTimeEnd(Timestamp resTimeEnd) {
		this.resTimeEnd = resTimeEnd;
	}
	public int getSpcPrice() {
		return spcPrice;
	}
	public void setSpcPrice(int spcPrice) {
		this.spcPrice = spcPrice;
	}
	public String getSpcName() {
		return spcName;
	}
	public void setSpcName(String spcName) {
		this.spcName = spcName;
	}
	public String getSpcImgTitle() {
		return spcImgTitle;
	}
	public void setSpcImgTitle(String spcImgTitle) {
		this.spcImgTitle = spcImgTitle;
	}
	public int getSpcNo() {
		return spcNo;
	}
	public void setSpcNo(int spcNo) {
		this.spcNo = spcNo;
	}
	public int getSpcDtlNo() {
		return spcDtlNo;
	}
	public void setSpcDtlNo(int spcDtlNo) {
		this.spcDtlNo = spcDtlNo;
	}
	@Override
	public String toString() {
		return "ResMeView [resGroupNo=" + resGroupNo + ", memId=" + memId + ", resMany=" + resMany + ", resName="
				+ resName + ", resNo=" + resNo + ", resCancle=" + resCancle + ", resTimeStart=" + resTimeStart
				+ ", resTimeEnd=" + resTimeEnd + ", spcPrice=" + spcPrice + ", spcName=" + spcName + ", spcImgTitle="
				+ spcImgTitle + ", spcNo=" + spcNo + ", spcDtlNo=" + spcDtlNo + "]";
	}
	
	
	
}
