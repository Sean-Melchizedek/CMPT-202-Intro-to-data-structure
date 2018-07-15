/**
 * Lab 6 
 * @author Sean
 */

import java.util.Scanner;

public class PalindromeChecker
{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String message = null;
		ListStack<String> check = new ListStack<String>();
		ListStack<String> duo_check = new ListStack<String>();
		int count_input = 0;
		int count = 0;
		String part1 = null;
		String part2 = null;
		boolean result = false;
		

		do 
		{
			System.out.println("Enter a string:");

			message = scan.nextLine();
			if(message.length() != 0)
			{
				check.push(message);
				count_input++;
			}
		}
		while (message.length() != 0);
		scan.close();
		
		if(count_input%2 == 0)
		{
			for(int i = 0; i < count_input/2; i++)
			{
				duo_check.push(check.pop());
				count++;
			}
			
			for(int i = 0; i < count; i++)
			{	
				part1 = check.pop();
				part2 = duo_check.pop();
				if(part1.equals(part2))
				{
					result = true;
				}
				else
				{
					result = false;
				}
				
			}
		}
		else
		{
			for(int i = 0; i < count_input/2; i++)
			{
				duo_check.push(check.pop());
				count++;
			}
			check.pop();
			
			for(int i = 0; i < count; i++)
			{	
				part1 = check.pop();
				part2 = duo_check.pop();
				if(part1.equals(part2))
				{
					result = true;
				}
				else
				{
					result = false;
				}
				
			}
			
		}
		
		if(result == true)
		{
			System.out.println("it is a Palindrome");
		}
		else
		{
			System.out.println("it is not a Palindrome");
		}	
	}
}