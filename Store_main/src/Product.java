public class Product {
    private String productname;
    private double price;
    private int stock;
    private String productcode;

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }


    public Product(String productname, double price, String productcode) {
        this.productname = productname;
        this.price = price;
        this.productcode = productcode;
    }

    public void restock(int amount){
        setStock(getStock()+amount);
    }
}
