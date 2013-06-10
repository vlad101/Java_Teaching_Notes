/***************************************************
 * The Generic Linked List implementation.         *
 * @author: Vladimir Efros                         *
 * This program implements a Generic LinkedList.   *
 ***************************************************/

/**
 * A representation of a Node of A Generic LinkedList that accepts any type of parameter.
 */
class Node<AnyType>
{
    public AnyType value;
    public Node<AnyType> next;
    
    /**
     * The constructor method initializes a Node of the Generic LinkedList.
     * @param val Initializes the value with any type.
     * @param n Initializes the Node.
     */
    public Node(AnyType val, Node n)
    {
        value = val;
        next = n;
    }
    
    /**
     * The sister constructor method.
     * @param val Initializes the value with any type.
     */
    public Node(AnyType val)
    {
        this(val, null);
    }    
}

/**
 * A representation of the LinkedList that accepts any type of the parameter.
 */
class LinkedList<AnyType>
{
    private Node head;
    
    /**
     * The constructor method initializes the LinkedList with the first null Node.
     */
    public LinkedList()
    {
        head = null;
    }
    
    /**
     * The add method inserts a value in the first position of the LinkedList.
     * @param val The inserted value of any type.
     */
    public void add(AnyType val)
    {
        if(isEmpty())
            head = new Node(val);
        
        else
            head = new Node(val, head);
    }
    
    /**
     * The add method adds a value to the LinkedList at the specified location.
     * @param index The location where the value is added.
     * @param val The value of any type that is to be added to the LinkedList.
     */
    public void add(int index, AnyType val)
    {
        if(index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        
        if(index == 0)
            head = new Node(val, head);
        else
        {
            Node pred = head;
            for(int i = 1; i <= index - 1; i++)
                pred = pred.next;
            pred.next = new Node(val, pred.next);
        }
    }
    
    /**
     * The remove method removes an element at the specified location.
     * @param index The specified position of the element that is to be removed.
     * @exception IndexOutOfBoundsException if the index is out of bounds.
     * @return The removed value.
     */
    public AnyType remove(int index)
    {
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        
        if(index == 0)
        {
            AnyType temp = (AnyType) head.value;
            head = head.next;
            return temp;
        }
        
        else
        {
            Node pred = head;
            for(int i = 1; i <= index - 1; i++)
                pred = pred.next;
            AnyType temp = (AnyType) pred.next.value;
            pred.next = pred.next.next;
            return temp;
        }
    }
    
    /**
     * The remove method removes the specified value of any type from the LinkedLiist.
     * @param val The value that is to be removed.
     * @return true if the element is removed, otherwise return false.
     */
    public boolean remove(AnyType val)
    {
        if(isEmpty())
            return false;
        
        if(head.value == val)
        {
            head  = head.next;
            return true;
        }
        
        else
        {
            Node pred;
            for(pred = head; pred.next != null && ! pred.next.value.equals(val); pred = pred.next)
                pred = pred.next;
            if(pred.next == null)
                return false;
            else
            {
                pred.next = pred.next.next;
                return true;
            }
        }
    }
    
    public AnyType get(int index)
    {
        Node pred;
        int i;
        for(i = 0, pred = head; i < size(); i++, pred = pred.next)
            if(i == index)
                return (AnyType) pred.value;
        return null;
    }
    
    /**
     * The toString method returns the state of the object.
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("The elements of the LinkedList: ");
        for(Node ref = head; ref != null; ref = ref.next)
            builder.append(ref.value + " ");
        return builder.toString();
    }
    
    /**
     * The clear method clears all the elements of the LinkedList.
     */
    public void clear()
    {
        while(head != null)
            remove(0);
        head = null;
    }
    
    /**
     * The size method returns the size of the LinkedList.
     */
    public int size()
    {
        int count = 0;
        for(Node ref = head; ref != null; ref = ref.next)
            count++;
        return count;
    }
    
    /**
     * The isEmpty method true if the LinkedList is empty, otherwise returns false.
     */
    public boolean isEmpty()
    {
        return (head == null);
    }
    
    /**
     * The getIterator method returns the Iterator for the LinkedLink class.
     */
    public Iterator<AnyType> getIterator()
    {
        return new Iterator<AnyType>(this);
    }
    
    /**
     * The recRev method reverses the LinkedList recursively.
     */
    public void recRev()
    {
        recRev(head);
    }
    
    /**
     * The recRev method reverses the LinkedList recursively.
     * @param start The first node of the LinkedList.
     */
    private void recRev(Node start)
    {
        if(isEmpty())
            return;
        
        if(start.next == null)
        {
            head = start;
            return;
        }
        
        recRev(start.next);
        start.next.next = start;
        start.next = null;
    }
}

/**
 * The representation of the Iterator for the LinkedList class.
 */
class Iterator<AnyType>
{
    private LinkedList theList;
    private int prev;
    private boolean canRemove;
    
    /**
     * The constructor method initializes the LinkedList Iterator.
     * @param l The initialization of the LinkedList object.
     */
    public Iterator(LinkedList l)
    {
        theList = l;
        prev = -1;
        canRemove = false;
    }
    
    /**
     * The hasNext method returns true if theList object 
     * has next element, otherwise returns false.
     */
    public boolean hasNext()
    {
        return (prev + 1 < theList.size());
    }
    
    /**
     * The next method returns the element of any type, otherwise returns null.
     */
    public AnyType next()
    {
        if(hasNext())
        {
            prev++;
            canRemove = true;
            return (AnyType) theList.get(prev);
        }
        return null;
    }
    
    /**
     * The delete method deletes a specified element from the LinkedList.
     */
    public void delete()
    {
        if(canRemove)
        {
            theList.remove(prev);
            prev--;
            canRemove = false;
        }
        else
            return;
    }
}

/**
 * The Test Drive of the Program.
 */
public class GenericLinkedList 
{
    public static void main(String[] args)
    {
        // Create a String LinkedList Object
        LinkedList<String> myStringList = new LinkedList<String>();
        
        // Add three elements to the Generic LinkedList
        String[] nums = {"One", "Two", "Three", "Four", "Five"};
        for(String i : nums)
            myStringList.add(i);
        
        System.out.println();
        
        System.out.println(myStringList);
        myStringList.recRev();
        System.out.println(myStringList);
        
        // Add two elements at the specified position
        myStringList.add(0, "Hi");
        myStringList.add(6, "Bye");
        
        // Display all the elements using the get method
        System.out.print("The get method: ");
        for(int i = 0; i < myStringList.size(); i++)
            System.out.print(myStringList.get(i) + " ");
        System.out.println();
        
        // Create two iterator objects
        Iterator iterator1 = myStringList.getIterator();
        Iterator iterator2 = myStringList.getIterator();
        
        // Display all the elements using the get method
        System.out.print("The iterator method: ");
        while(iterator1.hasNext())
            System.out.print(iterator1.next() + " ");
        System.out.println();
        
        // Remove an element from the LinkedList using an iterator delete method
        while(iterator2.hasNext())
            if(iterator2.next().equals("Three"))
                iterator2.delete();
        System.out.println();
        System.out.println(myStringList);
        
        // Remove an element at the specified position
        myStringList.remove(4);
        
        // Remove an element from the LinkedList
        if(myStringList.remove("One"))
            System.out.println("Removed");
        
        System.out.println(myStringList);
        
        // Create an Integer LinkedList Object
        LinkedList<Integer> myIntList = new LinkedList<Integer>();
        int[] num = {1, 2, 3, 4, 5, 6, 7};
        for(int i : num)
            myIntList.add(i);
        
        System.out.println(myIntList);
        
        // Reverse the LinkedList
        myIntList.recRev();
        
        System.out.println(myIntList);
        
        System.out.println("Get second element from the end: " + myIntList.get(myIntList.size() - 2));
        
        System.out.println("Get second element from the end: " + myIntList.get(myIntList.size() / 2));
    }
}