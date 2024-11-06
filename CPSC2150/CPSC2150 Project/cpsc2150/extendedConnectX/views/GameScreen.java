package cpsc2150.extendedConnectX.views;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

Michael Ellis - Michael-Joseph-Ellis

Ryan Chen - rchen55

Cooper Taylor - Cooper-Taylor

Adam Niemczura - AdamNiem

 */

public class GameScreen {

    /**
     * Prints out the string representation of the game board to the terminal
     * 
     * @param game_board the 2D char representation of the game board
     *
     * @pre arg != NULL AND arg = [array of strings] AND arg[i].length = columns AND arg.length = rows
     *
     * @post game board is printed to the terminal AND game_board = #game_board.
     * The game board printed is the exact number of columns and rows as specified in the precondition
     */
    public void printBoard(char[][] game_board){

    }

    /**
     * Checks if the game has ended and if so handles it by ending the game and prompting the user with an end of game description along with an option for the player to play again
     *
     * @pre game_board != NULL AND game_board.length == [number of rows] AND game_board[0].length == [number of columns] AND [game is ongoing] == TRUE
     *
     * @post end of game description is printed to the console and player is given a prompt in the console if they want to play again AND game_board = #game_board
     */
    public void checkGameEnd(char[][] game_board){

    }

    /**
     * Gets the input from the player and uses that input to modify the game state based on what input the player provides
     *
     * @pre user must use keyboard input only AND [user input is a single character]
     *
     * @post Returns the character user inputted as a char type after the user has provided keyboard input.
     * keyboard input is filtered to ensure that only the options possible are passed and the corresponding action for that user input is provided
     *
     * @return [char that holds the user keyboard input]
     */
    public char getInput() throws IOException {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String input = reader.readLine();

            return input.charAt(0);
    }

    /**
     * Prints out visual information about the current game state to the console/terminal
     *
     * @pre game_board != NULL AND game_board.length == [number of rows] AND game_board[0].length == [number of columns]
     *
     * @post current state of the game is printed to the console and game_board == #game_board. The game_boards number of rows and columns remains unchanged
     * More specifically, text is printed to the console to the player asking to input a value to represent what column they wish to put a token in
     */
    public void printGameState(char[][] game_board){

    }

    /**
     * This function will display the game board to the user and run the game loop.
     * @param args the command-line arguments passed to the program when it is executed. Not used for anything
     * @pre none
     * @post args = #args and main will continue to run so long as the script is running, serving as the main game and interaction loop for the game
     *
     */
    public static void main(String[] args)
    {
        
    }
}