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
        int m = 0;
        /*for (int i = 0; i < points.length; i++) {
            Point p = points[i];
            for (int j = 0; j < points.length; j++) {
                Point q = points[j];
                if (!(j == i)) {
                    segSlope[m] = q;
                    m++;
                }
            }*/
            Point p = points[0];
            Point[] segSlope = new Point[points.length - 1];
            System.arraycopy(points, 1, segSlope, 0, points.length - 1);
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
    /*}

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
        Point[] pointsCopy = new Point[points.length];
        System.arraycopy(points, 0, pointsCopy, 0, points.length);
        int current = 0;
        while (current < points.length) {
            for (int i = current + 1; i < pointsCopy.length; i++) {
                if (points[current] == pointsCopy[i]) {
                    throw new java.lang.IllegalArgumentException("Duplicate error.");
                }
            }
            current++;
        }
    }
    
    private void nullcheck(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new java.lang.IllegalArgumentException("Null error.");
            }
        }
    }
}