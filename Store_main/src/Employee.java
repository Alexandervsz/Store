public class Employee extends Inventory {

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
