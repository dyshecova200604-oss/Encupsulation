
public class DiscountProduct extends Product {

    private  double originalPrice;
    private  int discount; // Процент скидки 0..100

    public DiscountProduct(String name, double originalPrice, int discount) {
        super(name);
        if (originalPrice < 0 || discount < 0 || discount > originalPrice) {
            throw new IllegalArgumentException("Invalid price or discount");
        }
        this.originalPrice = originalPrice;
        this.discount = discount;
    }

    /**
     * Цена товара со скидкой.
     */
    @Override
    public double getPrice() {
        return originalPrice * (1 - getDiscountRate()); // Возвращаем цену со скидкой // Возвращаем цену со скидкой
    }

    public boolean isSpecial() {
        return discount > 0;
    }


    @Override
    public String toString() {
        return super.toString() + " (Discounted Price: " + getPrice() + ")";
    }



    public double getDiscountRate() {
        return discount / 100.0;
    }



    public String getType() {
        return "DiscountProduct";
    }
}
