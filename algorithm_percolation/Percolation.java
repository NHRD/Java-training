import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation{

    private int size;
    private int width;
    private int[] open;
    private int topid;
    private WeightedQuickUnionUF uf;

    public Percolation(int n){
        topid = 0;
        size = n * n;
        width = n;
        open = new int[size];
        uf = new WeightedQuickUnionUF(size + 2);

    }

    public void open(int row, int col){
        boundarycheck(row, col);
        int num = rc2id(row, col);
        open[num-1] = 1;
        makeconnection(row, col);
    }
    
    private void makeconnection(int row, int col){
        boundarycheck(row, col);
        if(col == 1){
            int id = rc2id(row, 1);
            int idl = rc2id(row, 2);
            uf.union(id , topid);
            uf.union(id, idl);
        }else if(col == width){
            int id = rc2id(row, width);
            int idu = rc2id(row, width - 1);
            uf.union(id, size + 2);
            uf.union(id, idu);
        }else{
            int id = rc2id(row, col);
            int idu = rc2id(row, col - 1);
            int idl = rc2id(row, col + 1);
            attemptunion(id, idu);
            attemptunion(id, idl);
        }
        if(row == 1){
            int id = rc2id(1, col);
            int idr = rc2id(2 , col);
            uf.union(id , idr);
        }else if(row == width){
            int id = rc2id(row, width);
            int idl = rc2id(row, width - 1);
            uf.union(id, idl);
        }else{
            int id = rc2id(row, width);
            int idl = rc2id(row - 1, col);
            int idr = rc2id(row + 1, col);
            attemptunion(id, idl);
            attemptunion(id, idr);
        }
    }

    public int rc2id(int row, int col){
        boundarycheck(row, col);
        int num = (col - 1) * width + row;
        return num;
    }

    public void attemptunion(int i, int j){
        if(isOpen(i , j) == true){
            uf.union(i , j);
        }
    }

    public boolean isOpen(int row, int col){
        boundarycheck(row, col);
        int num = rc2id(row, col);
        return (open[num-1] == 1);
    }
    
    public boolean isFull(int row, int col){
        boundarycheck(row, col);
        int num = rc2id(row, col);
        return (uf.connected(topid, num));
    }
    
    public int numberOfOpenSites(){
        int num = 0;
        for(int i = 0; i < open.length; i++){
                if(open[i] == 1){
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