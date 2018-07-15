/*
 * Lab 7
 * Sean Yan & 
 * 
 * 
 */
public class ArrayQueue<T> implements Queue<T> 
{	
	public static final int CAPACITY_MULTIPLIER = 2;
	public static final int DEFAULT_CAPACITY = 15;
	private int capacity = 0;
	private int numberOfItems = 0;
	private T[] queue;
	private int front = 0;
	private int rear = 0;
	
	public ArrayQueue()
	{
		this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int capacity)
	{
		if (capacity < 0) 
		{
			throw new IllegalArgumentException("Capacity must be >= 0");
		}
		
		this.capacity = capacity;
		queue = (T[])new Object[capacity];
	}

	@Override
	public void add(T item) 
	{
		ensureCapacity();
		
		if(this.isEmpty())
		{
			if(queue[rear]!= null)
			{
				bleachlist();
			}
			queue[front] = item;
			numberOfItems++;
		}
		else
		{
			rear++;
			if(rear == capacity && rear>front && front>0)
			{
				rear = 0;	
			}
			queue[rear] = item;
			numberOfItems++;
		}
		printlist();
	}

	@Override
	public T remove() 
	{
		T rv;
		if(this.isEmpty())
		{
			rv = null;
		}
		else
		{
			rv = queue[front];
			front++;//front move one time
			if(front == capacity)
			{
				front = 0;	
			}
			numberOfItems--;
		}
		printlist();
		return rv;
	}

	@Override
	public boolean isEmpty() 
	{
		if(numberOfItems == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int size() 
	{
		return numberOfItems;
	}

	@SuppressWarnings("unchecked")
	private void ensureCapacity() 
	{
		if (numberOfItems == capacity) 
		{
			T[] newArray = (T[])new Object[(numberOfItems + 1) * CAPACITY_MULTIPLIER];
			
			if(rear>front)
			{
				System.arraycopy(queue, front, newArray, 0, numberOfItems);
			}
			else if(rear < front)
			{
				System.arraycopy(queue, front, newArray, 0, capacity-front);
				System.arraycopy(queue, 0, newArray, capacity-front, front);
				front = 0;
				rear = numberOfItems-1;
			}
			capacity = (numberOfItems + 1) * CAPACITY_MULTIPLIER;
			queue = newArray;
			printlist();
		}
	}
	
	private void printlist()
	{
		System.out.println();
		System.out.println("+++++++++++++++++++++");
		for(int i = 0; i < queue.length; i++)
		{
			System.out.print(queue[i]+ " ");
		}
		System.out.println();
		for(int i = 0; i < queue.length; i++)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("+++++++++++++++++++++");
		System.out.println("front"+front);
		System.out.println("rear"+rear);
		System.out.println("numberOfItems: " + numberOfItems);
	}

	private void bleachlist()
	{
		if(numberOfItems == 0)
		{
			for(int i = 0; i< queue.length; i++)
			{
				queue[i] = null;
			}
			front = 0;
			rear = 0;
		}
	}
}
