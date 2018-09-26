import java.util.Arrays;

public class FastCollinearPoints {
    
    private LineSegment[] segments;
    private LineSegment[] segSlope;
    private int segNum = 0;
    
    public FastCollinearPoints(Point[] points) {
        segments = new LineSegment[1];
        int k = 0;
        int l = 0;
        for (int i = 0; i < points.length; i++) {
            Point p = points[i];
            boundarycheck(p);
            int m = 0;
            for (int j = 0; j < points.length - 1; j++) {
                Point q = points[j];
                boundarycheck(q);
                if (q == p) {
                    continue;
                } else {
                    segSlope[m] = q;
                    m++;
                }
            Arrays.sort(segSlope);
            while (k <= segSlope.length && l <= segSlope.length) {
                while (segSlope[k] == segSlope[l]) {
                    l++;
                }
                if ((l - k) > 2) {
                    segments[segNum] = new LineSegment[] {points[i], segSlope[l]};
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

    private void boundarycheck(Point p) {
        if (p == null) {
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
 }