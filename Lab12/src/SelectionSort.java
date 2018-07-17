
public class SelectionSort<T extends Comparable<? super T>> extends SortingAlgorithm<T> 
{

	@Override
	public void sort(T[] array) 
	{
		GenericComparablesSelectionSort.selectionSort(array, array.length);
		
	}

}
