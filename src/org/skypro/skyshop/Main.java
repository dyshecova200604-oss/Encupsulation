package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Article;
import org.skypro.skyshop.search.SearchEngine;
public class Main {
    public static void main(String[] args) {
        // Создание корзины для товаров
        ProductBasket basket = new ProductBasket();
        // Создание продуктов
        DiscountedProduct product1 = new DiscountedProduct("Банан", 500, 10);
        SimpleProduct product2 = new SimpleProduct("Яблоко", 100);
        FixPriceProduct product3 = new FixPriceProduct("Апельсин", 200);
        SimpleProduct product4 = new SimpleProduct("Ноутбук", 50000);
        DiscountedProduct product5 = new DiscountedProduct("Iphone 15", 90000, 20);
        // Добавление продуктов в корзину
        try {
            basket.addProduct(product1);
            basket.addProduct(product2);
            basket.addProduct(product3);
            basket.addProduct(product4);
            basket.addProduct(product5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при добавлении товара: " + e.getMessage());
        }
        // Печать содержимого корзины
        ProductBasket.printedBasket();
        // Проверка наличия товара в корзине
        System.out.println("Наличие товара 'milk': " + basket.equalsProduct("milk"));
        // Создание поискового движка
        SearchEngine searchEngine = new SearchEngine();
        // Добавление продуктов в поисковый движок
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        // Создание статей
        Article article1 = new Article("Гайд по выбору бананов", "Как выбрать спелые бананы и хранить их правильно.");
        Article article2 = new Article("Рецепты с яблоками", "Пироги, салаты и смузи с яблоками.");
        Article article3 = new Article("Новый iPhone 15", "В обзоре сравним камеру и производительность iPhone 15.");
        Article article4 = new Article("Скидки на электронику", "Большая распродажа ноутбуков и телевизоров.");
        // Добавление статей в поисковый движок
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);
        // Поиск по запросу
        String query = "кофе";
        try {
            System.out.println("Лучший результат для запроса '" + query + "': " + searchEngine.bestResult(query));
        } catch (org.skypro.skyshop.BestResultNotFound e) {
            System.out.println("Подходящего товара не найдено: " + e.getMessage());
        }
    }
}