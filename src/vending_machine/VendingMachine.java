package vending_machine;

import java.util.List;

/**
 * 상속받은 클래스가 추상 메소드가 존재하는 추상 클래스라면 <br/>
 * 추상 메소드를 이 클래스에서 구현을 시키거나 <br/>
 * 이 클래스도 추상클래스로 만들어 주어야 한다. <br>
 * <b> 환불 불가능한 자판기 </b>
 * 
 */
public class VendingMachine<I> implements Sellable<I> {

	private InsertMoneyHandler<I> insertMoneyHandler;
	private PressButtonHandler<I> pressButtonHandler;
	private PrintHandler<I> printHandler;

	// 멤버변수 자리
	/**
	 * 상품 수량
	 */
	// int productQuantity;
	private List<I> productArray; // Product 타입의 데이터 클래스

	/**
	 * 돈
	 */
	private int money;

	public VendingMachine(List<I> itemArray) {
		// 제일 심플하게 무엇인지 모르니 Null 반환
		// 돈만있고 아무것도 팔지 않는 자판기
		this(100_000, itemArray);

	}

	public VendingMachine(int money, List<I> itemArray) {
		this.money = money;
		this.productArray = itemArray;

	}

	@Override
	public void setMoney(int money) {
		// TODO Auto-generated method stub
		this.money = money;
	}

	@Override
	public List<I> getProductArray() {
		// TODO Auto-generated method stub
		return this.productArray;
	}

	@Override
	public void setProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getMoney() {
		// TODO Auto-generated method stub
		return this.money;
	}

	@Override
	public void setInsertMoneyHandler(InsertMoneyHandler<I> handler) {
		// TODO Auto-generated method stub
		this.insertMoneyHandler = handler;
	}

	@Override
	public void setPressButtonHandler(PressButtonHandler<I> handler) {
		// TODO Auto-generated method stub
		this.pressButtonHandler = handler;
	}

	@Override
	public void setPrintHandler(PrintHandler<I> handler) {
		// TODO Auto-generated method stub
		this.printHandler = handler;
	}

	@Override
	public void insertMoney(Customer customer, String productName) {
		// TODO Auto-generated method stub

		// this.productArray를 반복하면서 Product 인스턴스의 제품명 확인
		// Product 인스턴스의 제품명과 productName이 같으면,
		// 해당 제품의 가격으로 자판기의 돈을 증가시키고
		// 고객의 돈을 감소시킨다.

		for (I product : this.productArray) {
			this.insertMoneyHandler.handle(this, customer, product, productName);
		}
		// money += this.productArray.getPrice(); // VendingMachine 잔고에 상품 값 더함 ( 하기
		// 코드에서 pay() 메서드로 고객이 지불하게됨 )
		// customer.pay(this.productArray.getPrice()); // 고객이 상품 구입후 pay() 메서드를 통한 상품값
		// 지불
	}

	@Override
	public void pressButton(Customer customer, String productName) {
		// TODO Auto-generated method stub
		this.pressButton(customer, productName, VendingMachine.PRODUCT_COUNT);
	}

	@Override
	public void pressButton(Customer customer, String productName, int orderCount) {
		// TODO Auto-generated method stub
		for (I product : this.productArray) {
			this.pressButtonHandler.handle(this, customer, product, productName, orderCount);
			;

		}
	}

	protected void refund(Customer customer, int refundMoney) {
		// TODO Auto-generated method stub
		System.out.println("환불자판기가 아닙니다. 환불은 불가능합니다");

	}

	@Override
	public void printProducts() {
		System.out.println("자판기의 잔액: " + this.money);
		for (I product : this.productArray) {
//			if(product!= null) {
//				
//			}
			this.printHandler.handle(product);
		}

		// TODO Auto-generated method stub

	}
//public class VendingMachine extends Seller {

	// super도 결국 인스턴스이기에 사용이 불가능함
//	public VendingMachine() {
//		super(); // 슈퍼클래스의 파라미터가 없는 기본 형태 생성자를 호출한다.
//	}
//	
//	public VendingMachine(int money) {
//		super(money); // 슈퍼클래스의 int 파라미터가 있는 생성자를 호출한다
//	}
//
//	@Override
//	public final void insertMoney(Customer customer, String productName) {
//		// TODO Auto-generated method stub
//		super.insertMoney(customer, productName);
//	}
//	
//	@Override
//	public final void pressButton(Customer customer, String productName) {
//		// TODO Auto-generated method stub
//		super.pressButton(customer, productName);
//	}
//	@Override
//	public final void pressButton(Customer customer, String productName, int orderCount) {
//		// TODO Auto-generated method stub
//		super.pressButton(customer, productName, orderCount);
//	}
//
//	@Override
//	protected void refund(Customer customer, int refundMoney) {
//		// TODO Auto-generated method stub
//		System.out.println("재고가 없습니다.");
//		System.out.println("환불은 못해드려요.");
//	}

}
