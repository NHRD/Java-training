public class BruteCollinearPoints {

    private int segNum = 0;
    private LineSegment[] segment;

    public BruteCollinearPoints(Point[] points) {
        Point slope = new Point();
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
                       if (p.slopeTo(q) == p.slopeTo(r) && p.slopeTo(r) == p.slopeTo(s)) {
                           segNum++;
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
          
    }               
 }