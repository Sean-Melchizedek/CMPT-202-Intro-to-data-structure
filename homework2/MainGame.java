import java.io.FileNotFoundException;

/**
 * 
 */

/**
 * @author Sean Yan
 * Homework 2
 *
 *Processing the Snowman game with method in Snowman class.
 */
public class MainGame 
{

	public MainGame() 
	{
		
	}

	
	
	public static void main(String[] args) 
	{
		Snowman game = new Snowman();
		try 
		{
			game.readWords("words.txt");
			String gameword = game.getWord();
			game.playGame(gameword);
			System.out.println("The answer is " + gameword);
		} 
		catch (FileNotFoundException fnf) 
		{
			System.err.println("words.txt file Not Found");
		}
	}

}
