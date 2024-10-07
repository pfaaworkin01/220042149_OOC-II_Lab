
public class Square extends Shape {

    private double sideLength;
    private static final String shapeName = "Square";

    public Square(double x, double y, double sideLength) {
        super(x, y);
        this.sideLength = sideLength;
    }

    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public double calculateArea() {
        return sideLength * sideLength;
    }
}

