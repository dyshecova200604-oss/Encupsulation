
  import org.skypro.skyshop.product.DiscountProduct;
  import org.skypro.skyshop.product.FixPriceProduct;
  import org.skypro.skyshop.product.SimpleProduct;
  import skyshop.product.Product;
  import skyshop.basket.ProductBasket;

        public class Main {
            public static void main(String[] args) {
                ProductBasket basket = new ProductBasket();

                // Создаем несколько продуктов
                SimpleProduct product1 = new SimpleProduct("Яблоко", 100);
                DiscountProduct product2 = new DiscountProduct("Банан", 150, 20); // 20% скидка
                FixPriceProduct product3 = new FixPriceProduct("Апельсин", 200);

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