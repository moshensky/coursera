package com.moshensky;

import com.moshensky.interfaces.IUnionFind;

public class QuickUnionUF implements IUnionFind
{

    private int[] id;
    
    public QuickUnionUF(int n)
    {
        this.id = new int[n];
        for (int i = 0; i < this.id.length; i++)
        {
            this.id[i] = i;
        }
    }
    
    @Override
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        this.id[i] = j;
    }

    @Override
    public boolean connected(int p, int q)
    {
        boolean result = root(p) == root(q);
        return result;
    }

    @Override
    public int find(int p)
    {
        int result = root(p);
        return result;
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
        for (int i = 0; i < this.id.length; i++)
        {
            sb.append(this.id[i]);
            sb.append(" ");
        }
        
        return sb.toString();
    }
    
    private int root(int i)
    {
        int parent = this.id[i];
        int current = i;
        while (parent != current)
        {
            current = parent;
            parent = this.id[parent];
        }
        
        return parent;
    }

}
