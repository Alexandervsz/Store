public class CombineItem {
    private Product product1;
    private Product product2;

    public CombineItem(Product product1) {
        this.product1 = product1;
    }

    public void addSecondItem(Product product) {
        this.product2 = product;
    }

    public Product addItems (){
        if (product1.getProductName().equals("H") & product2.getProductName().equals("O") & product1.getAmount() == 2 & product2.getAmount() == 1){
            return new Product("water", 200.0, "h2o", 0);
        }
        return null;
    }
}
