
/*Question 2  A class called MyPoint, which models a 2D point with x and y coordinates, is designed as follows:
    • Two instance variables x (int) and y (int).
    • A default (or "no-arg") constructor that construct a point at the default location of (0, 0).
    • A overloaded constructor that constructs a point with the given x and y coordinates.
    • A method setXY() to set both x and y.
    • A method getXY() which returns the x and y in a 2-element int array. A toString()
      method that returns a string description of the instance in the format "(x, y)".
    • A method called distance(int x, int y) that returns the distance from this point to
      another point at the given (x, y) coordinates.
    • An overloaded distance(MyPoint another) that returns the distance from this point to
      the given MyPoint instance (called another).
    • Another overloaded distance() method that returns the distance from this point to the
      origin (0,0) Develop the code for the class MyPoint.
    Develop the code for the class MyPoint. Also develop a JAVA program (called
    TestMyPoint) to test all the methods defined in the class.
*/

class MyPoint {
    int x, y;

    MyPoint() {
        x = 0;
        y = 0;
    }

    MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int[] getXY() {
        return new int[]{x, y};
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    double distance(int x, int y) {
        return Math.sqrt(Math.pow(this.x - x, 2)
                + Math.pow(this.y - y, 2));
    }

    double distance(MyPoint another) {
        return distance(another.x, another.y);
    }

    double distance() {
        return distance(0, 0);
    }
}

public class TestMyPoint {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint();
        MyPoint p2 = new MyPoint(3, 4);

        System.out.println("Default point: " + p1);
        System.out.println("Parameterized point: " + p2);

        p1.setXY(1, 2);
        System.out.println("After setXY: " + p1);

        System.out.println("Coordinates: "
                + java.util.Arrays.toString(p1.getXY()));

        System.out.println("Distance from (1, 2) to (5, 6): "
                + p1.distance(5, 6));

        System.out.println("Distance between p1 and p2: "
                + p1.distance(p2));

        System.out.println("Distance from p2 to origin: "
                + p2.distance());
    }
}
