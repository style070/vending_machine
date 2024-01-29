package vending_machine;

public class VipCustomer extends Customer {

	
	public VipCustomer(int wallet) {
		super(wallet);
	}
	
	@Override
	protected Product getProductByName(String name) {
		// TODO Auto-generated method stub
		return super.getProductByName(name);
	}
	
}
