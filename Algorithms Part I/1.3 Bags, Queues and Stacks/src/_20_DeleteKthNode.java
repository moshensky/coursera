import java.util.NoSuchElementException;

/*
 * Write a method delete() that takes an int argument k and deletes
 * the kth element in a linked list, if it exists.
 */
public class _20_DeleteKthNode
{
    public static void main(String[] args)
    {
        StackDelKthNode<Integer> stack = new StackDelKthNode<>();
        for (int i = 0; i < 10; i++)
            stack.push(i);
        stack.deleteNode(8);
        for (int i : stack)
            System.out.println(i);
    }
}

class StackDelKthNode<T> extends Stack<T>
{
    public void deleteNode(int pos)
    {
        if (pos >= N)
            throw new NoSuchElementException();
        if (pos == 0)
        {
            first = first.next;
        }
        else
        {
            Node n = first;
            for (int i = 1; i < pos; i++)
                n = n.next;
            n.next = n.next.next;
        }
    }
}