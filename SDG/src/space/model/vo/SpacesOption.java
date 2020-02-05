package space.model.vo;

public class SpacesOption {

	private int spc_detail_no;
	private int spc_option_no;
	public SpacesOption() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpacesOption(int spc_detail_no, int spc_option_no) {
		super();
		this.spc_detail_no = spc_detail_no;
		this.spc_option_no = spc_option_no;
	}
	public int getSpc_detail_no() {
		return spc_detail_no;
	}
	public void setSpc_detail_no(int spc_detail_no) {
		this.spc_detail_no = spc_detail_no;
	}
	public int getSpc_option_no() {
		return spc_option_no;
	}
	public void setSpc_option_no(int spc_option_no) {
		this.spc_option_no = spc_option_no;
	}
	
}
