import skyshop.search.Searchable;
public class DiscountProduct extends Product implements Searchable {

    public DiscountProduct(String name, double originalPrice, double discount) {
        super(name);
        if (originalPrice < 0 || discount < 0 || discount > originalPrice) {
            throw new IllegalArgumentException("Invalid price or discount");
        }
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getSearchTerm() {
        return "";
    }

    @Override
    public String getType() {
        return "";
    }
}