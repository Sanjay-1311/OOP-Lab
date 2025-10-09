package Lab_6;

import java.util.Scanner;

public class Triangle extends Shape implements Colorable {
    Scanner sc = new Scanner(System.in);
    @Override
    double area(){
        System.out.println("Enter the length of the Triangle");
        String dim1=sc.nextLine();
        if (Double.parseDouble(dim1)<=0){
            System.out.println("Enter positive input");
            return 0;
        }
        System.out.println("Enter the height of the triangle");
        String dim2=sc.nextLine();
        if (Double.parseDouble(dim2)<=0){
            System.out.println("Enter positive input");
            return 0;
        }
        double area=Double.parseDouble(dim1)*Double.parseDouble(dim2)*0.5;
        return area;
    }
    @Override
    public String colorDescription(String color){
        return "The Triangle is "+color;
    }
    
}
