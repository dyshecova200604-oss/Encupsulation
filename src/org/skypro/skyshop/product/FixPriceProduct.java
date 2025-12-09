package org.skypro.skyshop.product;


public class FixPriceProduct extends Product {
    private final double fixedPrice;

    public FixPriceProduct(String name, double fixedPrice) {
        super(name);

        if (fixedPrice < 0) {
            throw new IllegalArgumentException("Cost cannot be negative");
        }
        this.fixedPrice = fixedPrice;
        // Инициализация переменной cost
    }
       @Override
        public String toString() {
        return super.toString() + " : Фиксированная.fixedPrice = fixedPrice; цена " + fixedPrice; // Используем super.toString() для получения имени продукта

    }


    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public double getPrice() {
return fixedPrice;

    }


    public String getType() {
        return "";

    }
}