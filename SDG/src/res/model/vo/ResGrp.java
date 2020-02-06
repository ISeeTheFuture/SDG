package res.model.vo;

import java.util.Date;

public class ResGrp extends Res{

	private int resNo;
	private int resCancle;
	private Date resDate;
	private int resTime;
	private int resPrior;
	private Date resTimeApply;
	
	public ResGrp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResGrp(int resGroupNo) {
		super(resGroupNo);
		// TODO Auto-generated constructor stub
	}
	public ResGrp(int resNo, int resGroupNo, int resCancle, Date resDate, int resTime, int resPrior, Date resTimeApply) {
		super(resGroupNo);
		this.resNo = resNo;
		this.resCancle = resCancle;
		this.resDate = resDate;
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
	public Date getResDate() {
		return resDate;
	}
	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}
	public int getResTime() {
		return resTime;
	}
	public void setResTime(int resTime) {
		this.resTime = resTime;
	}
	public int getResPrior() {
		return resPrior;
	}
	public void setResPrior(int resPrior) {
		this.resPrior = resPrior;
	}
	public Date getResTimeApply() {
		return resTimeApply;
	}
	public void setResTimeApply(Date resTimeApply) {
		this.resTimeApply = resTimeApply;
	}
	@Override
	public String toString() {
		return "ResGrp [resNo=" + resNo + ", resCancle=" + resCancle + ", resDate=" + resDate + ", resTime=" + resTime
				+ ", resPrior=" + resPrior + ", resTimeApply=" + resTimeApply + "]";
	}
	
	
}
