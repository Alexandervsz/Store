import java.util.Objects;

public class Product {
    private String productname;
    private double price;
    private int amount;
    private String productcode;

    public String getProductName() {
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }


    public Product(String productname, double price, String productcode, int amount) {
        this.productname = productname;
        this.price = price;
        this.productcode = productcode;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productcode.equals(product.productcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productcode);
    }

    @Override
    public String toString() {
        return productname+", nu voor €"+price+"! Nog "+amount+" op voorraad.";
    }


}
