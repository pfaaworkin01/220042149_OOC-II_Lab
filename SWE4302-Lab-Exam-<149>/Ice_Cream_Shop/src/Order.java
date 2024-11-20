import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Order {
    private List<OrderItem> orderItems;
    private List<IceCreamTopping> toppings;
    private boolean isWaffleCone;
    private static final double TAX_RATE = 0.08;
    private static final double WAFFLE_CONE_PRICE = 5.00;

    public Order(boolean isWaffleCone) {
        this.orderItems = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.isWaffleCone = isWaffleCone;
    }

    public void addItem(IceCreamFlavor flavor, int scoops) {
        orderItems.add(new OrderItem(flavor, scoops));
    }

    public void addTopping(IceCreamTopping topping) {
        toppings.add(topping);
    }

    public double calculateSubtotal() {
        double subtotal = 0.0;
        for (OrderItem item : orderItems) {
            subtotal += item.getItemTotal();
        }
        for (IceCreamTopping topping : toppings) {
            subtotal += topping.getPrice();
        }
        if (isWaffleCone) {
            subtotal += WAFFLE_CONE_PRICE;
        }
        return subtotal;
    }

    public double calculateTax() {
        return calculateSubtotal() * TAX_RATE;
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }


}