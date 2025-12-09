package skyshop.basket;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import skyshop.product.Product;
import java.util.ArrayList;
import java.util.List;
public  class ProductBasket {
    private final List<DiscountProduct> products;

    public ProductBasket() {
        this.products = new ArrayList<>();
    }

    public void clearBasket() {
        products.clear();
    }
    public boolean containsProduct(String productName) {
        return products.stream().anyMatch(product -> Boolean.parseBoolean(product.getName()));
    }

    public void printBasketContents() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            System.out.println("Содержимое корзины:");
            for (DiscountProduct product : products) {
                System.out.println(product.toString());
            }
        }
    }

    public double getTotalPrice () {
        return products.stream().mapToDouble(Product::getCost).sum();
    }

    public void addProduct(SimpleProduct apple) {
    }

    public void addProduct(FixPriceProduct orange) {
    }

    public void addProduct(DiscountProduct banana) {
    }
}