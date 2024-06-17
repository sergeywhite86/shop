package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ProductBasket {

    private final List <Product> products = new ArrayList<>();


    public void addProduct(Product product) {
       products.add(product);
    }

    public int costBasket() {
        if (products.isEmpty()) return 0;
        return products.stream().mapToInt(Product::getPrice).sum();
    }

    public void printProducts() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            products.forEach(System.out::println);
            System.out.printf("Итого : %d \n", costBasket());
            System.out.printf("Специальных товаров : %d \n",countSpecialProducts());
        }
    }

    public boolean isHaveProduct(String productName) {
        if (products.isEmpty()) return false;
        return products.stream().anyMatch(p -> p.getName().equals(productName));
    }

    public void clean() {
        products.clear();
    }

    public int countSpecialProducts(){
        return (int) products.stream().filter(Objects::nonNull).filter(Product::isSpecial).count();
    }

    public List<Product> deleteProduct(String productName) {
        products.removeIf(p -> p.getName().equals(productName));
        return products;
    }
}
