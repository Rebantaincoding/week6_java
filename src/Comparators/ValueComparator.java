package Comparators;
import java.util.*;

import Products.Product;

//Overriding comparator method to compare products based on inventory value
public class ValueComparator implements Comparator<Product>{
     @Override
     public int compare(Product p1,Product p2) {
    	 return Double.compare(p1.getInventoryValue(),p2.getInventoryValue());
     }
}