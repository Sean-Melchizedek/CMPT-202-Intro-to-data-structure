/**
 * Lab 13
 * Applied the max heap on the implementation of the Priority Queue.
 * @author Sean Yan
 * 
 */
public class PriorityQueue<T extends Comparable<? super T>> implements Queue<T>
{

	MaxHeap<T> queue;
	
	public PriorityQueue() 
	{
		queue =  new MaxHeap<T>();
	}

	public PriorityQueue(int capacity)
	{
		queue = new MaxHeap<T>(capacity);
	}

	@Override
	public void add(T item) 
	{
		queue.add(item);
		
	}

	@Override
	public T remove() 
	{
		return queue.remove();
	}

	@Override
	public boolean isEmpty() 
	{
		return queue.isEmpty();
	}

	@Override
	public int size() 
	{
		return queue.getSize();
	}
	
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
