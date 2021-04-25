public class CombineItem {
    private Product product1;
    private Product product2;
    private int amount1;
    private int amount2;

    public CombineItem(Product product1, Product product2, int amount1, int amount2) {

        this.product1 = product1;
        this.product2 = product2;
        this.amount1 = amount1;
        this.amount2 = amount2;

    }

    public Product addItems() {
        String combined = product1.getProductName() + amount1 + product2.getProductName() + amount2;
        return switch (combined) {
            case "H2O1", "O1H2" -> new Product("Water", 200.0, "h2o", 1);
            case "C1O2", "O2C1" -> new Product("Koolzuur", 1000.0, "co2", 1);
            default -> null;
        };
    }
}
