public class YogurtFlavor {

    private String name;
    private double pricePerScoop;

    public YogurtFlavor(String name, double price) {
        this.name = name;
        this.pricePerScoop = price;
    }

    public String getName() {
        return name;
    }

    public double getPricePerScoop() {
        return pricePerScoop;
    }

}
