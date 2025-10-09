package Lab_6;

import java.util.Scanner;

public class Circle extends Shape implements Colorable {
    Scanner sc = new Scanner(System.in);
    @Override
    double area(){
        System.out.println("Enter the radius of the circle");
        String dim1=sc.nextLine();
        if (Double.parseDouble(dim1)<=0){
            System.out.println("Enter positive input");
            return 0;
        }
        double area=Double.parseDouble(dim1)*Double.parseDouble(dim1)*3.14;
        return area;
    }
    @Override
    public String colorDescription(String color){
        return "The circle is "+color;
    }
}
