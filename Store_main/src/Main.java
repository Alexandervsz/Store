import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.addProduct(new Product("H", 50.0, "H", 50));
        employee.addProduct(new Product("O", 50.0, "O", 100));
        employee.addProduct(new Product("C", 500.0, "C", 50));
        Customer customer = new Customer();
        Shop shop = new Shop(employee, customer);
        shop.printIntro();
    }


}



