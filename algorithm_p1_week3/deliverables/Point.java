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
        if (this.x == 0 && that.x == 0) {
            return Double.POSITIVE_INFINITY;
        }
        if (this.y == 0 && that.y == 0) {
            return +0.0;
        }
        double slope = (that.y - this.y) / (that.y - this.y);
        return slope;
    }

    public Comparator<Point> slopeOrder() {
        public int compare(Point q1, Point q2) {

            double dy1 = slopeTo(q1);
            double dy2 = slopeTo(q2);

            if (q1.x == q2.x && q1.y == q2.y) {
                return Double.NEGATIVE_INFINITY;
            }
            else if (q1.x == 0 && q2.x ==0) {
                return Double.POSITIVE_INFINITY;
            }
            else if (q1.y == 0 && q2.y == 0) {
                return +0.0;
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