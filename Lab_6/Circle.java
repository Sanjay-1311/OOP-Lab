package Lab_6;

public class Circle extends Shape implements Colorable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return 3.14 * radius * radius;
    }

    @Override
    public String colorDescription(String color) {
        return "The circle is " + color;
    }
}
