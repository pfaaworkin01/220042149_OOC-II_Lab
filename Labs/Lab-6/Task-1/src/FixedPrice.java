public class FixedPrice implements Pricing {

    @Override
    public double calculatePrice(Product product) {
        return product.getBasePrice();
    }

}
