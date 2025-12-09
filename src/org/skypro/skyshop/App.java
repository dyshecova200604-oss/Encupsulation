package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Article;
import org.skypro.skyshop.search.SearchEngine;

public class App {
    public static void main(String[] args) throws org.skypro.skyshop.BestResultNotFound {

        ProductBasket basket = new ProductBasket();

        DiscountedProduct product1 = new DiscountedProduct("Банан", 500, 10);
        SimpleProduct product2 = new SimpleProduct("Яблоко", 100);
        FixPriceProduct product3 = new FixPriceProduct("Апельсин", 200);
        SimpleProduct product4 = new SimpleProduct("Ноутбук", 50000);
        DiscountedProduct product5 = new DiscountedProduct("Iphone 15", 90000, 20);

        try {
            basket.addProduct(product1);
            basket.addProduct(product1);
            System.out.println("Добавлен продукт: " + product1.getName());

            basket.addProduct(product2);
            System.out.println("Добавлен продукт: " + product2.getName());

            basket.addProduct(product3);
            System.out.println("Добавлен продукт: " + product3.getName());

            basket.addProduct(product4);
            System.out.println("Добавлен продукт: " + product4.getName());

            basket.addProduct(product5);
            System.out.println("Добавлен продукт: " + product5.getName());

            basket.addProduct(new SimpleProduct("Чай", 500));
            System.out.println("Добавлен продукт: Чай");

            basket.addProduct(new DiscountedProduct("Чай", 300, 15));
            System.out.println("Добавлен продукт: Чай");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Ошибка при добавлении товара");
        }

        // Вывод содержимого корзины
        System.out.println("\nСодержимое корзины:");
        basket.printBasket();

        // Проверка наличия товара в корзине
        System.out.println("\nТовар чай " + (basket.equalsProduct("чай") ? "найден" : "не найден") + " в корзине");

        SearchEngine searchEngine = new SearchEngine();

        // Добавление статей в поисковую систему
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

        // Удаление товара из корзины
        System.out.println();
        basket.removeProduct("Чaй");

        // Вывод удаленных товаров
        System.out.println("\nУдаленные товары:");
        basket.printRemovedList();

        // Содержимое корзины после удаления
        System.out.println("\nСодержимое корзины:");
        basket.printBasket();

        // Поиск по запросу
        String query = "кофе";
        System.out.println("\nРезультаты поиска по запросу '" + query + "':");
        System.out.println(searchEngine.search(query));

        // Поиск лучшего результата
        try {
            System.out.println(searchEngine.bestResult(query));
        } catch (org.skypro.skyshop.BestResultNotFound e) {
            System.out.println("Подходящего товара нет");
        }
    }
}