package space.model.vo;

public class SpacesImg {

	private int spcDetNo;
	private String spcImgTitle;
	private String spcImgText;
	private String spcImgRoute;
	private int spcNo;
	public SpacesImg() {
		super();
		// TODO Auto-generated constructor stub
	}
	//spaceRegFormEnd Servlet 에서 사용하는 파라미터 생성자
	public SpacesImg(int spcDetNo, String spcImgTitle, String spcImgText,String spcImgRoute, int spcNo) {
		super();
		this.spcDetNo = spcDetNo;
		this.spcImgTitle = spcImgTitle;
		this.spcImgTitle = spcImgText;
		this.spcImgRoute = spcImgRoute;
		this.spcNo = spcNo;
	}
	public int getSpcDetNo() {
		return spcDetNo;
	}
	public void setSpcDetNo(int spcDetNo) {
		this.spcDetNo = spcDetNo;
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
