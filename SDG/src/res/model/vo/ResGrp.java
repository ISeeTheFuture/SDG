package res.model.vo;


import java.sql.Timestamp;

public class ResGrp extends Res{

	private int resNo;
	private int resCancle;
	private Timestamp resTime;
	private int resPrior;
	private Timestamp resTimeApply;
	
	public ResGrp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResGrp(int resGroupNo) {
		super(resGroupNo);
	}
	public ResGrp(int resNo, int resGroupNo, int resCancle, Timestamp resTime, int resPrior, Timestamp resTimeApply) {
		super(resGroupNo);
		this.resNo = resNo;
		this.resCancle = resCancle;
		this.resTime = resTime;
		this.resPrior = resPrior;
		this.resTimeApply = resTimeApply;
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
	public Timestamp getResTime() {
		return resTime;
	}
	public void setResTime(Timestamp resTime) {
		this.resTime = resTime;
	}

	public int getResPrior() {
		return resPrior;
	}
	public void setResPrior(int resPrior) {
		this.resPrior = resPrior;
	}
	public Timestamp getResTimeApply() {
		return resTimeApply;
	}
	public void setResTimeApply(Timestamp resTimeApply) {
		this.resTimeApply = resTimeApply;
	}
	@Override
	public String toString() {
		return "ResGrp=" + getResGroupNo() + ", resNo=" + resNo + ", resCancle=" + resCancle + ", resTime=" + resTime
				+ ", resPrior=" + resPrior + ", resTimeApply=" + resTimeApply + "]";
	}
	
	
}
