package vending_machine;

/**
 * 상속받은 클래스가 추상 메소드가 존재하는 추상 클래스라면 <br/>
 * 추상 메소드를 이 클래스에서 구현을 시키거나 <br/>
 * 이 클래스도 추상클래스로 만들어 주어야 한다. <br>
 * <b> 환불 불가능한 자판기 </b>
 * 
 */
public class VendingMachine implements Sellable {

	// 멤버변수 자리
	/**
	 * 상품 수량
	 */
	// int productQuantity;
	private Product[] productArray; // Product 타입의 데이터 클래스

	/**
	 * 돈
	 */
	private int money;
	
	public VendingMachine() {
		this(100_000);
		
		
	}
	
	public VendingMachine(int money) {
		this.money = money;
		this.productArray=new Product[3];// Product 클래스에 정의된 데이터 클래스 인스턴스생성

		this.productArray[0]=new Product(); // product 데이터 클래스의 name 필드에 String "제로콜라"할당
		this.productArray[0].setName("제로펩시"); // product 데이터 클래스의 price 필드에 int 1600 할당
		this.productArray[0].setPrice(1600);this.productArray[0].setQuantity(50);

		this.productArray[1]=new Product(); // product 데이터 클래스의 name 필드에 String "제로콜라"할당
		this.productArray[1].setName("제로콜라"); // product 데이터 클래스의 price 필드에 int 1600 할당
		this.productArray[1].setPrice(1500);this.productArray[1].setQuantity(30);

		this.productArray[2]=new Product(); // product 데이터 클래스의 name 필드에 String "제로콜라"할당
		this.productArray[2].setName("제로스프라이트"); // product 데이터 클래스의 price 필드에 int 1600 할당
		this.productArray[2].setPrice(1400);this.productArray[2].setQuantity(20);
	}

	@Override
	public void setMoney(int money) {
		// TODO Auto-generated method stub
		this.money = money;
	}

	@Override
	public Product[] getProductArray() {
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
	public void insertMoney(Customer customer, String productName) {
		// TODO Auto-generated method stub

		// this.productArray를 반복하면서 Product 인스턴스의 제품명 확인
		// Product 인스턴스의 제품명과 productName이 같으면,
		// 해당 제품의 가격으로 자판기의 돈을 증가시키고
		// 고객의 돈을 감소시킨다.

		for (Product product : this.productArray) {
			if (product.getName().equals(productName)) {
				this.money += product.getPrice();
				customer.pay(product.getPrice());
				break; // 반복을 중단.
			}
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
		for (Product product : this.productArray) {
			if (product.getName().equals(productName)) {
				if (product.getQuantity() <= 0) {
					refund(customer, product.getPrice());
					return;
				}
				int quantity = product.getQuantity();
				quantity -= orderCount;
				product.setQuantity(quantity);

				customer.addStock(productName, product.getPrice(), orderCount);
			}

		}
	}

	
	protected void refund(Customer customer, int refundMoney) {
		// TODO Auto-generated method stub
		System.out.println("환불자판기가 아닙니다. 환불은 불가능합니다");

	}

	@Override
	public void printProducts() {
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
