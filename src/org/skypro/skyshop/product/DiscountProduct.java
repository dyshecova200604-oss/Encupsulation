package org.skypro.skyshop.product;

import skyshop.search.Searchable;

public class DiscountProduct extends Product implements Searchable {

    private final double originalPrice;
    private final int discountPercentage; // Процент скидки 0..100

    public DiscountProduct(String name, double originalPrice, int discountPercentage) {
        super(name); // Оставляем вызов родительского конструктора как у вас был
        if (originalPrice < 0) {
            throw new IllegalArgumentException("Original price cannot be negative");
        }
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
        this.originalPrice = originalPrice;
        this.discountPercentage = discountPercentage;
    }

    /**
     * Цена товара со скидкой.
     */
    public double getPrice() {
        return originalPrice * (1 - discountPercentage / 100.0);
    }


    public boolean isSpecial() {
        return discountPercentage > 0;
    }

    @Override
    public double getCost() {
        return getPrice();
    }


    @Override
    public String toString() {
        return super.toString()
                + " : Оригинальная цена " + String.format("%.2f", originalPrice)
                + ", Скидка " + discountPercentage + "%, Цена со скидкой " + String.format("%.2f", getPrice());
    }


    public double getDiscountRate() {
        return discountPercentage / 100.0;
    }

    @Override
    public String getSearchTerm() {
        return "";
    }

    @Override
    public String getType() {
        return "";
    }
}
