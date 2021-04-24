import java.time.LocalDateTime;
import java.util.Objects;

public class Customer {
    private String name;
    private LocalDateTime last_seen;
    private double total_spent;
    private double money = 100.0;
    private Inventory inventory;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Customer(String name, Inventory inventory) {
        this.name = name;
        this.inventory = inventory;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return Double.compare(customer.total_spent, total_spent) == 0  && Objects.equals(name, customer.name) && Objects.equals(last_seen, customer.last_seen);
    }

    @Override
    public int hashCode() {
        return Objects.hash( name, last_seen, total_spent);
    }
}
