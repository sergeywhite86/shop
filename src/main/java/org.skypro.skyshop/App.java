package org.skypro.skyshop;


import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.info.SearchEngine;


public class App {
    public static void main(String[] args) {
        try {
            Product product1 = new SimpleProduct(" ", 100);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Product product2 = new DiscountedProduct("water", 100, 0);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Product product3 = new DiscountedProduct("orange", 101, 50);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        SearchEngine searchEngine = new SearchEngine(8);
        Product product1 = new DiscountedProduct("appleappple", 10, 50);
        Product product2 = new SimpleProduct("appleappleapple", 100);
        Product product3 = new FixPriceProduct("sugar");
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);

        try {
            System.out.println(searchEngine.getSearchTherm("z"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(searchEngine.getSearchTherm("a"));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}