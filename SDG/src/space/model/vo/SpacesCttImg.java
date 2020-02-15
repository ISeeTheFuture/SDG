package space.model.vo;

public class SpacesCttImg {

	private int spcDetNo;
	private String spcCttImgTitle;
	private String spcImgText;
	private int spcNo;
	private String spcCttOldTitle;
	
	public SpacesCttImg() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpacesCttImg(int spcDetNo, String spcCttImgTitle, String spcImgText, int spcNo, String spcCttOldTitle) {
		super();
		this.spcDetNo = spcDetNo;
		this.spcCttImgTitle = spcCttImgTitle;
		this.spcImgText = spcImgText;
		this.spcNo = spcNo;
		this.spcCttOldTitle = spcCttOldTitle;
	}
	public int getSpcDetNo() {
		return spcDetNo;
	}
	public void setSpcDetNo(int spcDetNo) {
		this.spcDetNo = spcDetNo;
	}
	public String getSpcCttImgTitle() {
		return spcCttImgTitle;
	}
	public void setSpcCttImgTitle(String spcCttImgTitle) {
		this.spcCttImgTitle = spcCttImgTitle;
	}
	public String getSpcImgText() {
		return spcImgText;
	}
	public void setSpcImgText(String spcImgText) {
		this.spcImgText = spcImgText;
	}
	public int getSpcNo() {
		return spcNo;
	}
	public void setSpcNo(int spcNo) {
		this.spcNo = spcNo;
	}
	public String getSpcCttOldTitle() {
		return spcCttOldTitle;
	}
	public void setSpcCttOldTitle(String spcCttOldTitle) {
		this.spcCttOldTitle = spcCttOldTitle;
	}
	@Override
	public String toString() {
		return "SpacesCttImg [spcDetNo=" + spcDetNo + ", spcCttImgTitle=" + spcCttImgTitle + ", spcImgText="
				+ spcImgText + ", spcNo=" + spcNo + ", spcCttOldTitle=" + spcCttOldTitle + "]";
	} 
	
	

}
