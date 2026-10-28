package Transactions;

import Products.Product;

//Class to store transaction of type: ADD
public class AddTransaction extends Transaction {
      public AddTransaction(String type,Product p){
    	  super(type,p);
      }
      @Override
      public void displaydetails() {
    	  System.out.print(type+" "+p.getSku()+" Quantity: "+p.getQuantity()+" at "+p.getLastUpdated()+"\n");
      }
}
