
/*Question 7
Design a Java program to model basic geometric calculations using interfaces.
    1. Create two interfaces:
        CircleOps — containing methods to compute circle area and perimeter.
        RectangleOps — containing methods to compute rectangle area and perimeter.
    2. Create a third interface named ShapeOps that inherits both CircleOps and
       RectangleOps, and adds an additional method for displaying a summary.
    3. Create a base class named ShapeBase representing common shape information.
    4. Implement the ShapeOps interface in a class called ShapeCalculator, which also
       extends ShapeBase.
    5. Write three separate methods in another class (e.g., ShapesDemo), each accepting
       one of the interface types (CircleOps, RectangleOps, and ShapeOps) as a parameter.
    6. In main(), create an object of ShapeCalculator and pass it to each method to
       demonstrate polymorphism.
*/

interface CircleOps {
    double circleArea();
    double circlePerimeter();
}

interface RectangleOps {
    double rectangleArea();
    double rectanglePerimeter();
}

interface ShapeOps extends CircleOps, RectangleOps {
    void displaySummary();
}

class ShapeBase {
    String shapeName;

    ShapeBase(String shapeName) {
        this.shapeName = shapeName;
    }
}

class ShapeCalculator extends ShapeBase implements ShapeOps {
    double radius;
    double length;
    double width;

    ShapeCalculator(double radius, double length, double width) {
        super("Circle and Rectangle");
        this.radius = radius;
        this.length = length;
        this.width = width;
    }

    public double circleArea() {
        return Math.PI * radius * radius;
    }

    public double circlePerimeter() {
        return 2 * Math.PI * radius;
    }

    public double rectangleArea() {
        return length * width;
    }

    public double rectanglePerimeter() {
        return 2 * (length + width);
    }

    public void displaySummary() {
        System.out.println("Shape Summary");
        System.out.println("Circle Radius: " + radius);
        System.out.println("Circle Area: " + circleArea());
        System.out.println("Circle Perimeter: " + circlePerimeter());
        System.out.println("Rectangle Length: " + length);
        System.out.println("Rectangle Width: " + width);
        System.out.println("Rectangle Area: " + rectangleArea());
        System.out.println("Rectangle Perimeter: " + rectanglePerimeter());
    }
}

public class ShapesDemo {

    static void showCircle(CircleOps c) {
        System.out.println("Circle Area: " + c.circleArea());
        System.out.println("Circle Perimeter: " + c.circlePerimeter());
    }

    static void showRectangle(RectangleOps r) {
        System.out.println("Rectangle Area: " + r.rectangleArea());
        System.out.println("Rectangle Perimeter: " + r.rectanglePerimeter());
    }

    static void showShape(ShapeOps s) {
        s.displaySummary();
    }

    public static void main(String[] args) {
        ShapeCalculator obj = new ShapeCalculator(5, 10, 4);

        System.out.println("Using CircleOps reference:");
        showCircle(obj);

        System.out.println("\nUsing RectangleOps reference:");
        showRectangle(obj);

        System.out.println("\nUsing ShapeOps reference:");
        showShape(obj);
    }
}
