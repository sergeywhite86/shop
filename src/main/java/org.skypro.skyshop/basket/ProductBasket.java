package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


import java.util.Arrays;
import java.util.Objects;


public class ProductBasket {

    private final int capacity = 5;
    private final Product[] products = new Product[capacity];
    private int currentIndex = 0;

    public void addProduct(Product product) {
        if (currentIndex < products.length) {
            products[currentIndex] = product;
            currentIndex++;
        } else System.out.println("Невозможно добавить продукт");

    }

    public int costBasket() {
        if (currentIndex == 0) return 0;
        return Arrays.stream(products).filter(Objects::nonNull).mapToInt(Product::getPrice).sum();
    }

    public void printProducts() {
        if (currentIndex == 0) {
            System.out.println("В корзине пусто");
        } else {
            Arrays.stream(products).filter(Objects::nonNull).forEach(System.out::println);
            System.out.printf("Итого : %d \n", costBasket());
            System.out.printf("Специальных товаров : %d \n",countSpecialProducts());
        }
    }

    public boolean isHaveProduct(String productName) {
        if (currentIndex == 0) return false;
        return Arrays.stream(products).anyMatch(p -> p.getName().equals(productName));
    }

    public void clean() {
        Arrays.fill(products, null);
        currentIndex = 0;
    }

    public int countSpecialProducts(){
        return (int) Arrays.stream(products).filter(Objects::nonNull).filter(Product::isSpecial).count();
    }

}
