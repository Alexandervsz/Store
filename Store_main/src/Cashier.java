public class Cashier extends Employee {
    private int register_number;
    private double avg_cash_diff;

    public int getRegister_number() {
        return register_number;
    }

    public void setRegister_number(int register_number) {
        this.register_number = register_number;
    }

    public double getAvg_cash_diff() {
        return avg_cash_diff;
    }

    public void setAvg_cash_diff(double avg_cash_diff) {
        this.avg_cash_diff = avg_cash_diff;
    }

    public Cashier(int employee_number, String name, double salary) {
        super(employee_number, name, salary);
    }
}
