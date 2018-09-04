public class PercolationStats {
    
    public PercolationStats(int n, int trials) {
        size = n;
        t = trials;
        double[] thresholds = new double[t];

        for(int i = 0; i<t; i++){
            Percolation result = new Percolation(size);
            int row, col;
            int count = 0;
            while(!(result.percolates() == true)){
                do{
                row = StdRandom.uniform(size) + 1;
                col = StdRandom.uniform(size) + 1;
                }while(result.isOpen(row, col));
                result.open(row, col);
                count++;
            }
            thresholds[i] = count;
        }

    }   
    
    public double mean(){
        for(int i=0;i<)
    }
    /*public double stddev()                        // sample standard deviation of percolation threshold
    public double confidenceLo()                  // low  endpoint of 95% confidence interval
    public double confidenceHi()                  // high endpoint of 95% confidence interval
 
    public static void main(String[] args)        // test client (described below)*/
 }