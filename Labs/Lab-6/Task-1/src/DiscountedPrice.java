public class DiscountedPrice implements Pricing {
    private double discountRate;

    public DiscountedPrice(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public double calculatePrice(Product product) {
        return (product.getBasePrice() * (1 - discountRate));
    }

}
