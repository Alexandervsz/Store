import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Employee employee = new Employee();
        Customer customer;
        employee.addProduct(new Product("H", 50.0, "H", 50));
        employee.addProduct(new Product("O", 50.0, "O", 100));
        employee.addProduct(new Product("C", 500.0, "C", 50));
        customer = new Customer();
        PrintIntro(employee, customer);


    }


    public static void PrintIntro(Employee employee, Customer customer) {
        System.out.println("Wat wil je doen?");
        System.out.println("Dingen kopen (1):");
        System.out.println("Dingen combineren (2):");
        System.out.println("Dingen verkopen (3):");
        Scanner scanner2 = new Scanner(System.in);
        int userChoice = scanner2.nextInt();
        switch (userChoice) {
            case 1 -> OpenShop(employee, customer);
            case 2 -> CombineItems(employee, customer);
            case 3 -> SellItems(employee, customer);
            default -> PrintIntro(employee, customer);
        }


    }


    public static void OpenShop(Employee employee, Customer customer) {
        System.out.println(employee.toString());
        System.out.println("Je hebt zelf nog " + customer.getMoney() + " over.");
        boolean found = false;
        Product soldProduct = null;
        while (!found) {
            System.out.println("Voer hier je input in: ");
            Scanner scanner = new Scanner(System.in);
            String userChoice = scanner.nextLine();
            ArrayList<Product> products = employee.getProducts();

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
            double totalprice = userChoice * soldProduct.getPrice();

            if (employee.fetchProduct(soldProduct).getAmount() >= userChoice & money >= totalprice) {
                employee.updateProductStock(soldProduct, userChoice * -1);

                if (soldProduct.getAmount() == 0) {
                    employee.removeProduct(soldProduct);
                }

                if (customer.checkInventory(soldProduct)) {
                    Product oldProduct = customer.fetchProduct(soldProduct);
                    customer.updateProductStock(oldProduct, userChoice);
                } else {
                    Product newProduct = new Product(soldProduct.getProductName(), soldProduct.getPrice(), soldProduct.getProductcode(), userChoice);
                    customer.addProduct(newProduct);
                }
                customer.setMoney(money - totalprice);
                System.out.println("Bedankt!");
                sold = true;
                PrintIntro(employee, customer);

            } else {
                if (money < totalprice) {
                    System.out.println(money);
                    System.out.println(totalprice);
                    System.out.println("Je hebt te weinig geld.");

                } else if (employee.fetchProduct(soldProduct).getAmount() < userChoice) {
                    System.out.println("Ik heb er maar " + employee.fetchProduct(soldProduct).getAmount() + "\n");
                }

                OpenShop(employee, customer);
            }

        }


    }

    public static void CombineItems(Employee employee, Customer customer) {

        if (getCustomerItems(customer)) {
            System.out.println("Kies je eerste product.");
            Product product1 = FindProduct(customer);
            System.out.println("Kies je hoeveelheid eerste product.");
            int amount1 = FindInt(customer, product1);
            System.out.println("Kies je tweede product.");
            Product product2 = FindProduct(customer);
            System.out.println("Kies je hoeveelheid tweede product.");
            int amount2 = FindInt(customer, product2);
            CombineItem itemCombiner = new CombineItem(product1, product2, amount1, amount2);
            Product newProduct = itemCombiner.addItems();
            if (newProduct != null) {
                System.out.println("Je hebt " + newProduct.getProductName() + " gemaakt!");
                customer.updateProductStock(product1, amount1 * -1);
                customer.updateProductStock(product2, amount2 * -1);
                if (customer.checkInventory(newProduct)) {
                    Product oldProduct = customer.fetchProduct(newProduct);
                    customer.updateProductStock(oldProduct, oldProduct.getAmount() + 1);
                } else {
                    customer.addProduct(newProduct);
                }
            } else {
                System.out.println("Tot je teleurstelling gebeurt er niets.");

            }
            PrintIntro(employee, customer);
        } else {
            PrintIntro(employee, customer);
        }


    }


    public static Product FindProduct(Customer customer) {
        Product foundProduct = null;
        boolean found = false;
        while (!found) {
            System.out.println("Voer hier je input in: ");
            Scanner scanner = new Scanner(System.in);
            String userChoice = scanner.nextLine();
            ArrayList<Product> products = customer.getProducts();

            for (Product product : products) {
                if (userChoice.equals(product.getProductName())) {
                    found = true;
                    foundProduct = product;
                    break;
                }
            }
        }
        return foundProduct;
    }

    public static int FindInt(Customer customer, Product product) {
        System.out.println("Voer hier je input in: ");
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        if (userChoice <= customer.fetchProduct(product).getAmount()) {
            return userChoice;
        } else {
            System.out.println("Niet voldoende product.");
            FindInt(customer, product);
        }
        return -1;

    }

    public static boolean getCustomerItems(Customer customer) {
        System.out.print("Je hebt ");
        if ((customer.getProducts().size()) > 0) {
            System.out.println("\n");
        } else {
            System.out.println("niets.\n");
            return false;
        }
        StringBuilder string = new StringBuilder();

        for (Product product : customer.getProducts()) {
            string.append(product.getProductName());
            string.append(", ");
            string.append(product.getAmount());
            string.append(" stuks.");
            string.append("\n");


        }

        System.out.println(string);
        return true;

    }

    public static void SellItems(Employee employee, Customer customer) {
        if (getCustomerItems(customer)) {
            System.out.println("Welk product wil je verkopen?");
            Product product1 = FindProduct(customer);
            System.out.println("Hoe veel wil je er verkopen?");
            int amount1 = FindInt(customer, product1);
            if (employee.checkInventory(product1)) {
                Product oldProduct = employee.fetchProduct(product1);
                employee.updateProductStock(oldProduct, amount1);
            } else {
                Product employeeProduct = new Product(product1.getProductName(), product1.getPrice(), product1.getProductcode(), amount1);
                employee.addProduct(employeeProduct);
            }
            customer.updateProductStock(product1, amount1 * -1);
            customer.setMoney(customer.getMoney() + product1.getPrice() * amount1);
            System.out.println("Bedankt!");
        }
        PrintIntro(employee, customer);


    }
}



