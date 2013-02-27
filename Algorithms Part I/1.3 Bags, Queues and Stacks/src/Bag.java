import java.util.Iterator;


public class Bag<Item> implements Iterable<Item>
{
    private Node first;
    private int N;
    
    private class Node
    {
        Item item;
        Node next;
    }
    
    // add an item
    public void add(Item item)
    {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    
    // is the bag empty?
    public boolean isEmpty()
    {
        return first == null;
    }
    
    // number of items in the bag
    public int size()
    {
        return N;
    }
    
    @Override
    public Iterator<Item> iterator()
    {
        return new BagIterator();
    }
    
    private class BagIterator implements Iterator<Item>
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
        Bag<String> bag = new Bag<String>();
        bag.add("test");
        for (String s : bag)
            System.out.println(s);
    }
}
