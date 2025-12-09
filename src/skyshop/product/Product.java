package skyshop.product;
import org.skypro.skyshop.product.DiscountProduct;
import skyshop.search.Searchable;
public abstract class Product implements Searchable {
    protected final String name;
    protected final int price;

    protected Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * Search term для товара — имя товара.
     */
    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getType() {
        return "PRODUCT";
    }

    @Override
    public String toString() {
        return name + " (цена: " + price + ")";
    }

    public static double getCost(DiscountProduct discountProduct) {

        return discountProduct.getPrice() * (1 - discountProduct.getDiscountRate()); // Пример
    }
}