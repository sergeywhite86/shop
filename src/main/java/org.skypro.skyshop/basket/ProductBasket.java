package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


import java.util.*;


public class ProductBasket {

    private final Map<String, List<Product>> products = new HashMap<>();


    public void addProduct(Product product) {
        if (!products.containsKey(product.getName())) {
            List<Product> productsList = new ArrayList<>();
            productsList.add(product);
            products.put(product.getName(), productsList);
        } else {
            products.get(product.getName()).add(product);
        }
    }

    public int costBasket() {
        if (products.isEmpty()) return 0;
        return products.values().stream().flatMap(Collection::stream).mapToInt(Product::getPrice).sum();
    }

    public void printProducts() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            products.values().stream().flatMap(Collection::stream).forEach(System.out::println);
        }

        System.out.printf("Итого : %d \n", costBasket());
        System.out.printf("Специальных товаров : %d \n", countSpecialProducts());
    }

    public boolean isHaveProduct(String productName) {
        if (products.isEmpty()) return false;
        return products.keySet().stream().anyMatch(key -> key.equals(productName));
    }

    public void clean() {
        products.clear();
    }

    public int countSpecialProducts() {
        return (int) products.values().stream().flatMap(Collection::stream).filter(Product::isSpecial).count();
    }

    public Map<String, List<Product>> deleteProduct(String productName) {
        products.remove(productName);
        return products;
    }
}
