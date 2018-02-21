import java.util.ArrayList;
import java.util.Iterator;
/* Lab5
 * finished by 2/17/2018
 * 
 * @author Sean Yan
 * 
 * this is the class which implements the Set interface using an array list. 
 * The approach will be similar to how a Set was implemented with an array.
 *
 */


public class ListSet<T> implements Set<T> {

	private ArrayList<T> set = new ArrayList<T>();
	
	public ListSet() 
	{
		
	}

	@Override
	//Adds a new element to the set as long as it is not present in the set.
	public void add(T element) 
	{
		set.add(element);
	}

	@Override
	// Adds an array of elements to the set as long as an element is not present in the set.
	public void addAll(T[] elements) 
	{
		for(int i = 0; i< elements.length; i++)
		{
			set.add(elements[i]);
		}
	}

	@Override
	//Determines whether a set contains a specified element, returns true if set contains element, false otherwise.
	public boolean contains(T element) 
	{
		return set.contains(element);
	}

	@Override
	//Retuns the size (in elements) in the set.
	public int getSize() 
	{	
		return set.size();
	}

	@Override
	//Removes the specified element from the set.
	public void remove(T element) 
	{
		set.remove(element);
	}

	@Override
	 /** 
     * Creates a new set that combines the contents if this
     * set and anotherSet. If the same item occurs in each
     * set, only one item appears in the new set.
     *
     * Both this set and anotherSet are unchanged.
     *
     * Returns the new set.
     */
	public Set<T> union(Set<T> anotherSet) 
	{
		for(int i = 0; i < this.getSize(); i++)
		{
			if(anotherSet.contains( set.get(i) ) == false )
			{
				anotherSet.add(set.get(i));
			}
			
		}
		return anotherSet;
	}

	@Override
	 /**
     * Creates a new set that contains the objects that occur
     * in both this set and anotherSet.
     *
     * Returns the new set.
     */
	public Set<T> intersection(Set<T> anotherSet) 
	{
		Set<T> a = new ListSet<T>();
		for(int i = 0; i < this.getSize(); i++)
		{
			if(anotherSet.contains( set.get(i) ))
			{
				a.add(set.get(i));
				System.out.println(set.get(i));
			}	
		}
		return a;
	}

	@Override
	 /**
     * Creates a new set containing the objects that would
     * left in this set after removing those that also 
     * occur in anotherSet.
     *
     * Returns the new set.
     */
	public Set<T> difference(Set<T> anotherSet) 
	{
		Set<T> a = new ListSet<T>();
		for(int i = 0; i < this.getSize(); i++)
		{
			if(anotherSet.contains( set.get(i) )== false)
			{
				a.add(set.get(i));
				System.out.println(set.get(i));
			}	
		}
		return a;
	}

	@Override
    /**
     * Returns an iteration of the Set
     */
	public Iterator<T> iterator() {
		return new ListSetIterator();
	}
	
	private class ListSetIterator implements Iterator<T>
	{
		private int index = 0;
		
		/**
		 * Determines if there are more elements
		 * in the iteration.
		 * 
		 * @return true if there are more elements, false otherwise.
		 */
		public boolean hasNext() 
		{
			if (index < set.size())
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
				T nextItem = set.get(index);
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
