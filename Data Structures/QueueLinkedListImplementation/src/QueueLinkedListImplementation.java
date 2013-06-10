/**
 * The String Queue LinkedList Implementation.
 * @author: Vladimir Efros
 * This program implements a Queue LinkedList.
 */

interface QueueLinkedListType
{
    public void enqueue(String val);
    public boolean isEmpty();
    public String peek();
    public String dequeue();
}

/**
 * Node representation.
 */
class Node
{
    public String value;
    public Node next;
    
    /**
     * The method constructor initializes the Node of the LinkedList.
     * @param val The string value is initialized.
     * @param n The Node next is initialized.
     */
    public Node(String val, Node n)
    {
        value = val;
        next = n;
    }
}

/**
 * Queue LinkedList class declaration.
 */
class QueueLinkedList
{
    private Node rear = null;
    private Node front = null;
    
    /**
     * The enqueue method adds a string to the Queue LinkedList.
     * @param val The value of the string that is to be added.
     */
    public void enqueue(String val)
    {
        if(rear != null)
        {
            rear.next = new Node(val, null);
            rear = rear.next;
        }
        else
        {
            rear = new Node(val, null);
            front = rear;
        }
    }
    
    /**
     * @return The front element of the LinkedList Queue.
     */
    public String peek()
    {
        String temp = null;
        if(isEmpty()) 
            temp = null;
        else
            temp = front.value;
        return temp;
    }
    
    /**
     * The dequeue method removes the String from the LinkedList Queue.
     * @return true if the string was moved, otherwise returns false.
     */
    public String dequeue()
    {
        String temp = null;
        if(isEmpty())
            temp = null;
        else
        {
            temp = front.value;
            front = front.next;
            if(front == null)
                rear = null;
        }
        return temp;
    }
    
    /**
     * @return true if the string is empty, otherwise returns false.
     */
    public boolean isEmpty()
    {
        return (front == null);
    }
    
    /**
     * @return The elements of the queue LinkedList and converts in to string.
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("The content of the Queue LinkedList: ");
        for(Node ref = front; ref != null; ref = ref.next)
            builder.append(ref.value + " ");
        return builder.toString();
    }
}

/**
 * The program test driver.
 */
public class QueueLinkedListImplementation 
{
    public static void main(String[] args)
    {
        QueueLinkedList queue = new QueueLinkedList();
        
        String[] nums = {"One", "Two", "Three", "Four"};
        
        // Add the string elements to th queue
        for(String s : nums)
            queue.enqueue(s);
        
        // Display the top element of the queue
        System.out.println(queue.peek());
        
        // Display all the elements of the queue
        System.out.println(queue);
         
        // Remove two top elements
        queue.dequeue(); 
        queue.dequeue();
        
        // Display all the elements of the queue
        System.out.println(queue);
        
        // Add 1 string
        queue.enqueue("Five");
        
        // Display all the elements of the queue
        System.out.println(queue);
    }
}