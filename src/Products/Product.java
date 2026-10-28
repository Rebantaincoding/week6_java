package Products;

import java.util.*;

//Basic Product class that extends Comparable<Product>
public class Product implements Comparable<Product> {
	
	//Unique Id of product
     private String sku;
     
     //Name of Product
     private String name;
     
     //category
     private String category;
     
     //Price
     private double price;
     
     //Quantity
     private int quantity;
     
     //To store the last time product was updated
     private Date lastUpdated;
     
     //Parameterized constructor to initialize variables
     public Product(String sku,String name,String category,double price,int quantity) {
    	 this.sku=sku;
    	 this.name=name;
    	 this.category=category;
    	 this.price=price;
    	 this.quantity=quantity;
    	 this.lastUpdated=new Date();
     }
     
     //Overriding comapreTo method
     @Override
     public int compareTo(Product other) {
    	 return this.sku.compareTo(other.sku);
     }
     
     //Overriding equals method
     @Override
     public boolean equals(Object obj) {
         if(this == obj) return true;
         if(obj == null || getClass() != obj.getClass()) return false;
         Product product = (Product) obj;
         return sku.equals(product.sku);
     }
     
     //Getters 
     @Override 
     public int hashCode() {
    	 return sku.hashCode();
     }
	 public String getSku() {
		 return sku;
	 }
	 public String getName() {
		 return name;
	 }
	 public String getCategory() {
		 return category;
	 }
	 public double getPrice() {
		 return price;
	 }
	 public int getQuantity() {
		 return quantity;
	 }
	 public Date getLastUpdated() {
		 return lastUpdated;
	 }
	 
	 //Setters for selected attributes
	 public void setPrice(double price) {
		 this.price = price;
		 this.lastUpdated=new Date();
	 }
	 public void setQuantity(int quantity) {
		 this.quantity = quantity;
		 this.lastUpdated=new Date();
	 }
	 public double getInventoryValue() {
	        return price * quantity;
	    }
	 
	 //Display product details
	 public void showdetails() {
		 System.out.println("Id: "+sku);
		 System.out.println("Name: "+name);
		 System.out.println("Category: "+category);
		 System.out.println("Price: "+price);
		 System.out.println("Qunaity: "+quantity);
	 }
	 
}
