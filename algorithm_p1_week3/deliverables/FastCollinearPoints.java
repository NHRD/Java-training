import java.util.Arrays;

public class FastCollinearPoints {
    
    private LineSegment[] segments;
    private Point[] segSlope;
    private int segNum = 0;
    
    public FastCollinearPoints(Point[] points) {
        boundarycheck(points);
        segments = new LineSegment[1];
        int k = 0;
        int l = 0;
        for (int i = 0; i < points.length; i++) {
            Point p = points[i];
            int m = 0;
            for (int j = 0; j < points.length - 1; j++) {
                Point q = points[j];
                if (q == p) {
                    continue;
                } else {
                    segSlope[m] = q;
                    m++;
                }
            }
            Arrays.sort(segSlope);
            while (k <= segSlope.length && l <= segSlope.length) {
                while (segSlope[k] == segSlope[l]) {
                    l++;
                }
                if ((l - k) > 2) {
                    LineSegment newSegment = new LineSegment(points[i], segSlope[l]);
                    segments[segNum] = newSegment;
                    segNum++;
                } 
                if (segments.length == segNum) {
                    resize(segNum * 2);
                k = l;
                }
            }
        }
    }

    public int numberOfSegments() {
        return segNum;
    }

    public LineSegment[] segments() {
        return segments;
    }

    private void boundarycheck(Point[] points) {
        Point[] pointsCopy = new Point[points.length];
        System.arraycopy(points, 0, pointsCopy, 0, points.length);
        int current = 0;
        while (current < points.length) {
            for (int i = current + 1; i < pointsCopy.length; i++) {
                if (pointsCopy[i] == null) {
                    throw new java.lang.IllegalArgumentException("Null error.");
                }
                else if (points[current] == pointsCopy[i]) {
                    throw new java.lang.IllegalArgumentException("Duplicate error.");
                }
            }
            current++;
        }
    }

    private void resize(int size) {
        LineSegment[] copy = (LineSegment[]) new Object[size];
        for (int i = 0; i < segNum; i++) {
            copy[i] = segments[i];
        }
        segments = copy;
    }
 }