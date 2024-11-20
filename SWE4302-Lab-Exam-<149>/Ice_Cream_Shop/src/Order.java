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

    public String generateInvoice() {
        StringBuilder invoice = new StringBuilder("Ice Cream Shop Invoice\n");
        for (OrderItem item : orderItems) {
            invoice.append(item.getDescription()).append("\n");
        }
        for (IceCreamTopping topping : toppings) {
            invoice.append(topping.getName()).append(" - 1 time: $")
                    .append(String.format("%.2f", topping.getPrice())).append("\n");
        }
        invoice.append("Subtotal: $").append(String.format("%.2f", calculateSubtotal())).append("\n")
                .append("Tax: $").append(String.format("%.2f", calculateTax())).append("\n")
                .append("Total Amount Due: $").append(String.format("%.2f", calculateTotal()));

        return invoice.toString();
    }

    public void saveInvoiceToFile(String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(generateInvoice());
        }
    }

}