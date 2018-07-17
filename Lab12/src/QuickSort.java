
public class QuickSort<T extends Comparable <? super T>> extends SortingAlgorithm<T> {
	
	
	@Override
	public void sort(T[] array) 
	{
		this.quickSort(array, 0, array.length-1);
	}
	
	
	private void quickSort(T[]array, int left, int right)
	{
		T pivot = array[right];
		int origin_left = left;
		int origin_right = right;
		
		while(left <= right)
		{
			while(array[left].compareTo(pivot) < 0)
			{
				left++;
			}
			while(array[right].compareTo(pivot) > 0)
			{
				right--;
			}
			
			if(left <= right)
			{
				swap(array, left, right);
				left++;
				right--;
			}
		}
		// call quick sort recursively
		if(origin_left < right)
		{
			quickSort(array,origin_left,right);
		}
		if(left < origin_right)
		{
			quickSort(array,left,origin_right);
		}
		
		
	}
	
	/** Task: Swaps the array elements a[i] and a[j].
	 *  @param array  an array of T
	 *  @param i  an integer >= 0 and < a.length
	 *  @param j  an integer >= 0 and < a.length */
	private void swap(T[] array, int i, int j)
	{
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp; 
	} 

}
