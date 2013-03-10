

/*
 * Give a code fragment that removes the last node in a linked list whose first node is first.
 */
public class _19_DeleteLastNode
{

    public static void main(String[] args)
    {
        StackWithDeleteLastItem<Integer> stack = new StackWithDeleteLastItem<>();
        for (int i = 0; i < 10; i++)
            stack.push(i);
        stack.deleteLastNode();
        for (int i : stack)
        {
            System.out.println(i);
        }
        
    }
}

class StackWithDeleteLastItem<T> extends Stack<T>
{
    public void deleteLastNode()
    {
        Node n = first;
        while (n.next.next != null)
        {
            n = n.next;
        }
        n.next = null;
    }
}
