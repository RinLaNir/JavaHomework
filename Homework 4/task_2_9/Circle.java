package task_2_9;

import java.util.Arrays;
import java.util.Comparator;

public class Circle {
    private final Point center;
    private final double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

    // test client
    public static void main(String[] args) {
        Point center = new Point(1, 1);
        Circle circle = new Circle(center, 1);
        System.out.println("center: " + circle);
        System.out.println("area: " + circle.area());
        System.out.println("perimeter: " + circle.perimeter());
        Circle[] circles = {new Circle(new Point(0,0),1),
                new Circle(new Point(1,1),2),
                new Circle(new Point(1,4),5),
                new Circle(new Point(3,3),0.5),
                new Circle(new Point(-1,-2),3)};
        System.out.println("Max area: " + Arrays.stream(circles).max(Comparator.comparingDouble(Circle::area)));
        System.out.println("Min area: " + Arrays.stream(circles).min(Comparator.comparingDouble(Circle::area)));
        System.out.println("Max perimeter: " + Arrays.stream(circles).max(Comparator.comparingDouble(Circle::perimeter)));
        System.out.println("Min perimeter: " + Arrays.stream(circles).min(Comparator.comparingDouble(Circle::perimeter)));
    }
}

