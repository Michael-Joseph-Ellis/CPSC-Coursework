package cpsc2150.extendedConnectX.models;

/**
 *  iGameBoard interface for GameBoard operations checkIfFree, dropToken,
 *  checkForWin, checkTie, checkHorizWin, checkDiagWin, whatsAtPos, and isPlayerAtPos.
 *  2-Dimensional grid starting at Index 0.
 *
 * @initialization_ensures: board contains only ' ' characters
 *  and is MAX_ROW x MAX_COL or smaller
 *
 * @defines: self: the board
 *
 * @constraints: None?
 *
 */

public interface IGameBoard {
    public static final int MAX_ROW = 9;
    public static final int MAX_COL = 7;
    public static final int TOKENS_TO_WIN = 5;

    /**
     * A checker to see if a column has a free space, accepts 1 int param
     *
     * @param c the index of the column on self to check
     *
     * @return true IF [the column is free] AND false IF [column is full]
     *
     * @pre 0 <= c < [number of columns]
     *
     * @post checkIfFree = true OR checkIfFree = false AND self = #self
     *
     */
    default boolean checkIfFree(int c){
        return whatsAtPos(new BoardPosition(0,c)) == ' ';
    }

    // Primary - needs to access board so change can be made
    void dropToken(char p, int c);

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
    // Secondary, just call other check win methods
    default boolean checkForWin(int c){
        int row = 0;
        char player = whatsAtPos(new BoardPosition(row, c));

        while (player == ' ') {
            row++;
            player = whatsAtPos(new BoardPosition(row, c));
        }

        BoardPosition currentPos = new BoardPosition(row, c);

        if (checkHorizWin(currentPos, player))
            return true;
        if (checkVertWin(currentPos, player))
            return true;

        return checkDiagWin(currentPos, player);
    }

    // As long as we have MAX values, we can iterate and ensure all positions are filled
    // So secondary

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
    default boolean checkTie(){
        for (int r = 0; r < MAX_ROW; r++){
            for (int c =0; c < MAX_COL; c++){
                if (whatsAtPos(new BoardPosition(r,c)) == ' ')
                    return false;
            }
        }

        return true;
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

    // Like checkTie, we can just use whatsAtPos so Secondary
    default boolean checkHorizWin(BoardPosition pos, char p) 
    {
        int count = 1; // start counting from current position

        // check to the left of the current position
        for (int col = pos.getColumn() - 1; col >= 0; col--) {
            if (whatsAtPos(new BoardPosition(pos.getRow(), col)) == p) {
                count++;
                if (count >= TOKENS_TO_WIN) {
                    return true;
                }
            } else {
                break; // stop if we encounter a different token
            }
        }

        // same as above but for the right of current pos 
        for (int col = pos.getColumn() + 1; col < MAX_COL; col++) {
            if (whatsAtPos(new BoardPosition(pos.getRow(), col)) == p) {
                count++;
                if (count >= TOKENS_TO_WIN) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
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
    // Secondary (same reasoning)
    default boolean checkVertWin(BoardPosition pos, char p) {
        int count = 1; // start counting from the current position

        // check down
        for (int i = 1; i < TOKENS_TO_WIN; i++) {
            int newRow = pos.getRow() + i;
            if (newRow >= MAX_ROW || whatsAtPos(new BoardPosition(newRow, pos.getColumn())) != p) {
                break;
            }
            count++;
        }

        // check up
        for (int i = 1; i < TOKENS_TO_WIN; i++) {
            int newRow = pos.getRow() - i;
            if (newRow < 0 || whatsAtPos(new BoardPosition(newRow, pos.getColumn())) != p) {
                break;
            }
            count++;
        }

        return count >= TOKENS_TO_WIN;
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
     * count as a win and all tokens in diagonal must be player p's tokens. Else returns false.
     * Note: there are two diagonals to check
     */
    // Secondary (same reasoning)
    default boolean checkDiagWin(BoardPosition pos, char p){
        int row = pos.getRow();
        int col = pos.getColumn();
        int count = 1; // Start with the token at (row, col)

        // Check the main diagonal (\)
        // Count upwards-left (-1, -1)
        int tempRow = row - 1;
        int tempCol = col - 1;

        while (tempRow >= 0 && tempCol >= 0) {
            if (whatsAtPos(new BoardPosition(tempRow, tempCol)) == p)
                count++;
            else
                break;

            tempRow--;
            tempCol--;
        }

        // Count downwards-right (+1, +1)
        tempRow = row + 1;
        tempCol = col + 1;

        while (tempRow < MAX_ROW && tempCol < MAX_COL) {
            if (whatsAtPos(new BoardPosition(tempRow, tempCol)) == p)
                count++;
            else
                break;

            tempRow++;
            tempCol++;
        }

        // If we found a win on the main diagonal, return true
        if (count >= TOKENS_TO_WIN) {
            return true;
        }

        // Reset count for the anti-diagonal (/)
        count = 1;

        // Check the anti-diagonal (/)
        // Count upwards-right (-1, +1)
        tempRow = row - 1;
        tempCol = col + 1;

        while (tempRow >= 0 && tempCol < MAX_COL) {
            if (whatsAtPos(new BoardPosition(tempRow, tempCol)) == p)
                count++;
            else
                break;

            tempRow--;
            tempCol++;
        }

        // Count downwards-left (+1, -1)
        tempRow = row + 1;
        tempCol = col - 1;
        while (tempRow < MAX_ROW && tempCol >= 0) {
            if (whatsAtPos(new BoardPosition(tempRow, tempCol)) == p)
                count++;
            else
                break;

            tempRow++;
            tempCol--;
        }

        // Return true if there is a win on the anti-diagonal
        return count >= TOKENS_TO_WIN;
    }

    // Primary - needs access to board
    char whatsAtPos(BoardPosition pos);

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
    // Secondary - only needs whatsAtPos
    default boolean isPlayerAtPos(BoardPosition pos, char player){
        return whatsAtPos(pos) == player;
    }
}