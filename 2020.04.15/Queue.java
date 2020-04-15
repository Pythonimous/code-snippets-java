public class Queue<Item>
{
    private Node first = null;
    private Node last = null;
    public int N = 0;

    private class Node
    {
      private Item item;
      private Node next;
    }

    public boolean isEmpty()
    { return first == null; }

    public void enqueue(Item item)
    {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldLast.next = last;
        N++;
    }

    public Item dequeue()
    {
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;  // for garbage collection
        return item;
    }

    public void removeAfter(Item item) // removes the node following the first one with the given value
    {
        for (Node t = first; t != null; t = t.next)
        {
            if (t.item.equals(item) && t.next != null && t.next.next != null) t.next = t.next.next;
        }
    }

    public int size()
    { return N; }

    public static void main(String[] args)
    {
      Queue<String> queue = new Queue<String>();


      while (!StdIn.isEmpty())
      {
          String item = StdIn.readString();
          if (item.equals("-"))
              System.out.print(queue.dequeue() + " ");
          else
              queue.enqueue(item);
      }
      System.out.println();
      queue.removeAfter("the");
      System.out.println();
      while (!queue.isEmpty()) System.out.print(queue.dequeue() + " ");
      System.out.println();
    }
}
