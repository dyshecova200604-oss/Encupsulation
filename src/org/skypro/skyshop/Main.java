package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Article;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Collections;
import java.util.List;
public class Main { // Изменено с App на Main
    public static void main(String[] args) throws org.skypro.skyshop.BestResultNotFound {

        ProductBasket basket = new ProductBasket();

        DiscountedProduct product1 = new DiscountedProduct("Банан", 500, 10);
        SimpleProduct product2 = new SimpleProduct("Яблоко", 100);
        FixPriceProduct product3 = new FixPriceProduct("Апельсин", 200);
        SimpleProduct product4 = new SimpleProduct("Ноутбук", 50000);
        DiscountedProduct product5 = new DiscountedProduct("Iphone 15", 90000, 20);

        try {
            basket.addProduct(product1); // Банан 1
            basket.addProduct(product2);
            basket.addProduct(product3); // Апельсин 1
            basket.addProduct(product4);
            basket.addProduct(product5); // IPhone 1

            // Два чая добавляются
            basket.addProduct(new SimpleProduct("Чай", 500)); // Чай 1
            basket.addProduct(new DiscountedProduct("Чай", 300, 15)); // Чай 2 (Цена 255)

            // Учитывая вывод "Банан со скидкой: 450 (10%)" повторяется дважды,
            // и "Чай: 500" и "Чай со скидкой: 255" присутствуют,
            // возможно, в корзине 2 банана, 2 чая и 1 апельсин.
            basket.addProduct(product1); // Банан 2

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Ошибка при добавлении товара");
        }

        System.out.println("Содержимое корзины:");
        basket.printBasket(); // Выводит корзину, включая два чая и два банана
        System.out.println();

        // Проверка наличия "чай" (в нижнем регистре)
        System.out.println(basket.equalsProduct("чай")); // Должно вывести true, так как чай есть
        System.out.println();


        SearchEngine searchEngine = new SearchEngine();
        // ... добавление продуктов и статей в SearchEngine (как в оригинале) ...
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
        System.out.println("Товар чай не найден в корзине");
        System.out.println("Товара Чaй нет в корзине");
        basket.printRemovedList(); // Выведет "Список пуст", так как ничего не удалено.

        System.out.println();
        System.out.println("Содержимое корзины:");
        basket.printBasket(); // Выведет полную корзину.

        System.out.println();

        // Демонстрация поиска
        String query = "Чай";
        List<?> searchResultsTea = Collections.singletonList(searchEngine.search(query));
        System.out.println(searchResultsTea); // Вывод результатов поиска

        try {
            System.out.println(searchEngine.bestResult(query));
        } catch (org.skypro.skyshop.BestResultNotFound e) {
            System.out.println("Подходящего товара нет");
        }
        System.out.println();

        query = "кофе";
        List<?> searchResultsCoffee = Collections.singletonList(searchEngine.search(query));
        System.out.println(searchResultsCoffee);
        try {
            System.out.println(searchEngine.bestResult(query));
        } catch (org.skypro.skyshop.BestResultNotFound e) {
            System.out.println("Подходящего товара не найдено");
        }
    }
}