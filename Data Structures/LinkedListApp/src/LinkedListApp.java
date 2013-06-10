
class Queue<E>
{
    private E[] arr;
    private int rear; 
    private int front;
    private int size;
    
    public Queue(int capacity)
    {
        rear = 0; 
        front = 0;
        size = 0;
        arr = (E[])(new Object[capacity]);
    }
    
    public void enqueue(E val)
    {
        if(size == arr.length)
            return;
        else
        {
            arr[rear] = val;
            rear++;
            size++;
            if(rear == arr.length)
                rear = 0;
        }
    }
    
    public E peek()
    {
        if(size == 0)
            return null;
        return arr[front];
    }
    
    public E dequeue()
    {
        if(size == 0)
            return null;
        else
        {
            E temp = arr[front];
            arr[front] = null;
            front++;
            size--;
            if(front == arr.length)
                front = 0;
            return temp;
        }
    }
}

public class LinkedListApp
{
    public static void main(String[] args)
    {}
}