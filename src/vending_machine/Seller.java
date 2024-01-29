package vending_machine;

/**
 * 자판기의 추상 클래스
 * abstract Method가 있을경우
 * 클래스의 타입도 abstract class가 되어야 한다.
 * abstract class는 인스턴스로 만들 수가 없다. ( new Seller() ==> X 불가능 )
 */
public abstract class Seller {
	// 클래스 상수 ( 공용상수 )
	// pressButton시 한번에 구매할 수 있는 제품의 수
	public static final int PRODUCT_COUNT;
	public static final String MACHINE_NAME;
	// 클래스 상수에 값을 할당하는 방법
	// static block
	static {
		// static 변수/상수의 값을 초기화 하는 공간.
		PRODUCT_COUNT = 1;
		MACHINE_NAME = "자판기";
	}

	// 상수 자리
	// final int PRICE = 1300;

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

	public void setMoney(int money) {
		this.money = money;
	}

	public Product[] getProductArray() {
		return this.productArray;
	}

//	public void setProduct(Product product) {
//		this.productArray = product;
//	}

//	public void setMoney(int money) {
//		this.money = money;
//	}

	public int getMoney() {
		return this.money;
	}

	// 생성자 자리.
	/**
	 * VendingMachine의 인스턴스를 생성할 때 호출된다.
	 */
	public Seller() {
		// 생성자 내부에서 다른 생성자를 생성할 경우 그 위에 아무 코드도 있으면 안됨
		this(100_000);
		/**
		 * 1. 멤버변수 초기화(멤버변수에 기본 값을 별도로 할당을 하기 위해서) 
		 *  Reference Type 위주로 초기화 
		 *   배열 / 컬렉션 등.. 
		 * 2. 인스턴스 생성과 동시에 다른 메소드를 호출하기 위해서 사용
		 *  → ex) 인스턴스를 생성함과 동시에 insertMoney 메소드를 호출하기 위해서
		 */
//		System.out.println("자판기 인스턴스를 만들었습니다!"); // Main에서 인스턴스 생성 및 생성자가 호출될때 실행
//		//productQuantity=10;
//		
//		this.productArray = new Product[3];
//		
//		this.productArray[0] = new Product(); // Product 클래스에 정의된 데이터 클래스 인스턴스생성
//		this.productArray[0].setName("제로펩시");  // product 데이터 클래스의 name 필드에 String "제로콜라"할당 
//		this.productArray[0].setPrice(1600); //product 데이터 클래스의 price 필드에 int 1600 할당
//		this.productArray[0].setQuantity(50); //product 데이터 클래스의 quantity 필드에 String 50 할당
//		this.setMoney(100000); // Vending Machine이 초기에 가지는 잔돈(money) 값 100_000원 할당
//		
//		this.productArray[1] = new Product(); // Product 클래스에 정의된 데이터 클래스 인스턴스생성
//		this.productArray[1].setName("제로콜라");  // product 데이터 클래스의 name 필드에 String "제로콜라"할당 
//		this.productArray[1].setPrice(1500); //product 데이터 클래스의 price 필드에 int 1600 할당
//		this.productArray[1].setQuantity(30); //product 데이터 클래스의 quantity 필드에 String 50 할당
//		this.setMoney(100000); // Vending Machine이 초기에 가지는 잔돈(money) 값 100_000원 할당
//		
//		this.productArray[2] = new Product(); // Product 클래스에 정의된 데이터 클래스 인스턴스생성
//		this.productArray[2].setName("제로스프라이트");  // product 데이터 클래스의 name 필드에 String "제로콜라"할당 
//		this.productArray[2].setPrice(1400); //product 데이터 클래스의 price 필드에 int 1600 할당
//		this.productArray[2].setQuantity(20); //product 데이터 클래스의 quantity 필드에 String 50 할당
//		this.setMoney(100000); // Vending Machine이 초기에 가지는 잔돈(money) 값 100_000원 할당
//		
	}

	public Seller(int money) {
		
	this.money=money;

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

	/**
	 * 돈을 넣는다.
	 * 
	 * @param customer 돈을 넣은 고객
	 * @param productName 구매할 재품의 이름 (제로펩시,제로콜라,제로스프라이트)
	 */
	public void insertMoney(Customer customer, String productName) {
		
		// this.productArray를 반복하면서 Product 인스턴스의 제품명 확인
		// Product 인스턴스의 제품명과 productName이 같으면,
		// 해당 제품의 가격으로 자판기의 돈을 증가시키고
		// 고객의 돈을 감소시킨다.
		
		for( Product product : this.productArray )
		{
			if(product.getName().equals(productName)) {
				this.money += product.getPrice();
				customer.pay(product.getPrice());
				break; // 반복을 중단.
			}
		}
		//money += this.productArray.getPrice(); // VendingMachine 잔고에 상품 값 더함 ( 하기 코드에서 pay() 메서드로 고객이 지불하게됨 ) 
		//customer.pay(this.productArray.getPrice()); // 고객이 상품 구입후 pay() 메서드를 통한 상품값 지불
	}

	/**
	 * 버튼을 누른다.
	 * 
	 * @param customer 버튼을 누른 고객
	 * @param productName 구매할 제품의 이름 ( 제로펩시 , 제로콜라 , 제로스프라이트 )
	 */
	public void pressButton(Customer customer, String productName) {
//		//if (this.productQuantity <= 0) {
//		if(this.productArray.getQuantity()<=0) {
//			return; // 재고가 아무것도 없다면 메소드 즉시 종료
//		}
//		//this.product.quantity--; // 재고가 있을시 VendingMachine에 존재하는 상품의 개수 1개 감소
//		// Customer과 동일하게 아래 3줄라인으로 변경해서 setting
//		int quantity = getProductArray().getQuantity();
//		//quantity--;
//		quantity -= VendingMachine.PRODUCT_COUNT;
//		this.getProductArray().setQuantity(quantity);
//		
//		customer.addStock(this.getProductArray().getName(),this.getProductArray().getPrice()); // 고객의 데이터클래스 인스턴스에 (상품이름,가격)을 파라미터로 전송하여 데이터 변경
		
		//메소드 체이닝을 통한 재귀 호출 / 중복 코드 제거
		this.pressButton(customer,productName, VendingMachine.PRODUCT_COUNT);

	}

	public void pressButton(Customer customer, String productName,int orderCount) {
		
		// this.productArray를 반복하면서 productName과 같은지 비교한다.
		// 같으면 해당 제품의 수량을 체크하고 (0보다 작은지)
		// 작다면, 메소드를 종료시킨다.
		
		
		//if (this.productQuantity <= 0) {
				
		for(Product product : this.productArray) {
			if(product.getName().equals(productName)) {
				if(product.getQuantity() <= 0) {
					refund(customer, product.getPrice());
					return;
				}
				int quantity = product.getQuantity();
				quantity -= orderCount;
				product.setQuantity(quantity);
				
				customer.addStock(productName, product.getPrice(),orderCount);
			}
			
		}
	}

	
	/**
	 * 고객에게 환불처리한다.
	 * 상속된 클래스에서만 사용할 수 있도록 한다(protected)
	 * @param customer 환불받을 고객
	 * @param refundMoney 환불받은 금액
	 */
	protected abstract void refund(Customer customer, int refundMoney);

	public void printProducts() {
		
		System.out.println("자판기의 잔액 : " + this.money); // 자판기에 남은 잔액 출력
		for(Product product : this.productArray) {
			if(product != null) {
				System.out.println("자판기의 상품 수량 : " + product.getQuantity()); // 자판기에 남은 상품 재고 출력
				System.out.println("자판기의 상품 이름 : " + product.getName()); // 자판기의 상품 이름 출력;
				
			}
			
		}
	}

}
