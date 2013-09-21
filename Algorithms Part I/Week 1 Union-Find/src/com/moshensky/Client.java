package com.moshensky;

import com.moshensky.interfaces.IUnionFind;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class Client
{
    public static void main(String[] args)
    {
        In in = new In(args[0]);
        int n = in.readInt();
        //IUnionFind uf = new QuickFindUF(n);
        //IUnionFind uf = new QuickUnionUF(n);
        IUnionFind uf = new WeightedQuickUnionUF(n);
        while (!in.isEmpty())
        {
            int p = in.readInt();
            int q = in.readInt();
            if (!uf.connected(p,q))
            {
                uf.union(p, q);
                StdOut.println(p + " " + q);
                StdOut.println(uf);
            }
        }
        
        StdOut.println(uf);
    }
}
