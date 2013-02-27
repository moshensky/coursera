import java.util.Iterator;


public class Queue<Item> implements Iterable<Item>
{
    private Node first; // link to least recently added node
    private Node last;  // link to most recentrly added node
    private int N;      // number of items on the queue
    
    private class Node
    {
        Item item;
        Node next;
    }
    
    // add an item
    public void enqueue(Item item)
    {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty())
        {
            first = last;
        }
        else
        {
            oldLast.next = last;
        }
        N++;        
    }
    
    // remove the least recently added item
    public Item dequeue()
    {
        Item item = first.item;
        first = first.next;
        if (isEmpty())
        {
            last = null;
        }
        N--;
        return item;
    }
    
    // is the queue empty?
    public boolean isEmpty()
    {
        return first == null;
    }
    
    // number of items in the queue
    public int size()
    {
        return N;
    }
    
    @Override
    public Iterator<Item> iterator()
    {
        return new QueueIterator();
    }
    
    private class QueueIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext()
        {
            return current != null;
        }
        
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
        
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    
    // test client
    public static void main(String[] args)
    {
        Queue<String> queue = new Queue<String>();
        queue.enqueue("str");
        queue.enqueue("str1");
        for (int i = 0; i < 10; i++)
        {
            queue.enqueue("" + i);
        }
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        for (String s : queue)
            System.out.println(s);
        
        
        Queue<Integer> q = new Queue<Integer>();
        q.enqueue(0);
        q.enqueue(1);
        for (int i = 0; i < 87; i++)
        {
            int a = q.dequeue();
            int b = q.dequeue();
            q.enqueue(b);
            q.enqueue(a+b);
            System.out.println(a);
            
        }
    }
}










