
class Product {
    private String productID;
    private String name;
    private double basePrice;
    private String category;
    private int stockLevel;

    public Product(String id, String name, double basePrice, String category, int stockLevel) {
        this.productID = id;
        this.name = name;
        this.basePrice = basePrice;
        this.category = category;
        this.stockLevel = stockLevel;
    }

    public String getId() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getCategory() {
        return category;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void updateStock(int stockQuantity) {
        this.stockLevel += stockQuantity;
    }

}