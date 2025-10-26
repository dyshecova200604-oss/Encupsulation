package org.skypro.skyshop.product;

public class Product {
    // Поля класса с модификатором private
    private final String name; // Название продукта
    private final int price;    // Стоимость продукта

    // Конструктор для инициализации полей
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // Геттер для получения названия продукта
    public String getName() {
        return name;
    }

    // Геттер для получения стоимости продукта
    public int getPrice() {
        return price;
    }
}
