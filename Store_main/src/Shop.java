import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Shop {
    private Employee employee;
    private Customer customer;

    public Shop(Employee employee, Customer customer) {
        this.employee = employee;
        this.customer = customer;
    }

    public void printIntro() {
        System.out.println("Wat wil je doen?");
        System.out.println("Dingen kopen (1):");
        System.out.println("Dingen combineren (2):");
        System.out.println("Dingen verkopen (3):");
        Scanner scanner2 = new Scanner(System.in);
        int userChoice = scanner2.nextInt();
        switch (userChoice) {
            case 1:
                openShop();
            case 2:
                combineItems();
            case 3:
                sellItems();
            default:
                printIntro();
        }
    }

    public void openShop() {
        System.out.println(employee.toString());
        System.out.println("Je hebt zelf nog " + customer.getMoney() + " over.");
        Product soldProduct = findProduct(employee);
        System.out.println("Hoeveel wil je er kopen?");
        boolean sold = false;
        while (!sold) {
            int userChoice = findInt(employee, soldProduct);
            double money = customer.getMoney();
            double totalprice = userChoice * soldProduct.getPrice();

            if (employee.fetchProduct(soldProduct).getAmount() >= userChoice && money >= totalprice && userChoice >= 0) {
                employee.updateProductStock(soldProduct, userChoice * -1);

                if (soldProduct.getAmount() == 0) {
                    employee.removeProduct(soldProduct);
                }

                if (customer.checkInventory(soldProduct)) {
                    Product oldProduct = customer.fetchProduct(soldProduct);
                    customer.updateProductStock(oldProduct, userChoice);
                } else {
                    if (userChoice != 0) {
                        Product newProduct = new Product(soldProduct.getProductName(), soldProduct.getPrice(), soldProduct.getProductCode(), userChoice);
                        customer.addProduct(newProduct);
                    }
                }
                customer.setMoney(money - totalprice);
                System.out.println("Bedankt!");
                sold = true;
                printIntro();

            } else {
                if (money < totalprice) {
                    System.out.println(money);
                    System.out.println(totalprice);
                    System.out.println("Je hebt te weinig geld.");

                } else if (employee.fetchProduct(soldProduct).getAmount() < userChoice) {
                    System.out.println("Ik heb er maar " + employee.fetchProduct(soldProduct).getAmount() + "\n");
                } else if (userChoice < 0) {
                    System.out.println("ongeldige invoer, verkoop gestaakt.");
                }
                openShop();
            }
        }
    }
    public void combineItems() {

        if (getCustomerItems(customer, 1)) {
            System.out.println("Kies je eerste product.");
            Product product1 = findProduct(customer);
            System.out.println("Kies je hoeveelheid eerste product.");
            int amount1 = findInt(customer, product1);
            System.out.println("Kies je tweede product.");
            Product product2 = findProduct(customer);
            if (product1.equals(product2)) {
                System.out.println("Twee keer hetzelfde product gekozen!");
                combineItems();
            }
            System.out.println("Kies je hoeveelheid tweede product.");
            int amount2 = findInt(customer, product2);
            CombineItem itemCombiner = new CombineItem(product1, product2, amount1, amount2);
            Product newProduct = itemCombiner.addItems();
            if (newProduct != null) {
                System.out.println("Je hebt " + newProduct.getProductName() + " gemaakt!\n");
                customer.updateProductStock(product1, amount1 * -1);
                customer.updateProductStock(product2, amount2 * -1);
                if (customer.checkInventory(newProduct)) {
                    Product oldProduct = customer.fetchProduct(newProduct);
                    customer.updateProductStock(oldProduct, 1);
                } else {
                    customer.addProduct(newProduct);
                }
            } else {
                System.out.println("Tot je teleurstelling gebeurt er niets.\n");

            }
            printIntro();
        } else {
            printIntro();
        }
    }

    public Product findProduct(Inventory customer) {
        Product foundProduct = null;
        boolean found = false;
        while (!found) {
            System.out.println("Voer hier je input in: ");
            Scanner scanner = new Scanner(System.in);
            String userChoice = scanner.nextLine();


            ArrayList<Product> products = customer.getProducts();

            for (Product product : products) {
                if (userChoice.equals(product.getProductName()) || userChoice.toUpperCase(Locale.ROOT).equals(product.getProductName())) {
                    found = true;
                    foundProduct = product;
                    break;
                }
            }


        }
        if(!found){
            System.out.println("Dat product is er niet...");}
        return foundProduct;
    }

    public int findInt(Inventory customer, Product product) {
        System.out.println("Voer hier je input in: ");
        Scanner scanner = new Scanner(System.in);
        int userChoice = -1;
        try {
            userChoice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ongeldige invoer!");
            findInt(customer, product);
        }
        if (userChoice <= customer.fetchProduct(product).getAmount() && userChoice >= 0) {
            return userChoice;
        } else if (userChoice < 0) {
            System.out.println("Ongeldige invoer!");
            findInt(customer, product);
        } else if (userChoice <= customer.fetchProduct(product).getAmount()) {
            System.out.println("Niet voldoende product.");
            findInt(customer, product);
        }
        return userChoice;
    }

    public boolean getCustomerItems(Customer customer, int min) {
        System.out.print("Je hebt ");
        if ((customer.getProducts().size()) > min) {
            System.out.println("\n");
        } else {
            System.out.println("niet voldoende producten.\n");
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

    public void sellItems() {
        if (getCustomerItems(customer, 0)) {
            System.out.println("Welk product wil je verkopen?");
            Product product1 = findProduct(customer);
            System.out.println("Hoeveel wil je er verkopen?");
            int amount1 = findInt(customer, product1);
            if (amount1 < 0) {
                printIntro();
                return;
            }
            if (employee.checkInventory(product1)) {
                Product oldProduct = employee.fetchProduct(product1);
                employee.updateProductStock(oldProduct, amount1);
            } else {
                Product employeeProduct = new Product(product1.getProductName(), product1.getPrice(), product1.getProductCode(), amount1);
                employee.addProduct(employeeProduct);
            }
            customer.updateProductStock(product1, amount1 * -1);
            customer.setMoney(customer.getMoney() + product1.getPrice() * amount1);
            System.out.println("Bedankt!\n");
        }
        printIntro();
    }
}
