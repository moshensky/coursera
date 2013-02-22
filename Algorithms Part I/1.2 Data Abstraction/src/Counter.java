
public class Counter
{
    private final String name;
    private int count;
    
    // create a counter named id
    public Counter(String id)
    {
        name = id;
    }
    
    // increment the counter by one
    public void increment()
    {
        count++;
    }
    
    // number of increments since creation
    public int tally()
    {
        return count;
    }
    
    // string representation
    public String toString()
    {
        return count + " " + name;
    }
    
    public boolean equals(Object x)
    {
        if (this == x)
            return true;
        if (x == null)
            return false;
        if (this.getClass() != x.getClass())
            return false;
        Counter that = (Counter) x;
        if (that.count != this.count)
            return false;
        return true;
    }
    
    public static void main(String[] args)
    {
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        
        heads.increment();
        heads.increment();
        tails.increment();
        
        System.out.println(heads);
        System.out.println(tails);
        System.out.println(heads.tally() + tails.tally());
    }
}
