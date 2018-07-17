/**
 * 
 * Lab 13
 * MaxHeap.java
 * 
 * Implementation of the HeapInterface as a maximum heap (max heap)
 * 
 * @Sean
 *
 * @param <T>
 */
public class MaxHeap <T extends Comparable<? super T>> implements HeapInterface<T> 
{
	private T[] elements;
	private int numberOfElements = 0;
	private static final int DEFAULT_CAPACITY = 10;
	
	// as we always left the index zero empty so that we can have the sweet algebra equation for detecting children.
	
	
	

	public MaxHeap() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public MaxHeap(int capacity) 
	{
		elements = (T[]) new Comparable[capacity + 1];
	}

	
	public void add(T item) 
	{
		this.ensureCapacity();
		
		// to find the children/ parent for a node:
		// children_j = Node(j*2) || Node(j*2+1)
		// parent_j = Node(j/2)
		int addingIndex = numberOfElements + 1;
		int parentIndex = addingIndex/2;
		
		//1.put the item in the next available index.
		elements[addingIndex] = item;
			
		//2.check if item is bigger than its parent until reach the root.
		// if true, swap item.
		if(numberOfElements > 0 )
		{
//			System.out.println("before swap: ");
//			System.out.println("elements[adding]: " + elements[addingIndex]+" index "+ addingIndex);
//			System.out.println("elements[parent]: " + elements[parentIndex]+" index "+ parentIndex);
			while(elements[addingIndex].compareTo(elements[parentIndex])> 0 )
			{
				// put the parent in an instance variable.
				T instanceParent = elements[parentIndex];
				
				// swap
				elements[parentIndex] = elements[addingIndex];
				elements[addingIndex] = instanceParent;
				addingIndex = parentIndex;
				// if parent is root, then stop tracing after parent.
				if(parentIndex> 1)
				{	// still compare to the root though.
					parentIndex = parentIndex/2;
				}
			}
//			System.out.println("after swap: ");
//			System.out.println("elements[adding]: " + elements[addingIndex]+" index "+ addingIndex);
//			System.out.println("elements[parent]: " + elements[parentIndex]+" index "+ parentIndex);
//			for(int i = 0; i < elements.length; i++)
//			{
//				System.out.print(" "+ elements[i]);
//			}
//			System.out.println();
//			System.out.println();
		}
		this.numberOfElements++;
	}

	

	/**
	 * Removes and returns the item at the head of the heap.
	 * removes and returns the maximum item.
	 * Returns null if the heap is empty
	 */
	public T remove() 
	{	
		
		T instanceMax = elements[1];
		// after we remove, put the last item into the root.
		elements[1] = elements[numberOfElements];
		
		int position = 1;
		int greatest = 0;
		
		boolean swaping = true;
		
		
//		System.out.println("# elements " + numberOfElements);
//		System.out.println("removed: "+ instanceMax);
//		System.out.println("replaced by : " + elements[position]);
		
		
		while(swaping) 
		{
			if(position*2 >= numberOfElements)
			{
				break;
			}
	
			// find the index of the biggest child
			greatest = findIndex(findBiggerChild(elements[position*2], elements[position*2+1]));
			// compare 
			if(elements[position].compareTo(elements[greatest]) < 0)
			{
				//swap
				T instanceInPos = elements[position];  
				elements[position] = elements[greatest];
				elements[greatest] = instanceInPos;
				
				//update the position.
				position = greatest;
				
			}
			else
			{
				break;
				
			}
		}
		numberOfElements--;		
		return instanceMax;
	
	}
	

	private T findBiggerChild(T left, T right)
	{
		// if parent has two children 
		if(left != null && right != null)
		{
			if(left.compareTo(right) > 0)
			{
				return left;
			}
			else
			{
				return right;
			}
		}
		// if parent only has left children
		else
		{
			return left;
		}
		
	}
	
	private int findIndex(T item)
	{
		int result = 0;
		for(int i = 1; i< numberOfElements; i++)
		{
			if(elements[i].equals(item))
			{
				result = i;
			}
		}
		return result;
	}

	

	public T front() 
	{
		if(numberOfElements != 0)
		{
			return elements[1];
		}
		else 
		{
			return null;
		}
	}

	public boolean isEmpty() 
	{
		if(numberOfElements == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public int getSize() 
	{
		return numberOfElements;
	}
	

	private void ensureCapacity() 
	{
		// The following is a starting point
		elements = java.util.Arrays.copyOf(elements,  5 + elements.length);
	}
	
	public String toString()
	{   
		String array = new String("elements: ");
		for(int i =1; i< numberOfElements+1; i++)
		{
			array += " " + elements[i];
		}
		return array;
	}
	
	
}
