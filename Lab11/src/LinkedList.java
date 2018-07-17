import java.util.ArrayList;

/**
 * Implementation of the List interface.
 * 
 * This implementation involves a single-linked list.
 * This list is implemented by node.
 * 
 * Starting code @author Greg Gagne - February 2017
 * 
 * fully implemented @author Sean Yan & 
 * 
 * finished by 2/13/2018 20:47
 * 4/16/2018 adding the generic.
 * 
 *
 */
public class LinkedList<T> implements List<T> 
{
	// reference to the head of the linked list
	private Node head;

	// number of elements in the list
	private int numberOfElements;

	public LinkedList() 
	{
		head = null;
	}

	/** 
	 * Inner class representing a node in the linked list
	 */

	private class Node
	{
		private T data;
		private Node next;

		private Node(T data) {
			this(data,null);
		}

		private Node (T data, Node next) 
		{
			this.data = data;
			this.next = next;
		}
		
	}

	// Methods

	@Override
	public void add(T item) 
	{
		// adds (appends) an item to the rear of the list
		Node newNode = new Node(item);
		Node current = head;
		if (isEmpty()) 
		{
			// special case - first element being added to the list
			head = newNode;
		}
		else 
		{
			while (current.next != null) 
			{
				current = current.next;
			}
			// current now references the last item in the list
			current.next = newNode;
		}
		newNode.next = null;
		++numberOfElements;
	}

	@Override
	//adds item to List at specified index. 
	public boolean add(T item, int index) 
	{
		boolean result = false;
		Node prevsnode = head;
		Node current = head;
		Node tailnode;
		Node insertnode = new Node(item);
		
		if(index == 0)
		{
			if(head!=null)//if it is not empty
			{
				while(current.next != null)
				{	
					current = current.next;
				}
				tailnode = current;//find the tail node
				insertnode.next = head;
				head = insertnode;
				this.add(tailnode.data);// add the tail node back to the new list
				//numberOfElements++;
				// as using the add method we don't need to increase the number of elements any more.
				result = true;
			}
			else// if it is empty
			{
				add(item);//simply add it at the beginning.
				result = true;
			}
		}
		else// if it doesn't adding at the beginning.
		{
			if(index <= numberOfElements)
			{
				for(int i = 0; i < index-1; i++)
				{
					prevsnode = prevsnode.next;//prevs node from current(index -1)
				}
				for(int i = 0; i < index; i++)
				{
					current = current.next;// find the current node
				}
				insertnode.next = current;// the next of insert node is the current
				prevsnode.next = insertnode;// the next of prevs of current node is the insert node.
				numberOfElements++;			// before current --> insert --> current
				result = true;
			}
			else// if the index user input is bigger than the list's length
			{
				System.out.println("your input index in method add(item, index) is invalid.");
				System.out.println("it is bigger than the number of elements in list");
				System.out.println("the method will put your item at the end of the list.");
				add(item);// just add it at the end of the list
				result = true;
			}
		
		}
		return result;
	}

	@Override
	public boolean contains(T item) 
	{
		Node current = head;
		boolean found = false;

		while (current != null && !found)
		{
			if (current.data.equals(item)) 
			{
				found = true;
			}
			current = current.next;
		}
		return found;
	}

	@Override
	// return the data at the input index
	public T get(int index) 
	{
		Node current = head;
		
		if(numberOfElements > index)
		{
			for(int i = 0; i < index; i++)
			{
				current = current.next;
			}

			return current.data;
		}
		else return null;
	}

	@Override
	// (Thank god) it only Removes the first occurrence of the item from List
	// I thought the lab want me to remove all the items with same value
	// actually it doesn't :-)
	public boolean remove(T item) 
	{
		boolean result = false;
		if(contains(item))
		{
			int index = indexData(item);
			remove(index);// why don't we using the method which is already there? 
			result = true;
		}
		else// if item isn't in the list at the first place then we have to tell the user.
		{
			System.out.println(item + " does not exsit in the list.");
		}

		return result;
	}

	@Override
	public T remove(int index)
	{
		T rv = null;
		if (isEmpty() || index >= numberOfElements) 
		{
			rv = null;
		}
		else if (index == 0) 
		{
			// special case - first element in the list
			rv = head.data;
			head = head.next;
			numberOfElements--;
		}
		else 
		{
			int currentIndex = 0;
			Node current = head;

			while (currentIndex < (index - 1)) 
			{
				current = current.next;
				currentIndex++;
			}
			// current references the node we want to remove
			rv = current.next.data;
			current.next = current.next.next;
			numberOfElements--;
		}
		return rv;
	}

	@Override
	public int getLength()
	{
		// this S.O.P helped me to indicate the bug, I feel it is very useful so I just keep it
		System.out.println("your list right now is: "+ showList()+ ", length is: "+ numberOfElements);// this is using a helper method showList().
		return numberOfElements;
		
	}

	@Override
	// Determines if the List is empty.
	public boolean isEmpty() 
	{
		Node current = head;
		boolean empty = false;
		
		if(current == null)
		{
			empty = true;	
		}
		return empty;
	}

	@Override
	// Determines the frequency of item appearing in the List
	public int getFrequency(T item) 
	{
		Node current = head;
		int count = 0;
		while (current != null) 
		{
			if (current.data.equals(item)) 
			{
				count++;
			}
			current = current.next;
		}
		return count;
	}

	@Override
	// as it is singular linked, so once clean the head, it cleans everything
	public void clear() 
	{
		this.head = null;
	}
	
//////////////////////////////////////////////////////////these are the helper method////////////////////////////////////////////////////////	
	
	// helper method that return the content of the list.
	private ArrayList<T> showList()
	{
		ArrayList<T> content = new ArrayList<T>();
		for(int i = 0; i < numberOfElements; i++)
		{
			content.add(get(i));
		}
		
		return content;
	}
	
	// helper method that return the position of one data
	private int indexData(T item)
	{
		Node current = head;
		boolean found = false;
		int count = -1;
		while (current != null && !found) 
		{
			if (current.data.equals(item)) 
			{
				found = true;
			}
			current = current.next;
			
			count++;
		}
		return count;
	}
	
	

}
