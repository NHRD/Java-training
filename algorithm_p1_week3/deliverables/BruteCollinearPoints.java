public class BruteCollinearPoints {

    private int segNum = 0;
    private LineSegment[] segmentIDs;

    public BruteCollinearPoints(Point[] points) {
        Point slope = new Point();
        segmentIDs = (LineSegment[]) new Object[1];
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                       if (i == j || i == k || i == l || j == k || j == l || k == l) {
                           continue;
                       }
                       Point p = points[i];
                       Point q = points[j];
                       Point r = points[k];
                       Point s = points[l];
                       boundarycheck(p, q, r, s);
                       if (p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(r) == p.slopeTo(s)) {
                            Point[] slopepoints = new Point[] {p, q, r, s};
                            Arrays.sort(slopepoints);
                            segmentIDs[segNum] = new LineSegment[] {slopepoints[0], slopepoints[3]};
                            segNum++;
                        if (segmentIDs.length == segNum) {
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
          return segmentIDs;
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
 }