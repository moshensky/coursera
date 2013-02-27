/*
Write a program that takes from standard input an expression without left 
parentheses and prints the equivalent infix expression with the parentheses 
inserted. For example, given the input:
1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
your program should print:
( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 */
public class _09_FixInfixExpression
{
    
    public static void main(String[] args)
    {
        String s = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) != ' ')
                stack.push(s.charAt(i));
        }
        System.out.println();
        s = fixInfix(stack);
        System.out.println(s);
    }

    private static String fixInfix(Stack<Character> s)
    {
        Stack<Character> infix = new Stack<Character>();
        Queue<String> numbers = new Queue<String>();
        Stack<String> operators = new Stack<String>();
        
        while (!s.isEmpty())
        {
            char c = s.pop();
            if (c == ')')
            {
                infix.push(c);
            }
            else if (c == '-' || c == '+')
            {
                
            }
        }
            
        
        return infix.toString();
    }

}
