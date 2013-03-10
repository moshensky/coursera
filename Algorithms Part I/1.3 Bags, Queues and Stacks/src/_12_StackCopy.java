
public class _12_StackCopy
{
    public static Stack<String> Copy(Stack<String> stack)
    {
        Stack<String> copy = new Stack<String>();
        for (String s : stack)
        {
            copy.push(s);
        }
        return copy;
    }
    
    public static void main(String[] args)
    {
        Stack<String> stack = new Stack<String>();
        Stack<String> newStack;
        
        for (int i = 0; i < 10; i++)
        {
            stack.push("" + i);
        }
        
        // copy of the stack in reverse order
        newStack = Copy(stack);
        
        
        for (String s : newStack)
            System.out.println(s);        
    }

}
