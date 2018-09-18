import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int size;
    private int width;
    private boolean[] open;
    private int topid = 0;
    private WeightedQuickUnionUF uf;

    public Percolation(int n) {
        width = n;
        size = n * n;
        open = new boolean[size];
        uf = new WeightedQuickUnionUF(size + 2);
    }

    public void open(int row, int col) {
        boundarycheck(row, col);
        int num = rc2id(row, col);
        open[num-1] = true;
        makeconnection(row, col);
    }
    
    private void makeconnection(int row, int col) {
        boundarycheck(row, col);
        if (row == 1) {
            int id = rc2id(1, col);
            int idl = rc2id(2, col);
            attemptunion(id, topid);
            if (isOpen(2, col)) {
                attemptunion(id, idl);
                }
            }
        else if (row == width) {
            int id = rc2id(width, col);
            int idu = rc2id(width - 1, col);
            attemptunion(id, size + 1);
            if (isOpen(width - 1, col)) {
                attemptunion(id, idu);
                }
            }
        else {
            int id = rc2id(row, col);
            int idu = rc2id(row - 1, col);
            int idl = rc2id(row + 1, col);
            if (isOpen(row - 1, col)) {
                attemptunion(id, idu);
                }
            if (isOpen(row + 1, col)) {
                attemptunion(id, idl);
                }
            }
        if (col == 1) {
            int id = rc2id(row, 1);
            int idr = rc2id(row, 2);
            if (isOpen(row, 2)) {
                attemptunion(id, idr);
                }
            }
        else if (col == width) {
            int id = rc2id(row, width);
            int idl = rc2id(row, width - 1);
            if (isOpen(row, width -1)) {
                attemptunion(id, idl);
                }
            }
        else {
            int id = rc2id(row, col);
            int idl = rc2id(row, col - 1);
            int idr = rc2id(row, col + 1);
            if (isOpen(row, col - 1)) {
                attemptunion(id, idl);
            }
            if (isOpen(row, col + 1)) {
                attemptunion(id, idr);
            }
        }
    }

    private int rc2id(int row, int col) {
        boundarycheck(row, col);
        int num = (row - 1) * width + col;
        return num;
    }

    private void attemptunion(int i, int j) {
        if (!(uf.connected(i, j))) {
            uf.union(i, j);
        }
    }

    public boolean isOpen(int row, int col) {
        boundarycheck(row, col);
        int num = rc2id(row, col);
        return open[num-1];
    }
    
    public boolean isFull(int row, int col) {
        boundarycheck(row, col);
        int num = rc2id(row, col);
        if (open[num - 1]) {
            return (uf.connected(topid, num));
        }
        else {
            return false;
        }
    }
    
    public int numberOfOpenSites() {
        int num = 0;
        for (int i = 0; i < open.length; i++) {
                if (open[i]) {
                    num = num + 1;
                }
        }
        return num;
    }
    
    public boolean percolates() {
        return uf.connected(topid, size + 1);
    }

    private void boundarycheck(int row, int col) {
        if (row <= 0 || row > width) {
          throw new java.lang.IllegalArgumentException("row index row is out of bounds");
        }
        if (col <= 0 || col > width) {
          throw new java.lang.IllegalArgumentException("colum index col is out of bounds");
        }
      }
}