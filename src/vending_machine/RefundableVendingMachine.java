package vending_machine;

import java.util.List;

/**
 * 환불기능이 있는 자판기
 */

// extends 먼저사용
// 생성자와 refund 빼고 모두 삭제하면됨
public class RefundableVendingMachine<I> extends VendingMachine<I> implements Sellable<I> {

	public RefundableVendingMachine(List<I> itemArray) {
		super(itemArray);

	}

	public RefundableVendingMachine(int money,List<I> itemArray) {
		super(itemArray);
//		super.productArray = new Product[3];// Product 클래스에 정의된 데이터 클래스 인스턴스생성
//
//		super.productArray[0] = new Product(); // product 데이터 클래스의 name 필드에 String "제로콜라"할당
//		super.productArray[0].setName("제로펩시"); // product 데이터 클래스의 price 필드에 int 1600 할당
//		super.productArray[0].setPrice(1600);
//		this.productArray[0].setQuantity(50);
//
//		super.productArray[1] = new Product(); // product 데이터 클래스의 name 필드에 String "제로콜라"할당
//		super.productArray[1].setName("제로콜라"); // product 데이터 클래스의 price 필드에 int 1600 할당
//		super.productArray[1].setPrice(1500);
//		this.productArray[1].setQuantity(30);
//
//		super.productArray[2] = new Product(); // product 데이터 클래스의 name 필드에 String "제로콜라"할당
//		super.productArray[2].setName("제로스프라이트"); // product 데이터 클래스의 price 필드에 int 1600 할당
//		super.productArray[2].setPrice(1400);
//		this.productArray[2].setQuantity(20);

	}

	@Override
	protected void refund(Customer customer, int refundMoney) {
		// TODO Auto-generated method stub
		System.out.println("재고가 없네요");
		System.out.println(refundMoney + "원 환불 해드릴게요");
		// 1. 자판기의 금액을 환불 해줄 금액만큼 감소 시킨다.
		// super.money -= refundMoney;
		int money = super.getMoney();
		money -= refundMoney;
		super.setMoney(money);
		// 2. 고객에게 환불해준다.
		customer.addMoney(refundMoney);
	}

//public class RefundableVendingMachine extends Seller {

//	RefundableVendingMachine(){
//		super();
//	}
//	
//	RefundableVendingMachine(int money){
//		super(money);
//	}

//	@Override
//	protected void refund(Customer customer, int refundMoney) {
//		// TODO Auto-generated method stub
//		System.out.println("재고가 없네요");
//		System.out.println(refundMoney+"원 환불 해드릴게요");
//		// 1. 자판기의 금액을 환불 해줄 금액만큼 감소 시킨다.
//		//super.money -= refundMoney;
//		int money = super.getMoney();
//		money -= refundMoney;
//		super.setMoney(money);
//		// 2. 고객에게 환불해준다.
//		customer.addMoney(refundMoney);
//		
//	}
//	@Override
//	public void printProducts() {
//		// TODO Auto-generated method stub
//		super.printProducts();
//	}

}
