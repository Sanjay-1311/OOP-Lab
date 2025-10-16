package Lab_6;

public class Rectangle extends Shape implements Colorable {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    double area() {
        return length * breadth;
    }

    @Override
    public String colorDescription(String color) {
        return "The rectangle is " + color;
    }
}
