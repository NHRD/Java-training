public class Percolation{

    public Percolation(int n){
        size = n * n;
        grid = new int [n][n];
        id = new int[size + 2];
        opst = new int[size];
        uf = new WeightedQuickUnionUF(size);

    }

    public void open(int row, int col){

    }

    /*
    public boolean isOpen(int row, int col)
    public boolean isFull(int row, int col)
    public int numberOfOpenSites()
    public boolean percolates() 
    public static void main(String args)*/
}