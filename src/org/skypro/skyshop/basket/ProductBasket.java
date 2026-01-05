package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
   Product[] products = new Product[5];
    private int count;

    public boolean canAddMoreProducts () {
        return count < products.length;
    }

    public int sumBasket() {
        int sum = 0;
        for (Product product : products) {
            if (product != null) {
                sum = product.getPrice();
            }
        }
        return sum;
    }

    public void printedBasket() {
        int counter = 0;
        if (0 == sumBasket()) {
            System.out.println("Корзина пуста");
            return;
        }
        System.out.println("Содержимое корзины:");
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
            }
            if (product != null && product.isSpecial()) {
                counter++;
            }
        }
        System.out.println("Итого: " + sumBasket());
        System.out.println("Специальных товаров: " + counter);
    }

    public void clearBasket() {
        products = new Product[5];
        count = 0;
        System.out.println("Корзина очищена");
    }

    public boolean equalsProduct(String name) {
        for (Product product : products) {
            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void addProduct(Product product) {
        if (canAddMoreProducts ()) {
            products[count++] = product;
            System.out.println("Добавлен продукт: " +
                    product.getName());
        } else {
            System.out.println("Невозможно добавить продукт " +
                    product.getName() + ". Корзина переполнена");
        }
    }
}

