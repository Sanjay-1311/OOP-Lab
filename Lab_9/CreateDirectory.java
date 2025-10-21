package Lab_9;
import java.io.File;


public class CreateDirectory {
    public static void main(String[] args) {
        File directory = new File("C:\\Users\\notsa\\OOPS-lab\\OOP-Lab\\Lab_9\\NewDirectory");
        if (!directory.exists()) {
            directory.mkdir();
            System.out.println("Directory created successfully.");
        } else {
            System.out.println("Directory already exists.");
        }
    }
}
