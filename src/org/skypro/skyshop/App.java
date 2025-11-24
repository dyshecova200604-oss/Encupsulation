package org.skypro.skyshop;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import skyshop.basket.ProductBasket;
public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

// Создаем несколько продуктов
        SimpleProduct apple = new SimpleProduct("Яблоко", 100);
        DiscountProduct banana = new DiscountProduct("Банан", 150, 20); // 20% скидка
        FixPriceProduct orange = new FixPriceProduct("Апельсин", 200);
        SimpleProduct laptop = new SimpleProduct("Ноутбук", 50000);
        SimpleProduct phone = new SimpleProduct("iPhone 15", 90000);
        // Добавляем продукты в корзину
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(orange);
        basket.addProduct(laptop);
        basket.addProduct(phone);

        // Печатаем содержимое корзины с несколькими товарами
        basket.printBasketContents();

        // Получаем стоимость корзины с несколькими товарами
        System.out.println("Общая стоимость корзины: " + basket.getTotalPrice());
        // Поиск товара, который есть в корзине
        System.out.println("Корзина содержит 'Яблоко': " + basket.containsProduct("Яблоко"));

        // Поиск товара, которого нет в корзине
        System.out.println("Корзина содержит 'Груша': " + basket.containsProduct("Груша"));

        // Очистка корзины
        basket.clearBasket();

        // Печатаем содержимое пустой корзины
        basket.printBasketContents(); // Получаем стоимость пустой корзины


        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalPrice());

        // Поиск товара по имени в пустой корзине
        System.out.println("Корзина содержит 'Яблоко': " + basket.containsProduct("Яблоко"));

    }
}