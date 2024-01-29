package vending_machine;

public class Customer {
	/**
	 * 고객이 가진돈
	 */
	private int wallet;

	/**
	 * 고객이 가진 상품의 수량
	 */
	// int stock;
	private Product[] productArray; // 고객이 가진 상품의 물량을 추가하기 위해 Product 데이터클래스 선언

	/**
	 * 지출한다.
	 */

	public int getWallet() {
		return this.wallet;
	}

	public Product[] getProduct() {
		return productArray;
	}

	/**
	 * Customer 생성자
	 */
	// this는 생성자가 만들어준 인스턴스
	// 생성자의 인스턴스에 파라미터로 받은 인스턴스를 넣어줘라 라는 의미
//	public Customer(int wallet, int stock) {
	public Customer(int wallet) {
		this.wallet = wallet; // 고객이 가진돈을 파라미터 값으로 받아 (200_000) 값 할당
		// this.stock = stock;
		this.productArray = new Product[3]; // 고객이 가진 (장바구니 같은) 데이터클래스 생성
	}

	public void pay(int price) {
		if (this.wallet - price <= 0) {
			return; // 고객이 가진돈 - 상품 가격이 작으면 돈이 부족하므로 아무것도 하지 않도록 return;
		}
		this.wallet -= price; // 고객이 가진돈이 상품 가격보다 큰경우 구입이 가능하므로 고객의 지갑(wallet)에서 상품가격을 뺌
	}

	/**
	 * 환불받는다.
	 * @param money 환불받은 금액
	 */
	public void addMoney(int money) {
		this.wallet += money;
	}

	/**
	 * 상품이 하나 증가한다.
	 */
	public void addStock(String name, int price) {
//		// this.stock++;
//		// 고객이 제로콜라를 구매한 적이 있는지 확인.
//		// 고객이 제로콜라를 구매한 적이 없다면
//		if (this.productArray.getName() == null) {
//			// 고객이 가진 상품의 정보를 제로콜라로 채워준다.
//			this.product.setName(name); // 상품 이름 할당 ex) "제로 콜라"
//			this.product.setPrice(price); // 상품 가격 할당
//			//this.product.setQuantity(1); // 첫 구매이므로 고객의 장바구니에 Quantity 1 증가
//			this.product.setQuantity(VendingMachine.PRODUCT_COUNT);
//		}
//		// 고객이 가진 상품의 정보를 제로콜라로 채워준다.
//
//		// 고객이 제로콜라를 구매한 적이 있다면
//		else {
//			// 고객이 가진 제로콜라의 수량을 1개 증가 시킨다.
//			//this.product.quantity++; // 아래 라인처럼 풀어서 써야함
//			int quantity = this.product.getQuantity();
//			//quantity++;
//			quantity += VendingMachine.PRODUCT_COUNT;
//			this.product.setQuantity(quantity);
//		}
//		// 메소드 체이닝을 통한 재귀 호출 / 중복 코드 제거
//		//this.addStock(name, price, VendingMachine.PRODUCT_COUNT);
	}

	public void addStock(String name, int price, int productCount) {
		// 고객이 방금구매한 제품이 고객의 제품목록(this.productArray)에 있는지 확인한다.
		// 있다면, productcOunt만큼 수량만 증가시킨다.
		// 없다면, 비어있는 인덱스를 찾아서 새롭게 할당해 준다.
		// 인덱스(index)를 사용할것이므로 for-each가 아닌 for문을 사용한다.
		Product product = this.getProductByName(name);

		if (product != null) {

			int quantity = product.getQuantity();
			quantity += productCount;
			product.setQuantity(quantity);
			
		} else {
			int nullIndex = this.getNullIndex();
			if(nullIndex>=0) {
				this.productArray[nullIndex] = new Product();
				this.productArray[nullIndex].setName(name);
				this.productArray[nullIndex].setPrice(price);
				this.productArray[nullIndex].setQuantity(productCount);
			}

		}

//		// this.stock++;
//		// 고객이 제로콜라를 구매한 적이 있는지 확인.
//		// 고객이 제로콜라를 구매한 적이 없다면
//		if (this.product.getName() == null) {
//			// 고객이 가진 상품의 정보를 제로콜라로 채워준다.
//			this.product.setName(name); // 상품 이름 할당 ex) "제로 콜라"
//			this.product.setPrice(price); // 상품 가격 할당
//			//this.product.setQuantity(1); // 첫 구매이므로 고객의 장바구니에 Quantity 1 증가
//			this.product.setQuantity(productCount);
//		}
//		// 고객이 가진 상품의 정보를 제로콜라로 채워준다.
//
//		// 고객이 제로콜라를 구매한 적이 있다면
//		else {
//			// 고객이 가진 제로콜라의 수량을 1개 증가 시킨다.
//			//this.product.quantity++; // 아래 라인처럼 풀어서 써야함
//			int quantity = this.product.getQuantity();
//			//quantity++;
//			quantity += productCount;
//			this.product.setQuantity(quantity);
//		}
//	}
	}

	protected Product getProductByName(String name) {
		for (Product product : this.productArray) {
			if (product != null && product.getName().equals(name)) {
				return product;
			}
		}

		return null;
	}

	private int getNullIndex() {
		for (int i = 0; i < this.productArray.length; i++) {
			if (this.productArray[i] == null) {
				return i;
			}
		}
		return -1;

	}

	public void printProducts() {

		System.out.println("고객의 잔액 : " + this.wallet); // 자판기에 남은 잔액 출력
		for (Product product : this.productArray) {
			if(product != null) {
				
				System.out.println("고객의 상품 수량 : " + product.getQuantity()); // 자판기에 남은 상품 재고 출력
				System.out.println("고객의 상품 이름 : " + product.getName()); // 자판기의 상품 이름 출력;
			}
		}
	}
}
