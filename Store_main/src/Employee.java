import java.time.LocalDateTime;

public class Employee implements Employee_Interface {
    private int Employee_number;
    private String name;
    private double salary;
    private boolean is_working;
    private int hours_worked = 0;
    private LocalDateTime shift_start;

    public Employee(int employee_number, String name, double salary) {
        Employee_number = employee_number;
        this.name = name;
        this.salary = salary;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isIs_working() {
        return is_working;
    }

    public void setIs_working(boolean is_working) {
        this.is_working = is_working;
    }

    public int getHours_worked() {
        return hours_worked;
    }

    public void setHours_worked(int hours_worked) {
        this.hours_worked = hours_worked;
    }

    public LocalDateTime getShift_start() {
        return shift_start;
    }

    public void setShift_start(LocalDateTime shift_start) {
        this.shift_start = shift_start;
    }

    @Override
    public void check_in() {
        if (!is_working) {
            shift_start = LocalDateTime.now();
            is_working = true;
        }


    }

    @Override
    public void check_out() {
        if (is_working) {
            //hours_worked += LocalDateTime.now() - shift_start;
            is_working = false;
        }

    }

    @Override
    public void pay() {
        if (hours_worked > 0){
        double payment = salary * hours_worked;
        System.out.println("Sent €" + payment + "to " + name);
        hours_worked = 0;}
    }
}
