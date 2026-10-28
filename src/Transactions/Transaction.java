package Transactions;

import Products.Product;

//Class to store transaction details
public abstract class Transaction {
	
	//type of transaction:ADD or UPDATE
     String type;
     Product p;
     
     //Parameterized constructor
     public Transaction(String type,Product p){
    	 this.type=type;
    	 this.p=p;
     }
     
     //Getters and setters
	 public String getType() {
		 return type;
	 }
	 public void setType(String type) {
		 this.type = type;
	 }
	 public Product getP() {
		 return p;
	 }
	 public void setP(Product p) {
		 this.p = p;
	 }
	 
	 //abstract method to display details of transaction
	 public abstract void displaydetails();
     
}
