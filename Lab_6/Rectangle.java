package Lab_6;
import java.util.Scanner;
public class Rectangle extends Shape implements Colorable{
    Scanner sc = new Scanner(System.in);
    @Override
    double area(){
        System.out.println("Enter the length of the rectangle");
        String dim1=sc.nextLine();
        if (Double.parseDouble(dim1)<=0){
            System.out.println("Enter positive input");
            return 0;
        }
        System.out.println("Enter the breadth of the rectangle");
        String dim2=sc.nextLine();
        if (Double.parseDouble(dim2)<=0){
            System.out.println("Enter positive input");
            return 0;
        }
        double area=Double.parseDouble(dim1)*Double.parseDouble(dim2);
        return area;
    }
    @Override
    public String colorDescription(String color){
        return "The rectangle is "+color;
    }
}
