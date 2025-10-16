package Lab_6;

public class Triangle extends Shape implements Colorable {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double area() {
        return 0.5 * base * height;
    }

    @Override
    public String colorDescription(String color) {
        return "The Triangle is " + color;
    }
}
