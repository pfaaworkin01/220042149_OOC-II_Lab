import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Shape square1 = new Square(1, 1, 4);
        Shape square2 = new Square(2, 2, 2);
        Shape rectangle1 = new Rectangle(0, 0, 3, 4);
        Shape rectangle2 = new Rectangle(3, 4, 5, 6);
        Shape circle1 = new Circle(5, 5, 3);
        Shape circle2 = new Circle(2, 2, 2);

        List<Shape> shapes = new ArrayList<>();
        shapes.add(square1);
        shapes.add(square2);
        shapes.add(rectangle1);
        shapes.add(rectangle2);
        shapes.add(circle1);
        shapes.add(circle2);

        OrderPrinter printer = new OrderPrinter();
        System.out.println("Shapes after sorting: \n");
        printer.printShapes(shapes);

    }
}
