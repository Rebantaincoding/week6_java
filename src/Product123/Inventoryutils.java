package Product123;
import java.util.*;

import Comparators.NameComparator;
import Comparators.PriceComparator;
import Comparators.ValueComparator;
import Products.Product;
import Transactions.AddTransaction;
import Transactions.Transaction;
import Transactions.UpdateTransaction;

/* CLass that contains are the data structures: HashSet, LinkedList, ArrayList, HashMap to store the products, transactions, 
 * products with low stock and map to count the total items and total value per category respectively.it also contains all 
 * the utility methods to ADD,UPDATE,SEARCH,VIEW the products in sorted order and also view the previous transactions*/

public class Inventoryutils {
	
     //Linked List to store transaction history
     List<Transaction> transactions=new LinkedList<>();
     
     //Set to store the products
     HashSet<Product> products=new HashSet<>();
     
     //List to store products with low stock
     List<Product> lowstock=new ArrayList<>();
     
     //HashMap to store the count of goods of each category
     HashMap<String,Integer> categorycount=new HashMap<>();
     
     //HashMap to store the sum of inventory value of goods of each category
     HashMap<String,Double> categorysum=new HashMap<>();
     
     //Method to add product to the database
     public void addProduct(Product product) {
    	 products.add(product);
    	 //Add the transaction to the transaction database
    	 transactions.add(new AddTransaction("ADDED",product));
     }
     
     //Method to update the quantity of an existing product
     public boolean updateProduct(String sku,int quantity) {
    	 Product p=null;
    	 for(Product product:products) {
    		 if(product.getSku().equals(sku)) {
    			 p=product;
    		 }
    	 }
    	 if(p==null) {
    		 System.out.println("No Products found!!!");
    		 return false;
    	 }
    	
    		 int initial=p.getQuantity();
    		 p.setQuantity(quantity);
    		 
    		//Add the transaction to the transaction database
    		 transactions.add(new UpdateTransaction("UPDATED",p,initial,quantity));
    		 if(p.getQuantity()==0) {
    			 products.remove(p);
    		 }
    		 return true;
     }
     
     //View the products in a sorted order
     public void viewproducts(int criteria) {
    	 List<Product> productList = new ArrayList<>(products);
    	 if(productList.isEmpty()) {
    		 System.out.println("No details to show");
    	 }
    	 
    	 //Products sorted based on price
    	 if(criteria==1) {
    		 Collections.sort(productList,new PriceComparator());
    	 }
    	 
    	 //Products sorted based on inventory value
    	 else if(criteria==2) {
    		 Collections.sort(productList,new ValueComparator());
    	 }
    	 
    	 //Products sorted based on name
    	 else if(criteria==3) {
    		 Collections.sort(productList,new NameComparator());
    	 }
    	 System.out.printf("%-10s %-20s %-15s %-10s %-8s %-12s\n", 
                 "SKU", "Name", "Category", "Price", "Qty", "Value");
         System.out.println("-".repeat(85));
          //Display the sorted products
          for(Product product : productList) {
                    System.out.printf("%-10s %-20s %-15s ₹%-9.2f %-8d ₹%-11.2f\n", 
                    product.getSku(), product.getName(), product.getCategory(),
                    product.getPrice(), product.getQuantity(), product.getInventoryValue());
              }
    	 
     }
     
     //Search a product based on keyword
     public void searchProduct(String search) {
    	 List<Product> searchresults=new ArrayList<>();
    	 search=search.toLowerCase();
    	 
    	 //Checks whether the search keyword matches with product id,name or category
    	 for(Product product:products) {
    		 if((product.getSku().toLowerCase().contains(search))
    				 ||(product.getName().toLowerCase().contains(search))
    				 ||(product.getCategory().toLowerCase().contains(search))) {
    			 searchresults.add(product);
    		 }
    	 }
    	 System.out.println("SEARCH RESULTS FOR '"+search+"':");
    	 if(searchresults.isEmpty()) {
    		 System.out.println("No details to show");
    	 }
    	 System.out.printf("%-10s %-20s %-15s %-10s %-8s %-12s\n", 
                 "SKU", "Name", "Category", "Price", "Qty", "Value");
         System.out.println("-".repeat(85));
          
          //Display the search results
          for(Product product : searchresults) {
                    System.out.printf("%-10s %-20s %-15s ₹%-9.2f %-8d ₹%-11.2f\n", 
                    product.getSku(), product.getName(), product.getCategory(),
                    product.getPrice(), product.getQuantity(), product.getInventoryValue());
                  }
    	 
     }
     
     //Display products with stock quantity<=10
     public void lowStockAlert() {
    	 for(Product p:products) {
    		 if(p.getQuantity()<10) {
    			 lowstock.add(p);
    		 }
    	 }
    	 System.out.println("Low stock alert for Products with Product Ids: ");
    	 if(lowstock.isEmpty()) {
    		 System.out.println("No details to show");
    	 }
    	 for(Product product:lowstock) {
    		 System.out.println(product.getSku());
    	 }
    	 lowstock=new ArrayList<>();
     }
     
     
     //Get the last five transactions
     public void showTransaction() {
    	 int len=transactions.size();
    	 if(len>5) {
    	 for(int i=len-6;i<len;i++) {
    		 transactions.get(i).displaydetails();
    	 }
    	 }
    	 
    	 //If the number of transactions is less than 5, the show all the transactions
    	 else {
    		 for(Transaction t:transactions) {
    			 t.displaydetails();
    			 System.out.println();
    		 }
    	 }
     }
     
     //Display the count and total sum of each category
     public void InventoryStatistic() {
        for(Product product:products) {
        	String cat=product.getCategory().toLowerCase();
        	if(categorycount.get(cat)==null) {
        		categorycount.put(cat,1);
        		categorysum.put(cat, product.getInventoryValue());
        	}
        	else {
        		categorycount.put(cat,categorycount.get(cat)+1);
        		categorysum.put(cat,categorysum.get(cat)+ product.getInventoryValue());
        	}
        }
        System.out.println("Total Products: "+products.size());
        System.out.println("-".repeat(100));
        for(String cat:categorycount.keySet()) {
        	System.out.println("TYPE: "+cat);
        	System.out.println("Products: "+categorycount.get(cat));
        	System.out.println("Total value: "+categorysum.get(cat));
        	System.out.println("-".repeat(100));
        }
      }
     
 }
