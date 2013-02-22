import java.util.Iterator;


public class Stack<Item> implements Iterable<Item>
{
    private Node first; // top of stack
    private int N;      // number of items
    
    private class Node
    {
        Item item;
        Node next;
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

    @Override
    public Iterator<Item> iterator()
    {
        // TODO Auto-generated method stub
        return null;
    }

    // test client
    public static void main(String[] args)
    {
        Stack<String> stack = new Stack();
        for (int i = 0; i < 10; i++)
        {
            stack.push("test " + i);
        }
        
        System.out.println(stack.pop());
    }
}
