package space.model.vo;


public class SpacesSrch {

	private int spcDetNo;
	private int spcNo;
	private String spcName;
	
	private int spcTypeNo;
	private String spc_type_name;
	
	private int spcLocNo;
	private String spcLocationName;
	
	private int spcPricePrice;
	
	private String spcImgRoute;

	public SpacesSrch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SpacesSrch(int spcDetNo, int spcNo, String spcName, int spcTypeNo, String spc_type_name, int spcLocNo,
			String spcLocationName, int spcPricePrice, String spcImgRoute) {
		super();
		this.spcDetNo = spcDetNo;
		this.spcNo = spcNo;
		this.spcName = spcName;
		this.spcTypeNo = spcTypeNo;
		this.spc_type_name = spc_type_name;
		this.spcLocNo = spcLocNo;
		this.spcLocationName = spcLocationName;
		this.spcPricePrice = spcPricePrice;
		this.spcImgRoute = spcImgRoute;
	}

	public int getSpcDetNo() {
		return spcDetNo;
	}

	public void setSpcDetNo(int spcDetNo) {
		this.spcDetNo = spcDetNo;
	}

	public int getSpcNo() {
		return spcNo;
	}

	public void setSpcNo(int spcNo) {
		this.spcNo = spcNo;
	}

	public String getSpcName() {
		return spcName;
	}

	public void setSpcName(String spcName) {
		this.spcName = spcName;
	}

	public int getSpcTypeNo() {
		return spcTypeNo;
	}

	public void setSpcTypeNo(int spcTypeNo) {
		this.spcTypeNo = spcTypeNo;
	}

	public String getSpc_type_name() {
		return spc_type_name;
	}

	public void setSpc_type_name(String spc_type_name) {
		this.spc_type_name = spc_type_name;
	}

	public int getSpcLocNo() {
		return spcLocNo;
	}

	public void setSpcLocNo(int spcLocNo) {
		this.spcLocNo = spcLocNo;
	}

	public String getSpcLocationName() {
		return spcLocationName;
	}

	public void setSpcLocationName(String spcLocationName) {
		this.spcLocationName = spcLocationName;
	}

	public int getSpcPricePrice() {
		return spcPricePrice;
	}

	public void setSpcPricePrice(int spcPricePrice) {
		this.spcPricePrice = spcPricePrice;
	}

	public String getSpcImgRoute() {
		return spcImgRoute;
	}

	public void setSpcImgRoute(String spcImgRoute) {
		this.spcImgRoute = spcImgRoute;
	}

	@Override
	public String toString() {
		return "SpacesSrch [spcDetNo=" + spcDetNo + ", spcNo=" + spcNo + ", spcName=" + spcName + ", spcTypeNo="
				+ spcTypeNo + ", spc_type_name=" + spc_type_name + ", spcLocNo=" + spcLocNo + ", spcLocationName="
				+ spcLocationName + ", spcPricePrice=" + spcPricePrice + ", spcImgRoute=" + spcImgRoute + "]";
	}

	
	
}

