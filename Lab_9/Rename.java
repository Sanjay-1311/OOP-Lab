package Lab_9;
import java.io.File;
public class Rename {
    public static void main(String[] args) {
       File file = new File("C:\\Users\\notsa\\OOPS-lab\\OOP-Lab\\Lab_9\\Example.txt");
       try {
        file.renameTo(new File("C:\\Users\\notsa\\OOPS-lab\\OOP-Lab\\Lab_9\\RenamedExample.txt"));
        System.out.println("File renamed successfully.");
    } catch (Exception e) {
       System.out.println("An error occurred: " + e.getMessage());
        }
    }
}