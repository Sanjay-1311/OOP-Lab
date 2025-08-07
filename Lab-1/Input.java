
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) throws Exception {
        // Setup file logger
        FileWriter fw = new FileWriter("log.txt", true); // append mode
        PrintWriter logWriter = new PrintWriter(fw, true);
        PrintStream originalOut = System.out;

        // Redirect output to both console and log file
        PrintStream logOut = new PrintStream(new OutputStream() {
            public void write(int b) {
                originalOut.write(b);
                logWriter.write(b);
            }
        });
        System.setOut(logOut);

        // Input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int a = sc.nextInt();
        logWriter.println("INPUT a: " + a);

        System.out.println("Enter second number: ");
        int b = sc.nextInt();
        logWriter.println("INPUT b: " + b);

        // Operations
        int sum = a + b;
        int diff = a - b;

        // Output
        // System.out.println("Sum: " + sum);
        logWriter.println("OUTPUT Sum: " + sum);

        // System.out.println("Difference: " + diff);
        logWriter.println("OUTPUT Difference: " + diff);

        sc.close();
        logWriter.close();
    }
}

