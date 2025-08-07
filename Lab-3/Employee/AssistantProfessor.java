package Employee;

public class AssistantProfessor extends Employee {
    private double bPay;
    private String des;

    public AssistantProfessor(String Emp_name, int Emp_id, String Address, String Mail_id, String Mobile_no, double bPay) {
        super(Emp_name, Emp_id, Address, Mail_id, Mobile_no);
        this.bPay = bPay;
        this.des = "Assistant Professor";
    }

    @Override
    public void paySlip() {
        double grossSalary = bPay + (0.1 * bPay);  
        double netSalary = grossSalary - (0.05 * grossSalary);

        display();  

        System.out.println("Designation: " + des);
        System.out.println("Basic Pay: " + bPay);
        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("Net Salary: " + netSalary);
        System.out.println("-----------------------------------");
    }
}
