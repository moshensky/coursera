/*
 * Write a method remove() that takes a linked list and a string key as arguments 
 * and removes all of the nodes in the list that have key as its item field.
 */
public class _26_RemoveByKey<Item> extends Stack<Item>
{

    public void remove(Stack<Item> s, String key)
    {
        for (Item str : s)
        {
            if (str.equals(key))
            {
                ???
            }
        }
    }
    
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
