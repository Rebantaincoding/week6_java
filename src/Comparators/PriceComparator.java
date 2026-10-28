package Comparators;
import java.util.*;

import Products.Product;

//Overriding comparator method to compare products based on price
public class PriceComparator implements Comparator<Product>{
     @Override
     public int compare(Product p1,Product p2) {
    	 return Double.compare(p1.getPrice(),p2.getPrice());
     }
}
