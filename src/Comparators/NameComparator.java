package Comparators;
import java.util.Comparator;

import Products.Product;

//Overriding comparator method to compare products based on name
public class NameComparator implements Comparator<Product>{
     @Override
     public int compare(Product p1,Product p2) {
    	 return (p1.getName()).compareTo(p2.getName());
     }
}