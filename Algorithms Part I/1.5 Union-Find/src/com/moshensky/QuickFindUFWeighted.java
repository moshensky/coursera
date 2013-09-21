package com.moshensky;

public class QuickFindUFWeighted 
{
	private int[] id;
	private int[] sz; // tree size
	
	public QuickFindUFWeighted(int n)
	{
		id = new int[n];
		sz = new int[n];
		for (int i = 0; i < n; i++)
		{
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	private int root(int i) 
	{
		while (i != id[i])
		{
			i = id[i];
		}
		return i;
	}

	public boolean connected(int p, int q) 
	{
		return root(p) == root(q);
	}

	public void union(int p, int q) 
	{
		int i = root(p);
		int j = root(q);
		if (sz[i] < sz[j]) 
		{ 
			id[i] = j; 
			sz[j] += sz[i]; 
		}
		else 
		{ 
			id[j] = i; 
			sz[i] += sz[j]; 
		}
	}
	
	public String toString()
	{
		String str = "";
		for (int i = 0; i < id.length; i++)
		{
			str += (id[i] + " ");
		}
		return str;
	}
	
	public static void main(String[] str)
	{
		QuickFindUFWeighted uf = new QuickFindUFWeighted(10);
		
		uf.union(2, 4);
		System.out.println(uf);
		uf.union(4, 0);
		System.out.println(uf);
		uf.union(4, 7);
		System.out.println(uf);
		uf.union(5, 6);
		System.out.println(uf);
		uf.union(0, 3);
		System.out.println(uf);
		uf.union(4, 8);
		System.out.println(uf);
		uf.union(9, 1);
		System.out.println(uf);
		uf.union(5, 9);
		System.out.println(uf);
		uf.union(3, 1);
		System.out.println(uf);
	}
}
