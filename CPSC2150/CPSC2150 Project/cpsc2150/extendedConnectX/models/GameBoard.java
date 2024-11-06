package cpsc2150.extendedConnectX.models;

/*

Michael Ellis - Michael-Joseph-Ellis

Ryan Chen - rchen55

Cooper Taylor - Cooper-Taylor

Adam Niemczura - AdamNiem

 */

public class GameBoard extends AbsGameBoard
{
    private final char[][] board;

    /**
     * A constructor for GameBoard. 
     * 
     * @pre None
     * 
     * @post A new GameBoard is initialized with empty spots.
     */

    public GameBoard()
    {
        board = new char[MAX_ROW][MAX_COLUMN];

        // initialize the board with empty spots
        for (int r = 0; r < MAX_ROW; r++)
        {
            for (int c = 0; c < MAX_COLUMN; c++)
            {
                board[r][c] = ' ';
            }
        }
    }

    /**
     * A dynamic constructor for GameBoard letting you pass the initial board state. Useful for test cases
     *
     * @param initialBoard the initial board state as a char[][]
     *
     * @pre [num rows of initialBoard] = [number of rows] AND [num columns of initialBoard] = [number of columns]
     *
     * @post A new GameBoard is initialized with a board equivalent to the initialBoard specified.
     */

    // Initialize the board with the passed values
    public GameBoard(char[][] initialBoard)
    {
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
    
    // Places the character p in column c. The token will be placed in the lowest available row in column c.
    @Override // Now override because we are implementing an interface
    public void dropToken(char p, int c)
    {
        for (int r = MAX_ROW - 1; r >= 0; r--)
        {
            if (board[r][c] == ' ')
            {
                board[r][c] = p; // place the token
                break;
            }
        }
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
    
    // Returns what is in the GameBoard at position pos If no marker is there, it returns a blank space char.
    @Override // Now override because we are implementing an interface
    public char whatsAtPos(BoardPosition pos)
    {   
        return board[pos.getRow()][pos.getColumn()];
    }


    // LOOK AT THIS  
    
    /**
     * Override to convert the char[][] game board into a string
     * 
     * @return string representation of the game board
     * 
     * @pre game board must be of type char[][]
     * 
     * @post board = #board and a string representation of the game board that retains the dimensions and values of the game board
     * 
     */
    @Override
    public String toString()
    {
        StringBuilder boardString = new StringBuilder();

        // Add column headers
        for (int i = 0; i < MAX_COLUMN; i++) {
            boardString.append("|").append(i);
        }
        boardString.append("|\n");

        // Add each row of the board from top to bottom
        for (int r = 0; r < MAX_ROW; r++) {
            for (int c = 0; c < MAX_COLUMN; c++) {
                boardString.append("|").append(board[r][c]);
            }
            boardString.append("|\n");
        }

        return boardString.toString();
    }

    /**
     * Override to create a new GameBoard
     * 
     * @return a new GameBoard
     * 
     * @pre None
     * 
     * @post a new GameBoard is created
     */
    @Override
    public IGameBoard makeBoard()
    {
        return new GameBoard();
    }
}