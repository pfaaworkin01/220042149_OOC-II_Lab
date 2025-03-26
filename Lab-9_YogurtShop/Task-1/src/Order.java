import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Order {
    private List<OrderItem> orderItems;
    private List<YogurtTopping> toppings = new ArrayList<>();
    private boolean glassJar;
    private static final double TAX_RATE = 0.08;
    private static final double GLASS_JAR_COST = 5.00;

    public Order(boolean glassJar) {
        this.orderItems = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.glassJar = glassJar;
    }

    public void addItem(YogurtFlavor flavor, int scoops) {
        orderItems.add(new OrderItem(flavor, scoops));
    }

    public void addTopping(YogurtTopping topping) {
        toppings.add(topping);
    }

    public double calculateSubtotal() {
        double subtotal = 0.0;
        for (OrderItem item : orderItems) {
            subtotal += item.getItemTotal();
        }
        for (YogurtTopping topping : toppings) {
            subtotal += topping.getPrice();
        }
        if (glassJar) {
            subtotal += GLASS_JAR_COST;
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
        StringBuilder invoice = new StringBuilder("\nYogurt Shop Invoice\n");
        for (OrderItem item : orderItems) {
            invoice.append(item.getDescription()).append("\n");
        }
        for (YogurtTopping topping : toppings) {
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
