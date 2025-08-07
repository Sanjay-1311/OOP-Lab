import Employee.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        PrintStream originalOut = System.out;

        // Declare logStreamHolder here so it can be used in finally block
        final PrintStream[] logStreamHolder = new PrintStream[1];

        try {
            // Open log file in append mode with autoflush
            FileOutputStream fos = new FileOutputStream("log3.txt", true);
            logStreamHolder[0] = new PrintStream(fos, true);

            // Create PrintStream writing to both console and log file
            PrintStream dualOut = new PrintStream(new OutputStream() {
                @Override
                public void write(int b) throws IOException {
                    originalOut.write(b);
                    logStreamHolder[0].write(b);
                }
                @Override
                public void write(byte[] b, int off, int len) throws IOException {
                    originalOut.write(b, off, len);
                    logStreamHolder[0].write(b, off, len);
                }
                @Override
                public void flush() throws IOException {
                    originalOut.flush();
                    logStreamHolder[0].flush();
                }
                @Override
                public void close() throws IOException {
                    originalOut.close();
                    logStreamHolder[0].close();
                }
            }, true);

            // Redirect standard output to dual stream
            System.setOut(dualOut);

            while (true) {
                System.out.println("Select Employee Type to add:");
                System.out.println("1. Programmer");
                System.out.println("2. Assistant Professor");
                System.out.println("3. Associate Professor");
                System.out.println("4. Professor");
                System.out.println("5. Display");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                int choice;
                try {
                    choice = Integer.parseInt(sc.nextLine().trim());
                    logStreamHolder[0].println(">> Choice: " + choice);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }

                if (choice == 6) {
                    System.out.println("Exiting program.");
                    break;
                }

                if (choice == 5) {
                    System.out.println("\n--- All Employees Details ---");
                    if (employees.isEmpty()) {
                        System.out.println("No employees added yet.");
                    } else {
                        for (Employee emp : employees) {
                            emp.display();
                            System.out.println("-------------------------");
                        }
                    }
                    continue;
                }

                System.out.print("Enter Employee Name: ");
                String name = sc.nextLine().trim();
                logStreamHolder[0].println(">> Name: " + name);

                int id;
                while (true) {
                    System.out.print("Enter Employee ID: ");
                    String idInput = sc.nextLine().trim();
                    try {
                        id = Integer.parseInt(idInput);
                        logStreamHolder[0].println(">> Employee ID: " + id);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Please enter a valid integer.");
                    }
                }

                System.out.print("Enter Address: ");
                String address = sc.nextLine().trim();
                logStreamHolder[0].println(">> Address: " + address);

                System.out.print("Enter Email: ");
                String email = sc.nextLine().trim();
                logStreamHolder[0].println(">> Email: " + email);

                System.out.print("Enter Mobile Number: ");
                String mobile = sc.nextLine().trim();
                logStreamHolder[0].println(">> Mobile: " + mobile);

                double bPay;
                while (true) {
                    System.out.print("Enter Basic Pay: ");
                    String bPayInput = sc.nextLine().trim();
                    try {
                        bPay = Double.parseDouble(bPayInput);
                        if (bPay < 0) {
                            System.out.println("Basic Pay cannot be negative.");
                            continue;
                        }
                        logStreamHolder[0].println(">> Basic Pay: " + bPay);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Basic Pay! Please enter a valid number.");
                    }
                }

                switch (choice) {
                    case 1:
                        employees.add(new Programmer(name, id, address, email, mobile, bPay));
                        break;
                    case 2:
                        employees.add(new AssistantProfessor(name, id, address, email, mobile, bPay));
                        break;
                    case 3:
                        employees.add(new AssociateProfessor(name, id, address, email, mobile, bPay));
                        break;
                    case 4:
                        employees.add(new Professor(name, id, address, email, mobile, bPay));
                        break;
                    default:
                        System.out.println("Invalid choice, try again.");
                        continue;
                }

                System.out.println("Employee added successfully!\n");
            }

            System.out.println("\n--- Employee Pay Slips ---");
            for (Employee emp : employees) {
                emp.paySlip();
                System.out.println("-------------------------");
            }

        } catch (IOException e) {
            System.err.println("Error during logging: " + e.getMessage());
        } finally {
            System.setOut(originalOut);
            if (logStreamHolder[0] != null) {
                logStreamHolder[0].close();
            }
            sc.close();
        }
    }
}
