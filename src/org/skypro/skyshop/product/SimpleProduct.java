package org.skypro.skyshop.product;
import java.util.List;
public class SimpleProduct extends Product {
    private double cost;

    public SimpleProduct(String name, int i) {
        super(name);
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative");
        }
        this.cost = cost;

    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return name + " : " + cost;
    }
    @Override
    public double getPrice() {
        return cost;
    }

    @Override
    public double getCost() {
        return cost;
    }
}