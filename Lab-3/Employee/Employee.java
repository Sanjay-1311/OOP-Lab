package Employee;

public class Employee {
    private String Emp_name;
    private int Emp_id;
    private String Address;
    private String Mail_id;
    private String Mobile_no;
    public Employee() {
        Emp_name = null;
        Emp_id = 0;
        Address = null;
        Mail_id = null;
        Mobile_no = null;
    }
    public Employee(String Emp_name, int Emp_id, String Address, String Mail_id, String Mobile_no) {
        this.Emp_name = Emp_name;
        this.Emp_id = Emp_id;
        this.Address = Address;
        this.Mail_id = Mail_id;
        this.Mobile_no = Mobile_no;
    }
    public void setEmpname(String Emp_name) {
        this.Emp_name = Emp_name;
    }
    public String getEmpname() {
        return Emp_name;
    }
    public void setEmp_id(int Emp_id) {
        this.Emp_id = Emp_id;
    }

    public int getEmpid() {
        return Emp_id;
    }
    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getAddress() {
        return Address;
    }
    public void setMailId(String Mail_id) {
        this.Mail_id = Mail_id;
    }
    public String getMailId() {
        return Mail_id;
    }
    public void setmobileno(String Mobile_no) {
        this.Mobile_no = Mobile_no;
    }

    public String getMobileno() {
        return Mobile_no;
    }
    public void display() {
        System.out.println("Employee ID: " + Emp_id);
        System.out.println("Name: " + Emp_name);
        System.out.println("Address: " + Address);
        System.out.println("Email: " + Mail_id);
        System.out.println("Mobile: " + Mobile_no);
    }
    public void paySlip() {
        System.out.println("Pay slip not available for generic Employee.");
    }
}
