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
        if (this.y == that.y && this.x < that.x) {
            return -1;
        }
        if (this.y == that.y && this.x == that.x) {
            return 0;
        }
        return 1;
    }

    public double slopeTo(Point that) {
        if (this.y == that.y && this.x == that.y) {
            return Double.NEGATIVE_INFINITY;
        }
        if (this.x == 0 && that.x == 0) {
            return Double.POSITIVE_INFINITY;
        }
        if (this.y == 0 && that.y == 0) {
            return +0.0;
        } 
        else {
            double slope = (that.y - this.y) / (that.y - this.y);
            return slope;
        }
    }

    public Comparator<Point> slopeOrder() {
        return new SlopeOrder();
    }

    private class SlopeOrder implements Comparator<Point> {
        public int compare(Point q1, Point q2) {

            double dy1 = slopeTo(q1);
            double dy2 = slopeTo(q2);

            if (dy1 == dy2) {
                return 0;
            }
            else if (dy2 > dy1){
                return -1;
            }
            else {
                return 1;
            }
        }
    }
    
}