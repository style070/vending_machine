package vending_machine;

public class VendingMachine {
	
	// 클래스 상수(공용상수)
	/**
	 * 한 번에 구매할 수 있는 제품의 수
	 */
	public static final int PRODUCT_COUNT;
	public static final String MACHINE_NAME;
	
	// 클래스 상수에 값을 할당하는 방법
	// static block
	static {
		// static 변수 / 상수의 값을 초기화 하는 공간.
		PRODUCT_COUNT = 1;
		MACHINE_NAME = "자판기";
	}
	
	// 상수 자리
//	final int PRICE = 1300;
	
	// 멤버변수 자리
	/**
	 * 상품 수량
	 */
//	int productQuantity;
	private Product[] productArray;
	
	/**
	 * 돈
	 */
	private int money;
	
	public Product[] getProductArray() {
		return this.productArray;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	// 생성자 자리.
	/**
	 * VendingMachine의 인스턴스를 생성할 때 호출된다.
	 */
	public VendingMachine() {
		this(100_000);
//		System.out.println("자판기 인스턴스를 만들었습니다!");
//		// 생성자가 만들어준 인스턴스의 멤버변수에 값을 할당한다. (초기화)
////		this.productQuantity = 10;
//		this.product = new Product();
//		this.product.setName("제로펩시");
//		this.product.setPrice(1600);
//		this.product.setQuantity(50);
//		
//		this.money = 100_000;
		
		/*
		 * 생성자를 직접 만드는 이유 (두 가지)
		 * 1. 멤버변수 초기화 (멤버변수에 기본 값을 별도로 할당을 하기 위해서)
		 *    - Reference Type 위주로 초기화.
		 *       - 배열, 컬렉션
		 * 2. 인스턴스 생성과 동시에 다른 메소드를 호출하기 위해.
		 *    - 예> 인스턴스를 생성함과 동시에 insertMoney메소드를 호출하기 위해서.
		 */
	}
	
	public VendingMachine(int money) {
		this.money = money;
		
		this.productArray = new Product[3];
		
		this.productArray[0] = new Product();
		this.productArray[0].setName("제로펩시");
		this.productArray[0].setPrice(1600);
		this.productArray[0].setQuantity(50);
		
		this.productArray[1] = new Product();
		this.productArray[1].setName("제로콜라");
		this.productArray[1].setPrice(1500);
		this.productArray[1].setQuantity(30);
		
		this.productArray[2] = new Product();
		this.productArray[2].setName("제로스프라이트");
		this.productArray[2].setPrice(1400);
		this.productArray[2].setQuantity(20);
	}
	
	/**
	 * 돈을 넣는다.
	 * @param customer 돈을 넣은 고객
	 * @param productName 구매할 제품의 이름 (제로펩시, 제로콜라, 제로스프라이트)
	 */
	public void insertMoney(Customer customer, String productName) {
		// this.productArray를 반복하면서 Product 인스턴스의 제품명 확인.
		// Product 인스턴스의 제품명과 productName이 같으면,
		// 해당 제품의 가격으로 자판기의 돈을 증가시키고
		// 고객의 돈을 감소시킨다.
		for ( Product product : this.productArray ) {
			if (product.getName().equals(productName)) {
				this.money += product.getPrice();
				customer.pay(product.getPrice());
				break; // 반복을 중단.
			}
		}
	}
	
	/**
	 * 버튼을 누른다.
	 * @param customer 버튼을 누른 고객
	 * @param productName 구매할 제품의 이름 (제로펩시, 제로콜라, 제로스프라이트)
	 */
	public void pressButton(Customer customer, String productName) {
		this.pressButton(customer, productName, VendingMachine.PRODUCT_COUNT);
	}
	
	public void pressButton(Customer customer, String productName, int orderCount) {

		// this.productArray를 반복하면서 productName과 같은지 비교한다.
		// 같으면 해당 제품의 수량을 체크하고 (0보다 작은지)
		// 작다면, 메소드를 종료시킨다.
		// 그렇지 않다면 해당 제품의 수량을 하나 감소시키고
		// 고객에게 해당 제품을 전달한다.
		for ( Product product : this.productArray ) {
			if (product.getName().equals(productName)) {
				
				if (product.getQuantity() <= 0) {
					return; // 메소드를 종료.
				}
				
				int quantity = product.getQuantity();
				quantity -= orderCount;
				product.setQuantity(quantity);
				
				customer.addStock(productName, product.getPrice(), orderCount);
			}
		}
	}
	
	public void printProducts() {
		System.out.println("자판기의 잔액: " + this.money);
		for ( Product product : this.productArray ) {
			if ( product != null ) {
				System.out.println("자판기의 상품 수량: " + product.getQuantity());
				System.out.println("자판기의 상품 이름: " + product.getName());
			}
		}
	}
	
}
