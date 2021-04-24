import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Inventory employeeInventory = new Inventory();
        Employee employee = new Employee(1, "Bob", employeeInventory);
        Customer customer;
        employeeInventory.addProduct(new Product("H", 50.0, "H", 50));
        employeeInventory.addProduct(new Product("O", 50.0, "H", 50));
        System.out.println("Welkom, wat is je naam?");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        customer = new Customer(username, new Inventory());
        PrintIntro(employee, customer);


    }


    public static void PrintIntro(Employee employee, Customer customer) {
        System.out.println("Wat wil je doen?");
        System.out.println("Dingen kopen (1):");
        System.out.println("Dingen combineren (2):");
        Scanner scanner2 = new Scanner(System.in);
        int userChoice = scanner2.nextInt();
        switch (userChoice) {
            case 1 -> OpenShop(employee, customer);
            case 2 -> CombineItems();
            default -> PrintIntro(employee, customer);
        }


    }


    public static void OpenShop(Employee employee, Customer customer) {
        System.out.println(employee.toString());
        boolean found = false;
        Product soldProduct = null;
        while (!found) {
            Scanner scanner = new Scanner(System.in);
            String userChoice = scanner.nextLine();
            ArrayList<Product> products = employee.getInventory().getProducts();
            ArrayList<String> productnames = new ArrayList<>();

            for (Product product : products) {
                if (userChoice.equals(product.getProductName())) {
                    found = true;
                    soldProduct = product;
                    break;
                }
            }
        }
        System.out.println("Hoeveel wil je er kopen?");
        boolean sold = false;
        while (!sold) {
            Scanner scanner = new Scanner(System.in);
            int userChoice = scanner.nextInt();
            double money = customer.getMoney();
            double totalprice = soldProduct.getAmount() * soldProduct.getPrice();
            if (soldProduct.getAmount() >= userChoice & money > totalprice) {
                employee.getInventory().updateProductStock(soldProduct, userChoice);
                customer.getInventory().addProduct(soldProduct);
                customer.setMoney(money - totalprice);
                System.out.println("Bedankt!");
                sold = true;

            } else {
                System.out.println("Helaas, de verkoop wordt gestaakt.");
            }

        }
        PrintIntro(employee, customer);


    }

    public static void CombineItems() {

    }
}
