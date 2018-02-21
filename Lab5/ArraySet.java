/*	Lab 3
 * 	
 * 	Sean Yan*
 * 
 *  The one i did with someone in class somehow can not pass the test. :-(
 * 	After trying fixing it by 4 hours, I just decided that rewrite the whole lab by myself.
 * 	I feel like it is much easier if i do the lab by myself at the beginning. 
 * 	Because my partners always don't do anything but I have to be compatible with their ideas.
 *  And sometimes being compatible really caused tons of bugs and I can't fix them. 
 *  :-(((((
 * 			  
 * 	
 *  last modified by 2/6/2018 22:05
 * 	
 * 	this is the class which implements the Set interface using an array. 
 *  The approach will be similar to how a bag was implemented with an array.(in the bag project)
 */
import java.util.Iterator;
public class ArraySet<T> implements Set<T> 
{

	public static final int DEFAULT_CAPACITY = 15;
	private static final int CAPACITY_MULTIPLIER = 2;
	private int capacity = 0;
	private int numberOfElements = 0;
	private T[] elements;
	
	// default constructor.
	public ArraySet() 
	{
		this(DEFAULT_CAPACITY);
	}
	
	// constructor that allows the original size of the set to be specified.
	@SuppressWarnings("unchecked")
	public ArraySet(int capacity) 
	{
		if (capacity < 0)// the capacity should be greater than 0.
		{
			throw new IllegalArgumentException("one set's capacity must be >= 0");
		}
		this.capacity = capacity;
		elements = (T[])new Object[capacity];
	}

	@Override
	// implementing the add method from Set interface.
	public void add(T element) 
	{
		ensureCapacity();
		if(checkDuplicates(element)==false)
		{
			elements[numberOfElements] = element;
			numberOfElements++;
		}
			
	}

	@Override
	// implementing the addAll method from Set interface.
	public void addAll(T[] elements) 
	{
		for (int i = 0; i < elements.length; i++) 
		{
			add( elements[i]);	
		}

	}

	@Override
	// implementing the contains method from Set interface.
	public boolean contains(T element) 
	{
		if (indexOf(element) > -1)
			return true;
		else
			return false;
	}

	@Override
	// implementing the getSize method from Set interface.
	public int getSize() {
		return numberOfElements;
		
	}

	@Override
	// implementing the remove method from Set interface.
	public void remove(T element) 
	{
		int index = indexOf(element);
		if (index > -1) 
		{
			numberOfElements--;
			elements[index] = elements[numberOfElements];
		}
	}

	@Override
	// implementing the union method from Set interface.
	// A union of two sets combines the elements of both sets.
	public Set<T> union(Set<T> anotherSet) 
	{
		Set<T> s = new ArraySet<T>();
		s = anotherSet.intersection(anotherSet);// copy the anotherSet in case anotherSet got changed.  
		
		for(int i = 0;i < numberOfElements; i++)
		{
			if(s.contains(elements[i])==false)
			{
				s.add(elements[i]);
			}
		}
		return s;
	}

	@Override
	// implementing the intersection method from Set interface.
	// An intersection of two sets yields the values that appear in both sets.
	public Set<T> intersection(Set<T> anotherSet) {
		Set<T> s = new ArraySet<T>();
		for(int i = 0;i < numberOfElements; i++)
		{
			if(anotherSet.contains(elements[i])==true)
			{
				s.add(elements[i]);
			}
		}
		return s;
	}

	@Override
	// implementing the difference method from Set interface.
	// The difference between S1 and S2 refers to the elements that are only in S1 and not in S2.
	public Set<T> difference(Set<T> anotherSet) {
		Set<T> s = new ArraySet<T>();
		
		for(int i = 0; i < numberOfElements; i++)
		{
			if(anotherSet.contains(elements[i])==false)
			{
				s.add(elements[i]);
			}
		}
		return s;
	}
	
//////////////////////////////////////////////helper method area//////////////////////////////////////////////
	// these methods are not related to the interface but the class itself.
	
	// make sure the capacity of the ArraySet is big enough.
	// if it's not, it will double it's capacity.
	@SuppressWarnings("unchecked")
	private void ensureCapacity() 
	{
		if (numberOfElements == capacity) 
		{
			Object[] newArray = new Object[(numberOfElements+1) * CAPACITY_MULTIPLIER];
			System.arraycopy(elements,0,newArray,0,numberOfElements);
			elements = (T[]) newArray;
		}
	}
	
	// find the index of one element from the ArraySet.
	private int indexOf(Object element)
	{
		int index = -1;
		for (int i = 0; i < numberOfElements; i++) 
		{
			if (elements[i].equals(element)) 
			{
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	// check the duplicate when you adding elements into the set.
	private boolean checkDuplicates(Object element)
	{
		boolean result = false;
		
		for(int i = 0; i < numberOfElements; i++)
		{
			if(elements[i] == element)
			{
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public Iterator<T> iterator() 
	{
		return new ArraySetIterator();
	}
	
	
	private class ArraySetIterator implements Iterator<T>
	{
		private int index = 0;
		
		/**
		 * Determines if there are more elements
		 * in the iteration.
		 * 
		 * @return true if there are more elements, false otherwise.
		 */
		public boolean hasNext() {
			if (index < numberOfElements)
				return true;
			else
				return false;
		}

		/**
		 * Returns the next element in the iteration.
		 * 
		 * @throws java.util.NoSuchElementException if there are no more elements in the iteration.
		 */
		public T next() {
			if (hasNext()) {
				T nextItem = elements[index];
				index++;
				
				return nextItem;
			}
			else
				throw new java.util.NoSuchElementException("No items remaining in the iteration.");
			
		}

		/**
		 * The remove() operation is not supported.
		 * @throws UnsupportedOperationException if involved.
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}

}
