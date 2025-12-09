package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {

    private final String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название товара не может быть пустым");
        }
        this.name = name;
    }


    public boolean isSpecial() {
        return false;

    }

    public int getPrice() {
        return 0;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}