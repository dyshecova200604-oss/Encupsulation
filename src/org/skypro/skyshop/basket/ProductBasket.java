
package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    static Map<String, List<Product>> products = new HashMap<>();
    private static List<Product> delProducts = new LinkedList<>();
    static int count;

    public static int sumBasket() {
        int sum = products.values()
                .stream()
                .flatMap( Collection::stream )
                .mapToInt(Product::getPrice)
                .sum();
        return sum;
    }

    public static void printBasket(){
        int counter = 0;
        if (sumBasket() == 0) {
            System.out.println("Корзина пуста");
            return;
        }
        System.out.println("Содержимое корзины:");
        products.values().stream().forEach( System.out::println );
        System.out.println("Итого: " + sumBasket());
        System.out.println("Специальных товаров: " + getSpecialCount());
    }

    public static void printedBasket() {
    }

    private static int getSpecialCount(){
        int counter = products.values()
                .stream()
                .flatMap( Collection::stream )
                .filter( Product::isSpecial )
                .collect( Collectors.toList())
                .size();
        return counter;
    }

    public void clearBasket() {
        products.clear();
        count = 0;
        System.out.println("Корзина очищена");
    }

    public boolean equalsProduct(String name) {
        boolean isPresent = products.containsKey( name );
        if (isPresent) {
            System.out.println("Товар " + name + " есть в корзине");
        } else {
            System.out.println("Товар " + name + " не найден в корзине");
        }
        return isPresent;
    }

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
        System.out.println("Добавлен продукт: " + product.getName());
    }

    public List<Product> removeProduct( String name) {
        delProducts.clear();
        if (products.containsKey(name)) {
            List<Product> list = products.get(name);
            for (Product product : list) {
                delProducts.add(product);
                System.out.println("Удален продукт: " + product);
            }
            products.remove(name);
        } else {
            System.out.println("Товара " + name + " нет в корзине");
        }
        return delProducts;
    }

    public void printRemovedList(){
        if (delProducts.isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        System.out.println("Удаленные товары:");
        delProducts.forEach(System.out::println);
    }
}