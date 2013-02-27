
public class _05_BinaryRepresentationOfN
{
    public static void main(String[] args)
    {
        Stack<Byte> stack = new Stack<Byte>();
        int N = 255;
        while (N > 0)
        {
            stack.push((byte)(N % 2));
            N /= 2;
        }
        for (Byte n : stack)
        {
            System.out.print(n);
        }
    }

}
