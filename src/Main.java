//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import skyshop.product.Product;
import skyshop.basket.ProductBasket;
public class Main {
    public static void main(String[] args) {
// Создаем экземпляр корзины
        ProductBasket basket = new ProductBasket();

        // Создаем несколько продуктов
        Product product1 = new Product("Яблоко", 100);
        Product product2 = new Product("Банан", 150);
        Product product3 = new Product("Апельсин", 200);

        // Добавляем продукты в корзину
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);

        // Печатаем содержимое корзины
        basket.printBasketContents();

        // Проверяем наличие продукта в корзине
        String productToCheck = "Банан";
        if (basket.containsProduct(productToCheck)) {
            System.out.println(productToCheck + " есть в корзине.");
        } else {
            System.out.println(productToCheck + " нет в корзине.");
        }

        // Очищаем корзину
        basket.clearBasket();

        // Печатаем содержимое корзины после очистки
        basket.printBasketContents();
    }
}