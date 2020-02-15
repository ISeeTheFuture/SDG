package space.model.vo;

public class SpacesLocation {

	private int spcLocationNo;
	private String spcLocationName;
	public SpacesLocation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpacesLocation(int spcLocationNo, String spcLocationName) {
		super();
		this.spcLocationNo = spcLocationNo;
		this.spcLocationName = spcLocationName;
	}
	public int getSpcLocationNo() {
		return spcLocationNo;
	}
	public void setSpcLocationNo(int spcLocationNo) {
		this.spcLocationNo = spcLocationNo;
	}
	public String getSpcLocationName() {
		return spcLocationName;
	}
	public void setSpcLocationName(String spcLocationName) {
		this.spcLocationName = spcLocationName;
	}
	
	
	
	
}
