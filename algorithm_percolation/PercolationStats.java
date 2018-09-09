import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] thresholds;
    private int size;
    private int t;
    private double base = 1.96;
    
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Given N <= 0 || T <= 0");
        }
        size = n;
        t = trials;
        thresholds = new double[t];

        for (int i = 0; i < t; i++) {
            Percolation result = new Percolation(size);
            int row, col;
            int count = 0;
            while (!(result.percolates())) {
                do {
                row = StdRandom.uniform(size) + 1;
                col = StdRandom.uniform(size) + 1;
                } while (result.isOpen(row, col));
                result.open(row, col);
                count++;
            }
            thresholds[i] = (double) count / (double) (size * size);
        }
    }   
    
    public double mean() {
        return StdStats.mean(thresholds);
    }
    
    public double stddev() {
        return StdStats.stddev(thresholds);
    }
    
    public double confidenceLo() {
        return mean() - (base * stddev()/Math.sqrt(t));  
    } 

    public double confidenceHi() {
        return mean() + (base * stddev()/Math.sqrt(t));     
    }            

    public static void main(String[] args) {
        int nu = Integer.parseInt(args[0]);
        int tr = Integer.parseInt(args[1]);
        PercolationStats result = new PercolationStats(nu, tr);
        System.out.printf("mean                     = %f\n", result.mean());
        System.out.printf("stddev                   = %f\n", result.stddev());
        System.out.printf("95%% confidence interval = %f, %f\n", result.confidenceLo(), result.confidenceHi());
    }
 } 