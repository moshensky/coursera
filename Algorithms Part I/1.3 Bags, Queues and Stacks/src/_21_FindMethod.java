/*
 * Write a method find() that takes a linked list and a string key as arguments 
 * and returns true if some node in the list has key as its item field, false otherwise.
 */
public class _21_FindMethod
{
    
    public static void main(String[] args)
    {
        Queue<String> list = new Queue<>();
        
        for (int i = 0; i < 10; i++)
        {
            list.enqueue("" + i);
        }
        
        System.out.println(find(list, "3"));
    }
    
    
    public static boolean find(Queue<String> q, String key)
    {
        for (String s : q)
        {
            if (s.equals(key))
                return true;
        }
        return false;
    }

}
