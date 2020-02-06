package space.model.vo;

public class SpacesImg {

	private int spcDetailNo;
	private String spcImgTitle;
	private String spcImgText;
	private String spcImgRoute;
	private int spcNo;
	public SpacesImg() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpacesImg(int spcDetailNo, String spcImgTitle, String spcImgText, String spcImgRoute, int spcNo) {
		super();
		this.spcDetailNo = spcDetailNo;
		this.spcImgTitle = spcImgTitle;
		this.spcImgText = spcImgText;
		this.spcImgRoute = spcImgRoute;
		this.spcNo = spcNo;
	}
	public int getSpcDetailNo() {
		return spcDetailNo;
	}
	public void setSpcDetailNo(int spcDetailNo) {
		this.spcDetailNo = spcDetailNo;
	}
	public String getSpcImgTitle() {
		return spcImgTitle;
	}
	public void setSpcImgTitle(String spcImgTitle) {
		this.spcImgTitle = spcImgTitle;
	}
	public String getSpcImgText() {
		return spcImgText;
	}
	public void setSpcImgText(String spcImgText) {
		this.spcImgText = spcImgText;
	}
	public String getSpcImgRoute() {
		return spcImgRoute;
	}
	public void setSpcImgRoute(String spcImgRoute) {
		this.spcImgRoute = spcImgRoute;
	}
	public int getSpcNo() {
		return spcNo;
	}
	public void setSpcNo(int spcNo) {
		this.spcNo = spcNo;
	}

	
}
