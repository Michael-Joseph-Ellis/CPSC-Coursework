package cpsc2150.extendedConnectX.views;
import cpsc2150.extendedConnectX.models.GameBoard;
import cpsc2150.extendedConnectX.models.IGameBoard;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

Michael Ellis - Michael-Joseph-Ellis

Ryan Chen - rchen55

Cooper Taylor - Cooper-Taylor

Adam Niemczura - AdamNiem

*/

/**
 * The `GameScreen` class is responsible for handling the user interface
 * and game loop for a Connect X game.
 *
 * It provides methods for printing the game board, checking for game end conditions,
 * getting user input, and prompting the player for their move.
 */

public class GameScreen {

    /**
     * Prints out the string representation of the game board to the terminal
     *
     * @param gameBoard game board object
     *
     * @pre gameBoard != NULL
     * AND [gameBoard's toString result is string representation of board that is the correct number of columns and rows]
     *
     * @post game board is printed to the terminal AND gameBoard = #gameBoard.
     * AND The game board printed is the exact number of columns and rows as specified in the precondition
     */
    public static void printBoard(GameBoard gameBoard){
        System.out.println(gameBoard.toString());
    }

    /**
     * Checks if the game has ended and if so handles it by ending the game and prompting the user with an end of game description along with an option for the player to play again
     *
     * @param gameBoard game board object
     * @param column integer specifying column to check for win
     * @param player char for player who may have potentially won
     *
     * @pre gameBoard != NULL
     * AND [gameBoard's checkForWin (taking column number as an integer) and checkTie methods both exist
     * and return true or false based on a win or tie respectively]
     * AND [gameBoard method getInput is defined and returns user input as a string]
     *
     * @post end of game description is printed to the console and player is given a prompt in the console if they want to play again
     * AND gameBoard = #gameBoard
     * AND Returns true if game loop should end and false if otherwise
     *
     * @return boolean
     */
    public static boolean checkGameEnd(GameBoard gameBoard, int column, char player) throws IOException {
        boolean gameFinished = false;

        if (gameBoard.checkForWin(column))
        {
            System.out.println("Player " + player + " Won!");
            gameFinished = true;
        } else if (gameBoard.checkTie()) {
            System.out.println("It's a tie!");
            gameFinished = true;
        }
        if(gameFinished) {
            System.out.println("Would you like to play again? Y/N \n");
            String response = getInput();
            //New game if player says 'y' or 'Y' and if they say anything else end the program
            if (response.equalsIgnoreCase("y")) {
                return true; //true to indicate that this current game ended but player wants to play another game
            }else{
                System.exit(0); //Exit the program if player does not want to play again
            }
        }

        return false; //true to indicate game has not ended
    }

    /**
     * Gets the input from the player as a string
     *
     * @pre user must use keyboard input only AND [user input is a single character]
     *
     * @post [Returns the character user inputted as a string type after the user has provided keyboard input.
     * keyboard input is filtered to ensure that only the options possible are passed and the corresponding action for that user input is provided]
     *
     * @return [string that holds the user keyboard input]
     */
    public static String getInput() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        return reader.readLine();
    }

    /**
     * Prompts the user with turn information and an option for input in the terminal so that the user can play their turn
     *
     * @param gameBoard game board object
     * @param currentPlayer current player represented as a char
     *
     * @pre gameBoard != NULL
     * AND [gameBoard's dropToken method exists, taking a char and int for player and column respectively]
     *
     * @return integer
     *
     * @post player is given a text prompt detailing turn information AND gameBoard == #gameBoard
     * AND [The game_boards number of rows and columns remains unchanged.
     * More specifically, text is printed to the console to the player asking to input a value to represent what column they wish to put a token in]
     * AND [returns integer which represents the column the player chose to drop their token]
     */
    public static int promptPlayer(GameBoard gameBoard, char currentPlayer) throws IOException {
        String response = String.format("Player %s, what column do you want to place your marker in?", currentPlayer);
        System.out.println(response);

        //Player input to drop token
        //Check integer is within the bounds of the num of columns
        int columnChosen = Integer.parseInt(getInput());
        //Check user inputted column is within the bounds of columns
        while(columnChosen < 0 || columnChosen >= IGameBoard.MAX_COL)
        {
            System.out.println("Column selected out of bounds, pick again");
            columnChosen = Integer.parseInt(getInput());
        }

        //Drop the token
        gameBoard.dropToken(currentPlayer,  columnChosen);

        return columnChosen;

    }

    /**
     * This function will display the game board to the user and run the game loop.
     * @param args the command-line arguments passed to the program when it is executed. Not used for anything
     * @pre none
     * @post args = #args and main will continue to run so long as the script is running, serving as the main game and interaction loop for the game
     *
     */
    public static void main(String[] args) throws IOException {
        int turnCounter = 0; //Tracks the turns (used to determine who's turn it is)
        char currentPlayer = 'X';
        int columnSelected; //Tracks the column where token will be dropped per turn

        boolean endGame;

        //Initialize game board
        GameBoard gameBoard = new GameBoard();

        //Game loop: runs until user does not want to play anymore
        while (true) {
            //Check whose turn it is based on turn Counter
            if (turnCounter % 2 == 0) {
                currentPlayer = 'X';
            } else if (turnCounter % 2 == 1) {
                currentPlayer = 'O';
            }

            //Print Game Board to screen
            printBoard(gameBoard);

            //Prompt player to input token, returns the column the player selected
            columnSelected = promptPlayer(gameBoard, currentPlayer);

            //Check whether player won and whether to end the program or start another game
            //Return true if game ended but player wants to play again and false is current game has not ended yet
            endGame = checkGameEnd(gameBoard, columnSelected, currentPlayer);
            if(endGame)
            {
                gameBoard = new GameBoard(); //Wipe the board for a new game
            }

            //Increment turn counter
            turnCounter++;
        }
    }
}