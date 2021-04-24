public class Product_Count extends Product{
    private final int amount;

    public Product_Count(String productname, double price, String productcode, int stock, int amount) {
        super(productname, price, productcode, stock);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
