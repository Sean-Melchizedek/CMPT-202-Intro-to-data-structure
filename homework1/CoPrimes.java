/**
 * Homework 1
 * finished by 2018/1/24
 * 
 * Generate the co-primes from (1,1) to (m,n)
 * Configuration set to 15,15.
 * 
 * Sean Yan
 *
 */

public class CoPrimes {
	
	// draw the Asterisk if gcd=1 which equals to Coprime
	public void drawAsterisk(int col, int row)
	{
		for(int i = col; i > 0; i--)
		{
			for(int k = 0; k < row; k ++)
			{
				if(gcd(i,k) == 1)
				{
					System.out.print("*");
				}
				else if(gcd(i,k) > 1)
				{
					System.out.print(" ");
				}
				if(k == row-1)// 
				{
					System.out.println();
				}
			}
			
		}

	}
	
	// private help method to find the gcd.  
	private static int gcd(int m, int n)
	{
		int reminder;
		
		while(n > 0)
		{
			reminder = m % n;
			m = n;
			n = reminder;
		}
		return m;
	}
	
	// main method using args.
	public static void main(String[] args) 
	{
	
		if (args.length != 2) 
		{
			System.err.println("Must be passed two integer values > 0");
			
			System.exit(0);
		}
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);

		CoPrimes example = new CoPrimes();
		example.drawAsterisk(m, n);
	}

}