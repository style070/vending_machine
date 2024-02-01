package vending_machine;

public interface PressButtonHandler<I> {

//	if (product.getName().equals(productName)) {
//		if (product.getQuantity() <= 0) {
//			refund(customer, product.getPrice());
//			return;
//		}
//		int quantity = product.getQuantity();
//		quantity -= orderCount;
//		product.setQuantity(quantity);
//
//		customer.addStock(productName, product.getPrice(), orderCount);
//	}
	
	public void handle(VendingMachine<I> machine ,Customer customer,I item,String productName,int orderCount);
}
