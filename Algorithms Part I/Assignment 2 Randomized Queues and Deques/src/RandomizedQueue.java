import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> 
{
    
   // construct an empty randomized queue 
   public RandomizedQueue()           
   {
       
   }
   
   // is the queue empty? 
   public boolean isEmpty()           
   {
       
   }
   
   // return the number of items on the queue 
   public int size()                  
   {
       
   }
   
   // add the item 
   public void enqueue(Item item)     
   {
       if (item == null)
       {
           throw new NullPointerException();
       }
   }
   
   // delete and return a random item 
   public Item dequeue()              
   {
       if (isEmpty())
       {
           throw new NoSuchElementException();
       }
   }
   
   // return (but do not delete) a random item 
   public Item sample()               
   {
       if (isEmpty())
       {
           throw new NoSuchElementException();
       }
   }
   
   // return an independent iterator over items in random order 
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