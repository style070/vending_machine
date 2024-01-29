package vending_machine;

public interface Sellable {

	// 인터페이스는 상수 / 메소드만 선언
	// Interface에서 상수를 정의할때 , static final은 자동으로 적용도히므로 생략한다.
	//public static final int PRODUCT_COUNT=1;
	//public static final String MACHINE_NAME="자판기";
	public int PRODUCT_COUNT=1;
	public String MACHINE_NAME="자판기";
	

	// getter/setter 가져오기 ( 생성자는 제외 클래스에 있어야함)
	public void setMoney(int money);
	public Product[] getProductArray();
	public void setProduct(Product product);
	public int getMoney(); 
	
	
	// Seller에서 메소드 선언부를 가져와서 사용함
	/**
	 * 돈을 넣는다.
	 * 
	 * @param customer 돈을 넣은 고객
	 * @param productName 구매할 재품의 이름 (제로펩시,제로콜라,제로스프라이트)
	 */
	public void insertMoney(Customer customer, String productName);
	public void pressButton(Customer customer, String productName);
	public void pressButton(Customer customer, String productName,int orderCount);
	//public void refund(Customer customer, int refundMoney);
	public void printProducts();
	
	
}
