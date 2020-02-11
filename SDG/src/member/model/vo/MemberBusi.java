package member.model.vo;

public class MemberBusi {
	private String memId;
	private String memBusiNo;
	private String memBusiAddr;
	private String memBusiPhone;
	private String memBusiAllow;
	public MemberBusi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberBusi(String memId, String memBusiNo, String memBusiAddr, String memBusiPhone, String memBusiAllow) {
		super();
		this.memId = memId;
		this.memBusiNo = memBusiNo;
		this.memBusiAddr = memBusiAddr;
		this.memBusiPhone = memBusiPhone;
		this.memBusiAllow = memBusiAllow;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemBusiNo() {
		return memBusiNo;
	}
	public void setMemBusiNo(String memBusiNo) {
		this.memBusiNo = memBusiNo;
	}
	public String getMemBusiAddr() {
		return memBusiAddr;
	}
	public void setMemBusiAddr(String memBusiAddr) {
		this.memBusiAddr = memBusiAddr;
	}
	public String getMemBusiPhone() {
		return memBusiPhone;
	}
	public void setMemBusiPhone(String memBusiPhone) {
		this.memBusiPhone = memBusiPhone;
	}
	public String getMemBusiAllow() {
		return memBusiAllow;
	}
	public void setMemBusiAllow(String memBusiAllow) {
		this.memBusiAllow = memBusiAllow;
	}
	@Override
	public String toString() {
		return "MemberBusi [memId=" + memId + ", memBusiNo=" + memBusiNo + ", memBusiAddr=" + memBusiAddr
				+ ", memBusiPhone=" + memBusiPhone + ", memBusiAllow=" + memBusiAllow + "]";
	}
	
	

}
