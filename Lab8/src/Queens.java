/** 
 * Solve the n - queens problem using recursive backtracking algorithm.
 * always take recursive as a black box - what is the input? what is the output? where is it gonna return to?
 * find these three things then anything else does not matter.  
 * 
 * 
 * @author Sean Yan
 * start at 3/9/2018 9:34am
 * at 3/11/2018 10:20pm finished the is under attack function.
 * at 3/13/2018 3:16pm finished the "place queens" function.
 **/

public class Queens
{
  private final static int DEFAULT_BOARD_SIZE = 9;  
  
  private char board[][]; 	// game board
  	
  private int boardSize;	// size of game board
  
  private int currentcol = 0;// only use for place queens method.
  
  /**
   * Constructor: Creates an empty square board of default size.
   */
  public Queens() {
    this(DEFAULT_BOARD_SIZE);
  }          
  
  /**
   * Constructor: Creates an empty n x n square board.
   */
  public Queens(int boardSize) {
    board = new char[boardSize][boardSize];
    this.boardSize = boardSize;
    
    for (int r = 0; r < boardSize; r++) 
    	for (int c = 0; c < boardSize; c++)
    		board[r][c] = '*';    
  }           
  
  
  /*checked!
   * Clears the game board.
   */
  public void clearBoard() 
  {
	board = new char[this.boardSize][this.boardSize];
	 for (int r = 0; r < boardSize; r++) 
	 {
	    	for (int c = 0; c < boardSize; c++)
	    		board[r][c] = '*'; 
	 }
  }
  
  /** Solves Eight Queens problem.
    * Precondition: Empty game board  
    * Postcondition: If a solution is found, each 
    * row of the board contains one queen where
    * queens are non-attacking, and method 
    * returns true; otherwise, returns false (no 
    * solution exists for a queen anywhere in row 
    * specified) and the board is empty.
    */
  public boolean solveQueensProblem() 
  {
	  // we begin from row 0
    if (placeQueens(0) == true) 
      return true;
    else {
    	// no solution found, so return failure
    	clearBoard(); 
    	return false;
    }
  }      
  
  /**
   * checked!
   * Places queens in row of the board beginning
   * at the specified row. Queens are placed using
   * the recursive backtracking algorithm.
   * 
   * Precondition: Queens are placed correctly in
   * row 0 through row-1.
   * 
   * Postcondition: If a solution is found, each
   * row of the board contains one queen and method
   * returns true; otherwise, returns false (no
   * solution exists for a queen anywhere in row
   * specified).
   * 
   * @param row
   * @return
   */
  private boolean placeQueens(int currentrow) 
  {
    if (currentrow >= boardSize) 
    {
    	return true;  // Solution found: entire board has been filled!
    }
    for(int col = (currentcol%boardSize); col <boardSize; col++)// go through every columns begin at current column but not 0. 
    {
    	currentcol++;
    	if(this.isUnderAttack(currentrow, col)==false) // if the queen is not under attack
    	{
    		this.setQueen(currentrow, col);			   // set the queen to this position.
    		 // recursive to the next row calling placeQueens.		  
   			if(this.placeQueens(currentrow+1)==false)
   			{
   				this.removeQueen(currentrow, col);
   			}
   			else
   			{
   				return true;
   			}
   		}
    	
    		
   	}
    return false;
  } 
  
  /**
   * Place a queen at specified row and column
   * @param row
   * @param column
   */
  private void setQueen(int row, int column) 
  {
    board[row][column] = 'Q';
  }  
  
  /**
   * Removes a queen at specified row and column
   * @param row
   * @param column
   */
  private void removeQueen(int row, int column) {
	  board[row][column] = '*';
  }  
  
  /**
   * checked!
   * Determines if placing a Queen at specified row and column
   * will leave the Queen under attack.
   * 
   * This method must check if a Queen placed at the specified 
   * row:column is under attack by another Queen in the same column,
   * left-diagonal, or right diagonal.
   * 
   * @param row - The row the Queen is being placed
   * @param column - The column the Queen is being placed
   * @return True if queen is under attack, false otherwise.
   */
  private boolean isUnderAttack(int row, int column) 
  {
	  boolean rv = false;
	  int r;
	  int c;
	  
	  // first check left diagonal
	  r = row - 1;
	  c = column - 1;
	  while (r >= 0 && c >= 0) 
	  {
		  if (board[r][c] == 'Q')
		  {
			  rv = true;
			  break;
		  }
		  r--;
		  c--;
	  }
	  // now check right diagonal
	  r = row - 1;
	  c = column + 1;
	  while (r >= 0 && c <= this.boardSize-1) 
	  {
		  if (board[r][c] == 'Q')
		  {
			  rv = true;
			  break;
		  }
		  r--;
		  c++;
	  }
   
	  // now check columns -> the column does not change
	  r = row - 1;
	  c = column;
	  while (r >= 0) 
	  {
		  if (board[r][c] == 'Q')
		  {
			  rv = true;
			  break;
		  }
		  r--;
	  }  
	  
	  return rv;
  }  
  
  // returns the game board
  public char[][] getBoard()
  {
	  return board;
  }
  
  
  
  public static void main(String[] args) 
  {
          // specifies the size of the game board
          int size = Integer.parseInt("15");
	  
          // creates a new instance of the specified size
          Queens board = new Queens(size);
          char newBoard[][] = board.getBoard();
          QueensGUI gui = new QueensGUI(size,size);
          gui.draw(newBoard);
          board.placeQueens(0);      
  } 
  
}

	  
//          // call solveQueensProblem()
//          if (board.solveQueensProblem()) {
//              char newBoard[][] = board.getBoard();
//    	  
//              QueensGUI gui = new QueensGUI(size,size);
//              gui.draw(newBoard);
//              board.placeQueens(0);
//              
//          }
//          else {
//              System.out.println("No solution for board of size " + size);
//          }
//      }
//  }
