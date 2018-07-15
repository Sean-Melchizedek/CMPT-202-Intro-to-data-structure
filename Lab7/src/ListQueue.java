import java.util.ArrayList;
public class ListQueue<T> implements Queue<T> 
{
		ArrayList<T> queue = new ArrayList<T>();

		@Override
		public void add(T item)
		{
			queue.add(item);
		}

		@Override
		public T remove() 
		{
			T firstItem;
			if(queue.isEmpty()== false)
			{
				firstItem = queue.remove(0);
			}
			else
			{
				firstItem = null;
			}
			return firstItem;
		}

		public int size() 
		{
			return queue.size();
		}

		@Override
		public boolean isEmpty() 
		{
			
			return queue.isEmpty();
		}

}


