import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StackADT {

    /**
     * A simple static nested logger class to write terminal text to a log file.
     * By nesting it, we avoid needing a separate .java file.
     */
    public static class LogWriter {
        private static PrintWriter writer;

        static {
            try {
                FileWriter fw = new FileWriter("log-4.txt", true);
                writer = new PrintWriter(fw);
                writer.println("\n--- Log Session Started: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " ---");
            } catch (IOException e) {
                System.err.println("CRITICAL ERROR: LogWriter could not be initialized.");
                e.printStackTrace();
            }
        }

        public static void log(String message) {
            if (writer != null) {
                writer.println(message);
                writer.flush();
            }
        }

        public static void logInline(String message) {
            if (writer != null) {
                writer.print(message);
                writer.flush();
            }
        }

        public static void close() {
            if (writer != null) {
                writer.println("--- Log Session Ended: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " ---");
                writer.close();
            }
        }
    }
    // --- End of nested LogWriter class ---


    private static void logAndPrint(String message) {
        System.out.println(message);
        LogWriter.log(message);
    }

    private static void logAndPrintInline(String message) {
        System.out.print(message);
        LogWriter.logInline(message);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyStack<String> stringStack = null;

        while (stringStack == null) {
            try {
                logAndPrintInline("Enter initial stack size: ");
                int initialSize = scanner.nextInt();
                LogWriter.log(String.valueOf(initialSize));
                stringStack = new StackArray<>(initialSize);
            } catch (InputMismatchException e) {
                String badInput = scanner.next();
                logAndPrint("Invalid input. Please enter an integer.");
                LogWriter.log(badInput);
            } catch (IllegalArgumentException e) {
                logAndPrint("Error: " + e.getMessage());
            }
        }
        
        scanner.nextLine();

        int choice = 0;
        while (choice != 4) {
            logAndPrint("\n--- Stack Menu ---");
            logAndPrint("1. Push  2. Pop 3. Display 4. Exit");
            logAndPrintInline("Choice: ");

            try {
                choice = scanner.nextInt();
                LogWriter.log(String.valueOf(choice));
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        logAndPrintInline("Enter value to push: ");
                        String valueToPush = scanner.nextLine();
                        LogWriter.log(valueToPush);
                        try {
                            stringStack.push(valueToPush);
                            logAndPrint("'" + valueToPush + "' pushed to stack.");
                        } catch (StackOverflowException e) {
                            logAndPrint("Exception: " + e.getMessage());
                        }
                        break;

                    case 2:
                        try {
                            String poppedValue = stringStack.pop();
                            logAndPrint("'" + poppedValue + "' popped from stack.");
                        } catch (StackUnderflowException e) {
                            logAndPrint("Exception: " + e.getMessage());
                        }
                        break;

                    case 3:
                        LogWriter.log(stringStack.toString());
                        stringStack.display();
                        break;

                    case 4:
                        logAndPrint("Program exiting...");
                        break;

                    default:
                        logAndPrint("Invalid choice. Please enter a number between 1 and 4.");
                        break;
                }
            } catch (InputMismatchException e) {
                String badInput = scanner.next();
                logAndPrint("Invalid input. Please enter a number.");
                LogWriter.log(badInput);
                choice = 0;
            }
        }
        scanner.close();
        LogWriter.close();
    }
}
