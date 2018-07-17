import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Sean
 *
 */
public class HeapSort<T extends Comparable<? super T>> extends SortingAlgorithm<T> {

	MaxHeap<T> heap;
	ArrayList<T> descendingList;
	/**
	 * 
	 */
	public HeapSort() 
	{
		heap = new MaxHeap<T>();
		descendingList = new ArrayList<T>();
	}

	/* 
	 * @see SortingAlgorithm#sort(java.lang.Comparable[])
	 */
	@Override
	public void sort(T[] array) 
	{
		for(int i = 0; i < array.length; i++)
		{
			heap.add(array[i]);
		}
		
		for(int i = 0; i < array.length; i++)
		{
			array[array.length-1-i] = heap.remove();
		}
		
	}

}
