package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;


public abstract class Product implements Searchable {
    private final String name;
    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название товара не может быть пустым");
        }
        this.name = name;
    }


    public abstract boolean isSpecial();

    {
    }
    public abstract int getPrice();
    {
    }
    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return name;
    }
}