
public class ArrayStack<T> implements Stack<T> 
{

	public static final int CAPACITY_MULTIPLIER = 2;
	public static final int DEFAULT_CAPACITY = 15;
	
	private int capacity = 0;
	private int numberOfItems = 0;
	private T[] stack;
	
	public ArrayStack() 
	{
		this(DEFAULT_CAPACITY);
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity)
	{
		if (capacity < 0) 
		{
			throw new IllegalArgumentException("Capacity must be >= 0");
		}
		
		this.capacity = capacity;
		stack = (T[])new Object[capacity];
	}
	
	@Override
	public void push(T item)
	{
		ensureCapacity();
		ensureCapacity();
		ensureCapacity();

		stack[numberOfItems] = item;
		numberOfItems++;
		
		
	}

	@Override
	public T pop() 
	{
		if(this.isEmpty())
		{
			return null;
		}
		else
		{
			T rv = stack[numberOfItems-1];
			stack[numberOfItems] = null;
			if(numberOfItems > 0)
			{
				numberOfItems--;
			}
			return rv;
		}
	}

	@Override
	public T peek() 
	{
		if(this.isEmpty())
		{
			return null;
		}
		else
		{
			return stack[numberOfItems-1];
		}
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

	@SuppressWarnings("unchecked")
	private void ensureCapacity() 
	{
		if (numberOfItems == capacity) 
		{
			T[] newArray = (T[])new Object[(numberOfItems + 1) * 10000];
			System.arraycopy(stack, 0, newArray, 0, numberOfItems);
			stack = newArray;
		}
	}
}
