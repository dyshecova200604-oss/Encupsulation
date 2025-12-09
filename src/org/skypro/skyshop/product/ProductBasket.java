package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    static Map<String, List<Product>> products = new HashMap<>();
    private static final List<Product> delProducts = new LinkedList<>();
    static int count;

    public static int sumBasket() {
        int sum = 0;
        for (Map.Entry<String, List<Product>> entry: products.entrySet()) {
            List<Product> list = entry.getValue();
            for (Product product: list) {
                if (product != null) {
                    sum += product.getPrice();
                }
            }
        }
        return sum;
    }

    public void printBasket(){
        int counter = 0;
        if (sumBasket() == 0) {
            System.out.println("Корзина пуста");
            return;
        }
        System.out.println("Содержимое корзины:");
        for (Map.Entry<String, List<Product>> entry: products.entrySet()) {
            String name = entry.getKey();
            List<Product> list = entry.getValue();
            for (Product product: list) {
                if (product != null) {
                    System.out.println(product);
                }
                if (name != null && product.isSpecial()) {
                    counter++;
                }
            }
        }
        System.out.println("Итого: " + sumBasket());
        System.out.println("Специальных товаров: " + counter);
    }

    public void clearBasket() {
        products.clear();
        count = 0;
        System.out.println("Корзина очищена");
    }

    public boolean equalsProduct(String name) {
        for (Map.Entry<String, List<Product>> entry: products.entrySet()){
            String key = entry.getKey();
            if (key.equals(name)) {
                System.out.println("Товар " + name + " есть в корзине");
                return true;
            }
        }
        System.out.println("Товар " + name + " не найден в корзине");
        return false;
    }

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
        System.out.println("Добавлен продукт: " +
                product.getName());
    }


    public LinkedList<Product> removeProduct(String name) {
        delProducts.clear();
        if (products.containsKey(name)) {
            for (Map.Entry<String, List<Product>> entry: products.entrySet()){
                String key = entry.getKey();
                if (key.equals(name)) {
                    List<Product> list = entry.getValue();
                    for (Product product : list) {
                        delProducts.add(product);
                        System.out.println("Удален продукт: " + product);
                    }
                }
            }
            products.remove(name);
        } else {
            System.out.println("Товара " + name + " нет в корзине");
        }
        return (LinkedList<Product>) delProducts;
    }

    public void printRemovedList(){
        System.out.println("Удаленные товары:");
        for (Product product : delProducts){
            System.out.println(product);
        }
        if (delProducts.isEmpty()) {
            System.out.println("Список пуст");
        }
    }

    @Override
    public String toString() {
        return "ProductBasket{}";
    }
}