import java.util.ArrayList;

public class Inventory implements InventoryInterface {
    private ArrayList<Product> products = new ArrayList<>();


    public ArrayList<Product> getProducts() {
        return products;
    }


    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void updateProductStock(Product product, int amount) {
        this.products.remove(product);
        product.setAmount(product.getAmount() + amount);
        if (product.getAmount() != 0) {

            this.products.add(product);
        }
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public Product fetchProduct(Product product) {
        for (Product iter_product : products) {
            if (iter_product.hashCode() == product.hashCode()
            ) {
                return iter_product;
            }
        }
        return null;
    }

    public boolean checkInventory(Product product) {
        for (Product iterProduct : products) {
            if (product.hashCode() == iterProduct.hashCode()) {
                return true;
            }
        }
        return false;
    }

}
