import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeTest {

    @Test
    public void testSquareArea1() {
        Square square = new Square(1, 1, 4);
        assertEquals(16, square.calculateArea(), 0.01);
    }

    @Test
    public void testSquareArea2() {
        Square square = new Square(2, 2, 2);
        assertEquals(4, square.calculateArea(), 0.01);
    }

    @Test
    public void testRectangleArea1() {
        Rectangle rectangle = new Rectangle(0, 0, 3, 4);
        assertEquals(12, rectangle.calculateArea(), 0.01);
    }

    @Test
    public void testRectangleArea2() {
        Rectangle rectangle = new Rectangle(3, 4, 5, 6);
        assertEquals(30, rectangle.calculateArea(), 0.01);
    }

    @Test
    public void testCircleArea1() {
        Circle circle = new Circle(5, 5, 3);
        assertEquals(28.27, circle.calculateArea(), 0.01);
    }

    @Test
    public void testCircleArea2() {
        Circle circle = new Circle(2, 2, 2);
        assertEquals(12.57, circle.calculateArea(), 0.01);
    }

    @Test
    public void testShapeOrdering1() {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Square(1, 1, 4));
        shapes.add(new Rectangle(0, 0, 3, 4));
        shapes.add(new Circle(5, 5, 3));

        OrderPrinter printer = new OrderPrinter();
        printer.printShapes(shapes);

        assertEquals(12, shapes.get(0).calculateArea(), 0.01);
        assertEquals(16, shapes.get(1).calculateArea(), 0.01);
        assertEquals(28.27, shapes.get(2).calculateArea(), 0.01);
    }

    @Test
    public void testShapeOrdering2() {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Square(2, 2, 2));
        shapes.add(new Rectangle(3, 4, 5, 6));
        shapes.add(new Circle(2, 2, 2));

        OrderPrinter printer = new OrderPrinter();
        printer.printShapes(shapes);

        assertEquals(4, shapes.get(0).calculateArea(), 0.01);
        assertEquals(12.57, shapes.get(1).calculateArea(), 0.01);
        assertEquals(30, shapes.get(2).calculateArea(), 0.01);
    }
}

