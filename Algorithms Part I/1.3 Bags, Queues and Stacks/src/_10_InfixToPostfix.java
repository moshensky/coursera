/*
 * Write a filter InfixToPostfix that converts an arithmetic 
 * expression from infix to postfix.
 *    Infix String : a+b*c-d
    Postfix String : abc*+d-
 *    Infix String : 3+4*5/6
    Postfix String : 345*6/+
 *    Infix String : (300+23)*(43-21)/(84+7)
    Postfix String : 300 23 + 43 21 - * 84 7 + / 
 *    Infix String : (4+8)*(6-5)/((3-2)*(2+2))
    Postfix String : 4 8 + 6 5 - * 3 2 – 2 2 + * / 
 */
public class _10_InfixToPostfix
{

    public static void main(String[] args)
    {
        String infix = "a+b*c-d";
        infix = "3+4*5/6";
        infix = "(300+23)*(43-21)/(84+7)";
        infix = "(4+8)*(6-5)/((3-2)*(2+2))";
        String postfix = infixToPostfix(infix);
        System.out.println(postfix);
    }

    private static String infixToPostfix(String infix)
    {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operator = new Stack<Character>();
        for (int i = 0; i < infix.length(); i++)
        {
            //System.out.println("DEBUG: " + postfix);
            char c = infix.charAt(i);
            if (c == '*' || c == '/')
            {
                if (operator.isEmpty())
                {
                    operator.push(c);
                    postfix.append(' ');
                }
                else
                {
                    char peek = operator.peek();
                    while (peek != '-' && peek != '+' && peek != '(')
                    {
                        postfix.append(' ');
                        postfix.append(operator.pop());
                        if (operator.isEmpty())
                            break;
                        peek = operator.peek();
                    }
                    operator.push(c);
                    postfix.append(' ');
                }
            }
            else if (c == '-' || c == '+')
            {
                if (operator.isEmpty())
                {
                    operator.push(c);
                    postfix.append(' ');
                }
                else
                {
                    char peek = operator.peek();
                    while (peek != '(')
                    {
                        postfix.append(' ');
                        postfix.append(operator.pop());
                        if (operator.isEmpty())
                            break;
                        peek = operator.peek();
                    }
                    operator.push(c);
                    postfix.append(' ');
                }
            }
            else if ( c == '(')
            {
                operator.push(c);
            }
            else if ( c == ')')
            {
                char peek = operator.peek();
                while (peek != '(')
                {
                    postfix.append(' ');
                    postfix.append(operator.pop());
                    if (operator.isEmpty())
                        break;
                    peek = operator.peek();
                }
                operator.pop();
            }
            else
            {
                postfix.append(c);
            }
        }
        while (!operator.isEmpty())
        {
            postfix.append(' ');
            postfix.append(operator.pop());
        }
        return postfix.toString();
    }
}