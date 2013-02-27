import java.util.Iterator;
import java.util.NoSuchElementException;


public class Stack<Item> implements Iterable<Item>
{
    private Node first; // top of stack
    private int N;      // number of items
    
    private class Node
    {
        Item item;
        Node next;
    }
   
    // create an empty stack
    public Stack()
    {
        first = null;
        N = 0;
    }
    
    public boolean isEmpty()
    {
        return first == null;
    }

    public int size()
    {
        return N;
    }
    
    public void push(Item item)
    {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    
    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    
    public Item peek()
    {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    @Override
    public Iterator<Item> iterator()
    {
        return new StackIterator();
    }
    
    private class StackIterator implements Iterator<Item>
    {
        private Node current = first;

        @Override
        public boolean hasNext()
        {
            return current != null;
        }

        @Override
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
        
        
    }

    // test client
    public static void main(String[] args)
    {
        Stack<String> stack = new Stack<String>();
        String str = "it was - the best - of times - - - it was - the - -";
        String[] s = str.split(" ");
        
        for (int i = 0; i < s.length; i++)
        {
            if (s[i].equals("-"))
            {
                System.out.println(stack.pop());
            }
            else
            {
                stack.push(s[i]);
            }
        } 
    }
}
