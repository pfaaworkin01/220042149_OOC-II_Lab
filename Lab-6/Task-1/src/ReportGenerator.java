class ReportGenerator {
    private Inventory inventory;

    public ReportGenerator(Inventory inventory) {
        this.inventory = inventory;
    }

    public void generateInventoryReport() {
        System.out.println("Total Inventory Value: " + inventory.calculateTotalInventoryValue());
    }

    public void generateCategoryReport(String category) {
        System.out.println("Total Value for Category " + category + ": " + inventory.calculateInventoryByCategory(category));
    }

    public void generateSalesReport(OrderProcessing orderProcessing) {
        System.out.println("Order Status for Order ID " + orderProcessing.getOrderId() + ":" + orderProcessing.getStatus());
    }

}
