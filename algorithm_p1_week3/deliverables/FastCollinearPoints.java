import java.util.Arrays;

public class FastCollinearPoints {
   
    private int segNum = 0;
    private Object[] newSegment;
    private LineSegment[] segments;
    private Point[] segSlope;
    
    public FastCollinearPoints(Point[] points) {
        nullcheck(points);
        boundarycheck(points);
        newSegment = new Object[points.length];
        segSlope = new Point[points.length];
        int k = 0;
        int l = 1;
        /*for (int i = 0; i < points.length; i++) {
            Point p = points[i];
            for (int j = 0; j < points.length; j++) {
                Point q = points[j];
                if (!(j == i)) {
                    segSlope[m] = q;
                    m++;
                }
            }*/
        Point[] pointsCopy = new Point[points.length];
        System.arraycopy(points, 0, pointsCopy, 0, points.length);
        Arrays.sort(pointsCopy);
        for (int i = 0; i < points.length; i++) {
            Point p = pointsCopy[i];
            Point[] segSlope = new Point[pointsCopy.length - i - 1];
            System.arraycopy(pointsCopy, i + 1, segSlope, 0, pointsCopy.length - i - 1);
            Arrays.sort(segSlope, 0, segSlope.length, p.slopeOrder());
            while (k < segSlope.length && l < segSlope.length) {
                while (segSlope[k] == segSlope[l]) {
                    l++;
                }
                if ((l - k) > 2) {
                    newSegment[segNum] = new LineSegment(points[k], segSlope[l]);
                    segNum++;
                } 
                k++;
                l = k + 1;
            }
        }
    }

    public int numberOfSegments() {
        return segNum;
    }

    public LineSegment[] segments() {
        segments = new LineSegment[segNum];
        for (int i = 0; i < segNum; i++) {
            segments[i] = (LineSegment) newSegment[i];
        }
        return segments;
    }
        
    private void boundarycheck(Point[] points) {
        if (points.length > 0) {
            Point[] pointsCopy = new Point[points.length];
            System.arraycopy(points, 0, pointsCopy, 0, points.length);
            Arrays.sort(pointsCopy);
            Point currentPoint = pointsCopy[0];
            for (int i = 1; i < pointsCopy.length; i++) {
                if (pointsCopy[i].compareTo(currentPoint) == 0) {
                    throw new IllegalArgumentException("Cannot have duplicate points.");
                } else {
                    currentPoint = pointsCopy[i];
                }
            }
        }
    }
    
    private void nullcheck(Point[] points) {
        if (points == null) {
            throw new NullPointerException("The Point array cannot be null.");
        } 
        else {
            for (Point p : points) {
                if (p == null) {
                    throw new NullPointerException("One of the points is null.");
                }
            }
        }
    }
}