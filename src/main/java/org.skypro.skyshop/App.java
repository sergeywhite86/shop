package org.skypro.skyshop;


import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.info.Article;
import org.skypro.skyshop.product.info.SearchEngine;



import java.util.Arrays;
import java.util.Objects;


public class App {
    public static void main(String[] args) {

        Product product1 = new SimpleProduct("Apple", 100);
        Product product2 = new FixPriceProduct("Banana");
        Product product3 = new DiscountedProduct("Sugar", 30, 100);
        SearchEngine searchEngine = new SearchEngine(5);

        Article article1 = new Article("text", "bla bla bla bla");
        Article article2 = new Article("text2", "bla bla ");

        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(article1);
        searchEngine.add(article2);

        System.out.println(Arrays.toString(searchEngine.search("Apple")));

        Arrays.stream(searchEngine.search("text")).
                filter(Objects::nonNull).forEach(e -> System.out.println(e.getStringRepresentation()));

    }
}