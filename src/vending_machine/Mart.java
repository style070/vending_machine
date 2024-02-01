package vending_machine;

import java.util.ArrayList;
import java.util.List;

public class Mart {

	/**
	 * 함수지향방식으로 개발한 코드
	 * 
	 */

	// Product 클래스로 모두 할 수 있으므로 지워도 됨
//	public static void printTemperatureProduct(TemperatureProduct tp) {
//		System.out.println(tp.getName());
//	}

//	public static void printProduct(Product p) {
//		System.out.println(p.getName());
//		
//		if (p instanceof TemperatureProduct) {
//			TemperatureProduct tp =(TemperatureProduct) p;
//			tp.setIsHot(true);		
//			System.out.println(tp.getIsHot());
//		}
//	}

	/**
	 * 객체지향형으로 개발한 코드
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		//모든 클래스의 슈퍼클래스는 Object
//		/**
//		 * Object
//		 * --> Product
//		 * 	-->TemperatureProduct
//		 * Product IS A object
//		 * TemperatureProduct IS A Product
//		 * TemperatureProduct IS A Object
//		 * 
//		 */
//		Product p = new Product();
//		TemperatureProduct tp = new TemperatureProduct();
//		tp.setName("tp");
//		printProduct(tp);
//		printProduct(p); // 기존에는 Type ( Product , TemperautreProduct )이 맞지않아서 Error가 발생하지만 Product 데이터 클래스를 상속받아서 가능함

		// 객체지향 방식으로 개발.

		Product p = new Product();
		p.setName("보드마카");
		p.setPrice(500);
		p.setQuantity(40);

		System.out.println(p);

		// Seller ( 추상클래스 일때 )
		// --> VendingMachine
		// --> RefundableVendingMachine
		// IS A (다형성)
		// VendingMachine IS A Seller
		// RefundableVendingMachine IS A Seller
		// Seller drinkVendingMachine = new VendingMachine();
		// Seller drinkVendingMachine = new Refundable Vending Machine

		// Sellable ( 인터페이스 )
		// --> (구현) VendingMachine
		// --> (구현) RefundableVendingMachine
		// 인터페이스를 구현 ( IS A )
		// VendingMachine IS A Sellable
		// RefundableVendingMachine IS A Sellable
		// Seller drinkVendingMachine = new VendingMachine();
		// Seller drinkVendingMachine = new RefundableVendingMachine

		List<Product> productList = new ArrayList<>();// Product 클래스에 정의된 데이터 클래스 인스턴스생성

		Product product1 = new Product(); // product 데이터 클래스의 name 필드에 String "제로콜라"할당
		product1.setName("제로펩시"); // product 데이터 클래스의 price 필드에 int 1600 할당
		product1.setPrice(1600);// this.productArray[0].setQuantity(50);
		product1.setQuantity(50);
		productList.add(product1);
		
		Product product2 = new Product(); // product 데이터 클래스의 name 필드에 String "제로콜라"할당
		product2.setName("제로콜라"); // product 데이터 클래스의 price 필드에 int 1600 할당
		product2.setPrice(1500);// this.productArray[1].setQuantity(30);
		product2.setQuantity(50);
		productList.add(product2);

		Product product3 = new Product(); // product 데이터 클래스의 name 필드에 String "제로콜라"할당
		product3.setName("제로스프라이트"); // product 데이터 클래스의 price 필드에 int 1600 할당
		product3.setPrice(1400);// this.productArray[2].setQuantity(20);
		product3.setQuantity(50);
		productList.add(product3);
		
		Sellable<Product> drinkMachine = new VendingMachine<>(100_000, productList);
		// 익명클래스 new InsertMoneyHandler 클래스 내부 클래스는 Mart$1 (Mart에서만든 첫번째 클래스 인스턴스) 처럼 됨
		drinkMachine.setInsertMoneyHandler(new InsertMoneyHandler<Product>() {

			@Override
			public void handle(VendingMachine<Product> machine, Customer customer, Product item, String productName) {
				// TODO Auto-generated method stub
				if (item.getName().equals(productName)) {
					// machine.money += item.getPrice();
					int money = machine.getMoney();
					money += item.getPrice();
					machine.setMoney(money);
					customer.pay(item.getPrice());
				}
			}
		});
		drinkMachine.setPressButtonHandler(new PressButtonHandler<Product>() {
			
			@Override
			public void handle(VendingMachine<Product> machine, Customer customer, Product item, String productName,
					int orderCount) {
				// TODO Auto-generated method stub
				if (item.getName().equals(productName)) {
					if (item.getQuantity() <= 0) {
						machine.refund(customer, item.getPrice());
						return;
					}
					int quantity = item.getQuantity();
					quantity -= orderCount;
					item.setQuantity(quantity);
	
					customer.addStock(productName, item.getPrice(), orderCount);
				}
				
			}
		});
		drinkMachine.setPrintHandler(new PrintHandler<Product>() {
			
			@Override
			public void handle(Product item) {
				// TODO Auto-generated method stub
				System.out.println("자판기의 상품 수량:"+item.getQuantity());
				System.out.println("자판기의 상품 이름:"+item.getName());
			}
		});

		Customer musk = new Customer(200_000);

		drinkMachine.insertMoney(musk, "제로펩시");
		drinkMachine.pressButton(musk, "제로펩시", 50);

		drinkMachine.insertMoney(musk, "제로펩시");
		drinkMachine.pressButton(musk, "제로콜라", 30);

		drinkMachine.printProducts();
		musk.printProducts();

		Sellable<Product> snackMachine = new RefundableVendingMachine<>(400, productList);
		snackMachine.setInsertMoneyHandler(new InsertMoneyHandler<Product>() {

			@Override
			public void handle(VendingMachine<Product> machine, Customer customer, Product item, String productName) {
				// TODO Auto-generated method stub
				if (item.getName().equals(productName)) {
					// machine.money += item.getPrice();
					int money = machine.getMoney();
					money += item.getPrice();
					machine.setMoney(money);
					customer.pay(item.getPrice());
				}
			}
		});
		snackMachine.setPressButtonHandler(new PressButtonHandler<Product>() {
			
			@Override
			public void handle(VendingMachine<Product> machine, Customer customer, Product item, String productName,
					int orderCount) {
				// TODO Auto-generated method stub
				if (item.getName().equals(productName)) {
					if (item.getQuantity() <= 0) {
						machine.refund(customer, item.getPrice());
						return;
					}
					int quantity = item.getQuantity();
					quantity -= orderCount;
					item.setQuantity(quantity);
	
					customer.addStock(productName, item.getPrice(), orderCount);
				}
				
			}
		});
		snackMachine.setPrintHandler(new PrintHandler<Product>() {
			
			@Override
			public void handle(Product item) {
				// TODO Auto-generated method stub
				System.out.println("자판기의 상품 수량:"+item.getQuantity());
				System.out.println("자판기의 상품 이름:"+item.getName());
			}
		});
		snackMachine.insertMoney(musk, "제로펩시");
		snackMachine.pressButton(musk, "제로펩시", 5);

		snackMachine.insertMoney(musk, "제로스프라이트");
		snackMachine.pressButton(musk, "제로펩시", 10);

		snackMachine.printProducts();
		musk.printProducts();

	}
}
