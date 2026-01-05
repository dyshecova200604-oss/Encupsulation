package org.skypro.skyshop.product;

public abstract class SimpleProduct extends Product {

   private final int price;

    public SimpleProduct(String name, int price) {
        super(name);

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше 0");
        }
        this.price = price;

    }

    public int getPrice() {
        return (int) price;
    }

    @Override
    public String toString() {
        return getName() +
                ": " +
                price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SimpleProduct)) return false;
        SimpleProduct other = (SimpleProduct) obj;
        return Double.compare(other.price, price) == 0 && getName().equals(other.getName());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(getName(), price);
    }
}