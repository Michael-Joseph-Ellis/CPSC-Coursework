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
     * @return 
     * 
     * @pre None
     * 
     * @post A new GameBoard is initialized with empty spots
     */

    public GameBoard()
    {
        
    }

    /**
     * A checker to see if a column has a free space, accepts 1 int param
     * 
     * @param c the index of the column on the game board
     * 
     * @return true IF the column is free AND false IF column is full
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
     * @return true IF last token in c = Win ELSE false 
     * 
     * @pre 0 <= c < number of columns AND the last move was made in column c
     * 
     * @post checkForWin = true OR checkForWin = false
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
     * @post checkTie = true OR checkTie = false board = #board
     * 
     */
    public boolean checkTie()
    {
        /*this function will check to see if the game has resulted in a tie. A game is tied if there are no free board
        positions remaining. You do not need to check for any potential wins because we can assume that the players
        were checking for win conditions as they played the game. It will return true if the game is tied and
        false otherwise.*/
    }

    public boolean checkHorizWin(BoardPosition pos, char p)
    {
        /*checks to see if the last token placed (which was placed in position pos by player p) resulted in 5 in
        a row horizontally. Returns true if it does, otherwise false*/
    }

    public boolean checkVertWin(BoardPosition pos, char p)
    {
        /*checks to see if the last token placed (which was placed in position pos by player p) resulted in 5 in a row
        vertically. Returns true if it does, otherwise false*/
    }

    public boolean checkDiagWin(BoardPosition pos, char p)
    {
        /*checks to see if the last token placed (which was placed in position pos by player p) resulted in 5 in a row
        diagonally. Returns true if it does, otherwise false Note: there are two diagonals to check*/
    }

    public char whatsAtPos(BoardPosition pos)
    {
        //returns what is in the GameBoard at position pos If no marker is there, it returns a blank space char.
    }

    public boolean isPlayerAtPos(BoardPosition pos, char player)
    {
        /*returns true if the player is at pos; otherwise, it returns false. Note: this method will be implemented very
        similarly to whatsAtPos, but it's asking a different question. We only know they will be similar because we
        know GameBoard will contain a 2D array. If the data structure were to change in the future,
        these two methods could be radically different.*/
    }

    @Override
    public String toString(){

    }














}
