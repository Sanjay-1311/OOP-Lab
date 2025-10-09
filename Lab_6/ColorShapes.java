package Lab_6;

import java.io.PrintWriter;

public class ColorShapes {
    static PrintWriter logWriter;

    public static void main(String[] args) {
        java.util.Random rand = new java.util.Random();
        String[] colors = { "Red", "Blue", "Green", "Yellow", "Purple" };
        Shape[] shapes = new Shape[3];
        shapes[0] = new Rectangle();
        shapes[1] = new Triangle();
        shapes[2] = new Circle();
        System.out.println("\n--- Shape Details ---");
        for (Shape s : shapes) {
            double a = s.area();
            s.displayInfo(a, s.getClass().getSimpleName());
            System.out.println(((Colorable) s).colorDescription(colors[rand.nextInt(colors.length)]));
            System.out.println();
        }
    }
}