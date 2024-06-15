package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;


public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct(new SimpleProduct("Apple",  100));
        productBasket.addProduct(new FixPriceProduct("Banana"));
        productBasket.addProduct(new DiscountedProduct("Sugar",30,100));
        productBasket.printProducts();

    }
}