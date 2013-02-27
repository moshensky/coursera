import java.util.Iterator;


public class ResizingArrayStack<Item> implements Iterable<Item>
{
    @SuppressWarnings("unchecked")
    private Item[] a = (Item[]) new Object[1];  // stack items
    private int N = 0;                          // number of items
    
    // create an empty stack
    public ResizingArrayStack()
    {
        
    }
    
    private void resize(int max)
    {
        // move stack to a new array of size max
        @SuppressWarnings("unchecked")
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++)
        {
            temp[i] = a[i];
        }
        a = temp;
    }
    
    // add an item
    public void push(Item item)
    {
        if (N == a.length)
        {
            resize(2*a.length);
        }
        a[N++] = item;
    }
    
    // remove the most recently added item
    public Item pop()
    {
        Item item = a[--N];
        a[N] = null;  // avoid loitering 
        if (N > 0 && N == a.length/4)
        {
            resize(a.length/2);
        }
        return item;
    }
    
    // is the stack empty?
    public boolean isEmpty()
    {
        return N == 0;
    }
    
    // number of items in the stack
    public int size()
    {
        return N;
    }

    @Override
    public Iterator<Item> iterator()
    {
        return new ReverseArrayIterator();
    }
    
    private class ReverseArrayIterator implements Iterator<Item>
    {
        private int i = N;
        @Override
        public boolean hasNext()
        {
            return i > 0;
        }

        @Override
        public Item next()
        {
            // TODO throw exception when no items
            return a[--i];
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
        ResizingArrayStack<Integer> stack = new ResizingArrayStack<>();
        for (int i = 0; i < 100; i += 2)
        {
            stack.push(i);
        }
        
        for (Integer i : stack)
        {
            System.out.println(i);
        }
    }

}
