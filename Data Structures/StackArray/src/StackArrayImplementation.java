/**
 * The Stack String Array Implementation.
 * @author: Vladimir Efros
 * This program implements a Stack String Array.
 */

interface StackArrayType
{
    public void push(String str);
    public String peek();
    public String pop();
    public boolean isEmpty();
}

/**
 * Stack array representation.
 */
class StackArray
{
    private String[] arr;
    private int top;
    
    /**
     * The constructor method initializes the Stack String Array.
     * @param capacity The size of the Stack String Array.
     */
    public StackArray(int capacity)
    {
        if(capacity < 1)
            throw new IllegalArgumentException();
        arr = new String[capacity];
        top = 0;
    }
    
    /**
     * The push method adds a string to the Stack String Array.
     * @param str The string that is to be added to the Stack String Array.
     */
    public void push(String str)
    {
        if(top == arr.length)
            return;
        else
        {
            arr[top] = str;
            top++;
        }
    }
    
    /**
     * @return The top value of the Stack String Array, otherwise returns null.
     */
    public String peek()
    {
        String temp = null;
        if(isEmpty())
            temp = null;
        else
            return arr[top - 1];
        return temp;
    }
    
    
    /**
     * The pop method removes the string from the Stack String Array.
     * @return The String that is to be deleted, otherwise returns null.
     */
    public String pop()
    {
        String temp = null;
        if(isEmpty())
            temp = null;
        else
        {
            temp = arr[top - 1];
            arr[top - 1] = null;
            top--;
        }
        return temp;
    }
    
    /**
     * @return true if the Stack String Array is empty, otherwise returns false.
     */
    public boolean isEmpty()
    {
        return (top == 0);
    }
    
    /**
    * @return The elements of the Stack String Array and converts in to string.
    */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("The content of the Queue Array: ");
        for(int i = 0; i < top; i++)
            builder.append(arr[i] + " ");
        return builder.toString();
    }
}

/**
 * Program Test Driver.
 */
public class StackArrayImplementation 
{
    public static void main(String[] args)
    {
        // Create a new StackArray Object
        StackArray stack = new StackArray(3);
        
        // Push three string to the stack
        String[] nums = {"One", "Two", "Three"};
        for(String s : nums)
            stack.push(s);
        
        // Display the stack
        System.out.println(stack);
        
        // Pop one string from the stack
        stack.pop();
        
        // Display the stack
        System.out.println(stack);
    }
}