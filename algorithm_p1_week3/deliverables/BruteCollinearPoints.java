import java.util.Arrays;

public class BruteCollinearPoints {

    private int segNum = 0;
    private Object[] newSegment;
    private LineSegment[] segments;

    public BruteCollinearPoints(Point[] points) {
        boundarycheck(points);
        segments = new LineSegment[1];
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        Point p = points[i];
                        Point q = points[j];
                        Point r = points[k];
                        Point s = points[l];
                        if (p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(q) == p.slopeTo(s)) {
                            Point[] slopepoints = new Point[] {p, q, r, s};
                            Arrays.sort(slopepoints);
                            newSegment[segNum] = new LineSegment(slopepoints[0], slopepoints[3]);
                            segNum++;
                        if (segments.length == segNum) {
                            resize(segNum * 2);
                        }
                       }
                    }
                }
            }
        }
        segments = new LineSegment[segNum];
        for (int i = 0; i < segNum; i++) {
            segments[i] = (LineSegment) newSegment[i];
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