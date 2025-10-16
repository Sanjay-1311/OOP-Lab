package Lab_7;
import java.io.*;

class UnderException extends RuntimeException {
    public UnderException(String msg) {
        super(msg);
    }
}

class OverException extends Exception {
    public OverException(String msg) {
        super(msg);
    }
}

public class age {

    public static void checkVotingEligibility(int age) throws OverException {
        if (age < 18) {
            throw new UnderException("age " + age + " is below 18. not eligible to vote.");
        } else if (age > 120) {
            throw new OverException("age " + age + " is unrealistic.");
        } else {
            System.out.println("age " + age + " is eligible to vote.");
        }
    }

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("alog.txt", true);
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

        int[] testAges = {15, 25, 130,17,22,12,99};

        for (int a : testAges) {
            try {
                System.out.println("\nchecking age: " + a);
                checkVotingEligibility(a);
            } catch (UnderException e) {
                System.out.println("caught unchecked exception: " + e.getMessage());
            } catch (OverException e) {
                System.out.println("caught checked exception: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("caught normal exception: " + e.getMessage());
            }
        }
        log.close();
    }
    
}