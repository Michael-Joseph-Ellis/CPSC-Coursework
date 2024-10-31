package cpsc2150.extendedConnectX.models;

/*

Michael Ellis - Michael-Joseph-Ellis

Ryan Chen - rchen55

Cooper Taylor - Cooper-Taylor

Adam Niemczura - AdamNiem

 */

public class GameBoard
{

    private char[][] board;

    /**
     * A constructor for GameBoard. 
     * 
     * @return None
     * 
     * @pre None
     * 
     * @post A new GameBoard is initialized with empty spots.
     */

    public GameBoard()
    {
        
    }



    /**
     * A dynamic constructor for GameBoard letting you pass the initial board state. Useful for test cases
     *
     * @return None
     *
     * @param initialBoard the initial board state as a char[][]
     *
     * @pre [num rows of initialBoard] = [number of rows] AND [num columns of initialBoard] = [number of columns]
     *
     * @post A new GameBoard is initialized with a board equivalent to the initialBoard specified.
     */
    public GameBoard(char[][] initialBoard)
    {
        // Initialize the board with the passed values
        this.board = initialBoard;
    }

    /**
     * A checker to see if a column has a free space, accepts 1 int param
     * 
     * @param c the index of the column on the game board
     * 
     * @return true IF [the column is free] AND false IF [column is full]
     * 
     * @pre 0 <= c < [number of columns]
     * 
     * @post checkIfFree = true OR checkIfFree = false AND board = #board
     * 
     */
    
    public boolean checkIfFree(int c)
    {
        //returns true if the column can accept another token; false otherwise.
    }

    /**
     * This function places the token in the lowest available row in column c. 
     * 
     * @param p the character representing the player's token
     * @param c the index of the column on the game board 
     * 
     * @pre 0 <= c < [number of columns] AND checkIfFree(c) = true AND p != null
     * 
     * @post [The token is placed in the lowest available row of column c of board]
     */

    public void dropToken(char p, int c)
    {
        //places the character p in column c. The token will be placed in the lowest available row in column c.
    }

    /**
     * Checks if the last token placed in the specified column resulted in a win.
     * 
     * @param c the index of the column where the last token was placed 
     * 
     * @return true IF [last token in c results in a win] ELSE false 
     * 
     * @pre 0 <= c < [number of columns] AND [the last move was made in column c]
     * 
     * //@post checkForWin = true OR checkForWin = false AND board = #board
     * @post returns true if last token placed completes max number of consecutive same markers to win either Vertically, Horizontally, or Diagonally
     * else it returns false if these conditions are not met
     * AND board = #board
     * 
     */

    public boolean checkForWin(int c)
    {
        /*this function will check to see if the last token placed in column c resulted in the player winning the game.
        If so it will return true, otherwise false. Note: this is not checking the entire board for a win, it is just
        checking if the last token placed results in a win. You may call other methods to complete this method */
    }

    /**
     * Checks to see if the game has resulted in a tie
     * 
     * @return true IF [all cells in board are filled] ELSE false
     *
     * @pre None
     * 
     * //@post checkTie = true OR checkTie = false board = #board
     * @post returns true if all cells in the board are filled with tokens, else returns false. board = #board
     */

    public boolean checkTie()
    {
        /*this function will check to see if the game has resulted in a tie. A game is tied if there are no free board
        positions remaining. You do not need to check for any potential wins because we can assume that the players
        were checking for win conditions as they played the game. It will return true if the game is tied and
        false otherwise.*/
    }

    /**
     * Checks to see if the last token placed resulted in a horizontal win
     * 
     * @param pos the position where the last token was placed  
     * @param p player who placed the last token
     * 
     * @return true IF [last token results in a horizontal win] ELSE false
     * 
     * @pre 0 <= pos.getRow() < [number of rows] AND 0 <= pos.getColumn() < [number of columns] AND p != null
	 * 
     * //@post checkHorizWin = true OR checkHorizWin = false AND board = #board
     * @post checks to see if the last token placed (which was placed in position pos by player p) resulted in 5 in
     * a row horizontally of the same markers. Returns true if it does, otherwise false. board = #board
     */

    public boolean checkHorizWin(BoardPosition pos, char p)
    {
        /*checks to see if the last token placed (which was placed in position pos by player p) resulted in 5 in
        a row horizontally. Returns true if it does, otherwise false*/
    }

    /**
     * Checks to see if the last token placed resulted in a vertical win
     * 
     * @param pos the position where the last token was placed  
     * @param p the player who placed the last token
     * 
     * @return true IF [last token results in a vertical win] ELSE false
     * 
     * @pre 0 <= pos.getRow() < [number of rows] AND 0 <= pos.getColumn() < [number of columns] AND p != null
     * 
     * //@post checkVerWin = true OR checkVertWin = false AND board = #board
     * @post checks to see if the last token placed (which was placed in position pos by player p) resulted in 5 in a row
     * vertically of the same markers. Returns true if it does, otherwise false. board = #board
     * 
     */

    public boolean checkVertWin(BoardPosition pos, char p)
    {
        /*checks to see if the last token placed (which was placed in position pos by player p) resulted in 5 in a row
        vertically. Returns true if it does, otherwise false*/
    }
    /**
     * Checks to see if the last token placed resulted in a diagonal win
	  * 
     * @param pos the position where the last token was placed  
     * @param p the player who placed the last token
     * 
     * @return true IF [the player has achieved a diagonal win (5 in a row)] ELSE false
     *
     * @pre 0 <= pos.getRow() < [number of rows] AND 0 <= pos.getColumn() < [number of columns] AND p != null
     * 
     * //@post checkDiagWin = true OR checkDiagWin = false AND board = #board
     * @post checkDiagWin = Returns true if the last token inserted at position pos on the board by player p
     * results in a diagonal win for that player. Tokens diagonal to the token at pos must be the required length to
     * count as a win and and all tokens in diagonal must be player p's tokens. Else returns false.
     * Note: there are two diagonals to check
     */

    public boolean checkDiagWin(BoardPosition pos, char p)
    {
        /*checks to see if the last token placed (which was placed in position pos by player p) resulted in 5 in a row
        diagonally. Returns true if it does, otherwise false Note: there are two diagonals to check*/
    }


	/** Checks to see what is at a specific position on the board. 
     * 
	 * @param pos a position on the game board
     *
     * @return [character of token present at argument position]
     * 
     * @pre 0 <= pos.getRow() < [number of rows] AND 0 <= pos.getColumn() < [number of columns]
     * 
     * @post the character returned is 'X' or 'O' or ' ' (empty space) AND board = #board 
     * 
     */
    public char whatsAtPos(BoardPosition pos)
    {
        //returns what is in the GameBoard at position pos If no marker is there, it returns a blank space char.
    }


    // PLEASE CHANGE THESE TWO omg -- changed
    
    /**
     * Returns boolean on whether a specified player is at a specified position on the board
     *
     * @param pos a position on the game board
     * @param player the name of the player we are evaluating
     * 
     * @return boolean on whether a specified player is at a specified position on the board
     * 
     * @pre 0 <= pos.getRow() < [number of rows] AND 0 <= pos.getColumn() < [number of columns] AND player is some real player
     * 
     * @post boolean evaluates to true if the player in question is at the position specified on the board
     * and false if the player in question is not at the specified board position
     * 
     */
    public boolean isPlayerAtPos(BoardPosition pos, char player)
    {
        /*returns true if the player is at pos; otherwise, it returns false. Note: this method will be implemented very
        similarly to whatsAtPos, but it's asking a different question. We only know they will be similar because we
        know GameBoard will contain a 2D array. If the data structure were to change in the future,
        these two methods could be radically different.*/
    }

    /**
     * Override so as to convert the char[][] game board into a string
     * 
     * @return string representation of the game board
     * 
     * @pre game board must be of type char[][]
     * 
     * @post board = #board and a string representation of the game board that retains the dimensions and values of the game board
     * 
     */
    @Override
    public String toString(){

    }














}
