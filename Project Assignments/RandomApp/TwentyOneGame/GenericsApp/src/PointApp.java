import java.lang.StringBuilder;

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
		for(Node ref = first; ref != null; ref = ref.next)
			count++;
		return count;
	}
	
	public void add(int e)
	{
		if(isEmpty() || first.value > e)
		{
			first = new Node(e, first);
			last = first;
		}
		else
		{
			Node ref;
			for(ref = first; ref.next != null; ref = ref.next)
				if(ref.next.value > e)
					break;
			ref.next = new Node(e, ref.next);
			if(ref.next.next == null)
				last = ref.next;
		}
	}
	
	public void add(int index, int e)
	{
		if(index < 0 || index > size())
			throw new IndexOutOfBoundsException();
		if(index == 0)
		{
			first = new Node(e, first);
			if(last == null)
				last = first;
		}
		
		else
		{
			Node pred = first;
			for(int i = 1; i <= index - 1; i++)
				pred = pred.next;
			pred.next = new Node(e, pred.next);
			if(pred.next.next == null)
				last = pred.next;
		}
	}
	
	public boolean remove(int e)
	{
		if(isEmpty())
			return false;
		if(first.value == e)
		{
			first = first.next;
			if(first == null)
				last = null;
			return true;
		}
		else
		{
			Node pred;
			for(pred = first; pred.next != null && !(pred.next.value ==e); pred = pred.next)
			{
				pred = pred.next;
				if(pred.next == null)
					System.out.println("HELLO");
			}
				
				
			pred.next = pred.next.next;
			if(pred.next == null)
				last = pred;
			return true;	
		}
	}	
	
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		for(Node ref = first; ref != null; ref = ref.next)
			builder.append(ref.value + " ");
		builder.append("where First: " + first.value + " and "+ "Last: " + last.value);
		return builder.toString();
	}
}

public class PointApp
{
	public static void main(String[] args) 
	{
		LinkedList ll = new LinkedList();
		//ll.add(0, "Zero");
		ll.add(12);
		ll.add(1);
		ll.add(68);
		ll.add(5);
		ll.add(7);
		System.out.println(ll.toString());
		ll.remove(5);
		ll.remove(7);
		ll.remove(12);
		ll.remove(1);
		
		System.out.println(ll.toString());
 	}
}
