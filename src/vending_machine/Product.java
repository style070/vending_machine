package vending_machine;

/**
 * 자판기에서 판매할 상품의 정보 "데이터 클래스"
 */
public class Product {

	/**
	 * 상품의 이름
	 */
	private String name;

	/**
	 * 상품의 가격
	 */
	private int price;

	/**
	 * 상품의 재고
	 */
	private int quantity;
	

	// Getter
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	
	//Setter
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
