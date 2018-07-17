
public abstract class SortingAlgorithm <T extends Comparable <? super T>> extends Algorithm<T>{
	static final int NUMBER = 5;
	
	
	/**
	 * sorts the parameter array in ascending order (from smallest to largest) 
	 */ 
	public abstract void sort (T[] array);
	
	
	/**
	 * Invoke the appropriate sorting algorithm.
	 */
	public void apply(T[] array) 
	{
	    this.sort(array);
	}

	
	/*
	 *  take an array of Comparable objects as an argument  
	 *  return true if it is sorted, and false otherwise.
	 */
	public static <T extends Comparable<? super T>> boolean isSorted(Comparable[] array)
	{
		boolean result = true;
		for(int i = 1; i < array.length; i++)
		{
			if(array[i-1].compareTo(array[i]) > 0)
			{
				result = false;
				break;
			}
			
		}
		return result;
	}
	
	public static void compareSorts(int n)
	{
		SortingAlgorithm[] sorts = new SortingAlgorithm[NUMBER];
		sorts[0] = new SelectionSort();
		sorts[1] = new InsertionSort();
		sorts[2] = new MergeSort();
		sorts[3] = new QuickSort();
		sorts[4] = new HeapSort();
		
		String[] sortNames = new String[NUMBER];
		sortNames[0] = "SelectionSort: ";
		sortNames[1] = "InsertionSort: ";
		sortNames[2] = "MergeSort: ";
		sortNames[3] = "QuickSort: ";
		sortNames[4] = "HeapSort: ";
		
		Integer[][] sortArray = new Integer[NUMBER][n];
	    sortArray[0] = createRandomArray(n);

	    System.arraycopy(sortArray[0], 0, sortArray[1], 0, sortArray[0].length);
	    System.arraycopy(sortArray[0], 0, sortArray[2], 0, sortArray[0].length);
	    System.arraycopy(sortArray[0], 0, sortArray[3], 0, sortArray[0].length);
	    System.arraycopy(sortArray[0], 0, sortArray[4], 0, sortArray[0].length);
	     
	    for (int i=0; i < sorts.length; i++) 
	    {
	    	System.out.println(sortNames[i] + sorts[i].time(sortArray[i]));
	 	}
	}
	
	
	

}
