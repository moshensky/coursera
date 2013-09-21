package com.moshensky;

import com.moshensky.interfaces.IUnionFind;

public class WeightedQuickUnionUF implements IUnionFind
{
    private int[] id;
    private int[] sz;

    public WeightedQuickUnionUF(int n)
    {
        this.id = new int[n];
        this.sz = new int[n];
        for (int i = 0; i < this.id.length; i++)
        {
            this.id[i] = i;
            this.sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        if (this.sz[i] < this.sz[j])
        {
            this.id[i] = j;
            this.sz[j] += this.sz[i];
        }
        else
        {
            this.id[j] = i;
            this.sz[i] += this.sz[j];
        }
    }

    @Override
    public boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }

    @Override
    public int find(int p)
    {
        return root(p);
    }

    @Override
    public int count()
    {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(this.id.length);
        StringBuilder sbsz = new StringBuilder(this.id.length);
        for (int i = 0; i < this.id.length; i++)
        {
            sb.append(this.id[i]);
            sb.append(" ");
            sbsz.append(this.sz[i]);
            sbsz.append(" ");
        }
        
        sb.append("\n");
        sb.append(sbsz);
        
        return sb.toString();
    }
    
    private int root(int i)
    {
        while(i != id[i])
        {
            id[i] = id[id[i]];
            i = id[i];
        }
        
        return i;
    }

}
