import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements Iterable<Item>
{
	private class Node
	{
		Item item;
		Node next;
	}

	private Node first;
	private Node last;
	private int n;

	public Deque()
	{
		// construct an empty deque
		first = null;
		last = null;
		n = 0;
	}

	public boolean isEmpty()
	{
		// is the deque empty?
		return (first == null);
	}

	public int size()
	{
		// return the number of items on the deque
		return n;
	}

	public void addFirst(Item item)
	{
		// add the item to the front
		if (item == null)
			throw new java.lang.NullPointerException("The elemnet is null!");
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		if (last == null)
			last = first;
		n++;
	}

	public void addLast(Item item)
	{
		// add the item to the end
		if (item == null)
			throw new java.lang.NullPointerException("The elemnet is null!");
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (this.isEmpty())
			first = last;
		else
			oldlast.next = last;
		n++;
	}

	public Item removeFirst()
	{
		// remove and return the item from the front
		if (this.isEmpty())
			throw new java.util.NoSuchElementException("The deque is enpty!");
		Item temp = first.item;
		if (last == first)
			last = first = null;
		else
			first = first.next;
		n--;
		return temp;

	}

	public Item removeLast()
	{
		// remove and return the item from the end
		if (this.isEmpty())
			throw new java.util.NoSuchElementException("The deque is enpty!");
		Item temp = last.item;
		if (last == first)
			last = first = null;
		else
		{
			while (first.next != null)
				first = first.next;
			first.next = null;
		}
		n--;
		return temp;

	}

	public Iterator<Item> iterator()
	{
		// return an iterator over items in order from front to end
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;

		public boolean hasNext()
		{
			return current != null;
		}

		public void remove()
		{
			throw new java.lang.UnsupportedOperationException("The method is not supported");
		}

		public Item next()
		{
			if (current == null)
			{
				throw new java.util.NoSuchElementException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String[] args)
	{ // unit testing
		Deque<String> deque = new Deque<String>();
		deque.addFirst("aa");
		deque.addFirst("bb");
		deque.addFirst("cc");
		deque.addLast("dd");
		StdOut.println(deque.removeFirst());
		StdOut.println(deque.removeFirst());
		StdOut.println(deque.removeFirst());
		StdOut.println(deque.removeLast());
		StdOut.print("size:" + deque.size());
	}

}