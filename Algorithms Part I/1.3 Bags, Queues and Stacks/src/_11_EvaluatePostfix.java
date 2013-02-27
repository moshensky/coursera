/*
 * Write a program EvaluatePostfix that takes a postfix expression from standard
 * input, evaluates it, and prints the value. (Piping the output of your program
 * from the previous exercise to this program gives equivalent behavior to Evaluate.
 *  infix String   : (4+8)*(6-5)/((3-2)*(2+2))
 *  postfix String : 4 8 + 6 5 - * 3 2 – 2 2 + * /
 */
public class _11_EvaluatePostfix
{
    
    
    public static void main(String[] args)
    {
        String postfix = "4 8 + 6 5 - * 3 2 - 2 2 + * /";
        postfix = "7 16 * 5 + 16 * 3 + 16 * 1 +";
        double result = EvaluatePostfix(postfix.trim());
        System.out.println("result = " + result);
    }

    private static double EvaluatePostfix(String postfix)
    {
        double result = 0;
        Stack<Double> stack = new Stack<Double>();
        StringBuilder num = new StringBuilder();
        char c;
        for (int i = 0; i < postfix.length(); i++)
        {
            c = postfix.charAt(i);
            //System.out.print(c + "|");
            if (isNum(c))
            {
                num.append(c);
            }
            else if (isOperator(c))
            {
                // calc
                i++; // skip next wite field
                result = evaluateOperation(stack.pop(), stack.pop(), c);
                stack.push(result);
            }
            else if (c == ' ')
            {
                //if (num.length() > 0)
                stack.push(Double.parseDouble(num.toString()));
                num.setLength(0);
            }
        }
        return stack.pop();
    }

    private static double evaluateOperation(Double pop, Double pop2, char c)
    {
        switch (c)
        {
            case '+':
                return pop2 + pop;
            case '-':
                return pop2 - pop;
            case '*':
                return pop2 * pop;
            case '/':
                return pop2 / pop;
            default:
                return 0;
        }
    }

    private static boolean isOperator(char c)
    {
        switch (c)
        {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
            default:
                return false;
        }
    }

    private static boolean isNum(char c)
    {
        if (c >= '0' && c <= '9')
            return true;
        return false;
    }

}
