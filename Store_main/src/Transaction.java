import java.time.LocalDateTime;
import java.util.ArrayList;

public class Transaction {
    private ArrayList<Product_Count> products;
    private LocalDateTime date;
    private int cashier_number;
    private int register_number;
    private String customer_card_number;
    private String payment_method;

    public Transaction(ArrayList<Product_Count> products, LocalDateTime date, int cashier_number, int register_number, String customer_card_number, String payment_method) {
        this.products = products;
        this.date = date;
        this.cashier_number = cashier_number;
        this.register_number = register_number;
        this.customer_card_number = customer_card_number;
        this.payment_method = payment_method;
    }

    public Transaction(ArrayList<Product_Count> products, LocalDateTime date, int cashier_number, int register_number, String payment_method) {
        this.products = products;
        this.date = date;
        this.cashier_number = cashier_number;
        this.register_number = register_number;
        this.payment_method = payment_method;
    }
}
