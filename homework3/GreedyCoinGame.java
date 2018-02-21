/**
 * Plays Greedy Coin game such that the computer never loses.
 * 
 * Sean Yan
 * Homework #3
 * start at 2/13/2018 21:32
 * final edited by 2/20/2018 20:50
 */
import java.io.*;
import java.util.Scanner;
import java.util.LinkedList;
// generic !!!!
public class GreedyCoinGame 
{
	// list that save the coins
	private LinkedList<Integer> coinlist = new LinkedList<Integer>();
	// list that save the chosen coins from AI
	private LinkedList<Integer> aichoice_list = new LinkedList<Integer>();
	// list that save the chosen coins from human
	private LinkedList<Integer> humanchoice_list = new LinkedList<Integer>();

	
	public GreedyCoinGame(String file) throws FileNotFoundException 
	{
		Scanner inFile = new Scanner(new File(file));

		while (inFile.hasNext()) 
		{
			Integer nextcoin = inFile.nextInt();	
			coinlist.add(nextcoin);
		}
		inFile.close();
	}

	// prints the coins and their position and player's points
	public void printCoins() 
	{
		System.out.println("+++++++++++");
		
		for(int i = 0; i < coinlist.size(); i++)
		{
			System.out.print(coinlist.get(i) + " ");
		}
		System.out.println();
		for(int i = 0; i < coinlist.size(); i++)
		{
			System.out.print(i + "  ");
		}
		System.out.println();
		System.out.println("human points: " + getPoint(humanchoice_list) );
		System.out.println("AI points: " + getPoint(aichoice_list) );
		System.out.println("+++++++++++");
	}

	// main game method
	public void playGame() 
	{
		LinkedList<Integer> blueAndRed = readlist();
		
		System.out.println("Let's play the coin game!");
		
		System.out.println("blue is: " + blueAndRed.get(0));
		System.out.println("red is: " + blueAndRed.get(1));		
		while(coinlist.isEmpty()==false)
		{
			System.out.println();
			printCoins();
			this.aiBlueRedChoice();
			printCoins();
			this.makeHumanChoice();
		}
		System.out.println("GAME OVER!");
		if(getPoint(humanchoice_list) > getPoint(aichoice_list))
		{
			System.out.println("what? You win??? no way, you bastered cheater!!!");
		}
		else 
		{
			System.out.println("You lost");
		}
		System.out.println("human's points: "+ getPoint(humanchoice_list));
		System.out.println("AI's points: " + getPoint(aichoice_list));
		
	}

	public static void main(String[] args) throws IOException 
	{
		GreedyCoinGame game = new GreedyCoinGame("file5.txt");
		game.playGame();
	}
	
	////////////////////////////////////////helper method//////////////////////////////////////
	
	//ai's method that read the list in blue and red way.
	private LinkedList<Integer> readlist()
	{
		int sumEvencol = 0;
		int sumOddcol = 0;
		int indexEven = 0;
		int indexOdd = 1;
		LinkedList<Integer> sumlist = new LinkedList<Integer>();
		
		while(indexEven < coinlist.size())
		{
			sumEvencol += coinlist.get(indexEven);
			sumOddcol += coinlist.get(indexOdd);
			indexEven += 2;
			indexOdd += 2;		
		}
		Integer even = new Integer(sumEvencol);// wrap the int to Integer 
		Integer odd = new Integer(sumOddcol);
		sumlist.add(even);// add it into a array list.
		sumlist.add(odd);
		return sumlist;
		//fist is sum of even position and second is the odd.
	}
	
	//prompt and got human's input
	private int makeHumanChoice()
	{
		int humanChoice = 0;
		System.out.println("Indicate the position of the coin you choose: ");
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		humanChoice = keyboard.nextInt();
		
		
		humanchoice_list.add(coinlist.get(humanChoice));
		coinlist.remove(coinlist.get(humanChoice));	
		
		return humanChoice;
	}
	
	//AI makes his move based on blue and red 
	//AI is a smart ass and he does not need return you anything like human did.
	private void aiBlueRedChoice()
	{
		//the if and else determined by the blue and red algorithm.
		LinkedList<Integer> sumlist = readlist();
		if(sumlist.get(0) > sumlist.get(1))
		{
			System.out.println(  "AI chose " + coinlist.indexOf( coinlist.get(0) )  );
			aichoice_list.add( coinlist.get(0));
			coinlist.remove(coinlist.get(0));	
		}
		else
		{
			System.out.println(  "AI chose " + coinlist.indexOf( coinlist.get(coinlist.size()-1) )  );
			aichoice_list.add( coinlist.get(coinlist.size()-1) );
			coinlist.remove(coinlist.get(coinlist.size()-1));
		}
		
	}
	
	// helper method to get the total points from the input linked list.
	private int getPoint(LinkedList<Integer> inputlist)
	{
		int sum = 0;
		for(int i = 0; i < inputlist.size(); i++)
		{
			sum += inputlist.get(i);
		}
		return sum;
	}
}
