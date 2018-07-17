import java.util.Random;

public abstract class Algorithm < T extends Comparable < ? super T > >  {

	public Algorithm() 
	{
		
	}
	
	/*
	 *  abstract
	 *  passed a T array and applies an algorithm to it
	 */
	public abstract void apply(T[] array);
	{}

	/*
	 * takes a T array and returns the number of milliseconds required to invoke the apply() method 
	 * will ultimately use this method to record how long each of the different sorting algorithms requires.
	 */
	public long  time(T[] array) 
	{
        long start, end;     
        start = System.currentTimeMillis();
          
        // invoke the apply method
        this.apply(array);
          
        end = System.currentTimeMillis();

        // returns elapsed time
        return  (end - start);
    }
	
	/**
	 * Create an array containing n random Integers.
	 */
	public static Integer[] createRandomArray(int n)
	{
		Integer[] randomIntArray = new Integer[n];
		Random randomGenerator = new Random();
		
		for(int i = 0; i < n; i++)
		{
			randomIntArray[i] = randomGenerator.nextInt();
		}
		
		return randomIntArray;
	}
	


}
