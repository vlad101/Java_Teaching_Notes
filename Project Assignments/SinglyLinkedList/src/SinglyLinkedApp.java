class Node
{
	public int value;
	public Node next;
	
	public Node(int val, Node n)
	{
		value = val;
		next = n;
	}
	
	public Node(int val)
	{
		this(val, null);
	}
}

class SinglyLinkedList
{
	private Node first;
	private Node last;
	
	public SinglyLinkedList()
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
		for(Node current = first; current != null; current = current.next)
			count++;
		return count;
	}
	
	public void add(int val)
	{
		if(isEmpty())
		{
			first = new Node(val, first);
			last = first;
		}
		else
		{
			last.next = new Node(val, first);
			last = last.next;
		}
	}
	
	public void add(int index, int val)
	{
		if(index < 0 || index > size())
			throw new IndexOutOfBoundsException();
		if(index == 0)
		{
			first = new Node(val, first);
			if(last == null)
				last = first;
		}
			
		else
		{
			Node pred = first;
			for(int i = 1; i <= index; i++)
				pred = pred.next;
			pred.next = new Node(val, pred.next);
			if(pred.next.next == null)
				last = pred.next;
		}
			
	}
	
	
	public Node deleteFirst()
	{
		Node temp = first;
		first = first.next;
		if(first == null)
			last = null;
		return temp;
	}
	
	public boolean find(int val)
	{
		for(Node current = first; current != null; current = current.next)
			if(current.value == val)
				return true;
		return false;
	}

	public boolean delete(int val)
	{
		if(isEmpty())
			return false;
		if(first.value == val)
		{
			first = first.next;
			if(first == null)
				last = null;
			return true;
		}
		
		else
		{
			Node current;
			for(current = first; current.next != null && !(current.next.value == val); current = current.next)
				current = current.next;
			if(current.next == null)
				return false; 
			current.next = current.next.next;
			if(current.next == null)
				last = current;
			return true;
		}
	}
	
	public String toString()
	{
		java.lang.StringBuilder builder = new java.lang.StringBuilder();
		for(Node current = first; current != null; current = current.next)
			builder.append(current.value + " ");
		return builder.toString();			
	}
}

public class SinglyLinkedApp 
{
	public static void main(String[] args) 
	{
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.add(5);
		sll.add(9);
		sll.add(8);
		System.out.println(sll);
	}

}
