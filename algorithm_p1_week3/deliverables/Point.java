import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }   

    public int compareTo(Point that) {
        if (this.y < that.y) {
            return -1;
        }
        else if (this.y == that.y && this.x < that.x) {
            return -1;
        }
        else if (this.y == that.y && this.x == that.x) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public double slopeTo(Point that) {
        double slope = 0.0;
        if (this.y == that.y && this.x == that.x) {
            return Double.NEGATIVE_INFINITY;
        }
        else if (this.x == that.x) {
            return Double.POSITIVE_INFINITY;
        }
        else if (this.y == that.y) {
            return +0.0;
        } 
        else {
            return (double) (that.y - this.y) / (that.x - this.x);
        }
    }

    public Comparator<Point> slopeOrder() {
        return new SlopeOrder();
    }

    private class SlopeOrder implements Comparator<Point> {
        public int compare(Point p1, Point p2) {

            double dy1 = slopeTo(p1);
            double dy2 = slopeTo(p2);

            if (dy1 == dy2) {
                return 0;
            }
            else if (dy2 > dy1) {
                return -1;
            }
            else {
                return 1;
            }
        }
    }
    
}