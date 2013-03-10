import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Develop a class ResizingArrayQueueOfStrings that implements the
 * queue abstraction with a fixed-size array, and then extend your
 * implementation to use array resizing to remove the size restriction.
 */
public class ResizingArrayQueue<Item> implements Iterable<Item>
{
    private int first;
    private int last;
    private int N;
    private Item[] queue;
    
    @SuppressWarnings("unchecked")
    public ResizingArrayQueue()
    {
        first = 0;
        last = 0;
        N = 0;
        queue = (Item[]) new Object[2];
    }
    
    // add item to queue
    public void enqueue(Item item)
    {
        if (queue.length == N)
        {
            queue = resize(queue.length * 2);
        }
        queue[last++] = item;
        N++;
        if (last == queue.length)
        {
            last = 0;
        }
    }
    
    // remove item from queue
    public Item dequeue()
    {
        if (isEmpty())
        {
            throw new RuntimeException("Queue underflow!");
        }
        Item item = queue[first];
        queue[first++] = null;
        if (first == queue.length)
        {
            first = 0;
        }
        N--;
        if (queue.length/4 == N && N > 2) queue = resize(queue.length/2);
        return item;
    }
    
    // check if queue has elements
    public boolean isEmpty()
    {
        return N == 0;
    }
    
    public int size()
    {
        return N;
    }
    
    // resize array
    @SuppressWarnings("unchecked")
    private Item[] resize(int newSize)
    {
        Item[] arr = (Item[]) new Object[newSize];
        for (int i = 0; i < N; i++)
        {
            arr[i] = queue[(first + i) % queue.length];
        }       
        first = 0;
        last = N;
        return arr;
    }
    
    // 
    public Iterator<Item> iterator() 
    {
        return new ArrayIterator();
    }
    
    // an iterator
    private class ArrayIterator implements Iterator<Item>
    {
        private int i = 0;
        
        @Override
        public boolean hasNext()
        {
            return i < N;
        }

        @Override
        public Item next()
        {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = queue[(first + i) % queue.length];
            i++;
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
        ResizingArrayQueue<Integer> queue = new ResizingArrayQueue<>();
        for (int i = 0; i < 10; i++)
        {
            queue.enqueue(i);
        }
        for (int i : queue)
        {
            System.out.println(i);
        }
    }

}
