public class FastCollinearPoints {
    
    private LineSegment[] segments;
    private LineSegment[] segSlope;
    private int segNum = 0;
    
    public FastCollinearPoints(Point[] points) {
        segments = new LineSegment[1];
        for (int i = 0; i < points.length; i++) {
            Point p = points[i];
            for (int j = 0; j < points.length - 1; j++) {
                Point q = points[j];
                if (q == p) {
                    continue;
                }
                else {
                    segSlope[j] = q;
                }
            Arrays.sort(segSlope);
            int k = 0;
            int l = 0;
            while (k <= segSlope.length && l <= segSlope.length)
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
            copy[i] = segmentIDs[i];
        }
        segmentIDs = copy;
    }
    
    private checkDuplicatePoints(Point[] points) {
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