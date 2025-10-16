package Lab_7;

import java.io.*;

class InsufficientException extends Exception {
    public InsufficientException(String msg){
        super(msg);
    }
}

public class transfer {
    static void trans(double amount, double balance) {
        String msg = null;
        try {
            if (amount > balance) {
                throw new InsufficientException("amount cant be higher than balance, failed for: " + amount);
            }
            msg = "success for amount of: " + amount;
        } catch (InsufficientException e) {
            msg = e.getMessage();
        } finally {
            System.out.println(msg);
        }
    }
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("tlog.txt", true);
        PrintWriter log = new PrintWriter(fw, true);
        PrintStream og = System.out;
        PrintStream both = new PrintStream(new OutputStream() {
            public void write(int b) {
                og.write(b);
                log.write(b);
                og.flush();
                log.flush();
            }
        }, true);
        System.setOut(both);

        double balance = 500;
        trans(600, balance);
        trans(300, balance);
        trans(200,balance);

        log.close();
    }

}
