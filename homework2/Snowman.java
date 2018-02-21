/*
 * Homework 2 
 * wrote by Sean Yan
 * last modified on 2/4/2018 22:34
 * 
 * 
 * 
 * This is the class that plays basic snowman. This class will choose a word at random from a dictionary of possible words.  
 * For each incorrect guess, a new part of the snowman is constructed.
 * If the player cannot correctly guess the word within 6 tries, an entire snowman is completed, and the player loses. 
 * (For some odd reason the player loses if they can build a snowman.) 
 * The player wins if they guess the word within 6 tries.
 * 
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Snowman
{
	
	protected List<String> wordList = new ArrayList<String>();
	private ArrayList<String> userinputlist = new ArrayList<String>();// array of user's answer.
	
	private int life = 6;// numbers of user's chance = 6.
	private char nextChoice;// character that user's next guess.
	private int countTrue;// times of user have the right guess.
	private int indexOfChoice;
	private char[] charlist;// the Array contains the list of char which user already guessed right. 
	
	private String lowcase;// String of low case. 
	private String s_nextChoice;// String of user's next choice.
	private String alphabet = "abcdefghijklmnopqrstuvwxyz";// String contains default alphabet.
	
	// default constructor. 
	public Snowman()
	{
	}
	
	
	//  Read in the list of words
	public void readWords(String fileName) throws FileNotFoundException 
	{
		Scanner s = new Scanner(new File(fileName));

		while (s.hasNext())
		{
			wordList.add(s.next());
		}
		s.close();
	}

	
	// Selects a random word from the list and returns it.
	public String getWord() 
	{
		// returns a random word from wordList
		Random r = new Random();
		return wordList.get(r.nextInt(wordList.size()));
	}
		
	// return the result of the game
	public boolean resultBoolean()
	{
		boolean result;
		if(life == 0)
		{
			result = false;
			System.out.println("Snowman died! YOU LOST!");
		}
		else
		{
			result = true;
			System.out.println("Nice done! YOU WIN THIS GAME!");
		}
		return result;
	}
	
	

/////////////////////////////////////////////////////////////helping method//////////////////////////////////////////////////////////////////////
	
	// helping method: to check the word whether contains the char.
	private boolean checkChoice(char choiceLetter,String topicWord)
	{
		
		int index = topicWord.indexOf(choiceLetter);
		int lastindex = topicWord.lastIndexOf(choiceLetter);
		// if two index do not equal to each other, which means there are multiple same chars in one word.
		// eg: apple has two Ps.
		boolean result = false;
		
		// check if the choiceLetter and the original letter are the same.
		if (index >= 0) 
		{
			if( (index == lastindex) == true)
			{
				charlist[index] = choiceLetter;	
				result = true;	
				countTrue -= 1;
				System.out.println(choiceLetter +" does appear.");
			}
			else if( (index == lastindex) == false)
			{
				for(int i = 0; i < topicWord.length(); i++)
				{
					if(choiceLetter == topicWord.charAt(i))
					{
						charlist[i] = choiceLetter;
						countTrue -= 1;
					}
					
				}
				result = true;	
				System.out.println(choiceLetter +" appears twice.");
			}
			
		}
		else
		{
			System.out.println(choiceLetter +" does not appear.");
			System.out.println("your life decreased");
			life--;
			System.out.println();
		}
		return result;
	}
	
	// helping method: print out the char list in a readable way.
	private void printchar()
	{
		for (int i = 0; i < charlist.length; i++)
		{
			System.out.print(charlist[i]+" ");
		}
		System.out.println();
	}
	
	// helping method: Once user input invalid char, 
    // ignore the input value and prompt again.
	private char checkcase()
	{
		s_nextChoice = Character.toString(nextChoice);
		lowcase =  s_nextChoice.toLowerCase();
		nextChoice = lowcase.charAt(0);	
		return nextChoice;
	}
	
	// series codes to transfer input to low case 
	private boolean checkInvalid(char nextChoice)
	{
		// switch it into String, lower the case and switch back
		this.indexOfChoice = alphabet.indexOf(nextChoice);
		
		if(this.indexOfChoice < 0)
		{
			System.out.println("You entered a nonsense character, please try again.");
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	private boolean checkDuplicate(char input)
	{
		String s_input = Character.toString(input);
		return userinputlist.contains(s_input);
	}
	
///////////////////////////////////////////////////main game procession///////////////////////////////////////////////////	
	//play the game
	public void playGame(String word) 
	{	
		charlist = new char[word.length()];
		countTrue = word.length();
		Scanner reader = new Scanner(System.in);
		

		// 1. print the empty charlist to let player guess. 
		for (int i = 0; i < charlist.length; i++)
		{
			charlist[i] = '_';
		}
		printchar();

		// 2. main gaming while loop.
		while((life > 0))	
		{	
			System.out.println("Your chances remain: " + life);
			System.out.print("Input your choice:");
			this.nextChoice = reader.next().charAt(0);
			this.checkcase();
			
			while(this.checkDuplicate(nextChoice))
			{
				System.out.println("You have already guessed this letter, try another one.");
				System.out.print("Input your choice again: ");
				this.nextChoice = reader.next().charAt(0);
			}
			
			while(checkInvalid(this.nextChoice)==false)
			{
				System.out.println();
				System.out.println("Your chances remain: " + life);
				System.out.print("Input your choice again: ");
				this.nextChoice = reader.next().charAt(0);
			}
			
			System.out.println();
			System.out.println("you entered " + nextChoice);
			System.out.println();
			boolean resultofChoice = checkChoice(nextChoice,word);
			userinputlist.add(Character.toString(nextChoice));
			
			if(resultofChoice == true)
			{	
				if(countTrue == 0)
				{
					resultBoolean();
					break;
				}
				printchar();
			}
			else
			{
				printchar();
			}
		}
		if(life == 0)
		{
			resultBoolean();
		}	
	}
}