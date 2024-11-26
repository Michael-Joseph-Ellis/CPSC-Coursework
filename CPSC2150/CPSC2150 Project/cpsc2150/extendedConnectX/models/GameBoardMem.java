package cpsc2150.extendedConnectX.models;

import java.util.*;

/*

Ryan Chen - rchen55

Cooper Taylor - Cooper-Taylor

Michael Ellis - Michael-Joseph-Ellis

Adam Niemczura - AdamNiem

*/

/**
 * The GameBoardMem class is a memory-efficient implementation of the game board.
 * It uses a Map to store the positions of tokens for each player, instead of a 2D array.
 * Each key in the Map represents a player, and the value is a List of BoardPositions occupied by that player.
 *
 * @correspondence: self = board
 */
public class GameBoardMem extends AbsGameBoard 
{
    // Map to store player tokens and their positions on the board 
    private final Map<Character, List<BoardPosition>> board;

    private int rows;
    private int columns;
    private int numToWin;

    // Constructor
    public GameBoardMem(int rows, int columns, int numToWin){
        this.rows = rows;
        this.columns = columns;
        this.numToWin = numToWin;
        this.board = new HashMap<>();
    }

    @Override
    public void dropToken(char p, int c) {
        if (!board.containsKey(p)) {
            board.put(p, new Vector<BoardPosition>());
        }

        // Gravity-fy token
        int row = 0;
        while (row < rows && whatsAtPos(new BoardPosition(row, c)) == ' '){
            row++;
        }

        // Add board position
        board.get(p).add(new BoardPosition(row, c));
    }

    @Override
    public char whatsAtPos(BoardPosition pos) {
        return 0;
    }

    @Override
    public int getRows() {
        return rows;
    }

    @Override
    public int getColumns() {
        return columns;
    }

    @Override
    public int getNumToWin() {
        return numToWin;
    }
}