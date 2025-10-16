package Lab_6.Over;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Salary {

    private static final String LOG_FILE = "log2.txt";

    private static class LogWriter {
        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        private static boolean sessionOpened;

        private static void ensureSessionOpened() {
            if (!sessionOpened) {
                write("\n--- Log Session Started: " + LocalDateTime.now().format(FORMATTER) + " ---", true);
                sessionOpened = true;
            }
        }

        private static void log(String message) {
            ensureSessionOpened();
            write(message, true);
        }

        private static void logInline(String message) {
            ensureSessionOpened();
            write(message, false);
        }

        private static void close() {
            if (sessionOpened) {
                write("--- Log Session Ended: " + LocalDateTime.now().format(FORMATTER) + " ---", true);
                sessionOpened = false;
            }
        }

        private static void write(String message, boolean newline) {
            try (FileWriter fw = new FileWriter(LOG_FILE, true); PrintWriter writer = new PrintWriter(fw)) {
                if (newline) {
                    writer.println(message);
                } else {
                    writer.print(message);
                }
            } catch (IOException e) {
                System.err.println("CRITICAL ERROR: Unable to write to log2.txt. " + e.getMessage());
            }
        }
    }

    private static void logAndPrint(String message) {
        System.out.println(message);
        LogWriter.log(message);
    }

    private static void logAndPrintInline(String message) {
        System.out.print(message);
        LogWriter.logInline(message);
    }

    private static void logInput(String label, Object value) {
        LogWriter.log("INPUT " + label + ": " + value);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            logAndPrintInline("Enter employee name: ");
            String name = sc.nextLine();
            logInput("employee name", name);

            logAndPrintInline("Enter base salary: ");
            double baseSalary = sc.nextDouble();
            logInput("base salary", baseSalary);
            if (baseSalary <= 0) {
                throw new InvalidSalaryException("Salary must be positive.");
            }

            logAndPrintInline("Is this employee a manager? (yes/no): ");
            sc.nextLine();
            String isManager = sc.nextLine().trim().toLowerCase();
            logInput("is manager", isManager);

            Employee emp;
            if (isManager.equals("yes")) {
                logAndPrintInline("Enter manager bonus: ");
                double bonus = sc.nextDouble();
                logInput("manager bonus", bonus);
                if (bonus < 0) {
                    throw new InvalidSalaryException("Bonus cannot be negative.");
                }
                emp = new Manager(name, baseSalary, bonus);
            } else {
                emp = new Employee(name, baseSalary);
            }

            logAndPrint("\n--- Salary Details ---");
            logAndPrint("Employee Name: " + name);
            logAndPrint("Total Salary: " + emp.calculateSalary());
        } catch (InvalidSalaryException e) {
            String message = "Error: " + e.getMessage();
            logAndPrint(message);
            LogWriter.log("EXCEPTION: " + e.getMessage());
        } catch (InputMismatchException e) {
            String message = "Error: Please enter valid numeric values for salary and bonus.";
            logAndPrint(message);
            LogWriter.log("EXCEPTION: " + e.getMessage());
        } finally {
            LogWriter.close();
        }
    }
}