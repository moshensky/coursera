
public class Percolation 
{
    private int n;
    private int top;
    private int bottom;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF ufPerc;
    private byte[] site; // 0 - closed site, 1 - open site, 2 - full site;
    
    // create N-by-N grid, with all sites blocked
    public Percolation(int N)              
    {
        n = N;
        uf = new WeightedQuickUnionUF(n*n + 2);
        ufPerc = new WeightedQuickUnionUF(n*n + 2);
        site = new byte[n*n];
        top = n*n;
        bottom = n*n + 1;
    }
    
    // open site (row i, column j) if it is not already
    public void open(int i, int j)         
    {
        isInBounds(i, j);
        if (isOpen(i, j))
        {
            return;
        }
        int currentSite = convert2dTo1dCoord(i, j); 
        this.site[currentSite] = 1;
        
        // union with top virtuall cell
        if (i == 1 && !uf.connected(currentSite, top))
        {
            uf.union(currentSite, top);
            ufPerc.union(currentSite, top);
        }
        
        
        // union with bottom artificial cell
        if (i == n)
        {
            ufPerc.union(currentSite, bottom);
        }
        
        
        // union with bottom cell
        if (i < n)
        {
            if (isOpen(i+1, j))
            {
                uf.union(currentSite, convert2dTo1dCoord(i+1, j));
                ufPerc.union(currentSite, convert2dTo1dCoord(i+1, j));
            }
        }
        // union with upper cell
        if (i > 1)
        {
            if (isOpen(i-1, j))
            {
                uf.union(currentSite, convert2dTo1dCoord(i-1, j));
                ufPerc.union(currentSite, convert2dTo1dCoord(i-1, j));
            }
        }
        // union with left cell
        if (j > 1)
        {
            if (isOpen(i, j-1))
            {
                uf.union(currentSite, convert2dTo1dCoord(i, j-1));
                ufPerc.union(currentSite, convert2dTo1dCoord(i, j-1));
            }
        }
        // union with left cell
        if (j < n)
        {
            if (isOpen(i, j+1))
            {
                uf.union(currentSite, convert2dTo1dCoord(i, j+1));
                ufPerc.union(currentSite, convert2dTo1dCoord(i, j+1));
            }
        }
    }
    
    private boolean isInBounds(int i, int j)
    {
        if (i < 1 || i > n || j < 1 || j > n)
        {
            throw new IndexOutOfBoundsException();
        }
        return true;
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j)    
    {
        isInBounds(i, j);
        if (site[convert2dTo1dCoord(i, j)] == 1)
            return true;
        return false;
    }
    
    // is site (row i, column j) full?
    public boolean isFull(int i, int j)    
    {
        isInBounds(i, j);
        if (!isOpen(i, j))
            return false;
        int currentSite = convert2dTo1dCoord(i, j);
        if (uf.connected(top, currentSite))
            return true;
        return false;
    }

    private int convert2dTo1dCoord(int i, int j)
    {
        int pos = n*(i - 1) + j - 1;
        return pos;
    }
    
    // does the system percolate?
    public boolean percolates()            
    {
        if (ufPerc.connected(top, bottom))
            return true;
        return false;
    }
}