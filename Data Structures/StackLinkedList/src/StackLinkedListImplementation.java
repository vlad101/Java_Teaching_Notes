/**
 * The Stack String LinkeList Implementation.
 * @author: Vladimir Efros
 * This program implements a Stack String LinkeList.
 */

interface StackLinkedListType
{
    public void push(String str);
    public String peek();
    public String pop();
    public boolean isEmpty();
}

/**
 * The Stack String LinkeList node representation.
 */
class Node
{
    public String value;
    public Node next;
    
    /**
     * The constructor method initializes the Stack String LinkeList node.
     * @param val The string value initialization.
     * @param n The Node next initialization.
     */
    public Node(String val, Node n)
    {
        value = val;
        next = n;
    }
}

/**
 * The Stack String LinkeList representation.
 */
class StackLinkedList
{
    private Node top = null;
        
    /**
     * The push method adds a string to the Stack String LinkeList.
     * @param str The string that is to be added to the Stack String LinkeList.
     */
    public void push(String str)
    {
        top = new Node(str, top);
    }
    
    /**
     * @return The top value of the Stack String LinkeList, otherwise returns null.
     */
    public String peek()
    {
        String temp = null;
        if(isEmpty())
            temp = null;
        else
            temp = top.value;
        return temp;
    }
    
    
    /**
     * The pop method removes the string from the Stack String LinkeList.
     * @return The String that is to be deleted, otherwise returns null.
     */
    public String pop()
    {
        String temp = null;
        if(isEmpty())
            temp = null;
        else
        {
            temp = top.value;
            top= top.next;
        }
        return temp;
    }
    
    /**
     * @return true if the Stack String LinkeList is empty, otherwise returns false.
     */
    public boolean isEmpty()
    {
        return (top == null);
    }
    
    /**
    * @return The elements of the Stack String LinkeList and converts in to string.
    */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("The content of the Stack LinkedList: ");
        for(Node ref = top; ref != null; ref = ref.next)
            builder.append(ref.value + " ");
        return builder.toString();
    }
}

/**
 * Program Test Driver.
 */
public class StackLinkedListImplementation
{
    public static void main(String[] args)
    {
        // Create a new StackLinkedList Object
        StackLinkedList stack = new StackLinkedList();
        
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