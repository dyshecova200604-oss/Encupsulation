package org.skypro.skyshop;

import java.util.*;

import org.skypro.skyshop.Articles.Article;
import org.skypro.skyshop.SearchЕngine.SearchEngine;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public App() {
    }

    public static void main(String[] args) throws BestResultNotFound {
        SimpleProduct product1 = new SimpleProduct("Ноутбук",  50000);
        SimpleProduct product2 = new SimpleProduct("Яблоко",  100);
        DiscountedProduct product3 = new DiscountedProduct("Банан", 500, 10);
        DiscountedProduct product4 = new DiscountedProduct("Iphone 15", 90000, 20);
        FixPriceProduct product5 = new FixPriceProduct("Апельсин");


        ProductBasket basket = new ProductBasket();

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);


        System.out.println("\n===Список товаров===\n");

        basket.printBasket();

        System.out.println("\n===Список товаров===\n");

        var removedProducts = basket.removeProduct("Банан");
        basket.printBasket();
        System.out.println("Удаленные товары: " + removedProducts);

        System.out.println("\n===Список товаров===\n");

        var removedProductsTry = basket.removeProduct("Апельсин");
        if (removedProductsTry.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            basket.printBasket();
        }
        System.out.println("Удаленные товары: " + String.valueOf(removedProductsTry));
        System.out.println();
        System.out.println(basket.isHasProduct("Апельсин"));
        System.out.println(basket.isHasProduct("Десерт"));

        basket.deleteBasket();

        basket.printBasket();

        System.out.println(basket.isHasProduct("Банан"));

        System.out.println("\n===Поисковая система===\n");

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);


        Article article1 = new Article("Гайд по выбору бананов", "Как выбрать спелые бананы и хранить их правильно");
        Article article2 = new Article("Рецепты с яблоками", "Пироги, салаты и смузи с яблоками.");
        Article article3 = new Article("Новый iPhone 15", "В обзоре сравним камеру и производительность iPhone 15.");
        Article article4 = new Article("Скидки на электронику", "Большая распродажа ноутбуков и телевизоров.");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);

        Searchable[] searchResults = searchEngine.search("PRODUCT").toArray(new Searchable[0]);
        for (Searchable results : searchResults) {
            if (results == null) continue;
            System.out.println(results);
        }
        System.out.println();

        searchResults = searchEngine.search("ARTICLE").toArray(new Searchable[0]);
        for (Searchable results : searchResults) {
            if (results == null) continue;
            System.out.println(results);
        }
        System.out.println();

        searchResults = searchEngine.search("Апельсин").toArray(new Searchable[0]);
        for (Searchable results : searchResults) {
            if (results == null) continue;
            System.out.println(results);
        }

        System.out.println("\n=== Система поиска и создания исключений ===\n");

        try {
            new DiscountedProduct("Iphone 15", 90000, 20);
            System.out.println("Исключение не выброшено");
        } catch (IllegalArgumentException e) {
            System.out.println("\"Ошибка - цена меньше одного\"");
        }
        try {
            new DiscountedProduct("",  400, 10);
            System.out.println("Исключение не выброшено");
        } catch (IllegalArgumentException e) {
            System.out.println("\"Ошибка - не введен продукт\"");
        }
        try {
            new DiscountedProduct("Iphone 15",  90000, 20);
            System.out.println("Исключение не выброшено");
        } catch (IllegalArgumentException e) {
            System.out.println("\"Ошибка - скидка меньше ноля или больше ста процентов\"");
        }
        System.out.println(searchEngine.getSearchBestMatch("Го"));
        System.out.println(searchEngine.getSearchBestMatch("2"));
    }
}