package cpsc2150.extendedConnectX.models;

/**
 *  iGameBoard interface for GameBoard operations checkIfFree, dropToken,
 *  checkForWin, checkTie, checkHorizWin, checkDiagWin, whatsAtPos, and isPlayerAtPos.
 *  A grid starting at Index 0.
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
     * @post checkIfFree = true if column c contains at least one ' ' character;
     *       checkIfFree = false if all positions in column c are filled with tokens.
     *       AND self = #self
     */
    default boolean checkIfFree(int c){
        return whatsAtPos(new BoardPosition(0,c)) == ' ';
    }

    /**
     * Places the token in the lowest available row in column c.
     *
     * @param p the character representing the player's token
     * @param c the index of the column on the game board
     *
     * @pre 0 <= c < MAX_COL AND checkIfFree(c) = true AND p is not null
     *
     * @post self = #self with token p added to the lowest available row in column c
     */

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
     * @post checkForWin = true if the last token in column c forms a consecutive sequence
     *       of TOKENS_TO_WIN or more in any direction (vertical, horizontal, or diagonal);
     *       checkForWin = false otherwise.
     *       AND self = #self
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
     * @post checkTie = true if all cells in self are filled with tokens and no player has won;
     *       checkTie = false if there are any empty spaces or if a player has achieved a win.
     *       AND self = #self
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
     * @post checkHorizWin = true if there is a sequence of TOKENS_TO_WIN consecutive tokens
     *       in the same row as pos for player p; checkHorizWin = false otherwise.
     *       AND self = #self
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
     * @post checkVertWin = true if there is a sequence of TOKENS_TO_WIN consecutive tokens
     *       in the same column as pos for player p; checkVertWin = false otherwise.
     *       AND self = #self
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
     * @post checkDiagWin = true if there is a sequence of TOKENS_TO_WIN consecutive tokens
     *       along either diagonal direction for player p; checkDiagWin = false otherwise.
     *       AND self = #self
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

    /**
     * Retrieves the character at a specific position on the board.
     *
     * @param pos a position on the game board
     *
     * @return the character ('X', 'O', or ' ') present at the specified position.
     *
     * @pre 0 <= pos.getRow() < MAX_ROW AND 0 <= pos.getColumn() < MAX_COL
     *
     * @post returns the character at the specified position (either 'X', 'O', or ' ')
     *       AND self = #self
     */

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
     * @post isPlayerAtPos = true if self at pos contains the token of player;
     *       isPlayerAtPos = false if the token at pos does not match player.
     *       AND self = #self
     */
    // Secondary - only needs whatsAtPos
    default boolean isPlayerAtPos(BoardPosition pos, char player){
        return whatsAtPos(pos) == player;
    }
}