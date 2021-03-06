
import java.util.Scanner;

/**
 * The StirngList interface specifies the operations
 * that should be supported by a list of strings.
 */
interface StringList
{
	/**
	 * The add method adds a string to the list.
	 * @param str The string to add.
	 */
	public void add(String str);
	
	/**
	 * The add method adds a string at a specific index.
	 * @param index The added string position.
	 * @param str The string to add.
	 * @exception IndexOutOfBoundsException When index is out of bounds.
	 */
	public void add(int index, String str);
	
	/** The clear method clears the list */
	public void clear();
	
	/**
	 * The contains method searches the list for a specified string.
	 * @param str The string to search for.
	 * @return true of the list contains the string; false otherwise.
	 */
	public boolean contains(String str);
	
	/**
	 * The get method gets an element at a specific position.
	 * @param index The specified index.
	 * @return The element at index.
	 * @exception IndexOutOfBoundsException When index is out of bounds.
	 */
	public String get(int index);
	
	/**
	 * The indexOf method gets an index of the first 
	 * occurrence of the specified string.
	 * @param The string to search for.
	 * @return The index of the first occurrence of string
	 * if it exists; -1 if string is not on the list.
	 */
	public int indexOf(String str);
	
	
	/**
	 * The isEmpty method determines whether the list is empty.
	 * @return true of the list is empty; false otherwise.
	 */
	public boolean isEmpty();
		
	/**
	 * The remove method removes a specific string from the list.
	 * @param str The string to remove.
	 * @return true if the string was found; false otherwise.
	 */
	public boolean remove(String str);
		
	/**
	 * The method removes a string at a specific index.
	 * @param index The index of the string to remove.
	 * @exception IndexOutOfBoundsException When index is out of bounds.
	 */
	public String remove(int index);
	
	/**
	 * The set method replaces the string at a specified index with another string.
	 * @param index The index of the string to be replace.
	 * @param str The string to replace it with.
	 * @return The string previously stored at the index.
	 * @exception IndexOutOfBoundsException When index is out of bounds.
	 */
	public String set(int index, String str);
	
	/**
	 * The size method gets the number of elements in the list.
	 * @return The number of elements in the list.
	 */
	public int size();
}

class StringListType implements StringList
{
	// Constants for the default capacity and the resizing factor.
	private final int DEFAULT_CAPACITY = 10;
	private final  int RESIZE_FACTOR = 2;
	private String[] list;
	private int elements;
	
	// Constructor method #1.
	public StringListType()
	{
		list = new String[DEFAULT_CAPACITY];
		elements = 0;
	}

	// Constructor method #2.
	public StringListType(int capacity)
	{
		if(capacity < 1)
			throw new IllegalArgumentException();
		list = new String[capacity];
		elements = 0;
	}
	
	public void add(String str)
	{
		if(elements == list.length)
			resize();
		else
			list[elements++] = str;
	}
	
	private void resize()
	{
		int newLength = list.length * RESIZE_FACTOR; // Calculate a new length.
		String[] tempList = new String[newLength];     // Create a new list.
		for(int index = 0; index < elements; index++) // Copy existing elements to the new list.
			tempList[index] = list[index];
		list = tempList; // Replace a new list with the existing once.
	}
	
	public void add(int index, String str)
	{
		if(index < 0 || index >= elements) // Check if the index is valid.
			throw new IndexOutOfBoundsException();
		
		if(elements == list.length) // If the list is full, resize it
			resize();
		
		// Shift the elements starting at index to the rigth one position
		for(int index2 = index + 1; index2 < elements; index2++) 
			list[index2 + 1] = list[index2];
		list[index] = str;
		elements++;
	}
	
	public void clear()
	{
		for(int index = 0; index < list.length; index++)
			list[index] = null;
		elements = 0;
	}
	
	public boolean contains(String str)
	{
		for(int index = 0; index < elements; index++)
			if(list[index].equals(str))
				return true;
		return false;
	}

	public String get(int index)
	{
		if(index < 0 || index >= elements)
			throw new IndexOutOfBoundsException();
		return list[index];
	}
	
	public int indexOf(String str)
	{
		int index = -1;
		for(index = 0; index < elements; index++)
			if(list[index].equals(str))
				return index;
		return index;
	}
	
	public boolean isEmpty()
	{
		return (elements == 0);
	}
		
	public boolean remove(String str)
	{
		int index;
		for(index = 0; index < elements; index++)
			if(list[index].equals(str))
			{
				list[index] = null;
				break;
			}
			else
				return false;
		for(int index2 = index; index < elements; index++)
			list[index2 - 1] = list[index2];
		elements--;
		return true;
	}

	public String remove(int index)
	{
		if(index < 0 || index >= elements)
			throw new IndexOutOfBoundsException();
		String temp = list[index];
		list[index] = null;
		index++;
		elements--;
		for(int index2 = index; index2 < elements; index2++)
			list[index2 - 1] = list[index2];
		return temp;
	}
	
	public String set(int index, String str)
	{
		if(index < 0 || index >= elements)
			throw new IndexOutOfBoundsException();
		String temp = list[index];
		list[index] = str;
		return temp;
	}
	
	public int size()
	{
		return elements;
	}
	
	public String[] toStringArray()
	{
		String[] stringArray = new String[elements];
		
		for(int index = 0; index < elements; index++)
			stringArray[index] = list[index];
		return stringArray;
	}

}

public class StringListApp
{
	public static void main(String[] args) 
	{
		StringListType myList = new StringListType();
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter a series of words:");
		String input = keyboard.nextLine();
		
		String[] tokens = input.split(" ");
		for(String s : tokens)
			myList.add(s);
		System.out.println("Here are the words you entered: ");
		displayList(myList);
		myList.remove(0);
		myList.remove(myList.size() - 1);
		System.out.println("Here are the words after change: ");
		displayList(myList);
		myList.add(0, "dog");
		myList.add("cat");
		System.out.println("Here are the words after change: ");
		displayList(myList);
 	}
		
	public static void displayList(StringList list)
	{
		for(int index = 0; index < list.size(); index++)
			System.out.println("Index " + index + ":" + list.get(index));
	}
}
