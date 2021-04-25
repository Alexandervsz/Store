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
        String combined = product1.getProductName() + product1.getAmount() + product2.getProductName() + product2.getAmount();
        if (combined.equals("H2O1") || combined.equals("O1H2")) {
            return new Product("water", 200.0, "h2o", 1);
        }
        return null;
    }
}
