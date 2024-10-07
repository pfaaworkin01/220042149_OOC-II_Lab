public class Circle extends Shape {

    private double radius;
    private static final String shapeName = "Circle";

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public double calculateArea() {
        double result = Math.PI * radius * radius;
        return Math.round(result * 100.0) / 100.0;
    }

}
