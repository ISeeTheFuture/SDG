package space.model.vo;

import java.util.Date;

public class Spaces {

	private int spc_det_no;
	private int spc_no;
	private int spc_loc_no;
	private char spc_det_avail;
	private String spc_det_content;
	private char spc_det_shqring;
	private char spc_det_holiday;
	private int spc_det_size;
	private int spc_det_capacity;
	private int spc_cap_min;
	private int spc_cpa_max;
	private Date spc_date_start;
	private Date spc_date_end;
	private Date spc_det_date;
	public Spaces() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Spaces(int spc_det_no, int spc_no, int spc_loc_no, char spc_det_avail, String spc_det_content,
			char spc_det_shqring, char spc_det_holiday, int spc_det_size, int spc_det_capacity, int spc_cap_min,
			int spc_cpa_max, Date spc_date_start, Date spc_date_end, Date spc_det_date) {
		super();
		this.spc_det_no = spc_det_no;
		this.spc_no = spc_no;
		this.spc_loc_no = spc_loc_no;
		this.spc_det_avail = spc_det_avail;
		this.spc_det_content = spc_det_content;
		this.spc_det_shqring = spc_det_shqring;
		this.spc_det_holiday = spc_det_holiday;
		this.spc_det_size = spc_det_size;
		this.spc_det_capacity = spc_det_capacity;
		this.spc_cap_min = spc_cap_min;
		this.spc_cpa_max = spc_cpa_max;
		this.spc_date_start = spc_date_start;
		this.spc_date_end = spc_date_end;
		this.spc_det_date = spc_det_date;
	}
	public int getSpc_det_no() {
		return spc_det_no;
	}
	public void setSpc_det_no(int spc_det_no) {
		this.spc_det_no = spc_det_no;
	}
	public int getSpc_no() {
		return spc_no;
	}
	public void setSpc_no(int spc_no) {
		this.spc_no = spc_no;
	}
	public int getSpc_loc_no() {
		return spc_loc_no;
	}
	public void setSpc_loc_no(int spc_loc_no) {
		this.spc_loc_no = spc_loc_no;
	}
	public char getSpc_det_avail() {
		return spc_det_avail;
	}
	public void setSpc_det_avail(char spc_det_avail) {
		this.spc_det_avail = spc_det_avail;
	}
	public String getSpc_det_content() {
		return spc_det_content;
	}
	public void setSpc_det_content(String spc_det_content) {
		this.spc_det_content = spc_det_content;
	}
	public char getSpc_det_shqring() {
		return spc_det_shqring;
	}
	public void setSpc_det_shqring(char spc_det_shqring) {
		this.spc_det_shqring = spc_det_shqring;
	}
	public char getSpc_det_holiday() {
		return spc_det_holiday;
	}
	public void setSpc_det_holiday(char spc_det_holiday) {
		this.spc_det_holiday = spc_det_holiday;
	}
	public int getSpc_det_size() {
		return spc_det_size;
	}
	public void setSpc_det_size(int spc_det_size) {
		this.spc_det_size = spc_det_size;
	}
	public int getSpc_det_capacity() {
		return spc_det_capacity;
	}
	public void setSpc_det_capacity(int spc_det_capacity) {
		this.spc_det_capacity = spc_det_capacity;
	}
	public int getSpc_cap_min() {
		return spc_cap_min;
	}
	public void setSpc_cap_min(int spc_cap_min) {
		this.spc_cap_min = spc_cap_min;
	}
	public int getSpc_cpa_max() {
		return spc_cpa_max;
	}
	public void setSpc_cpa_max(int spc_cpa_max) {
		this.spc_cpa_max = spc_cpa_max;
	}
	public Date getSpc_date_start() {
		return spc_date_start;
	}
	public void setSpc_date_start(Date spc_date_start) {
		this.spc_date_start = spc_date_start;
	}
	public Date getSpc_date_end() {
		return spc_date_end;
	}
	public void setSpc_date_end(Date spc_date_end) {
		this.spc_date_end = spc_date_end;
	}
	public Date getSpc_det_date() {
		return spc_det_date;
	}
	public void setSpc_det_date(Date spc_det_date) {
		this.spc_det_date = spc_det_date;
	}
	
	
	
}
