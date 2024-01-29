package vending_machine;

public class Mart {

	public static void main(String[] args) {
		
		// 객체지향 방식으로 개발.
		VendingMachine drinkMachine = new VendingMachine();
		
		Customer musk = new Customer(200_000);
		
		drinkMachine.insertMoney(musk, "제로펩시");
		drinkMachine.pressButton(musk, "제로펩시");
		
		drinkMachine.insertMoney(musk, "제로콜라");
		drinkMachine.pressButton(musk, "제로콜라");
		
		drinkMachine.printProducts();
		musk.printProducts();
		
		VendingMachine snackMachine = new VendingMachine(400);
		snackMachine.insertMoney(musk, "제로스프라이트");
		snackMachine.pressButton(musk, "제로스프라이트", 4);
		
		snackMachine.insertMoney(musk, "제로펩시");
		snackMachine.pressButton(musk, "제로펩시", 2);
		
		snackMachine.printProducts();
		musk.printProducts();
	}
	
}
