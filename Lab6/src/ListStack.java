import java.util.ArrayList;

public class ListStack<T> implements Stack<T> 
{
	ArrayList<T> stack = new ArrayList<T>();
	
	
	
	@Override
	public void push(T item) 
	{
		stack.add(item);
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
			T rv = stack.get(lastIndex(stack));
			stack.remove(lastIndex(stack));
			return rv;
		}
	}


	@Override
	public T peek() 
	{
		T a = null;
		if(stack.isEmpty())
		{
			a = null;
		}
		else if(this.isEmpty()==false)
		{
			a =  stack.get(lastIndex(stack));
		}
		return a;
	}


	@Override
	public boolean isEmpty() 
	{
		if(stack.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	private int lastIndex(ArrayList<T> stack)
	{
		int lastIndex = stack.size() - 1;
		return lastIndex;
	}
	
	
}
