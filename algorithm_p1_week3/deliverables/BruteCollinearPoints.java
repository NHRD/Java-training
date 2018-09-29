import java.util.Arrays;

public class BruteCollinearPoints {

    private int segNum = 0;
    private LineSegment[] segments;

    public BruteCollinearPoints(Point[] points) {
        segments = new LineSegment[1];
        checkDuplicatePoints(points);
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        Point p = points[i];
                        Point q = points[j];
                        Point r = points[k];
                        Point s = points[l];
                        boundarycheck(p, q, r, s);
                        if (p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(r) == p.slopeTo(s)) {
                            Point[] slopepoints = new Point[] {p, q, r, s};
                            Arrays.sort(slopepoints);
                            LineSegment newSegment = new LineSegment(slopepoints[0], slopepoints[3]);
                            segments[segNum] = newSegment;
                            segNum++;
                        if (segments.length == segNum) {
                            resize(segNum * 2);
                        }
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
        return segments;
    }
    
    private void boundarycheck(Point p, Point q, Point r, Point s) {
        if (p == null || q == null || r == null || s == null) {
            throw new java.lang.IllegalArgumentException("null error.");
        }
    }

    private void resize(int size) {
        LineSegment[] copy = (LineSegment[]) new Object[size];
        for (int i = 0; i < segNum; i++) {
            copy[i] = segments[i];
        }
        segments = copy;
    }
    
    private void checkDuplicatePoints(Point[] points) {
        if (points.length > 0) {
            Point[] pointsCopy = new Point[points.length];
            System.arraycopy(points, 0, pointsCopy, 0, points.length);
            Arrays.sort(pointsCopy);
            Point currentPoint = pointsCopy[0];
            for (int i = 1; i < pointsCopy.length; i++) {
                if (pointsCopy[i].compareTo(currentPoint) == 0) {
                    throw new java.lang.IllegalArgumentException("duplicate point error.");
                } else {
                    currentPoint = pointsCopy[i];
                }
            }
        } else {
            throw new java.lang.IllegalArgumentException("null error.");
        }
    }
 }