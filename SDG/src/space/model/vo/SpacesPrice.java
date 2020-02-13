package space.model.vo;


public class SpacesPrice {

	private int spcPriceNo;
	private int spcDetNo;
	private String spcDetName;
	private String spcPriceDay;
	private int spcPriceStart;
	private int spcPriceEnd;
	private char spcPricePeak;
	private char spcPricePer;
	private char spcPriceDayBool;
	private int spcPricePrice;
	public SpacesPrice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SpacesPrice(int spcPriceNo, int spcDetNo, String spcDetName, String spcPriceDay, int spcPriceStart,
			int spcPriceEnd, char spcPricePeak, char spcPricePer, char spcPriceDayBool, int spcPricePrice) {
		super();
		this.spcPriceNo = spcPriceNo;
		this.spcDetNo = spcDetNo;
		this.spcDetName = spcDetName;
		this.spcPriceDay = spcPriceDay;
		this.spcPriceStart = spcPriceStart;
		this.spcPriceEnd = spcPriceEnd;
		this.spcPricePeak = spcPricePeak;
		this.spcPricePer = spcPricePer;
		this.spcPriceDayBool = spcPriceDayBool;
		this.spcPricePrice = spcPricePrice;
	}
	
	public SpacesPrice(int spcDetNo, String spcDetName, String spcPriceDay, char spcPricePer, int spcPricePrice) {
		this.spcDetNo = spcDetNo;
		this.spcDetName = spcDetName;
		this.spcPriceDay = spcPriceDay;
		this.spcPricePer = spcPricePer;
		this.spcPricePrice = spcPricePrice;
	}
	public int getSpcPriceNo() {
		return spcPriceNo;
	}
	public void setSpcPriceNo(int spcPriceNo) {
		this.spcPriceNo = spcPriceNo;
	}
	public int getSpcDetNo() {
		return spcDetNo;
	}
	public void setSpcDetNo(int spcDetNo) {
		this.spcDetNo = spcDetNo;
	}
	public String getSpcDetName() {
		return spcDetName;
	}
	public void setSpcDetName(String spcDetName) {
		this.spcDetName = spcDetName;
	}
	public String getSpcPriceDay() {
		return spcPriceDay;
	}
	public void setSpcPriceDay(String spcPriceDay) {
		this.spcPriceDay = spcPriceDay;
	}
	public int getSpcPriceStart() {
		return spcPriceStart;
	}
	public void setSpcPriceStart(int spcPriceStart) {
		this.spcPriceStart = spcPriceStart;
	}
	public int getSpcPriceEnd() {
		return spcPriceEnd;
	}
	public void setSpcPriceEnd(int spcPriceEnd) {
		this.spcPriceEnd = spcPriceEnd;
	}
	public char getSpcPricePeak() {
		return spcPricePeak;
	}
	public void setSpcPricePeak(char spcPricePeak) {
		this.spcPricePeak = spcPricePeak;
	}
	public char getSpcPricePer() {
		return spcPricePer;
	}
	public void setSpcPricePer(char spcPricePer) {
		this.spcPricePer = spcPricePer;
	}
	public char getSpcPriceDayBool() {
		return spcPriceDayBool;
	}
	public void setSpcPriceDayBool(char spcPriceDayBool) {
		this.spcPriceDayBool = spcPriceDayBool;
	}
	public int getSpcPricePrice() {
		return spcPricePrice;
	}
	public void setSpcPricePrice(int spcPricePrice) {
		this.spcPricePrice = spcPricePrice;
	}
	
	
	
}
