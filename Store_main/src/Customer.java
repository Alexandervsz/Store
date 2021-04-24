import java.time.LocalDateTime;
import java.util.Objects;

public class Customer {
    private String card_number;
    private String name;
    private String address;
    private LocalDateTime last_seen;
    private double total_spent;

    public Customer(String card_number, String name, String address) {
        this.card_number = card_number;
        this.name = name;
        this.address = address;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getLast_seen() {
        return last_seen;
    }

    public void setLast_seen(LocalDateTime last_seen) {
        this.last_seen = last_seen;
    }

    public double getTotal_spent() {
        return total_spent;
    }

    public void setTotal_spent(double total_spent) {
        this.total_spent = total_spent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Double.compare(customer.total_spent, total_spent) == 0 && card_number.equals(customer.card_number) && Objects.equals(name, customer.name) && Objects.equals(address, customer.address) && Objects.equals(last_seen, customer.last_seen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(card_number, name, address, last_seen, total_spent);
    }
}
