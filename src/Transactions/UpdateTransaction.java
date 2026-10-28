package Transactions;

import Products.Product;

//Class to store transaction of type: UPDATE
public class UpdateTransaction extends Transaction{
    int prevquantity;
    int newquantity;
	public UpdateTransaction(String type, Product p, int prevquantity,int newquantity) {
		super(type, p);
		this.prevquantity=prevquantity;
		this.newquantity=newquantity;
	}
	@Override
	public void displaydetails() {
		System.out.print(type+" "+p.getSku()+" Quantity changed from "+prevquantity+" to "+newquantity+" at "+p.getLastUpdated()+"\n");
	}
    
}
