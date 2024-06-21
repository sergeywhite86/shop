package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        int total = 0;
        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            for (Product product : entry.getValue()) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printProducts() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
                for (Product product : entry.getValue()) {
                    System.out.println(product);
                }
            }

            System.out.printf("Итого : %d \n", costBasket());
            System.out.printf("Специальных товаров : %d \n", countSpecialProducts());
        }
    }

    public boolean isHaveProduct(String productName) {
        if (products.isEmpty()) return false;
        return products.keySet().stream().anyMatch(key -> key.equals(productName));
    }

    public void clean() {
        products.clear();
    }

    public int countSpecialProducts() {
        int count = 0;
        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            for (Product product : entry.getValue()) {
                if (product.isSpecial()) count++;
            }
        }
        return count;
    }

    public Map<String, List<Product>> deleteProduct(String productName) {
        products.remove(productName);
        return products;
    }
}
