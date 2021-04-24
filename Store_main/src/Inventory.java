import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> products = new ArrayList<>();


    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void updateProductStock(Product product, int amount){
        this.products.remove(product);
        product.setAmount(product.getAmount() -amount);
        this.products.add(product);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
    }
}
