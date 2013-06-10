/**
 * The String Queue Array implementation.
 * @author: Vladimir Efros
 * This program implements a Queue Linked List.
 */

interface QueueArrayType
{
    public boolean isEmpty();
    public void enqueue(String val);
    public String peek();
    public String dequeue();
}

/**
 * Queue Array class declaration.
 */
class QueueArray
{
    private String[] arr;
    private int rear;
    private int front;
    private int size;
    
    /**
     * The constructor method initializes queue object.
     * @param capacity The size of the queue array.
     */
    public QueueArray(int capacity) 
    {
        if(capacity < 1)
            throw new IllegalArgumentException();
        arr = new String[capacity];
        rear = 0;
        front = 0;
        size = 0;
    }
    
    /**
     * @return true if the queue array is empty, otherwise returns false.
     */
    public boolean isEmpty()
    {
        return (size == 0);
    }
    
    /**
     * The enqueue method adds a string to the queue array.
     * @param val The string that is to be added to the array.
     */
    public void enqueue(String val)
    {
        if(size == arr.length)
            return;
        arr[rear] = val;
        rear++;
        size++;
        if(rear == arr.length)
            rear = 0;
    }
    
    /**
     * @return The front value of the array.
     */
    public String peek()
    {
        if(isEmpty())
            return null;
        else
            return arr[front];
    }
    
    /**
     * The dequeue method removes the last string from the array.
     * @return true if the string is removed, otherwise return false.
     */
    public String dequeue()
    {
        String temp = null;
        if(isEmpty())
            temp = null;
        else
        {
            temp = arr[front];
            arr[front] = null;
            front++;
            size--;
            if(front == arr.length)
                front = 0;
        }
        return temp;
    }
    
    /**
     * @return All the elements of the queues and converts it to string.
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("The elements of the queue: ");
        for(int i = 0; i < arr.length; i++)
            builder.append(arr[i] + " ");
        return builder.toString();
    }
}

/**
 * The queue array test driver.
 */
public class QueueArrayImplementation 
{
    public static void main(String[] args)
    {
        QueueArray queue = new QueueArray(4);
        
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
