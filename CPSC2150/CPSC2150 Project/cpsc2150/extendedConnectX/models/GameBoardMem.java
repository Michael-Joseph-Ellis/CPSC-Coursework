package cpsc2150.extendedConnectX.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private final int rows; 
    private final int columns;
    private final int numToWin;

}