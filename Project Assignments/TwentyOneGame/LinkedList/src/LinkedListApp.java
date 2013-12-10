import java.lang.StringBuilder;

class Node
{
	public String value;
	public Node next;
	
	public Node(String val, Node n)
	{
		value = val;
		next = n;
	}
	
	public Node(String val)
	{
		this(val, null);
	}
}

class LinkedList
{
	private Node first;
	private Node last;
	
	public LinkedList()
	{
		first = null;
		last = null;
	}
	
	public boolean isEmpty()
	{
		return (first == null);
	}
	
	public int size()
	{
		int count = 0;
		Node ref = first;
		while(ref != null)
		{
			ref = ref.next;
			count++;
		}
		return count;
	}
	
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("The Linked List: ");
		Node ref = first;
		while(ref != null)
		{
			builder.append(ref.value + " ");
			ref = ref.next;
		}
		return builder.toString();
	}
	
	public void add(String e)
	{
		if(isEmpty())
		{
			first = new Node(e);
			last = first;
		}
		else
		{
			last.next = new Node(e);
			last = last.next;
		}
	}
	
	public void add(int index, String e)
	{
		if(index < 0 || index > size())
			throw new IndexOutOfBoundsException();
		if(index == 0)
		{
			first = new Node(e, first);
			if(last == null)
				last = first;
			return;
		}
		Node pred = first;
		for(int i = 1; i <= index - 1; i++)
			pred = pred.next;
		pred.next = new Node(e, pred.next);
		if(pred.next.next == null)
			last = pred.next;
	}
	
	public String remove(int index)
	{
		String element = "";
		if(index < 0 || index > size())
		{
			String message = String.valueOf(index);
			throw new IndexOutOfBoundsException(message);
		}
			
		if(index == 0)
		{
			element = first.value;
			first = first.next;
			if(first == null)
				last = null;
		}
		else
		{
			Node pred = first;
			for(int i = 1; i <= index - 1; i++)
				pred = pred.next;
			element = pred.next.value;
			pred.next = pred.next.next;
			if(pred.next == null)
				last = pred;
		}
		return element;
	}
	
	public boolean remove(String e)
	{
		if(isEmpty())
			return false;
		
		if(first.value.equals(e))
		{
			first = first.next;
			if(first == null)
				last = null;
			return true;
		}
		
		Node pred = first;
		while(pred.next != null && !pred.next.value.equals(e))
			pred = pred.next;
		if(pred.next != null || !pred.next.value.equals(e))
			return false;
		
		pred.next = pred.next.next;
		if(pred.next == null)
			last = pred;
		return true;
	}
}

public class LinkedListApp
{
	public static void main(String[] args)
	{
		LinkedList ll = new LinkedList();
		ll.add("Vlad");
		ll.add("Sveta");
		ll.remove(0);
		System.out.println(ll.toString());
		
	}
}