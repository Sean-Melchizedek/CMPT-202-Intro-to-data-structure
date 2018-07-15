/* Lab7
 * 
 * @author Sean Yan
 * 
 *  this class uses a list stack and a list queue to determine whether a given phrase is a palindrome or not.
 */
import java.util.Scanner;

public class PalindromeChecker {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		String message = null;
		ListQueue<String> check = new ListQueue<String>();
		ListStack<String> duo_check = new ListStack<String>();
		int count_input = 0;
		int count = 0;
		String part1 = null;
		String part2 = null;
		boolean result = false;
		
		// prompt the user to input some strings.
		// and add them into the queue.
		do 
		{
			System.out.println("Enter a string:");

			message = scan.nextLine();
			if(message.length() != 0)
			{
				check.add(message);
				count_input++;
			}
		}
		while (message.length() != 0);
		scan.close();
		
		// this is the situation that the length of input is even.  
		if(count_input%2 == 0)
		{   // remove the first half of the queue push them into the stack.
			for(int i = 0; i < count_input/2; i++)
			{
				duo_check.push(check.remove());
				count++;
			}
			// compare each string from queue and stack.
			for(int i = 0; i < count; i++)
			{	
				part1 = check.remove();
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
		// this is the situation that the length of input is odd.  
		else
		{
			for(int i = 0; i < count_input/2; i++)
			{
				duo_check.push(check.remove());
				count++;
			}
			// the center of the odd input is not counted.
			check.remove();
			// compare each string from queue and stack.
			for(int i = 0; i < count; i++)
			{	
				part1 = check.remove();
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
		// SOP the result.
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
