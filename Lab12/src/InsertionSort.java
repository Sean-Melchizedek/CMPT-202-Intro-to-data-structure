
public class InsertionSort<T extends Comparable<? super T>> extends SortingAlgorithm<T> {

	@Override
	public void sort(T[] array) 
	{
		GenericComparablesInsertionSort.insertionSort(array, array.length);
	}

}
