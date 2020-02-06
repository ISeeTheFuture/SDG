package res.model.vo;

import java.util.Date;

import space.model.vo.SpacesDefault;

public class Res extends SpacesDefault {

	private int resGroupNo;
	private int resMany;
	private String resName;
	private String resPhone;
	private String resEmail;
	private String resContent;
	private Date resApply;
	
	
	
	public Res() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Res(int resGroupNo) {
		super();
		// TODO Auto-generated constructor stub
	}
	public Res(String memberId, int spcNo) {
		super(memberId, spcNo);
		// TODO Auto-generated constructor stub
	}
	public Res(int resGroupNo, String memberId, int spcNo, int resMany, String resName, String resPhone, String resEmail, String resContent,
			Date resApply) {
		super(memberId, spcNo);
		this.resGroupNo = resGroupNo;
		this.resMany = resMany;
		this.resName = resName;
		this.resPhone = resPhone;
		this.resEmail = resEmail;
		this.resContent = resContent;
		this.resApply = resApply;
	}
	public int getResGroupNo() {
		return resGroupNo;
	}
	public void setResGroupNo(int resGroupNo) {
		this.resGroupNo = resGroupNo;
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
	public Date getResApply() {
		return resApply;
	}
	public void setResApply(Date resApply) {
		this.resApply = resApply;
	}
	@Override
	public String toString() {
		return "Res [resGroupNo=" + resGroupNo + ", resMany=" + resMany + ", resName=" + resName + ", resPhone="
				+ resPhone + ", resEmail=" + resEmail + ", resContent=" + resContent + ", resApply=" + resApply + "]";
	}
	
	
	
}
