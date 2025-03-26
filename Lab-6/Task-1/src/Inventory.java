import java.util.ArrayList;
import java.util.List;

class Inventory {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
    }

    public void removeProduct(String productId) {
    }

    public Product getProduct(String productId) {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        System.out.println("Invalid Product ID!!!");
        return null;
    }

    public double calculateTotalInventoryValue() {
        return 0;
    }

    public double calculateInventoryByCategory(String category) {
        return 0;
    }

    public void updateStock(String productId, int quantity) {
    }
}
