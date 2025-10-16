package Lab_6.Maths;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MathOperations {

    private static final String LOG_FILE = "log1.txt";

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
                System.err.println("CRITICAL ERROR: Unable to write to log1.txt. " + e.getMessage());
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

    public int sum(int a, int b) {
        logAndPrint("Called sum(int, int)");
        return a + b;
    }

    public double sum(double a, double b, double c) {
        logAndPrint("Called sum(double, double, double)");
        return a + b + c;
    }

    public int sum(int... numbers) {
        logAndPrint("Called sum(int...)");
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            MathOperations mo = new MathOperations();

            logAndPrintInline("Enter two integers: ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            logInput("two integers", a + ", " + b);
            logAndPrint("Sum of 2 ints: " + mo.sum(a, b));

            logAndPrintInline("Enter three doubles: ");
            double d1 = sc.nextDouble();
            double d2 = sc.nextDouble();
            double d3 = sc.nextDouble();
            logInput("three doubles", d1 + ", " + d2 + ", " + d3);
            logAndPrint("Sum of 3 doubles: " + mo.sum(d1, d2, d3));

            logAndPrintInline("Enter how many integers to sum (varargs): ");
            int n = sc.nextInt();
            logInput("varargs count", n);
            int[] nums = new int[n];
            logAndPrint("Enter " + n + " integers:");
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
                logInput("varargs value[" + i + "]", nums[i]);
            }
            logAndPrint("Sum using varargs: " + mo.sum(nums));
        } catch (InputMismatchException e) {
            String message = "Error: Please enter numeric values where required.";
            logAndPrint(message);
            LogWriter.log("EXCEPTION: " + e.getMessage());
        } finally {
            LogWriter.close();
        }
    }
}