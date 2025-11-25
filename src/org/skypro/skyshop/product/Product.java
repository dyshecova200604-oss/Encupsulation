package org.skypro.skyshop.product;

import skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String name; // Поле для хранения имени продукта

    public Product(String name) {
        this.name = name; // Инициализация имени продукта
    }

    public String getName() { // Метод должен возвращать имя продукта
        return name;
    }


    public String getSearchTerm() {
        return "";
    }

    public abstract boolean isSpecial();

    public abstract double getPrice(); // Абстрактный метод для получения цены продукта
}