/*************************************************
 * The String ArrayList implementation.          *
 * @author: Vladimir Efros                       *
 * This program implements a String ArrayList.   *
 *************************************************/

interface StringArrayList
{
    public void add(String str);
    public void add(int index, String str);
    public boolean remove(String str);
    public String remove(int index);
    public String set(int index, String str);
    public String get(int index);
    public int size();
    public void clear();
    public boolean contains(String str);
    public boolean isEmpty();
    public boolean isFull();
}

class ArrayList implements StringArrayList
{
    private final int DEFAULT_CAPACITY = 10;  // Default size of the String Array
    private final int RESIZE_FACTOR = 2;      // Resize factor is needed for resizing of the String ArrayList
    
    private String[] arrayList;               // An actual String ArrayList
    private int elems;                        // Number of elements
    
    /**
     * The constructor method creates an empty array containing 10 elements.
     */
    public ArrayList()
    {
        arrayList = new String[DEFAULT_CAPACITY];
        elems = 0;
    }
    
    /**
     * The constructor method creates an array of desired size.
     * @param capacity The size is specified by the user.
     * @exception IllegalArgumentException is thrown if the capacity is less than 1.
     */
    public ArrayList(int cap)
    {
        if(cap < 1)
            throw new IllegalArgumentException();
        
        arrayList = new String[cap];
        elems = 0;
    }
    
    /**
     * The add method adds a string to the end of the arrayList.
     * @param str String that is added to the array.
     */
    public void add(String str)
    {
        if(isFull())
            resize();
        
        else if(str == null || str.length() < 1)
            return;
        
        arrayList[elems] = str;
        elems++;
    }
    
    /**
     * The add method add a string at the specified location.
     * @param index The place where the string gets added.
     * @exception IndexOutOfBoundsException when the index is not in the right range.
     * @param str The string that is to be added to the array.
     */
    public void add(int index, String str)
    {
        if(isFull())
            resize();
        
        if(index < 0 || index > elems)
            throw new IndexOutOfBoundsException();
        
        if(str == null || str.length() <= 0)
            return;
        
        for(int index2 = elems; index2 > index; index2--)
            arrayList[index2] = arrayList[index2 - 1];
        arrayList[index] = str;
        elems++;
    }
    
    /**
     * The remove method removes the string from the list.
     * @param str The string that is to be removed from the list.
     * @return true if the string is removed, otherwise return false.
     */
    public boolean remove(String str)
    {
        if(str == null || str.length() < 1)
            return false;
        for(int index = 0; index < elems; index++)
            if(str.equals(arrayList[index]))
            {
                arrayList[index] = null;
                for(int index2 = index + 1; index2 < elems; index2++)
                    arrayList[index2 - 1] = arrayList[index2];
                elems--;
                return true;
            }
        return false;
    }
    
    /**
     * The remove method removes the string from the specified index location.
     * @param index The specified location where the string is removed.
     * @return String if the value is removed, otherwise return null.
     */
    public String remove(int index)
    {
        if(index < 0 || index >= elems)
            return null;
        String temp = arrayList[index];
        arrayList[index] = null;
        for(int index2 = index + 1; index2 < elems; index2++)
            arrayList[index2 - 1] = arrayList[index2];
        elems--;
        return temp;
    }
    
    /**
     * The set method sets the string at the specified index location.
     * @param index The location of the set string.
     * @param str The string that is to be set.
     * @return String that has been replaced.
     */
    public String set(int index, String str)
    {
        if(index < 0 || index > elems)
            return null;
        String temp = arrayList[index];
        arrayList[index] = str;
        return temp;
    }
    
    /**
     * The get method gets a value from the specified array location.
     * @param index The index that is searched.
     * @exception IndexOutOfBoundsException when the index is not in the right range.
     * @return The value at the index location.
     */
    public String get(int index)
    {
        if(index < 0 || index >= elems)
            throw new IndexOutOfBoundsException();
        return arrayList[index];
    }
    
    /**
     * The resize method resizes the array if the size gets too small.
     */
    public void resize()
    {
        // Create a new arrayList object with a larger size
        String[] newArrayList = new String[RESIZE_FACTOR * arrayList.length]; 
        
        // Copy each element into the new arrayList
        for(int index = 0; index < elems; index++)
            newArrayList[index] = arrayList[index];
        
        // Copy the reference
        arrayList = newArrayList;
    }
    
    /**
     * The clear method clears all of the elements of the array.
     */
    public void clear()
    {
        for(int index = 0; index < arrayList.length; index++)
            arrayList[index] = null;
        elems = 0;
    }
    
    /**
     * The contains method searches for the value in the string.
     * @param str The string that is searched.
     * @return true if the string i found, otherwise returns false.
     */
    public boolean contains(String str)
    {
        if(str == null || str.length() <= 0)
            return false;
        for(int index = 0; index < elems; index++)
            if(str.equals(arrayList[index]))
                return true;
        return false;
    }
    
    /**
     * The get method gets the index of the string location.
     * @param str The string that is searched.
     * @return The index of the searched string.
     */
    public int indexOf(String str)
    {
        if(str == null || str.length() < 1)
            return -1;
        
        for(int index = 0; index < elems; index++)
            if(str.equals(arrayList[index]))
                return index;
        return -1;
    }
    
    /**
     * @return The size of the array.
     */
    public int size()
    {
        return elems;
    }
    
    /**
     * @return true if the is full, otherwise return false.
     */
    public boolean isFull()
    {
        return (elems == arrayList.length);
    }
    
    /**
     * @return true if the array is empty, otherwise returns false.
     */
    public boolean isEmpty()
    {
        return (elems == 0);
    }
    
    /**
     * @return The elements of the array and converts it to string.
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("The elements of the String arrayy: ");
        for(int index = 0; index < elems; index++)
            builder.append(arrayList[index]);
        return builder.toString();
    }
}

/**
 * The program test drive.
 */
public class ArrayListImplementation 
{
    public static void main(String[] args)
    {
        // Create a new ArrayList Object
        ArrayList myList = new ArrayList();
        
        // Add the Strings to the String array
        String[] nums1 = {"Zero", "One", "Two", "Three", "Four", "Five", "Six"};
        for(String s : nums1)
            myList.add(s);
        
        // Display the String array elements
        displayList(myList);
        
        // Add the first and the last elements
        myList.add(0, "Very First!");
        myList.add(myList.size(), "Very Last!");  
                
        // Find the String in the String array
        if(myList.contains("Two"))
            System.out.println("Found!");
        else
            System.out.println("Not Found!");
        
        // Get the index of the String
        if(myList.indexOf("Five") < 0)
            System.out.println("Not found!");
        else
            System.out.println(myList.indexOf("Five"));
        
        // Remove the element from the String array
        myList.remove("One");
        
         // Display the String array elements
        displayList(myList);
        
        // Remove the String element by the index
        myList.remove(3);
        
        // Replace the String by specifying index
        myList.set(0, "VERY FIRST!");
        myList.set(myList.size() - 1, "VERY LAST!");
        
        // Delete all the element in the String array
        myList.clear();
        System.out.println(myList.size());
        
        // Display the String array elements
        displayList(myList);
    }
    
    public static void displayList(StringArrayList theList)
    {
        for(int index = 0; index < theList.size(); index++)
            System.out.print(theList.get(index) + " ");
        System.out.println();
    }
}