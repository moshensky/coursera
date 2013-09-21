package com.moshensky;

public class QuickFindUF 
{
	private int[] id;
	
	public QuickFindUF(int n)
	{
		id = new int[n];
		for (int i = 0; i < n; i++)
		{
			id[i] = i;
		}
	}
	
	public boolean connected(int p, int q)
	{
		return (id[p] == id[q]);
	}

	public void union(int p, int q)
	{
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++)
		{
			if (pid == id[i])
			{
				id[i] = qid;
			}
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
		QuickFindUF uf = new QuickFindUF(10);
		
		uf.union(9, 5);
		System.out.println(uf);
		uf.union(8, 7);
		System.out.println(uf);
		uf.union(3, 9);
		System.out.println(uf);
		uf.union(4, 8);
		System.out.println(uf);
		uf.union(7, 0);
		System.out.println(uf);
		uf.union(5, 1);
		System.out.println(uf);
		
		//System.out.println(uf);
	}
	
}
