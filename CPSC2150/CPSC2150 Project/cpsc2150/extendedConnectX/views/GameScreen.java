package cpsc2150.extendedConnectX.views;

import cpsc2150.extendedConnectX.models.GameBoard;
import cpsc2150.extendedConnectX.models.GameBoardMem;
import cpsc2150.extendedConnectX.models.IGameBoard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

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
     * NOTE: 
     * The current driver is most likely too long to be viable. In other words, the current
     * implemented driver is just for test and should probably be broken down.
     * This is project has yet to have the new implementation of the GameBoardMem class, however I've added in the 
     * if statement to check if the game mode is memory efficient or not.  
     */

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean gameEnded = false; // Main game loop control
        do {
            // Get game settings
            System.out.println("How many players?");
            int numPlayers = Integer.parseInt(getValidatedInput(reader, "Must be between 2 and 10", input ->
                    input.matches("\\d+") && Integer.parseInt(input) >= 2 && Integer.parseInt(input) <= 10));

            char[] playerTokens = new char[numPlayers];
            Set<Character> usedTokens = new HashSet<>();

            // Collect player tokens
            for (int i = 0; i < numPlayers; i++)
            {
                System.out.printf("Enter the character to represent player %d:\n", i + 1);
                char token;
                while (true)
                {
                    String input = getValidatedInput(reader, "Enter a single letter character.", str ->
                            str.length() == 1 && Character.isLetter(str.charAt(0)));
                    token = Character.toUpperCase(input.charAt(0));

                    if (usedTokens.contains(token))
                    {
                        System.out.println(token + " is already taken as a player token!");
                    }
                    else
                    {
                        usedTokens.add(token);
                        break;
                    }
                }
                playerTokens[i] = token;
            }

            // Board dimensions and winning condition
            System.out.println("How many rows should be on the board?");
            int rows = Integer.parseInt(getValidatedInput(reader, "Must be between 3 and 100", input ->
                    input.matches("\\d+") && Integer.parseInt(input) >= 3 && Integer.parseInt(input) <= 100));

            System.out.println("How many columns should be on the board?");
            int columns = Integer.parseInt(getValidatedInput(reader, "Must be between 3 and 100", input ->
                    input.matches("\\d+") && Integer.parseInt(input) >= 3 && Integer.parseInt(input) <= 100));

            System.out.println("How many in a row to win?");
            int numToWin = Integer.parseInt(getValidatedInput(reader, "Must be between 3 and 25 and less than rows and columns", input ->
                    input.matches("\\d+") && Integer.parseInt(input) >= 3 && Integer.parseInt(input) <= 25 &&
                            Integer.parseInt(input) <= rows && Integer.parseInt(input) <= columns));

            // Game mode selection
            System.out.println("Would you like a Fast Game (F/f) or a Memory Efficient Game (M/m)?");
            String gameMode = getValidatedInput(reader, "Enter F or M", input ->
                    input.equalsIgnoreCase("f") || input.equalsIgnoreCase("m"));

            IGameBoard gameBoard;
            if (gameMode.equalsIgnoreCase("f"))
            {
                gameBoard = new GameBoard(rows, columns, numToWin);
            }
            else
            {
                gameBoard = new GameBoardMem(rows, columns, numToWin);
            }

            // Play a round
            boolean roundEnded = false;
            int turnCounter = 0;

            while (!roundEnded)
            {
                printBoard(gameBoard);

                char currentPlayer = playerTokens[turnCounter % numPlayers];
                System.out.printf("Player %c, what column do you want to place your marker in?\n", currentPlayer);

                int column = Integer.parseInt(getValidatedInput(reader, "Column out of bounds. Try again.", input ->
                        input.matches("\\d+") && Integer.parseInt(input) >= 0 && Integer.parseInt(input) < columns));

                gameBoard.dropToken(currentPlayer, column);

                roundEnded = checkGameEnd(gameBoard, column, currentPlayer);
                turnCounter++;
            }

            // Replay prompt
            System.out.println("Would you like to play again? Y/N");
            String playAgain = getValidatedInput(reader, "Enter Y or N", input ->
                    input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n"));

            if (playAgain.equalsIgnoreCase("n"))
            {
                gameEnded = true;
            }
        } while (!gameEnded);
    }

    /**
     * Displays the current state of the game board in the console.
     *
     * @param gameBoard The game board object implementing the IGameBoard interface.
     *
     * @pre gameBoard != null
     *      AND [gameBoard.toString() produces a string representation of the game board with correct dimensions.]
     *
     * @post The game board's current state is printed to the console.
     *       AND gameBoard == #gameBoard.
     */
    public static void printBoard(IGameBoard gameBoard)
    {
        System.out.println(gameBoard.toString());
    }

    /**
     * Evaluates whether the game has ended due to a win or a tie and handles post-game actions.
     * If the game has ended, it prints the game outcome.
     *
     * @param gameBoard The game board object representing the current state of the game.
     * @param column The column index where the last token was placed.
     * @param player The character representing the current player.
     *
     * @pre reader != null
     *      AND gameBoard != null
     *      AND 0 <= column < gameBoard.getColumns()
     *      AND gameBoard.checkForWin(column) and gameBoard.checkTie() are valid methods.
     *
     * @post If the game ends, a message indicating the outcome (win or tie) is printed.
     *       AND gameBoard == #gameBoard
     *
     * @return true if the round ends; false otherwise.
     */

    public static boolean checkGameEnd(IGameBoard gameBoard, int column, char player) throws IOException
    {
        if (gameBoard.checkForWin(column))
        {
            System.out.printf("Player %c Won!\n", player);
            return true; // Round ends
        }
        else if (gameBoard.checkTie())
        {
            System.out.println("It's a tie!");
            return true; // Round ends
        }
        return false; // Round continues
    }

    /**
     * Validates user input based on a specified condition and provides feedback for invalid inputs.
     *
     * @param reader The `BufferedReader` used to read user input from the console.
     * @param errorMessage The error message to display when the input does not satisfy the validation condition.
     * @param condition A `Predicate<String>` representing the condition the input must satisfy to be considered valid.
     *
     * @return The validated user input as a `String`, which satisfies the specified condition.
     *
     * @throws IOException If an I/O error occurs while reading user input.
     *
     * @pre reader != null
     *      AND errorMessage != null
     *      AND condition != null
     *      AND reader is ready to read input from the user.
     *
     * @post Returns a valid input string that satisfies the given condition.
     *       If invalid input is provided, the error message is displayed, and the user is prompted again until valid input is received.
     */
    private static String getValidatedInput(BufferedReader reader, String errorMessage, java.util.function.Predicate<String> condition) throws IOException
    {
        while (true)
        {
            String input = reader.readLine().trim();
            if (condition.test(input))
            {
                return input;
            }
            System.out.println(errorMessage);
        }
    }
}