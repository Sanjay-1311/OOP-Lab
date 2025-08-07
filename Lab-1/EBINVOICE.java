import java.util.*;
import java.io.FileWriter;
import java.io.PrintWriter;

public class EBINVOICE {
    private int ConNo;
    private String ConName;
    private float prev;
    private float curr;
    private String type;
    private float bill;
    static Scanner scanner = new Scanner(System.in);
    
    static PrintWriter logWriter;

    public void GetDetails() {
        System.out.print("Enter the consumer number: ");
        if (scanner.hasNextInt()) {
            int temp = scanner.nextInt();
            if (temp >= 0) {
                ConNo = temp;
                logWriter.println("INPUT Consumer Number: " + ConNo);
            } else {
                System.out.println("Enter a valid positive consumer number.");
                return;
            }
        } else {
            System.out.println("Enter a valid integer for consumer number.");
            scanner.next();
            return;
        }
        scanner.nextLine();

        System.out.print("Enter the consumer Name: ");
        ConName = scanner.nextLine();
        logWriter.println("INPUT Consumer Name: " + ConName);

        System.out.print("Enter the previous month reading: ");
        if (scanner.hasNextFloat()) {
            float temp = scanner.nextFloat();
            if (temp >= 0) {
                prev = temp;
                logWriter.println("INPUT Previous Month Reading: " + prev);
            } else {
                System.out.println("Enter a valid positive previous reading.");
                return;
            }
        } else {
            System.out.println("Enter a valid float number for previous reading.");
            scanner.next();
            return;
        }

        System.out.print("Enter the current month reading: ");
        if (scanner.hasNextFloat()) {
            float temp = scanner.nextFloat();
            if (temp >= 0 && temp >= prev) {
                curr = temp;
                logWriter.println("INPUT Current Month Reading: " + curr);
            } else {
                System.out.println("Current reading must be >= previous reading and positive.");
                return;
            }
        } else {
            System.out.println("Enter a valid float number for current reading.");
            scanner.next();
            return;
        }
        scanner.nextLine();

        System.out.print("Enter the type of EB connection (domestic/commercial): ");
        type = scanner.nextLine().trim().toLowerCase();
        if (type.equals("domestic") || type.equals("commercial")) {
            logWriter.println("INPUT Connection Type: " + type);
        } else {
            System.out.println("Enter a valid type of connection (domestic or commercial).");
            type = null;
        }
    }

    public float compute() {
        if (type == null) {
            return 0;
        }

        bill = 0;
        float reading = curr - prev;

        if (reading < 0) {
            System.out.println("Current reading cannot be less than previous reading.");
            return 0;
        }

        if (type.equals("domestic")) {
            if (reading <= 100) {
                bill = reading * 1;
            } else if (reading <= 200) {
                bill = 100 * 1 + (reading - 100) * 2.5f;
            } else if (reading <= 500) {
                bill = 100 * 1 + 100 * 2.5f + (reading - 200) * 4;
            } else {
                bill = 100 * 1 + 100 * 2.5f + 300 * 4 + (reading - 500) * 6;
            }
        } else if (type.equals("commercial")) {
            if (reading <= 100) {
                bill = reading * 2;
            } else if (reading <= 200) {
                bill = 100 * 2 + (reading - 100) * 4.5f;
            } else if (reading <= 500) {
                bill = 100 * 2 + 100 * 4.5f + (reading - 200) * 6;
            } else {
                bill = 100 * 2 + 100 * 4.5f + 300 * 6 + (reading - 500) * 7;
            }
        }

        logWriter.println("OUTPUT EB Bill: " + bill);
        return bill;
    }

    public static void main(String[] args) throws Exception {
        logWriter = new PrintWriter(new FileWriter("log.txt", true), true);

        EBINVOICE eb = new EBINVOICE();
        eb.GetDetails();
        float result = eb.compute();

        if (result == 0) {
            System.out.println("Enter correct readings or valid connection type.");
            logWriter.println("ERROR: Invalid input or connection type.");
        } else {
            System.out.println("The generated EB invoice is: " + result);
        }

        logWriter.close();
    }
}

