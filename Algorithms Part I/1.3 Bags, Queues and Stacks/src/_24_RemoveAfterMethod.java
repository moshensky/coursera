/*
 * Write a method removeAfter() that takes a linked-list Node as argument and removes
 * the node following the given one (and does nothing if the argument or the next 
 * field in the argument node is null).
 */
public class _24_RemoveAfterMethod<Item> 
{
    private Node first;
    private int N;
    
    class Node
    {
        Item item;
        Node next;
    }
    
    public void removeAfter(Node node)
    {
        if (node == null || node.next == null)
            return;
        else
        {
            node.next = node.next.next;
        }
    }

    public static void main(String[] args)
    {
        _24_RemoveAfterMethod<Integer> list = new _24_RemoveAfterMethod<>();
        for (int i = 0; i < 10; i++)
        {
            list.first = new Node();
            list.first.item = i;
        }
    }
    
}
