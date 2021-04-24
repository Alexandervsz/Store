import java.time.LocalDateTime;
import java.util.Objects;

public class Employee implements Employee_Interface {
    private int Employee_number;
    private String name;
    private boolean is_working;
    private int hours_worked = 0;
    private LocalDateTime shift_start;
    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Employee(int employee_number, String name, Inventory inventory) {
        Employee_number = employee_number;
        this.name = name;
        this.inventory = inventory;
    }

    public int getEmployee_number() {
        return Employee_number;
    }

    public void setEmployee_number(int employee_number) {
        Employee_number = employee_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean isIs_working() {
        return is_working;
    }

    public void setIs_working(boolean is_working) {
        this.is_working = is_working;
    }

    public int getHours_worked() {
        return hours_worked;
    }

    public void setHours_worked(int hours_worked) {
        this.hours_worked = hours_worked;
    }

    public LocalDateTime getShift_start() {
        return shift_start;
    }

    public void setShift_start(LocalDateTime shift_start) {
        this.shift_start = shift_start;
    }

    public  void addItemToInventory(Product product){
        inventory.addProduct(product);
    }

    @Override
    public void check_in() {
        if (!is_working) {
            shift_start = LocalDateTime.now();
            is_working = true;
        }


    }

    @Override
    public void check_out() {
        if (is_working) {
            //hours_worked += LocalDateTime.now() - shift_start;
            is_working = false;
        }

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Employee_number == employee.Employee_number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Employee_number);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Hallo, wat wil je kopen?\nIk heb in de aanbieding:\n");
        for (Product product: inventory.getProducts()){
            string.append( product.getProductName());
            string.append(", waarvan ik er nog ");
            string.append(product.getAmount());
            string.append(" van over heb.\n");
            string.append("Ze kosten ieder ");
            string.append(product.getPrice());
            string.append("\n");
        }
        return string.toString();
    }
}
