public class Product_Count extends Product{
    private int amount;

    public Product_Count(String productname, double price, String productcode, int stock, int amount) {
        super(productname, price, productcode, stock);
        this.amount = amount;
    }
}