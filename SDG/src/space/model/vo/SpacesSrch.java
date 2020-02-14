package space.model.vo;

import java.sql.Array;

public class SpacesSrch {

	private int spcDetNo;
	private int spcNo;
	private String spcName;
	
	private int spcTypeNo;
	private String spcTypeName;
	
	private int spcLocNo;
	private String spcLocationName;
	
	private int spcPricePrice;
	
	private String spcImgTitle;

	public SpacesSrch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SpacesSrch(int spcDetNo, int spcNo, String spcName, int spcTypeNo, String spcTypeName, int spcLocNo,
			String spcLocationName, int spcPricePrice, String spcImgTitle) {
		super();
		this.spcDetNo = spcDetNo;
		this.spcNo = spcNo;
		this.spcName = spcName;
		this.spcTypeNo = spcTypeNo;
		this.spcTypeName = spcTypeName;
		this.spcLocNo = spcLocNo;
		this.spcLocationName = spcLocationName;
		this.spcPricePrice = spcPricePrice;
		this.spcImgTitle = spcImgTitle;
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

	public String getSpcTypeName() {
		return spcTypeName;
	}

	public void setSpcTypeName(String spcTypeName) {
		this.spcTypeName = spcTypeName;
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

	public String getSpcImgTitle() {
		return spcImgTitle;
	}

	public void setSpcImgTitle(String spcImgTitle) {
		this.spcImgTitle = spcImgTitle;
	}

	@Override
	public String toString() {
		return "SpacesSrch [spcDetNo=" + spcDetNo + ", spcNo=" + spcNo + ", spcName=" + spcName + ", spcTypeNo="
				+ spcTypeNo + ", spcTypeName=" + spcTypeName + ", spcLocNo=" + spcLocNo + ", spcLocationName="
				+ spcLocationName + ", spcPricePrice=" + spcPricePrice + ", spcImgTitle=" + spcImgTitle + "]";
	}
	
	
	
}

