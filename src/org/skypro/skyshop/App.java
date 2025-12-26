package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.Articles.Article;
import org.skypro.skyshop.SearchЕngine.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws org.skypro.skyshop.search.BestResultNotFound {

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
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при добавлении товара:"+ e.getMessage());
        }

        ProductBasket.printedBasket();

        System.out.println(basket.equalsProduct("milk"));


        ProductBasket.printedBasket();


        SearchEngine searchEngine = new SearchEngine(15);


        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);

        Article article1 = new Article("Гайд по выбору бананов", "Как выбрать спелые бананы и хранить их правильно.");
        Article article2 = new Article("Рецепты с яблоками", "Пироги, салаты и смузи с яблоками.");
        Article article3 = new Article("Новый iPhone 15", "В обзоре сравним камеру и производительность iPhone 15.");
        Article article4 = new Article("Скидки на электронику", "Большая распродажа ноутбуков и телевизоров.");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);

        String query = "кофе";
        try {
            System.out.println(searchEngine.BestResult(query));
        } catch (org.skypro.skyshop.search.BestResultNotFound e) {
            System.out.println("Подходящего товара не найдено");
        }
    }
}

