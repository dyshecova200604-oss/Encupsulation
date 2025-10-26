package skyshop;
import skyshop.product.Product;
import skyshop.basket.ProductBasket;
public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        // Создаем несколько продуктов
        Product apple = new Product("Яблоко", 100);
        Product banana = new Product("Банан", 150);
        Product orange = new Product("Апельсин", 200);

        // Добавляем продукты в корзину
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(orange);

        // Печатаем содержимое корзины с несколькими товарами
        basket.printBasketContents();

        // Пытаемся добавить продукт в заполненную корзину
        Product melon = new Product("Дыня", 250);
        basket.addProduct(melon); // Это должно вывести сообщение о невозможности добавить продукт

        // Получаем стоимость корзины с несколькими товарами
        System.out.println("Общая стоимость корзины: " + basket.getTotalPrice());

        // Поиск товара, который есть в корзине
        System.out.println("Корзина содержит 'Яблоко': " + basket.containsProduct("Яблоко"));

        // Поиск товара, которого нет в корзине
        System.out.println("Корзина содержит 'Груша': " + basket.containsProduct("Груша"));

        // Очистка корзины
        basket.clearBasket();

        // Печатаем содержимое пустой корзины
        basket.printBasketContents();

        // Получаем стоимость пустой корзины
        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalPrice());

        // Поиск товара по имени в пустой корзине
        System.out.println("Корзина содержит 'Яблоко': " + basket.containsProduct("Яблоко"));
    }
}
