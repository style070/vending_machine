package vending_machine;

public interface PrintHandler<I> {


//	for( I product : this.productArray) {
//		if(product!= null) {
//			System.out.println("자판기의 상품 수량:"+product.getQuantity());
//			System.out.println("자판기의 상품 이름:"+product.getName());
//		}
//		this.printHandler.handle(product);
//	}
	
	public void handle(I item);
	
}
