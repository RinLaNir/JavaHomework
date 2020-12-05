package task_2_9;

public class Point {
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point other) {
        if (other == null) return Double.POSITIVE_INFINITY;
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.hypot(dx, dy);
    }

    public static boolean collinear(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y) == 0;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }


    // test client
    public static void main(String[] args) {
        Point p = new Point(0, 0);
        System.out.println("p  = " + p);
        Point q = new Point(1, 1);
        System.out.println("q  = " + q);
        Point r = new Point(2, 2);
        System.out.println("r  = " + r);
        System.out.println("dist(p, r) = " + p.distanceTo(r) + " = " + r.distanceTo(p));
        System.out.println("collinear = " + Point.collinear(p,q,r));
    }
}