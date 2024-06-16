package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private final int discount;
    private final int price;

    public DiscountedProduct(String name, int discount, int price) {
        super(name);
        if (discount < 0 || discount > 100) throw new IllegalArgumentException("discount must be between 0 and 100");
        if (price < 1) throw new IllegalArgumentException("price must be > 0");
        this.discount = discount;
        this.price = price;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        return price - (price * discount / 100);
    }

    @Override
    public String toString() {
        return String.format("%s : %d (%d %%)", super.toString(), getPrice(),discount);
    }
}
