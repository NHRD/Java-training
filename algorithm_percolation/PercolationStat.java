public class PercolationStats {

    private double[] thresholds;
    private int size;
    private int t;
    
    public PercolationStats(int n, int trials) {
        size = n;
        t = trials;
        thresholds = new double[t];

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
            thresholds[i] = count / (size * size) ;
        }
    }   
    
    public double mean(){
        return StdStats.mean(thresholds);
    }
    
    public double stddev(){
        return StdStats.stddev(thresholds);
    }
    
    public double confidenceLo(){
        return mean() - (1.96 * Math.pow(stddev() , 1/2))/Math.pow(t,1/2);
    } 

    public double confidenceHi(){
        return mean() + (1.96 * Math.pow(stddev() , 1/2))/Math.pow(t,1/2);     
    }            

    public static void main(String[] args){
        //int N = Integer.parseInt(args[0]);
        //int T = Integer.parseInt(args[1]);
        int N = 10;
        int T = 10;
        PercolationStats result = new PercolationStats(N, T);
        double mean = result.mean();
        double stdev = result.stddev();
        double[] confidence = new double[2];
        confidence[0] = result.confidenceLo();
        confidence[1] = result.confidenceHi();
        System.out.println(mean);
        System.out.println(stdev);
        System.out.println(confidence);
    }
 }