/**
 * @author Sean Yan 
 * This is a Lab1 for cmpt202
 * 
 * This program will only contain a main() method that tosses two coins 100 times each. 
 * Afterwards, report the percentage of heads for the first coin and the percentage of heads for the second coin.
 */

public class UseGenericCoin {
	
	// main
	public static void main(String[] args)
	{
		GenericCoin one = new GenericCoin();
		GenericCoin two = new GenericCoin();
		int countHeads = 0;
		int countTails = 0;
		
		//toss the first coin 100 times 
		for(int i = 0; i < 100; i++)
		{
			one.toss();
			if(one.isHeads() == true)
			{
				countHeads++;
			}
			else
			{
				countTails++;
			}
		}
		int headpercent_1 = countHeads; 
		System.out.println("The first coin has " + headpercent_1 +" % of heads.");
		
		// rest the counts to 0
		countHeads = 0;
		countTails = 0;
		
		// toss the second coin 100 times 
		for(int i = 0; i < 100; i++)
		{
			two.toss();
			if(two.isHeads() == true)
			{
				countHeads++;
			}
			else
			{
				countTails++;
			}
		}
		int headpercent_2 = countHeads;
		System.out.println("The second coin has " + headpercent_2 +" % of heads.");
		
		// report the results
		if(headpercent_1 > headpercent_2)
		{
			System.out.println("The first coin was heads " + (headpercent_1 - headpercent_2) + " more times." );
		}
		else if(headpercent_1 < headpercent_2)
		{
			System.out.println("The second coin was heads " + (headpercent_2 - headpercent_1) + " more times." );
		}
		else
		{
			System.out.println("Both coins had the same number of heads." );
		}
			
	}

}
