package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
public class ProductBasket {
    private Product[] products; // Массив для хранения продуктов
    private int productCount;   // Счетчик добавленных продуктов

    // Конструктор, инициализирующий массив
    public ProductBasket() {
        this.products = new Product[10]; // Начальный размер массива
        this.productCount = 0;
    }

    // Метод добавления продукта в корзину
    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount] = product;
            productCount++;
        } else {
            System.out.println("Корзина полна, не удалось добавить продукт: " + product.getName());
        }
    }

    // Метод получения общей стоимости корзины
    public int getTotalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < productCount; i++) {
            totalPrice += products[i].getPrice();
        }
        return totalPrice;
    }

    // Метод, который печатает содержимое корзины
    public void printBasketContents() {
        if (productCount == 0) {
            System.out.println("В корзине пусто.");
        } else {
            for (int i = 0; i < productCount; i++) {
                System.out.println(products[i].getName() + ": " + products[i].getPrice());
            }
            System.out.println("Итого: " + getTotalPrice());
        }
    }

    // Метод проверки наличия продукта в корзине по имени
    public boolean containsProduct(String name) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    // Метод очистки корзины
    public void clearBasket() {
        products = new Product[10]; // Сбрасываем массив
        productCount = 0;           // Обнуляем счетчик
        System.out.println("Корзина очищена.");
    }
}
