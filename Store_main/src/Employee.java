import java.time.LocalDateTime;
import java.util.Objects;

public class Employee extends Inventory {
    private int Employee_number;
    private String name;



    public Employee(int employee_number, String name) {
        Employee_number = employee_number;
        this.name = name;
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
        for (Product product : getProducts()) {
            string.append(product.getProductName());
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
