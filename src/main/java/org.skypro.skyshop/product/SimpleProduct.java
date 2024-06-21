package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private final int price;


    public SimpleProduct(String name, int price) {
        super(name);
        if (price < 1) throw new IllegalArgumentException("Price must be positive");
        this.price = price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s : %d", super.toString(), price);
    }
}


