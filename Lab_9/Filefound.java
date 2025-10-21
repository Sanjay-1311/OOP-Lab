package Lab_9;
import java.io.File;


public class Filefound {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\notsa\\OOPS-lab\\OOP-Lab\\Lab_9\\Example.txt");
        try {
            if (file.exists()) {
                System.out.println("File found: " + file.getAbsolutePath());
            } else {
                System.out.println("File not found. Please check the file path: " + file.getAbsolutePath());
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}