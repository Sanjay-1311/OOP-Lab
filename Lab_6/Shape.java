package Lab_6;

public abstract class Shape {
    protected int dim1;
    protected int dim2;
    abstract double area();
    final void displayInfo(double area,String name){
        System.out.println("Shape:"+name+" area:"+area );
    } 
}
