using System;

namespace Week_1_Mergesort
{
    public class Program
    {
        public static void Main(string[] args)
        {
            int[] array = new int[] { 5, 4, 3, 2, 6, 3, 66 };
            array = MergeSort(array);

            foreach (var item in array)
            {
                Console.Write(item);
                Console.Write(" ");
            }
        }

        private static int[] MergeSort(int[] array)
        {
            if (array.Length == 0 || array.Length == 1)
            {
                return array;
            }

            int half = array.Length / 2;
            int[] right = new int[half];
            Array.Copy(array, right, half);
            int[] left = new int[array.Length - half];
            Array.Copy(array, half, left, 0, left.Length);

            right = MergeSort(right);
            left = MergeSort(left);

            array = Merge(right, left);
            return array;
        }

        private static int[] Merge(int[] right, int[] left)
        {
            int[] array = new int[right.Length + left.Length];

            int k = 0;
            int m = 0;
            for (int i = 0; i < array.Length; i++)
            {
                if (k >= right.Length)
                {
                    array[i] = left[m];
                    m += 1;
                    continue;
                }

                if (m >= left.Length)
                {
                    array[i] = right[k];
                    k += 1;
                    continue;
                }

                if (right[k] > left[m])
                {
                    array[i] = left[m];
                    m += 1;
                }
                else
                {
                    array[i] = right[k];
                    k += 1;
                }
            }

            return array;
        }
        
    }
}
