package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Article;
import org.skypro.skyshop.search.SearchEngine;

public class Main { // Изменено с App на Main
    public static void main(String[] args) throws org.skypro.skyshop.BestResultNotFound {

        ProductBasket basket = new ProductBasket();

        DiscountedProduct product1 = new DiscountedProduct("Банан", 500, 10);
        SimpleProduct product2 = new SimpleProduct("Яблоко", 100);
        FixPriceProduct product3 = new FixPriceProduct("Апельсин", 200);
        SimpleProduct product4 = new SimpleProduct("Ноутбук", 50000);
        DiscountedProduct product5 = new DiscountedProduct("Iphone 15", 90000, 20);

        try {
            basket.addProduct(product1);
            basket.addProduct(product2);
            basket.addProduct(product3);
            basket.addProduct(product4);
            basket.addProduct(product5);
            basket.addProduct(new SimpleProduct("Чай", 500));
            basket.addProduct(new DiscountedProduct("Чай", 300, 15));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Ошибка при добавлении товара");
        }

        System.out.println();
        basket.printBasket();
        System.out.println();

        System.out.println(basket.equalsProduct("чай"));
        System.out.println();


        SearchEngine searchEngine = new SearchEngine();

        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);


        Article article1 = new Article("Гайд по выбору бананов", "Как выбрать спелые бананы и хранить их правильно.");
        Article article2 = new Article("Рецепты с яблоками", "Пироги, салаты и смузи с яблоками.");
        Article article3 = new Article("Новый iPhone 15", "В обзоре сравним камеру и производительность iPhone 15.");
        Article article4 = new Article("Скидки на электронику", "Большая распродажа ноутбуков и телевизоров.");
        Article article5 = new Article("Кофе робуста", "Робуста");
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);
        searchEngine.add(article5);

        searchEngine.add(new Article("Чай зелёный", "Чай зелёный. Чай в пакетиках"));

        System.out.println();
        basket.removeProduct("Чaй");

        System.out.println();
        basket.printRemovedList();

        System.out.println();
        basket.printBasket();

        System.out.println();

        String query = "Чай";
        System.out.println("Результаты поиска для запроса  + query + :");

        System.out.println(searchEngine.search(query));

        try {
                System.out.println("Лучший результат для запроса  + query + :");
            System.out.println(searchEngine.bestResult(query));

        } catch (org.skypro.skyshop.BestResultNotFound e) {
            System.out.println("Подходящего товара нет");
        }
        System.out.println();

        query = "кофе";
        System.out.println("Результаты поиска для запроса  + query + :");
        System.out.println(searchEngine.search(query));
        try {
            System.out.println("Лучший результат для запроса  + query + :");

            System.out.println(searchEngine.bestResult(query));
        } catch (org.skypro.skyshop.BestResultNotFound e) {
            System.out.println("Подходящего товара не найдено");
        }
    }
}