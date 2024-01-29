package vending_machine;

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
		
		
		//Seller
		//   --> VendingMachine
		//   --> RefundableVendingMachine
		// IS A (다형성)
		// VendingMachine IS A Seller
		// RefundableVendingMachine IS A Seller
		// Seller drinkVendingMachine = new VendingMachine();
		// Seller drinkVendingMachine = new Refundable Vending Machine

		Seller drinkMachine = new VendingMachine();

		Customer musk = new Customer(200_000);

		drinkMachine.insertMoney(musk, "제로펩시");
		drinkMachine.pressButton(musk, "제로펩시",50);

		drinkMachine.insertMoney(musk, "제로펩시");
		drinkMachine.pressButton(musk, "제로펩시");

		drinkMachine.printProducts();
		musk.printProducts();

		Seller snackMachine = new RefundableVendingMachine(400);
		snackMachine.insertMoney(musk, "제로펩시");
		snackMachine.pressButton(musk, "제로펩시", 50);

		snackMachine.insertMoney(musk, "제로펩시");
		snackMachine.pressButton(musk, "제로펩시", 2);

		snackMachine.printProducts();
		musk.printProducts();

	}
}
