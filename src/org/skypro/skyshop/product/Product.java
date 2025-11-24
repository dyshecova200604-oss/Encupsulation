package org.skypro.skyshop.product;

public abstract class Product {
    private final String name; // Поле для хранения имени продукта

    public Product(String name) {
        this.name = name; // Инициализация имени продукта
    }

    public String getName() { // Метод должен возвращать имя продукта
        return name;
    }

    public abstract boolean isSpecial(); // Абстрактный метод для проверки, является ли продукт специальным

    public abstract double getCost(); // Абстрактный метод для получения стоимости продукта

    public abstract double getPrice(); // Абстрактный метод для получения цены продукта
}