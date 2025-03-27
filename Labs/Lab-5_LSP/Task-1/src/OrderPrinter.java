
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderPrinter {

    private void orderShapes(List<Shape> shapes) {
        Collections.sort(shapes, new Comparator<Shape>() {

            @Override
            public int compare(Shape s1, Shape s2) {

                double areaDifference = s1.calculateArea() - s2.calculateArea();
                if(areaDifference != 0) {
                    if(areaDifference> 0) return 1;
                    else return -1;
                }

                double xDifference = s1.getX() - s2.getX();
                if(xDifference != 0) {
                    if(xDifference > 0) return 1;
                    else return -1;
                }

                double yDifference = s1.getY() - s2.getY();
                if(yDifference != 0) {
                    if(yDifference > 0) return 1;
                    else return -1;
                }

                return 0;
            }
        });
    }

    public void printShapes(List<Shape> shapes) {
        orderShapes(shapes);

        for(Shape shape : shapes) {
            System.out.println("Shape           : " + shape.getShapeName());
            System.out.println("Area            : " + shape.calculateArea());
            System.out.println("X Co-ordinate   : " + shape.getX());
            System.out.println("Y Co-ordinate   : " + shape.getY() + "\n");
        }
    }

}