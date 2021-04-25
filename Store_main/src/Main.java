import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Employee employee = new Employee(1, "Bob");
        Customer customer;
        employee.addProduct(new Product("H", 50.0, "H", 50));
        employee.addProduct(new Product("O", 50.0, "H", 50));
        System.out.println("Welkom, wat is je naam?");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        customer = new Customer(username);
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
        System.out.println("Je hebt zelf nog "+customer.getMoney()+ " over.");
        boolean found = false;
        Product soldProduct = null;
        while (!found) {
            Scanner scanner = new Scanner(System.in);
            String userChoice = scanner.nextLine();
            ArrayList<Product> products = employee.getProducts();
            ArrayList<String> productnames = new ArrayList<>();

            for (Product product : products) {
                if (userChoice.equals(product.getProductName())) {
                    found = true;
                    soldProduct = product;
                    System.out.println(soldProduct.getAmount());
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
            double totalprice = userChoice * soldProduct.getPrice();
            if (employee.fetchProduct(soldProduct).getAmount() >= userChoice & money >= totalprice) {
                employee.updateProductStock(soldProduct, userChoice);
                Product fetchedProduct = employee.fetchProduct(soldProduct);
                if (fetchedProduct.getAmount() == 0){
                    employee.removeProduct(fetchedProduct);
                }
                customer.addProduct(soldProduct);
                customer.setMoney(money - totalprice);
                System.out.println("Bedankt!");
                sold = true;

            }
            else {
                if(money < totalprice){
                    System.out.println(money);
                    System.out.println(totalprice);
                    System.out.println("Je hebt te weinig geld.");

                }
                else if(employee.fetchProduct(soldProduct).getAmount() < userChoice){
                    System.out.println("Ik heb er maar "+employee.fetchProduct(soldProduct).getAmount()+"\n");
                }

                OpenShop(employee, customer);
            }

        }
        PrintIntro(employee, customer);


    }

    public static void CombineItems() {

    }
}
