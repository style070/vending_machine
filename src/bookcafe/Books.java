package bookcafe;

// Books 데이터 클래스
public class Books {
	
	// 멤버변수 선언
	private String booksName;
	private Boolean booksStatus;
	private int booksPrice;
	
	
	// Getter/Setter
	public String getBooksName() {
		return booksName;
	}
	public void setBooksName(String booksName) {
		this.booksName = booksName;
	}
	public Boolean getBooksStatus() {
		return booksStatus;
	}
	public void setBooksStatus(Boolean booksStatus) {
		this.booksStatus = booksStatus;
	}
	public int getBooksPrice() {
		return booksPrice;
	}
	public void setBooksPrice(int booksPrice) {
		this.booksPrice = booksPrice;
	}
	
	
	
	
}
