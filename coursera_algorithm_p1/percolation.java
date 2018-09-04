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
        opst = new int[size];
        uf = new WeightedQuickUnionUF(size + 2);

    }

    public void open(int row, int col){

        int num = rc2id(row, col);
        open[num] = 1;
    }

    public makeconnection(int row, int col){
        if(col == 1){
            int id = rc2id(row, 1);
            uf.union(id , topid);
        }else if(col == width){
            int id = rc2id(row, width);
            uf.union(id, size + 2);
        }else{
            int id = rc2id(row, col);
            int idu = rc2id(row, col - 1);
            int idl = rc2id(row, col + 1);
            attemptunion(id, idu);
            attemptunion(id, idl);
        }
    }

    public int rc2id(int row, int col){
        num = (col - 1) * n + row;
        return num;
    }

    public void attemptunion(int i, int j){
        if(isOpen(i , j) == true){
            uf.union(i , j);
        }
    }

    public boolean isOpen(int row, int col){
        int num = rc2id(row, col);
        return (open[num] == 1);
    }
    
    public boolean isFull(int row, int col){
        int num = rc2id(row, col);
        return (uf.connected(topid, num));
    }
    
    public int numberOfOpenSites(){
        int num = 0;
        for(int i = 0; i < open.length; I++){
                if(open[i] == 1){
                    num = num + 1;
                }
        }
        return num;
    }
    
    public boolean percolates() {
        return uf.connected(topid, size + 1);
    }
    /*
    public static void main(String args)*/
}