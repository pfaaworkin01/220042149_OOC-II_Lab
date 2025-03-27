
public class Rectangle extends Shape {

    private double length;
    private double width;
    private static final String shapeName = "Rectangle";

    public Rectangle(double x, double y, double length, double width) {
        super(x, y);
        this.length = length;
        this.width = width;
    }

    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

}
