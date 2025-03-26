import java.util.ArrayList;
import java.util.List;

class OrderProcessing {
    private String orderId;
    private List<Product> products = new ArrayList<>();
    private String status;
    private double totalPrice;

    public String getOrderId() {
        return orderId;
    }

    public OrderProcessing(String orderId) {
        this.orderId = orderId;
        this.status = "Pending";
    }

    public void createOrder(Product product, int quantity) {
    }

    public void processOrder(Pricing pricing) {
        this.status = "Shipped";
    }

    public double getTotalPrice() {
        this.status = "Delivered";
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }
}

