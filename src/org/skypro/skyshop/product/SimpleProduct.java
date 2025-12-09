package org.skypro.skyshop.product;

public class SimpleProduct extends Product  {
    private final double cost;
    public SimpleProduct(String name, double cost) {
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
        return super.getName() + " : " + cost; // Используем метод getName() из родительского класса
    }
    @Override
    public double getPrice() {
        return cost;
    }
        public double getCost() {
            return cost;
        }
        @Override
        public String getSearchTerm() {
            return getName();
        }
        @Override
        public String getType() {
            return toString();
        }
    }
