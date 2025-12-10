package org.skypro.skyshop.product;

public class SimpleProduct extends org.skypro.skyshop.product.Product {

    final int price;
    public SimpleProduct(String name, int price) {
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше 0");
        }
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return getName() +
                ": " +
                price;
    }
}