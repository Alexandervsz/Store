public class Employee extends Inventory {

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Hallo, wat wil je kopen?\nIk heb in de aanbieding:\n");
        for (Product product : getProducts()) {
            string.append(product.toString());
            string.append("\n");
        }
        return string.toString();
    }
}
