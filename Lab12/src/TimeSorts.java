public class TimeSorts {

	public TimeSorts() 
	{}

	public static void main(String[] args) 
	{
		System.out.println("Sort for random number array, length: 25000");
		SortingAlgorithm.compareSorts(25000);
		System.out.println();
		System.out.println("Sort for random number array, length: 50,000");
		SortingAlgorithm.compareSorts(50000);
		System.out.println();
		System.out.println("Sort for random number array, length: 75,000");
		SortingAlgorithm.compareSorts(75000);
		System.out.println();
		System.out.println("Sort for random number array, length: 100,000");
		SortingAlgorithm.compareSorts(100000);
		System.out.println();
	
	}

}
