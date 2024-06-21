package org.skypro.skyshop;



import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.service.Article;
import org.skypro.skyshop.service.SearchEngine;


public class App {
    public static void main(String[] args) throws BestResultNotFound {

        ProductBasket productBasket = new ProductBasket();
        Product product1 = new DiscountedProduct("water", 10, 50);
        Product product2 = new SimpleProduct("bread", 100);
        Product product3 = new FixPriceProduct("sugar");
        Product product4 = new FixPriceProduct("apple");
        productBasket.addProduct(product1);
        productBasket.addProduct(product2);
        productBasket.addProduct(product3);
        productBasket.addProduct(product4);
        productBasket.printProducts();
        productBasket.deleteProduct("apple");
        productBasket.printProducts();

        System.out.println("_________________");
        Product product5 = new SimpleProduct("apple",55);
        Product product6 = new SimpleProduct("app",58);
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);
        searchEngine.add(product6);
        System.out.println(searchEngine.getSearchTherm("app"));

        Article article1 = new Article("text11","ccdvevr");
        Article article2 = new Article("text211","ccdvevr");
        Article article3 = new Article("text31111","ccdvevr");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        System.out.println(searchEngine.getSearchTherm("text"));
    }
}