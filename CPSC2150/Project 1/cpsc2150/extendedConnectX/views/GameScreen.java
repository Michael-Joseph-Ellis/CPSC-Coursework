package cpsc2150.extendedConnectX.views;

/*Ryan Chen, Michael Ellis, Cooper Taylor, Adam Niemczura



 */
public class GameScreen {

    /**
     * Prints out the string representation of the game board to the terminal
     * 
     * @param args the string representation of the game board
     *
     * @pre arg != NULL AND arg = [array of strings] AND arg[i].length = columns AND arg.length = rows
     *
     * @post game board is printed to the terminal AND args = #args
     */
    private void printBoard(String[] args){

    }

    /**
     * Checks if the game has ended and if so handles it by ending the game and prompting the user with an end of game description along with an option for the player to play again
     *
     * @pre game_board != NULL AND game_board.length == [number of rows] AND game_board[0].length == [number of columns] AND [game is ongoing] == TRUE
     *
     * @post end of game description is printed to the console and player is given a prompt in the console if they want to play again AND game_board = #game_board
     */
    private void checkGameEnd(char[][] game_board){

    }

    /**
     * Gets the input from the player and uses that input to modify the gamestate based on what input the player provides
     *
     * @pre user must use keyboard input only AND [user input is a single character]
     *
     * @post Returns the character user inputted as a char type
     *
     * @return [char that holds the user keyboard input]
     */
    public char getInput(){

    }

    /**
     * Gets the input from the player and uses that input to modify the gamestate based on what input the player provides
     *
     * @pre user must use keyboard input only AND [user input is an integer]
     *
     * @post Returns the integer user inputted as a int type
     *
     * @return [int that holds the user keyboard input]
     */
    public int getInput(){

    }

    /**
     * Prints out visual information about the current game state to the console/terminal
     *
     * @pre game_board != NULL AND game_board.length == [number of rows] AND game_board[0].length == [number of columns]
     *
     * @post current state of the game is printed to the console and game_board == #game_board
     */
    private void printGameState(char[][] game_board){

    }

    /**
     * This function will display the game board to the user and run the game loop.
     * @param args the command-line arguments passed to the program when it is executed.
     * @pre none
     * @post the game board will be displayed to the player along with the ability for user input AND args = #args
     */
    public static void main(String[] args)
    {

    }
}

