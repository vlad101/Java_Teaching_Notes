/*************************************************************
 * The HashMap Chaining implementation (using a LinkedList). *
 * @author: Vladimir Efros                                   *
 * This program implements a HashMap Chaining.               *
 *************************************************************/

interface HashMapType
{
    public void insert(int key, int value);
    public int get(int key);
    public void remove(int key);
    public void clear();
}

/**
 * A Node Entry representation.
 */
class Node
{
    private int key;
    private int value;
    public Node next;
    
    /**
     * The constructor method initializes a Node entry.
     * @param k Initializes the key.
     * @param v Initializes the value.
     */
    public Node(int k, int v)
    {
        key = k;
        value = v;
        next = null;
    }
    
    /**
     * @return The value of the key.
     */
    public int getKey()
    {
        return key;
    }
    
    /**
     * @param v The value of the value that is to be set.
     */
    public void setValue(int v)
    {
        value = v;
    }
    
    /**
     * @return The value of the value.
     */
    public int getValue()
    {
        return value;
    }
}

class HashMap implements HashMapType
{
    public final int SIZE = 5;
    Node[] table;
    
    /**
     * The constructor method initializes HashMap.
     */
    public HashMap()
    {
        table = new Node[SIZE];
        for(int i = 0; i < SIZE; i++)
            table[i] = null;
    }
    
    /**
     * The insert method inserts value and the key into a HashMap.
     * @param key The key that is to be inserted.
     * @param value The value that is to be inserted.
     */
    public void insert(int key, int value)
    {
        int hashFunc = key % SIZE;
        if(table[hashFunc] == null)
            table[hashFunc] = new Node(key, value);
        else
        {
            Node pred;
            for(pred = table[hashFunc]; pred.next != null && pred.next.getKey() != key; pred = pred.next)
                pred = pred.next;
            if(pred.getKey() == key)
                pred.setValue(value);
            else
                pred = new Node(key, value);
        }
    }
    
    /**
     * The get Method gets and returns the value of the key.
     * @param key The value of the key that is to be returned.
     * @return The value if the key is in a HashMap, otherwise returns -1.
     */
    public int get(int key)
    {
        int hashFunc = key % SIZE;
        if(table[hashFunc] == null)
            return -1;
        Node pred;
        for(pred = table[hashFunc]; pred.next != null && pred.next.getKey() != key; pred = pred.next)
            pred = pred.next;
        if(pred.getKey() == key)
            return(pred.getValue());
        else 
            return -1;
    }
    
    /**
     * The remove method removes a specified key and a value from a HashMap.
     * @param key The key that is to be removed from a HashMap.
     */
    public void remove(int key) {

        int hashFunc = key % SIZE;
        if (table[hashFunc] != null) 
        {
            Node pred;
            for(pred = table[hashFunc]; pred.next != null && pred.next.getKey() != key; pred = pred.next) 
            pred = pred.next;
            if (pred.getKey() == key) 
            {
                  if (pred.next == null)
                       table[hashFunc] = pred.next;
                  else
                       pred = pred.next;
            }
        }
    }
    
    /**
     * The clear method deletes all the values from a HashMap.
     */
    public void clear()
    {
        for(int i = 0; i < SIZE; i++)
            table[i] = null;
    }
    
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < SIZE; i++)
            if(table[i] != null)
                builder.append(i + 1 + ". Key: " + table[i].getKey() + " Value: " + table[i].getValue() + "\n");
            else
                builder.append(i + 1 + ". Key: null" + " Value: null" + "\n");
        return builder.toString();
    }
}

/**
 * The Driver of the Program.
 */
public class HashMapImplementation
{
    public static void main(String[] args)
    {
        // Create a HashMap Object
        HashMap hash = new HashMap();
        
        // Insert a value into a HashMap Object
        hash.insert(1,5);
        hash.insert(2,4);
        hash.insert(3,3);
        hash.insert(4,2);
        hash.insert(5,1);
        
        // Display a HashMap
        System.out.println(hash);
        
        // Get value of the key 5
        System.out.println(hash.get(5));
        
        // Remove key 1 from a HashMap
        hash.remove(1);
        
        // Display a HashMap
        System.out.println(hash);
    }
}