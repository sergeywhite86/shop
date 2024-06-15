package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct(new Product("Apple",  100));
        productBasket.addProduct(new Product("Banana", 200));
        productBasket.addProduct(new Product("Orange", 300));
        productBasket.addProduct(new Product("Pear", 400));
        productBasket.addProduct(new Product("Water", 500));
        productBasket.addProduct(new Product("Grape", 600));
        System.out.println(productBasket.costBasket());
        productBasket.printProducts();
        System.out.println(productBasket.isHaveProduct("Appl"));
        productBasket.clean();
        productBasket.printProducts();
        System.out.println(productBasket.costBasket());
        System.out.println(productBasket.isHaveProduct("A"));

    }
}