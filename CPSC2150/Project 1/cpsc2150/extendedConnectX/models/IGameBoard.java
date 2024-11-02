package cpsc2150.extendedConnectX.models;

/**
 *  iGameBoard interface for GameBoard operations checkIfFree, dropToken,
 *  checkForWin, checkTie, checkHorizWin, checkDiagWin, whatsAtPos, and isPlayerAtPos.
 *  2-Dimensional grid starting at Index 0.
 *
 * @ initialization_ensures: board contains only ' ' characters
 *  and is MAX_ROW x MAX_COLUMN or smaller
 *
 * @ defines: self: the board
 *
 * @ contraints: None?
 *
 */

public interface IGameBoard {
    public static final int MAX_ROW = 9;
    public static final int MAX_COLUMN = 7;
    public static final int NUM_TO_WIN = 5;

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
    public default boolean checkIfFree(int c){
        return whatsAtPos(new BoardPosition(0,c)) == ' ';
    };

    // Primary - needs to access board so change can be made
    public void dropToken(char p, int c);

    // Secondary, just call other check win methods
    public default boolean checkForWin(int c){
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
    };

    // As long as we have MAX values, we can iterate and ensure all positions are filled
    // So secondary
    public default boolean checkTie(){
        for (int r = 0; r < MAX_ROW; r++){
            for (int c =0; c < MAX_COLUMN; c++){
                if (whatsAtPos(new BoardPosition(r,c)) == ' ')
                    return false;
            }
        }

        return true;
    };

    // Like checkTie, we can just use whatsAtPos so Secondary
    public default boolean checkHorizWin(BoardPosition pos, char p){
        int rightBound = pos.getColumn() + NUM_TO_WIN / 2;
        int leftBound = pos.getColumn() - NUM_TO_WIN / 2;

        // Will fail if NUM_TO_WIN >= MAX_COLUMN
        if (leftBound < 0) {
            rightBound += -leftBound;
            leftBound = 0;
        }

        if (rightBound >= MAX_COLUMN){
            leftBound -= (rightBound - MAX_COLUMN - 1);
            rightBound = MAX_COLUMN - 1;
        }

        for (int i = leftBound; i <= rightBound; i++) {
            if (whatsAtPos(new BoardPosition(pos.getRow(), i)) != p)
                return false;
        }

        return true;
    };

    // Secondary (same reasoning)
    public default boolean checkVertWin(BoardPosition pos, char p){

        // This should be run on the last token dropped, meaning we don't have to test 'up'
        if (pos.getRow() < MAX_ROW - NUM_TO_WIN) {
            for (int i = 0; i < pos.getRow(); i++){
                if (whatsAtPos(new BoardPosition(pos.getRow() + i, pos.getColumn())) != p)
                    return false;
            }
        }

        return false;
    };

    // Secondary (same reasoning)
    public default boolean checkDiagWin(BoardPosition pos, char p);

    // Primary - needs access to board
    public char whatsAtPos(BoardPosition pos);

    // Secondary - only needs whatsAtPos
    public default boolean isPlayerAtPos(BoardPosition pos, char player);


}
