package oop_exam;

public class DrinkVendingMachineMain {

	public static void main(String[] args) {
		
		DrinkVendingMachine vendingMachine = new DrinkVendingMachine();
		vendingMachine.printStock();
		
		Drink orderdDrink = vendingMachine.order("박카스", 10);
		System.out.println(">> 주문결과: "+ orderdDrink.name + ", " + orderdDrink.price + ", " + orderdDrink.stock);
		
		orderdDrink = vendingMachine.order("박카스", 5);
		System.out.println(">> 주문결과: "+ orderdDrink.name + ", " + orderdDrink.price + ", " + orderdDrink.stock);
		
		orderdDrink = vendingMachine.order("밀키스", 5);
		System.out.println(">> 주문결과: "+ orderdDrink.name + ", " + orderdDrink.price + ", " + orderdDrink.stock);
		
		vendingMachine.printStock();
		
		vendingMachine.fill("박카스", 300);
		vendingMachine.fill("몬스터", 450);
		vendingMachine.fill("핫식스", 250);
		vendingMachine.fill("밀키스", 150);
		
		vendingMachine.fill("제로콜라", 500);
		
		vendingMachine.printStock();
	}
	
}
