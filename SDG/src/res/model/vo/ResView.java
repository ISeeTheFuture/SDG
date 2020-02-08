package res.model.vo;


import java.sql.Timestamp;

public class ResView{

	private int resGroupNo;
	private String memId;
	private int resMany;
	private String resName;
	private String resPhone;
	private String resEmail;
	private String resContent;
	private int resNo;
	private int resCancle;
	private Timestamp resTimeStart;
	private Timestamp resTimeEnd;
	private int resPrior;
	
	public ResView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResView(int resGroupNo, String memId, int resMany, String resName, String resPhone, String resEmail,
			String resContent, int resNo, int resCancle, Timestamp resTimeStart, Timestamp resTimeEnd, int resPrior) {
		super();
		this.resGroupNo = resGroupNo;
		this.memId = memId;
		this.resMany = resMany;
		this.resName = resName;
		this.resPhone = resPhone;
		this.resEmail = resEmail;
		this.resContent = resContent;
		this.resNo = resNo;
		this.resCancle = resCancle;
		this.resTimeStart = resTimeStart;
		this.resTimeEnd = resTimeEnd;
		this.resPrior = resPrior;
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

	public String getResPhone() {
		return resPhone;
	}

	public void setResPhone(String resPhone) {
		this.resPhone = resPhone;
	}

	public String getResEmail() {
		return resEmail;
	}

	public void setResEmail(String resEmail) {
		this.resEmail = resEmail;
	}

	public String getResContent() {
		return resContent;
	}

	public void setResContent(String resContent) {
		this.resContent = resContent;
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

	public int getResPrior() {
		return resPrior;
	}

	public void setResPrior(int resPrior) {
		this.resPrior = resPrior;
	}

	@Override
	public String toString() {
		return "ResView [resGroupNo=" + resGroupNo + ", memId=" + memId + ", resMany=" + resMany + ", resName="
				+ resName + ", resPhone=" + resPhone + ", resEmail=" + resEmail + ", resContent=" + resContent
				+ ", resNo=" + resNo + ", resCancle=" + resCancle + ", resTimeStart=" + resTimeStart + ", resTimeEnd="
				+ resTimeEnd + ", resPrior=" + resPrior + "]";
	}
	
	
	

}
