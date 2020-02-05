package space.model.vo;

public class SpacesType extends Spaces{

	private String spc_type_name;

	public SpacesType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SpacesType(String spc_type_name , int spc_type_no) {
		super();
		this.spc_type_name = spc_type_name;
	}

	public String getSpc_type_name() {
		return spc_type_name;
	}

	public void setSpc_type_name(String spc_type_name) {
		this.spc_type_name = spc_type_name;
	}
	
	
	
}
