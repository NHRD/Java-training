import java.util.Arrays;

public class BruteCollinearPoints {

    private int segNum = 0;
    private Object[] newSegment;
    private LineSegment[] segments;

    public BruteCollinearPoints(Point[] points) {
        nullcheck(points);
        boundarycheck(points);
        newSegment = new Object[points.length];
        int n = points.length;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    for (int l = k + 1; l < n; l++) {
                        Point p = points[i];
                        Point q = points[j];
                        Point r = points[k];
                        Point s = points[l];
                         if (p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(r) == p.slopeTo(s)) {
                            Point[] slopepoints = new Point[] {p, q, r, s};
                            Arrays.sort(slopepoints, 0, slopepoints.length);
                            newSegment[segNum] = new LineSegment(slopepoints[0], slopepoints[3]);
                            segNum++;
                        }
                        else {
                           continue;
                       }
                    }
                }
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
            throw new IllegalArgumentException("The Point array cannot be null.");
        } 
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException("One of the points is null.");
            }
        }
    }

}