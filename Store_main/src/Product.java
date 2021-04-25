import java.util.Objects;

public class Product {
    private String name;
    private double price;
    private int amount;
    private String code;

    public Product(String name, double price, String code, int amount) {
        this.name = name;
        this.price = price;
        this.code = code;
        this.amount = amount;
    }

    public String getProductName() {
        return name;
    }


    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProductCode() {
        return code;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return code.equals(product.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return name + ", nu voor €" + price + "! Nog " + amount + " op voorraad.";
    }


}
