public class OrderItem {

    private YogurtFlavor flavor;
    private int scoops;

    public OrderItem(YogurtFlavor flavor, int scoops) {
        this.flavor = flavor;
        this.scoops = scoops;
    }

    public double getItemTotal() {
        return scoops * flavor.getPricePerScoop();
    }

    public String getDescription() {
        return flavor.getName() + " - " + scoops + " scoop(s): $" + String.format("%.2f", getItemTotal());
    }

}
