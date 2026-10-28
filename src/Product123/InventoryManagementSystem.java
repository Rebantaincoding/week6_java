package Product123;

import java.util.Scanner;

import Products.Product;
//Contains the main method to implement all the utility methods under Inventoryutils
public class InventoryManagementSystem {
       public static void main(String args[]) {
    	   
    	   //Scanner class to take input
    	   Scanner sc=new Scanner(System.in);
    	   Inventoryutils iu=new Inventoryutils();
    	   int choice=0;
    	   
    	   //Menu driven interface to perform the desired task
    	   while(choice!=8) {
    		   System.out.println("\n=== INVENTORY MANAGEMENT SYSTEM ===\r\n"
    		   		+ "1. Add Product\r\n"
    		   		+ "2. Update Quantity\r\n"
    		   		+ "3. View Products (Sorted)\r\n"
    		   		+ "4. Search Products\r\n"
    		   		+ "5. Low Stock Alerts\r\n"
    		   		+ "6. Transaction History\r\n"
    		   		+ "7. Inventory Statistics\r\n"
    		   		+ "8. Exit\r\n"
    		   		+ "Enter your choice:");
    		   choice=sc.nextInt();
    		   
    		   //Implement add product functionality
    		   if(choice==1) {
    			   System.out.println("\n===ADD PRODUCT===\n");
    			   System.out.println(".".repeat(100));
    			   System.out.println("Enter Product Id:");
    			   sc.nextLine();
    			   String sku=sc.nextLine();
    			   System.out.println("Enter Product Name:");
    			   String name=sc.nextLine();
    			   System.out.println("Enter Product Category:");
    			   String type=sc.nextLine();
    			   System.out.println("Enter Price:");
    			   double price=sc.nextDouble();
    			   System.out.println("Enter Quantity: ");
    			   int quantity=sc.nextInt();
    			   Product product=new Product(sku,name,type,price,quantity);
    			   iu.addProduct(product);
    			   System.out.println("Product Added!!");
    		   }
    		   
    		   //Implement the update product functionality
    		   else if(choice==2) {
    			   System.out.println("\n===UPDATE QUANTITY===\n");
    			   System.out.println(".".repeat(100));
    			   System.out.println("Enter product Id:");
    			   sc.nextLine();
    			   String sku=sc.nextLine();
    			   System.out.println("Enter Quantity: ");
    			   int quantity=sc.nextInt();
    			   if(iu.updateProduct(sku, quantity)) {
    				   System.out.println("Updated Succesfully!!!");
    			   }
    		   }
    		   
    		   //View sorted products
    		   else if(choice==3) {
    			   System.out.println("\n===VIEW PRODUCT===\n");
    			   System.out.println(".".repeat(100));
    			   System.out.println("View Products sorted by\n1.Price\n2.Inventory Value\n3.Name\n");
    			   int ch=sc.nextInt();
    			   iu.viewproducts(ch);
    		   }
    		   
    		   //Searching a product
    		   else if(choice==4) {
    			   System.out.println("\n===SEARCH PRODUCT===\n");
    			   System.out.println(".".repeat(100));
    			   System.out.println("Enter keyword:");
    			   sc.nextLine();
    			   String search=sc.nextLine();
    			   iu.searchProduct(search);
    		   }
    		   
    		   //Showing products with low stock
    		   else if(choice==5) {
    			   System.out.println("\n===LOW STOCK ALERTS===\n");
    			   System.out.println(".".repeat(100));
    			   iu.lowStockAlert();
    		   }
    		   
    		   //Showing the transaction history
    		   else if(choice==6) {
    			   System.out.println("\n===LAST 5 TRASNACTIONS===\n");
    			   System.out.println(".".repeat(100));
    			   iu.showTransaction();
    		   }
    		   
    		   //Display inventory statistics 
    		   else if(choice==7) {
    			   System.out.println("\n===INVENTORY STATISTICS===\n");
    			   System.out.println("-".repeat(100));
    			   iu.InventoryStatistic();
    		   }
    	   }
    	   sc.close();
       }
}
