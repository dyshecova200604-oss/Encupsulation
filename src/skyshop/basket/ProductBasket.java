package skyshop.basket;

import org.skypro.skyshop.product.DiscountProduct;
import skyshop.product.Product;
import java.util.ArrayList;
import java.util.List;

public  class ProductBasket {
    private List<Product> products;

    public ProductBasket() {
        this.products = new ArrayList<>();
    }
    public void addProduct(DiscountProduct product) {
        if (product != null) {
            products.add(product);
            System.out.println(product.getName() + " добавлен в корзину.");
        } else {
            System.out.println("Не удалось добавить продукт: продукт не может быть null.");
        }
    }

    public void clearBasket() {
        products.clear();
    }

    public boolean containsProduct(String productName) {
        return products.stream().anyMatch(product -> product.getName().equalsIgnoreCase(productName));
    }

    public void printBasketContents() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            System.out.println("Содержимое корзины:");
            for (Product product : products) {
                System.out.println(product.toString());
            }
        }
    }

        public double getTotalPrice () {
            return products.stream().mapToDouble(Product::getPrice).sum();
        }
    }
