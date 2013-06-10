/**
 * The Linked List implementation.
 * @author: Vladimir Efros
 * This program implements a String LinkedList.
 */

interface LinkedListType
{
    public void add(String str);
    public void add(int index, String str);
    public String remove(int index);
    public void clear();
    public boolean isEmpty();
    public boolean remove(String str);
    public int size();
}

/**
 * Node representation.
 */
class Node
{
    public String value;
    public Node next;
    
    /**
     * The constructor method.
     * @param val Stores the String data.
     * @param n Stores th reference to the Node next.
     */
    public Node(String val, Node n)
    {
        value = val;
        next = n;
    }
    
     /**
     * The constructor method.
     * @param val Stores the String data.
     */
    public Node(String val)
    {
        this(val, null);
    }
}

/**
 * The LinkedList implementation.
 */
class LinkedList implements LinkedListType
{
    private Node first;
    private Node last;
    
    /**
     * The constructor method initializes LinkedList object.
     */
    public LinkedList()
    {
        first = null; 
        last = null;
    }
    
    /**
     * The add method adds a String to a LinkedList.
     * @param str The string value that is to be added to the LinkedList.
     */
    public void add(String str)
    {
        if(str == null || str.length() <= 0)
            return;
        if(isEmpty())
        {
            first = new Node(str);
            last = first;
        }
        else
        {
            last.next = new Node(str);
            last = last.next;
        }
    }
    
    /**
     * The add method adds a String at the specified index location.
     * @param index The location where a string will be added.
     * @exception IndexOutOfBoundsException if the index is out of the range.
     * @param str The string that is to be added to the linked list.
     */
    public void add(int index, String str)
    {
        if(index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        
        if(str == null || str.length() <= 0)
            return;
        
        if(index == 0)
        {
            first = new Node(str, first);
            if(first == null)
                last = first;
        }
        else
        {
            Node pred = first;
            for(int i = 1; i <= index - 1; i++)
                pred = pred.next;
            pred.next = new Node(str, pred.next);
            if(pred.next.next == null)
                last = pred.next;
        }
    }
    
    /**
     * The remove method removes the string at the specified location.
     * @param index The location where the string is removed.
     * @exception IndexOutOfBoundsException if the index is out of the range.
     * @return a String value if the String is removed, otherwise returns a null.
     */
    public String remove(int index)
    {
        String temp = null;
        if(index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        
        else if(isEmpty())
            temp = null;
        
        else if(index == 0)
        {
            temp = first.value;
            first = first.next;
            if(first == null)
                last = null;
        }
        else
        {
            Node pred = first;
            for(int i = 1; i <= index - 1; i++)
                pred = pred.next;
            temp = pred.next.value;
            pred.next = pred.next.next;
            if(pred.next == null)
                last = pred;
        }
        return temp;
    }
    
    /**
     * The clear method deletes all the elements of the LinkedList and 
     * sets the the first and last value to null. 
     */
    public void clear()
    {
        Node ref = first;
        while(first != null)  // Alternatively
        {                     // while(first != null) { remove(0); }
            ref = ref.next;
            remove(0);
        }
            
        if(first == null)
            last = null;
        
    }
    
    /**
     * The remove method removes the specified string from the LinkedList.
     * @param str The string that is to be removed.
     * @return true if the string was removed, otherwise false.
     */
    public boolean remove(String str)
    {
        boolean flag = false;
        if(str == null || str.length() < 1)
            flag = false;
        if(first.value.equals(str))
        {
            first = first.next;
            if(first == null)
                last = null;
            flag = true;
        }
        else
        {
            Node pred;
            for(pred = first; pred.next != null && !(pred.next.value.equals(str)); pred = pred.next)
                pred = pred.next;
            if(pred.next == null)
                flag = false;
            else
            {
                pred.next = pred.next.next;
                if(pred.next == null)
                    last = pred;
                flag = true;
            }
        }
        return flag;
    }
    
    /**
     * @return true if the string is empty.
     */
    public boolean isEmpty()
    {
        return (first == null);
    }
    
    /**
     * @return The amount of elements in the list.
     */
    public int size()
    {
        int count = 0;
        for(Node ref = first; ref != null; ref = ref.next)
            count++;
        return count;
    }
    
    /**
     * @return The elements of the LinkedList and convert is to string.
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("The LinkedList Items: ");
        for(Node ref = first; ref != null; ref = ref.next)
            builder.append(ref.value + " ");
        return builder.toString();
    }
}

/**
 * The LinkedList representation driver.
 */
public class LinkedListImplementation 
{
    public static void main(String[] args)
    {
        LinkedList myList = new LinkedList();
        
        String[] nums = {"One", "Two", "Three"};
        for(String s : nums)
            myList.add(s);
        System.out.println(myList);
        
        myList.remove("One");
        myList.remove("Two");
        myList.remove("Three");
        System.out.println(myList);
        
        myList.add("Zero");
        myList.add(1, "newOne"); 
        myList.add(2, "NewTwo"); 
        System.out.println(myList);
        
        myList.remove(0);
        myList.remove(1);
        System.out.println(myList);
        
        myList.clear();
        System.out.println(myList);
    }
}