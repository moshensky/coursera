package com.moshensky;

import com.moshensky.interfaces.IUnionFind;

public class QuickFindUF implements IUnionFind
{
    private int[] id;

    public QuickFindUF(int n)
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
        int oldP = this.id[p];
        for (int i = 0; i < this.id.length; i++)
        {
            if (oldP == this.id[i])
            {
                this.id[i] = id[q];
            }
        }
    }

    @Override
    public boolean connected(int p, int q)
    {
        boolean result = this.id[p] == this.id[q];
        return result;
    }

    @Override
    public int find(int p)
    {
        return this.id[p];
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
        return  sb.toString();
    }

}
