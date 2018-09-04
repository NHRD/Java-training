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
        double sum = 0;
        double mean = 0;
        for(int i=0;i < thresholds.length; i++){
            sum = sum + threshold[i];
        }
        mean = sum / threshold.length;
        return mean;
    }
    
    public double stddev(){
        double sumsq = 0;
        double stdev = 0;
        for(int i=0;i < thresholds.length; i++){
            sumsq = sumsq + (threshold[i] - mean())^2;
        }
        stdev = sumsq / (threshold.length - 1);
    }
    
    public double confidenceLo(){
        double conLo = 0;
        conLo = mean() - (1.96 * stddev()^(1/2)/(threshold.length)^(1/2));
        return conLo;
    } 

    public double confidenceHi(){
        double conHi = 0;
        conLo = mean() + (1.96 * stddev()^(1/2)/(threshold.length)^(1/2));
        return conHi;        
    }            

    public static void main(String[] args){
        PercolationStats result = new PercolationStats(args[1],args[2]);
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