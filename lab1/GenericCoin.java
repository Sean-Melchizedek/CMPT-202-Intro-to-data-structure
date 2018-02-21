/**
	 *  Name: Sean Yan  Justin Chong
	 *  Date: Jan 17
	 *
	 *    This class provides a generic coin.
	 */
	
public class GenericCoin {
	
	private enum CoinSide{HEADS, TAILS};
	private CoinSide side;
	
	// constructor initializes the coin at heads
	public GenericCoin() 
	{
		this.side = CoinSide.HEADS;
	}
	
	// sets the coin to heads
	public void setToHeads()
	{
		this.side = CoinSide.HEADS;
	}
	
	// sets the coin to tails
	public void setToTails()
	{
		this.side = CoinSide.TAILS;
	}
	
	// sets the coin randomly to heads or tails
	public void toss()
	{
		double chance = Math.random();
		if(chance >= 0.5)
		{
			setToHeads();
		}
		else if(chance < 0.5)
		{
			setToTails();
		}
	}
	
	// returns true if the coin is heads
	public boolean isHeads()
	{
		boolean headornot = true;
		if(side == CoinSide.HEADS)
		{
			headornot = true;		
		}
		else if(side == CoinSide.TAILS)
		{
			headornot = false;
		}
		return headornot;
	}
	
	// returns true if the coin is tails
	public boolean isTails()
	{
		boolean tailornot = true;
		if(side == CoinSide.TAILS)
		{
			tailornot = true;		
		}
		else if(side == CoinSide.HEADS)
		{
			tailornot = false;
		}
		return tailornot;
	}
	
	// returns the String "heads" or "tails" based on the side coin 
	public String toString()
	{
		if (isTails() == true)
		{
			return "tails";
		}
		else
		{
			return "heads";
		}
		
	}
	
	
////////////////////////////////////end of the class///////////////////////////	
	
	

}
