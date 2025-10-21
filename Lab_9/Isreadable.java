package Lab_9;
import java.io.File;
public class Isreadable {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\notsa\\OOPS-lab\\OOP-Lab\\Lab_9\\RenamedExample.txt");
        try {
            if (file.canRead()) {
                System.out.println("File is readable: " + file.getAbsolutePath());
            } else {
                System.out.println("File is not readable: " + file.getAbsolutePath());
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
