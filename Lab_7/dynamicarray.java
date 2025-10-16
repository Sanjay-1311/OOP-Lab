package Lab_7;

import java.io.*;
import java.util.*;

class InvalidSizeException extends Exception {
    public InvalidSizeException(String msg) {
        super(msg);
    }
}

public class dynamicarray {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("dlog.txt", true);
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

        Scanner sc = new Scanner(System.in);
        int size = 0;
        try {
            System.out.print("Enter size: ");
            String input = sc.next();   
            log.println(input); 
            log.flush();
            size = Integer.parseInt(input); 
            if (size <= 0) {
                log.close();
                sc.close();
                throw new InvalidSizeException("size must be bigger than 0");
                
            }
            
            System.out.println("success");
        } catch (NumberFormatException e) {
            System.out.println("invalid, enter integer");
        } catch (InvalidSizeException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        log.close();
        sc.close();
    }
    
}