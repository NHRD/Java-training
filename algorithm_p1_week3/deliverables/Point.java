import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

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
        if (this.x == that.x) {
            return Double.POSITIVE_INFINITY;
        }
        if (this.y == that.y) {
            return +0.0;
        }
        double slope = (that.y - this.y) / (that.y - this.y);
        return slope;
    }

    public Comparator<Point> slopeOrder() {
        public int compare(Point q1, Point q2) {

            double dy1 = slopeTo(q1);
            double dy2 = slopeTo(q2);

            if (dy1 == 0 && dy2 ==0) {
                return Double.NEGATIVE_INFINITY;
            }
            else if (dy1 >= 0 && dy2 < 0) {
                return -1;
            }
            else if (dy2 >= 0 && dy1 < 0) {
                return +1;
            }
        }
    }
}