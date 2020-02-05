package space.model.vo;

public class SpacesLocation {

	private int spc_location_no;
	private String spc_location_name;
	public SpacesLocation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpacesLocation(int spc_location_no, String spc_location_name) {
		super();
		this.spc_location_no = spc_location_no;
		this.spc_location_name = spc_location_name;
	}
	public int getSpc_location_no() {
		return spc_location_no;
	}
	public void setSpc_location_no(int spc_location_no) {
		this.spc_location_no = spc_location_no;
	}
	public String getSpc_location_name() {
		return spc_location_name;
	}
	public void setSpc_location_name(String spc_location_name) {
		this.spc_location_name = spc_location_name;
	}
	
	
}
