package cpsc2150.extendedConnectX.models;

public abstract class AbsGameBoard implements IGameBoard
{

    /**
     * Provides a string representation of the current game board.
     *
     * @return A formatted string that visually represents the board's current state.
     *
     * @pre The game board must be a 2D character array `char[][]`.
     *
     * @post The returned string representation retains the dimensions and values of the game board.
     */
    @Override
    public String toString()
    {
        StringBuilder boardString = new StringBuilder();

        // Add column headers
        for (int i = 0; i < MAX_COL; i++) {
            boardString.append("|").append(i);
        }
        boardString.append("|\n");

        // Add each row of the board from top to bottom
        for (int r = 0; r < MAX_ROW; r++) {
            for (int c = 0; c < MAX_COL; c++) {
                char[][] board = new char[MAX_ROW][MAX_COL];
                boardString.append("|").append(board[r][c]);
            }
            boardString.append("|\n");
        }
        return boardString.toString();
    }
}