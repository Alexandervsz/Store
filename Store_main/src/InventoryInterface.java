public interface InventoryInterface {
    void addProduct(Product product);
    void updateProductStock(Product product, int amount);
    void removeProduct(Product product);
    Product fetchProduct(Product product);
}
