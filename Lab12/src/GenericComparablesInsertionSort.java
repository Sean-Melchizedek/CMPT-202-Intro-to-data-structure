/********************************************************************
 * Class for sorting an array of Comparable objects from smallest to 
 * largest.
 * This version of the class uses generics that are Comparables
 ********************************************************************/

public class GenericComparablesInsertionSort {

	public GenericComparablesInsertionSort() 
	{}

	
	/*
	 * Sorts the first n objects in an array into ascending order
	 * using insertion sort algorithm.
	 */	
	public static <T extends Comparable<? super T>> void insertionSort(T[] array, int length) 
	{
		for(int i = 1; i < array.length; i ++)
		{
			T key = array[i];
			int j = i - 1;
			
			while(j >= 0 && (array[j].compareTo(key) > 0))
			{
				array[j+1] = array[j];
				j--;
			}
			
			array[j+1] = key;
		}
	} 

}
