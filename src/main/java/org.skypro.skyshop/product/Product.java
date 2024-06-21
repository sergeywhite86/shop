package org.skypro.skyshop.product;

import org.skypro.skyshop.service.Searchable;

public abstract class Product implements Searchable {

    private final String name;


    public Product(String name) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    @Override
    public String searchTerm() {
        return name;
    }

    @Override
    public String getTypeContent() {
        return "PRODUCT";
    }

    public String getName() {
        return name;
    }


    public abstract boolean isSpecial();


    public abstract int getPrice();

    @Override
    public String toString() {
        return name;
    }
}
