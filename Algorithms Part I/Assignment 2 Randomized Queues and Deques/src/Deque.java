import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> 
{
    
   // construct an empty deque
   public Deque()                     
   {
       
   }
   
   // is the deque empty?
   public boolean isEmpty()           
   {
       
   }
   
   // return the number of items on the deque
   public int size()                  
   {
       
   }
   
   // insert the item at the front
   public void addFirst(Item item)    
   {
       if (item == null)
       {
           throw new NullPointerException();
       }
   }
   
   // insert the item at the end
   public void addLast(Item item)     
   {
       if (item == null)
       {
           throw new NullPointerException();
       }
       
   }
   
   // delete and return the item at the front
   public Item removeFirst()          
   {
       if (isEmpty())
       {
           throw new NoSuchElementException ();
       }
   }
   
   // delete and return the item at the end
   public Item removeLast()           
   {
       if (isEmpty())
       {
           throw new NoSuchElementException ();
       }
   }
   
   // return an iterator over items in order from front to end
   public Iterator<Item> iterator()   
   {
       
   }
   
    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext()
        {
            return current != null;
        }

        public void remove()
        { /* not supported */
            throw new UnsupportedOperationException ();
        }

        public Item next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException(); 
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}