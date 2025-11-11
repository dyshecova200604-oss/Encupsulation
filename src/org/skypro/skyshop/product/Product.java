package org.skypro.skyshop.product;

public abstract class Product {
    String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean isSpecial();

    public abstract double getCost();

    public abstract double getPrice();
}
