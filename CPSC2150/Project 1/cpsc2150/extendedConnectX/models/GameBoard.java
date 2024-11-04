package cpsc2150.extendedConnectX.models;

/*

Michael Ellis - Michael-Joseph-Ellis

Ryan Chen - rchen55

Cooper Taylor - Cooper-Taylor

Adam Niemczura - AdamNiem

 */

public class GameBoard implements IGameBoard
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

    };














}
