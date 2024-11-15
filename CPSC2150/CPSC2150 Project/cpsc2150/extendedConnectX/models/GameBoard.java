package cpsc2150.extendedConnectX.models;

/*

Michael Ellis - Michael-Joseph-Ellis

Ryan Chen - rchen55

Cooper Taylor - Cooper-Taylor

Adam Niemczura - AdamNiem

*/

/**
 * GameBoard is a concrete implementation of the AbsGameBoard class, implementing the IGameBoard interface.
 * It represents a grid-like game board for a ConnectX game, with defined operations for placing tokens
 * and checking for game conditions.
 *
 * @corresponds:  self: board
 *
 * @invariants: board is a MAX_ROW x MAX_COL grid and contains only ' ', 'X', or 'O' characters.
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
        board = new char[MAX_ROW][MAX_COL];

        // initialize the board with empty spots
        for (int r = 0; r < MAX_ROW; r++)
        {
            for (int c = 0; c < MAX_COL; c++)
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
    
    // Returns what is in the GameBoard at position pos If no marker is there, it returns a blank space char.
    @Override // Now override because we are implementing an interface
    public char whatsAtPos(BoardPosition pos)
    {   
        return board[pos.getRow()][pos.getColumn()];
    }
}