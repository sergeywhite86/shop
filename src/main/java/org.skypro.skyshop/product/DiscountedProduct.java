package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private final int discount;
    private final int cost;

    public DiscountedProduct(String name, int discount, int cost) {
        super(name);
        this.discount = discount;
        this.cost = cost;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        return cost - (cost * discount / 100);
    }

    @Override
    public String toString() {
        return String.format("%s : %d (%d %%)", super.toString(), getPrice(),discount);
    }
}
