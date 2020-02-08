package member.model.vo;

import java.io.Serializable;
import java.sql.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;


/**
 * @author user2
 *
 */
public class Member implements Serializable, HttpSessionBindingListener{
	
	private static final long serialVersionUID = 1L;
	
	private String memId;
	private String memPass;
	private String memName;
	private String memRole;
	private String memAdmin;
	private int memPoint;
	private int memGradeName;
	private int memGender;
	private Date memBirth;
	private Date memDate;
	private Date memRest;
	private int IgnoreOn;
	
	
	
	
	
	
	
	
	
	
	
	
	public int getIgnoreOn() {
		return IgnoreOn;
	}
	public void setIgnoreOn(int ignoreOn) {
		IgnoreOn = ignoreOn;
	}
	public Member(String memId, String memPass, String memName,  int memPoint,
			int memGradeName, int memGender, Date memBirth,
			String memEmail, String memPhone, String memAddr) {
		super();
		this.memId = memId;
		this.memPass = memPass;
		this.memName = memName;
		this.memPoint = memPoint;
		this.memGradeName = memGradeName;
		this.memGender = memGender;
		this.memBirth = memBirth;
		this.memEmail = memEmail;
		this.memPhone = memPhone;
		this.memAddr = memAddr;
	}
	public Member(String memId, String memPass, String memName, String memRole, String memAdmin, int memPoint,
			int memGradeName, int memGender, Date memBirth, Date memDate, Date memRest, Date memLastLogin,
			String memEmail, String memPhone, String memAddr) {
		super();
		this.memId = memId;
		this.memPass = memPass;
		this.memName = memName;
		this.memRole = memRole;
		this.memAdmin = memAdmin;
		this.memPoint = memPoint;
		this.memGradeName = memGradeName;
		this.memGender = memGender;
		this.memBirth = memBirth;
		this.memDate = memDate;
		this.memRest = memRest;
		this.memLastLogin = memLastLogin;
		this.memEmail = memEmail;
		this.memPhone = memPhone;
		this.memAddr = memAddr;
	}
	public Date getMemLastLogin() {
		return memLastLogin;
	}
	public void setMemLastLogin(Date memLastLogin) {
		this.memLastLogin = memLastLogin;
	}
	private Date memLastLogin;
	private String memEmail;
	private String memPhone;
	private String memAddr;
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPass() {
		return memPass;
	}
	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemRole() {
		return memRole;
	}
	public void setMemRole(String memRole) {
		this.memRole = memRole;
	}
	public String getMemAdmin() {
		return memAdmin;
	}
	public void setMemAdmin(String memAdmin) {
		this.memAdmin = memAdmin;
	}
	public int getMemPoint() {
		return memPoint;
	}
	public void setMemPoint(int memPoint) {
		this.memPoint = memPoint;
	}
	public int getMemGradeName() {
		return memGradeName;
	}
	public void setMemGradeName(int memGradeName) {
		this.memGradeName = memGradeName;
	}
	public int getMemGender() {
		return memGender;
	}
	public void setMemGender(int memGender) {
		this.memGender = memGender;
	}
	public Date getMemBirth() {
		return memBirth;
	}
	public void setMemBirth(Date memBirth) {
		this.memBirth = memBirth;
	}
	public Date getMemDate() {
		return memDate;
	}
	public void setMemDate(Date memDate) {
		this.memDate = memDate;
	}
	public Date getMemRest() {
		return memRest;
	}
	public void setMemRest(Date memRest) {
		this.memRest = memRest;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemAddr() {
		return memAddr;
	}
	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String memId, String memPass, String memName, String memRole, String memAdmin, int memPoint,
			int memGradeName, int memGender, Date memBirth, Date memDate, Date memRest, String memEmail,
			String memPhone, String memAddr) {
		super();
		this.memId = memId;
		this.memPass = memPass;
		this.memName = memName;
		this.memRole = memRole;
		this.memAdmin = memAdmin;
		this.memPoint = memPoint;
		this.memGradeName = memGradeName;
		this.memGender = memGender;
		this.memBirth = memBirth;
		this.memDate = memDate;
		this.memRest = memRest;
		this.memEmail = memEmail;
		this.memPhone = memPhone;
		this.memAddr = memAddr;
	}
	@Override
	public String toString() {
		return "Member [memId=" + memId + ", memPass=" + memPass + ", memName=" + memName + ", memRole=" + memRole
				+ ", memAdmin=" + memAdmin + ", memPoint=" + memPoint + ", memGradeName=" + memGradeName
				+ ", memGender=" + memGender + ", memBirth=" + memBirth + ", memDate=" + memDate + ", memRest="
				+ memRest + ", memEmail=" + memEmail + ", memPhone=" + memPhone + ", memAddr=" + memAddr + "]";
	}

	public Member(String memId, String memPass, String memName, int memGender, Date memBirth, String memEmail,
			String memPhone, String memAddr) {
		super();
		this.memId = memId;
		this.memPass = memPass;
		this.memName = memName;
		this.memGender = memGender;
		this.memBirth = memBirth;
		this.memEmail = memEmail;
		this.memPhone = memPhone;
		this.memAddr = memAddr;
	}
	public Member(String memId) {
		super();
		this.memId = memId;
	}
	public Member(String memId, int memGradeName) {
		super();
		this.memId = memId;
		this.memGradeName = memGradeName;
	}
	public Member(String memId, int memPoint, int memGradeName) {
		super();
		this.memId = memId;
		this.memPoint = memPoint;
		this.memGradeName = memGradeName;
	}
	
	
	
	
	
	
}
