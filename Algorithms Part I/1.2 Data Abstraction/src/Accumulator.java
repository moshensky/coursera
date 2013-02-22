
public class Accumulator
{
    private double total;
    private int n;
    
    // add a new data value
    public void addDataValue(double val)
    {
        total += val;
        n++;
        
    }
    
    // mean of all data values
    public double mean()
    {
        return total / n;
    }
    
    // string representation
    public String toString()
    {
        return "Mean (" + n + " values): " + String.format("%7.5f", mean());
    }
    
    // test accumulator 
    public static void main(String[] args)
    {
        int T = 10000000; //Integer.parseInt(args[0]);
        Accumulator a = new Accumulator();
        for (int t = 0; t < T; t++)
            a.addDataValue(Math.random());
        System.out.println(a);
    }
}
