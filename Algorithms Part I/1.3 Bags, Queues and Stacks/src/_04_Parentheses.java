/*
Write a stack client Parentheses that reads in a text stream from standard input
and uses a stack to determine whether its parentheses are properly balanced. For ex-
ample, your program should print true for [()]{}{[()()]()} and false for [(]).
*/



public class _04_Parentheses
{
    private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';
    
    public static boolean isBalanced(String s)
    {
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++)
        {
            // System.out.println(s.charAt(i));
            if (s.charAt(i) == LEFT_PAREN)
                stack.push(LEFT_PAREN);
            else if (s.charAt(i) == LEFT_BRACE)
                stack.push(LEFT_BRACE);
            else if (s.charAt(i) == LEFT_BRACKET)
                stack.push(LEFT_BRACKET);
            else 
            {
                if (s.charAt(i) == RIGHT_PAREN)
                {
                    if (stack.isEmpty() || stack.pop() != LEFT_PAREN)
                        return false;
                }
                else if (s.charAt(i) == RIGHT_BRACE)
                {
                    if (stack.isEmpty() || stack.pop() != LEFT_BRACE)
                        return false;
                }
                else if (s.charAt(i) == RIGHT_BRACKET)
                {
                    if (stack.isEmpty() || stack.pop() != LEFT_BRACKET)
                        return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args)
    {
        String s = "[()]{}{[()()()]}";
        System.out.println(isBalanced(s));
    }

}
