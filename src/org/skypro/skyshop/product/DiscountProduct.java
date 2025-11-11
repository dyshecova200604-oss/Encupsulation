package org.skypro.skyshop.product;

public class DiscountProduct extends Product {
    private String name;
    private double originalPrice;
    private double discountPercentage; // Процент скидки

    public DiscountProduct(String name, double originalPrice, double discountPercentage) {
        super(name);
        this.name = name;
        if (originalPrice < 0) {
            throw new IllegalArgumentException("Original price cannot be negative");
        }
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100");
        }
        this.originalPrice = originalPrice;
        this.discountPercentage = discountPercentage;
    }
    // Метод для расчета цены со скидкой

    public double getPrice() {
        return originalPrice * (1 - discountPercentage / 100);
    }


    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public double getCost() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " : Оригинальная цена " + originalPrice + ", Скидка " + discountPercentage + "%, Цена со скидкой " + getPrice();

        }

        public double getDiscountPercentage() {
            return discountPercentage; // Метод для получения процента скидки
        }
    }
