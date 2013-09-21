// 1 3 5 2 4 6 - has 3 inversions 3,2 5,2 5,4
using System;

class Program
{
    static void Main(string[] args)
    {
    }

    private static int Count(int[] array, int n)
    {
        if (n == 1)
        {
            return 0;
        }

        int length = n / 2; 
        int[] left = new int[length];
        int[] right = new int[n - length];

        Array.Copy(array, left, length);
        Array.Copy(array, length, right, length, n);

        int x = Count(left, left.Length);
        int y = Count(right, right.Length);
        int z = CountSplitInv(array, n);

        return x + y + z;
    }

    private static int CountSplitInv(int[] array, int n)
    {
        throw new NotImplementedException();
    }
}
