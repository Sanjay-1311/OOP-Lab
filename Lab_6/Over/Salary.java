package Lab_6.Over;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Salary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter employee name: ");
            String name = sc.nextLine();
            System.out.print("Enter base salary: ");
            double baseSalary = sc.nextDouble();
            if (baseSalary <= 0) {
                throw new InvalidSalaryException("Salary must be positive.");
            }
            System.out.print("Is this employee a manager? (yes/no): ");
            sc.nextLine();
            String isManager = sc.nextLine().trim().toLowerCase();
            Employee emp;
            if (isManager.equals("yes")) {
                System.out.print("Enter manager bonus: ");
                double bonus = sc.nextDouble();
                if (bonus < 0) {
                    throw new InvalidSalaryException("Bonus cannot be negative.");
                }
                emp = new Manager(name, baseSalary, bonus);
            } else {
                emp = new Employee(name, baseSalary);
            }
            System.out.println("\n--- Salary Details ---");
            System.out.println("Employee Name: " + name);
            System.out.println("Total Salary: " + emp.calculateSalary());
        } catch (InvalidSalaryException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid numeric values for salary and bonus.");
        } finally {
            sc.close();
        }
    }
}