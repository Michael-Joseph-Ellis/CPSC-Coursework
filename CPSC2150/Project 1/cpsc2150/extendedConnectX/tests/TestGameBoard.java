package cpsc2150.extendedConnectX.tests;

import cpsc2150.extendedConnectX.models.*;
import static cpsc2150.extendedConnectX.models.GameBoard.MAX_COLUMN;
import static cpsc2150.extendedConnectX.models.GameBoard.MAX_ROW; 

import static org.junit.Assert.*;
import org.junit.Test;

/* Tests needed to be done by each member (going off google doc): 
 * 
 * Cooper - GameBoard (1), checkIfFree (5), checkHorizontalWin (4)
 * Ryan - checkTie (4), whatsAtPos (5)
 * Michael - checkVertWin (3) DONE, checkDiagWin (7) DONE 
 * Adam - dropToken (5) IP, isPlayerAtPos (5) DONE
 */

public class TestGameBoard 
{

	 /* The following test is for the default constructor of GameBoard.
	  * Test_GameBoard_Constructor()
	  *
	  * - Cooper Taylor
	  */

	 //Scope: Constructor, toString()
	 @Test
	 public void Test_GameBoard_Constructor()
	 {
		 GameBoard gb = new GameBoard();
		 String obs = gb.toString();


		 char[][] expectedBoard = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        };

		  String exp = expectedBoardTostring(expectedBoard);

		  assertEquals(exp,obs);

	 }


	 /* The following tests are for the checkIfFree method.
	  * Test_checkIfFree_col0_free
	  * Test_checkIfFree_col0_notFree
	  * Test_checkIfFree_col6_free
	  * Test_checkIfFree_col6_notFree
	  * Test_checkIfFree_empty_col3_free
	  *
	  * - Cooper Taylor
	  */

	 //Scope: Constructor, dropToken(), checkIfFree()
	 @Test
	 public void Test_checkIfFree_col0_free()
	 {
		  GameBoard gb = new GameBoard();

		  char[][] initialBoard = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'O', ' ', ' ', ' ', ' ', ' ', ' '},
            {'X', ' ', ' ', ' ', ' ', ' ', ' '},
            {'X', ' ', ' ', ' ', ' ', ' ', ' '},
        };

		  // Loop from the bottom row to the top row to set up the board
        for (int row = initialBoard.length - 1; row >= 0; row--) {
            for (int col = 0; col < initialBoard[row].length; col++) {
                char token = initialBoard[row][col];
                if (token != ' ') {
                    gb.dropToken(token, col);
                }
            }
        }

		  assertEquals(true,gb.checkIfFree(0));

	 }

	 //Scope: Constructor, dropToken(), checkIfFree()
	 @Test
	 public void Test_checkIfFree_col0_notFree()
	 {
		  GameBoard gb = new GameBoard();

		  char[][] initialBoard = {
            {'X', ' ', ' ', ' ', ' ', ' ', ' '},
            {'O', ' ', ' ', ' ', ' ', ' ', ' '},
            {'X', ' ', ' ', ' ', ' ', ' ', ' '},
            {'O', ' ', ' ', ' ', ' ', ' ', ' '},
            {'X', ' ', ' ', ' ', ' ', ' ', ' '},
            {'O', ' ', ' ', ' ', ' ', ' ', ' '},
            {'X', ' ', ' ', ' ', ' ', ' ', ' '},
            {'O', ' ', 'O', ' ', ' ', ' ', ' '},
            {'X', 'O', 'X', 'X', ' ', ' ', ' '},
        };

		  // Loop from the bottom row to the top row to set up the board
        for (int row = initialBoard.length - 1; row >= 0; row--) {
            for (int col = 0; col < initialBoard[row].length; col++) {
                char token = initialBoard[row][col];
                if (token != ' ') {
                    gb.dropToken(token, col);
                }
            }
        }

		  assertEquals(false,gb.checkIfFree(0));

	 }

	 //Scope: Constructor, dropToken(), checkIfFree()
	 @Test
	 public void Test_checkIfFree_col6_free()
	 {
		  GameBoard gb = new GameBoard();

		  char[][] initialBoard = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', 'O'},
        };

		  // Loop from the bottom row to the top row to set up the board
        for (int row = initialBoard.length - 1; row >= 0; row--) {
            for (int col = 0; col < initialBoard[row].length; col++) {
                char token = initialBoard[row][col];
                if (token != ' ') {
                    gb.dropToken(token, col);
                }
            }
        }

		  assertEquals(true,gb.checkIfFree(6));

	 }


	 //Scope: Constructor, dropToken(), checkIfFree()
	 @Test
	 public void Test_checkIfFree_col6_notFree()
	 {
		  GameBoard gb = new GameBoard();

		  char[][] initialBoard = {
            {' ', ' ', ' ', ' ', ' ', ' ', 'O'},
            {' ', ' ', ' ', ' ', ' ', ' ', 'X'},
            {' ', ' ', ' ', ' ', ' ', ' ', 'O'},
            {' ', ' ', ' ', ' ', ' ', ' ', 'X'},
            {' ', ' ', ' ', ' ', ' ', 'X', 'X'},
            {' ', ' ', ' ', ' ', ' ', 'O', 'O'},
            {' ', ' ', ' ', ' ', ' ', 'O', 'X'},
            {' ', ' ', ' ', ' ', 'X', 'X', 'O'},
            {'X', 'O', 'X', 'X', 'X', 'O', 'O'},
        };

		  // Loop from the bottom row to the top row to set up the board
        for (int row = initialBoard.length - 1; row >= 0; row--) {
            for (int col = 0; col < initialBoard[row].length; col++) {
                char token = initialBoard[row][col];
                if (token != ' ') {
                    gb.dropToken(token, col);
                }
            }
        }

		  assertEquals(false,gb.checkIfFree(6));

	 }


	 //Scope: Constructor, dropToken(), checkIfFree()
	 @Test
	 public void Test_checkIfFree_empty_col3_free()
	 {
		  GameBoard gb = new GameBoard();

		  char[][] initialBoard = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
        };

		  // Loop from the bottom row to the top row to set up the board
        for (int row = initialBoard.length - 1; row >= 0; row--) {
            for (int col = 0; col < initialBoard[row].length; col++) {
                char token = initialBoard[row][col];
                if (token != ' ') {
                    gb.dropToken(token, col);
                }
            }
        }

		  assertEquals(true,gb.checkIfFree(3));
	 }

 	 /* The following tests are for the checkHorizontalWin method
     * Test_checkHorizontalWin_playerO_NoWin_pos8_0
     * Test_checkHorizontalWin_playerX_Win_pos8_6
     * Test_checkHorizontalWin_playerO_Win_pos5_6
	  * Test_checkHorizontalWin_playerX_noWin_pos4_6
     * 
     * 
     * - Cooper Taylor
     */

	 //Scope: Constructor, dropToken, BoardPosition Constructor, checkHorizWin
	 @Test
	 public void Test_checkHorizontalWin_playerO_NoWin_pos8_0()
	 {
		  GameBoard gb = new GameBoard();

		  char[][] initialBoard = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', 'X', ' ', ' ', ' ', ' ', ' '},
        };

		  // Loop from the bottom row to the top row to set up the board
        for (int row = initialBoard.length - 1; row >= 0; row--) {
            for (int col = 0; col < initialBoard[row].length; col++) {
                char token = initialBoard[row][col];
                if (token != ' ') {
                    gb.dropToken(token, col);
                }
            }
        }

		  // Drop new token
		  gb.dropToken('O', 0);

		  boardPos = new BoardPosition(8,0);

		  assertEquals(false, gb.checkHorizWin(boardPos, 'O'));
	 }

	 //Scope: Constructor, dropToken, BoardPosition Constructor, checkHorizWin
	 @Test
	 public void Test_checkHorizontalWin_playerX_Win_pos8_6()
	 {
		  GameBoard gb = new GameBoard();

		  char[][] initialBoard = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'O', 'O', 'X', 'O', 'O', 'O', ' '},
            {'X', 'O', 'X', 'X', 'X', 'X', ' '},
        };

		  // Loop from the bottom row to the top row to set up the board
        for (int row = initialBoard.length - 1; row >= 0; row--) {
            for (int col = 0; col < initialBoard[row].length; col++) {
                char token = initialBoard[row][col];
                if (token != ' ') {
                    gb.dropToken(token, col);
                }
            }
        }

		  // Drop new token
		  gb.dropToken('X', 6);

		  boardPos = new BoardPosition(8,6);

		  assertEquals(true, gb.checkHorizWin(boardPos, 'X'));
	 }



	 //Scope: Constructor, dropToken, BoardPosition Constructor, checkHorizWin
	 @Test
	 public void Test_checkHorizontalWin_playerO_Win_pos5_6()
	 {
		  GameBoard gb = new GameBoard();

		  char[][] initialBoard = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', 'O', 'O', 'O', 'O', ' '},
            {' ', 'X', 'X', 'O', 'O', 'X', 'O'},
            {'X', 'X', 'O', 'X', 'X', 'X', 'X'},
            {'X', 'X', 'O', 'X', 'O', 'O', 'O'},
        };

		  // Loop from the bottom row to the top row to set up the board
        for (int row = initialBoard.length - 1; row >= 0; row--) {
            for (int col = 0; col < initialBoard[row].length; col++) {
                char token = initialBoard[row][col];
                if (token != ' ') {
                    gb.dropToken(token, col);
                }
            }
        }

		  // Drop new token
		  gb.dropToken('O', 6);

		  boardPos = new BoardPosition(5,6);

		  assertEquals(true, gb.checkHorizWin(boardPos, 'O'));
	 }


	 //Scope: Constructor, dropToken, BoardPosition Constructor, checkHorizWin
	 @Test
	 public void Test_checkHorizontalWin_playerX_NoWin_pos4_6()
	 {
		  GameBoard gb = new GameBoard();

		  char[][] initialBoard = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', 'X', 'O'},
            {' ', ' ', ' ', ' ', 'X', 'O', 'O'},
            {' ', ' ', ' ', 'X', 'O', 'X', 'O'},
            {' ', ' ', 'X', 'O', 'X', 'X', 'X'},
        };

		  // Loop from the bottom row to the top row to set up the board
        for (int row = initialBoard.length - 1; row >= 0; row--) {
            for (int col = 0; col < initialBoard[row].length; col++) {
                char token = initialBoard[row][col];
                if (token != ' ') {
                    gb.dropToken(token, col);
                }
            }
        }

		  // Drop new token
		  gb.dropToken('X', 6);

		  boardPos = new BoardPosition(4,6);

		  assertEquals(false, gb.checkHorizWin(boardPos, 'X'));
	 }


    /* The following tests are for the checkVertWin method.
     * test_checkVertWin_PlayerO_Win_pos0_0()  
     * test_checkVertWin_PlayerX_Win_pos4_2()  
     * test_checkVertWin_PlayerO_NoWin_pos3_1() 
     * 
     * - Michael
     */

    @Test
    public void test_checkVertWin_PlayerX_Win_pos4_2() 
    {
        GameBoard gb = new GameBoard();

        for (int i = 0; i <= 3; i++) {gb.dropToken('O', 2);}
        for (int i = 0; i <= 4; i++) {gb.dropToken('X', 2);}

        String observed = gb.toString();

        char[][] expectedBoard = {
            {' ', ' ', 'X', ' ', ' ', ' ', ' '},
            {' ', ' ', 'X', ' ', ' ', ' ', ' '},
            {' ', ' ', 'X', ' ', ' ', ' ', ' '},
            {' ', ' ', 'X', ' ', ' ', ' ', ' '},
            {' ', ' ', 'X', ' ', ' ', ' ', ' '},
            {' ', ' ', 'O', ' ', ' ', ' ', ' '},
            {' ', ' ', 'O', ' ', ' ', ' ', ' '},
            {' ', ' ', 'O', ' ', ' ', ' ', ' '},
            {' ', ' ', 'O', ' ', ' ', ' ', ' '},
        };
        
        String expected = expectedBoardToString(expectedBoard);

        assertEquals(expected, observed);
    }

    @Test 
    public void test_checkVertWin_PlayerO_NoWin_pos3_1()
    {
        GameBoard gb = new GameBoard();

        for (int i = 0; i <= 1; i++) {gb.dropToken('O', 1);}
        for (int i = 0; i <= 2; i++) {gb.dropToken('X', 1);}
        for (int i = 0; i <= 1; i++) {gb.dropToken('O', 1);}
        
        String observed = gb.toString();

        char[][] expectedBoard = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', 'O', ' ', ' ', ' ', ' ', ' '},
            {' ', 'O', ' ', ' ', ' ', ' ', ' '},
            {' ', 'X', ' ', ' ', ' ', ' ', ' '},
            {' ', 'X', ' ', ' ', ' ', ' ', ' '},
            {' ', 'X', ' ', ' ', ' ', ' ', ' '},
            {' ', 'O', ' ', ' ', ' ', ' ', ' '},
            {' ', 'O', ' ', ' ', ' ', ' ', ' '},
        };
        
        String expected = expectedBoardToString(expectedBoard);

        assertEquals(expected, observed);
    }

    @Test 
    public void test_checkVertWin_PlayerX_NoWin_Interrupted_pos5_0()
    {
        GameBoard gb = new GameBoard();

        for (int i = 0; i <= 1; i++) {gb.dropToken('O', 0);}
        for (int i = 0; i <= 2; i++) {gb.dropToken('X', 0);}
        for (int i = 0; i <= 0; i++) {gb.dropToken('O', 0);}
        for (int i = 0; i <= 2; i++) {gb.dropToken('X', 0);}

        String observed = gb.toString();

        char[][] expectedBoard = {
            {'X', ' ', ' ', ' ', ' ', ' ', ' '},
            {'X', ' ', ' ', ' ', ' ', ' ', ' '},
            {'X', ' ', ' ', ' ', ' ', ' ', ' '},
            {'O', ' ', ' ', ' ', ' ', ' ', ' '},
            {'X', ' ', ' ', ' ', ' ', ' ', ' '},
            {'X', ' ', ' ', ' ', ' ', ' ', ' '},
            {'X', ' ', ' ', ' ', ' ', ' ', ' '},
            {'O', ' ', ' ', ' ', ' ', ' ', ' '},
            {'O', ' ', ' ', ' ', ' ', ' ', ' '},
        };

        String expected = expectedBoardToString(expectedBoard);

        assertEquals(expected, observed);
    }

    /*
     * The following tests are for the checkDiagWin method.
     * 
     * test_checkDiagWin_PlayerX_DiagWin_pos2_2()
     * test_checkDiagWin_PlayerO_Win_Boundary_pos0_0()
     * test_checkDiagWin_PlayerX_ValidWin_pos4_0()
     * test_checkDiagWin_PlayerO_ValidDiagWin_pos1_1()
     * test_checkDiagWin_PlayerX_BoundaryWin_pos4_6()
     * test_checkDiagWin_PlayerO_boundaryWin_pos8_0()
     * test_checkDiagWin_PlayerX_NoWin_ScatteredTokens_pos3_3()
     * 
     * - Michael 
     */

    @Test 
    public void test_checkDiagWin_PlayerX_DiagWin_pos2_2() 
    {
        GameBoard gb = new GameBoard();
        
        for (int i = 0; i <= 0; i++) {
            for (int j = 0; j <= 4; j++) {gb.dropToken('O', j + 2);} 
        }

        for (int i = 4; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {gb.dropToken('O', (j + 2));}
        }

        for (int i = 0; i <= 4; i++) {gb.dropToken('X', (i + 2));}

        String observed = gb.toString();

        char[][] expectedBoard = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', 'X', ' ', ' ', ' ', ' '},
            {' ', ' ', 'O', 'X', ' ', ' ', ' '},
            {' ', ' ', 'O', 'O', 'X', ' ', ' '},
            {' ', ' ', 'O', 'O', 'O', 'X', ' '},
            {' ', ' ', 'O', 'O', 'O', 'O', 'X'},
            {' ', ' ', 'O', 'O', 'O', 'O', 'O'},
            {' ', ' ', 'O', 'O', 'O', 'O', 'O'},
        };

        String expected = expectedBoardToString(expectedBoard);

        assertEquals(expected, observed);   
    }

    @Test 
    public void test_checkDiagWin_PlayerO_Win_Boundary_pos0_0()
    {
        GameBoard gb = new GameBoard();

        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 4; j++) {gb.dropToken('X', j);} 
        }

        for (int i = 4; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {gb.dropToken('X', (j));}
        }

        for (int i = 0; i <= 4; i++) {gb.dropToken('O', (i));}

        String observed = gb.toString();

        char[][] expectedBoard = {
            {'O', ' ', ' ', ' ', ' ', ' ', ' '},
            {'X', 'O', ' ', ' ', ' ', ' ', ' '},
            {'X', 'X', 'O', ' ', ' ', ' ', ' '},
            {'X', 'X', 'X', 'O', ' ', ' ', ' '},
            {'X', 'X', 'X', 'X', 'O', ' ', ' '},
            {'X', 'X', 'X', 'X', 'X', ' ', ' '},
            {'X', 'X', 'X', 'X', 'X', ' ', ' '},
            {'X', 'X', 'X', 'X', 'X', ' ', ' '},
            {'X', 'X', 'X', 'X', 'X', ' ', ' '},
        };

        String expected = expectedBoardToString(expectedBoard);

        assertEquals(expected, observed);
    }

    @Test 
    public void test_checkDiagWin_PlayerX_ValidWin_pos4_0()
    {
        GameBoard gb = new GameBoard();

        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 4; j++) {gb.dropToken('O', j);} 
        }

        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= i; j++) {gb.dropToken('O', (4 - j));}
        }

        for (int i = 0; i <= 4; i++) {gb.dropToken('X', (4 - i));}
        
        String observed = gb.toString();

        char[][] expectedBoard = {
            {' ', ' ', ' ', ' ', 'X', ' ', ' '},
            {' ', ' ', ' ', 'X', 'O', ' ', ' '},
            {' ', ' ', 'X', 'O', 'O', ' ', ' '},
            {' ', 'X', 'O', 'O', 'O', ' ', ' '},
            {'X', 'O', 'O', 'O', 'O', ' ', ' '},
            {'O', 'O', 'O', 'O', 'O', ' ', ' '},
            {'O', 'O', 'O', 'O', 'O', ' ', ' '},
            {'O', 'O', 'O', 'O', 'O', ' ', ' '},
            {'O', 'O', 'O', 'O', 'O', ' ', ' '},
        };

        String expected = expectedBoardToString(expectedBoard);
        
        assertEquals(expected, observed);
    }

    @Test 
    public void test_checkDiagWin_PlayerO_ValidDiagWin_pos1_1() 
    {
        GameBoard gb = new GameBoard();

        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 4; j++) {gb.dropToken('X', (j + 1));} 
        }

        for (int i = 4; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {gb.dropToken('X', (j + 1));}
        }

        for (int i = 0; i <= 4; i++) {gb.dropToken('O', (i + 1));}

        String observed = gb.toString();

        char[][] expectedBoard = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', 'O', ' ', ' ', ' ', ' ', ' '},
            {' ', 'X', 'O', ' ', ' ', ' ', ' '},
            {' ', 'X', 'X', 'O', ' ', ' ', ' '},
            {' ', 'X', 'X', 'X', 'O', ' ', ' '},
            {' ', 'X', 'X', 'X', 'X', 'O', ' '},
            {' ', 'X', 'X', 'X', 'X', 'X', ' '},
            {' ', 'X', 'X', 'X', 'X', 'X', ' '},
            {' ', 'X', 'X', 'X', 'X', 'X', ' '},
        };

        String expected = expectedBoardToString(expectedBoard);

        assertEquals(expected, observed);
    }

    @Test 
    public void test_checkDiagWin_PlayerX_BoundaryWin_pos4_6() 
    {
        GameBoard gb = new GameBoard();

        
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 4; j++) {gb.dropToken('O', (j + 2));} 
        }

        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= i; j++) {gb.dropToken('O', (6 - j));}
        }

        for (int i = 0; i <= 4; i++) {gb.dropToken('X', (6 - i));}

        String observed = gb.toString();

        char[][] expectedBoard = {
            {' ', ' ', ' ', ' ', ' ', ' ', 'X'},
            {' ', ' ', ' ', ' ', ' ', 'X', 'O'},
            {' ', ' ', ' ', ' ', 'X', 'O', 'O'},
            {' ', ' ', ' ', 'X', 'O', 'O', 'O'},
            {' ', ' ', 'X', 'O', 'O', 'O', 'O'},
            {' ', ' ', 'O', 'O', 'O', 'O', 'O'},
            {' ', ' ', 'O', 'O', 'O', 'O', 'O'},
            {' ', ' ', 'O', 'O', 'O', 'O', 'O'},
            {' ', ' ', 'O', 'O', 'O', 'O', 'O'},
        };

        String expected = expectedBoardToString(expectedBoard);

        assertEquals(expected, observed);
    }

    @Test 
    public void test_checkDiagWin_PlayerO_boundaryWin_pos8_0()
    {
        GameBoard gb = new GameBoard();

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= i; j++) {gb.dropToken('X', (4 - j));}
        }

        for (int i = 0; i <= 4; i++) {gb.dropToken('O', (4 - i));}

        String observed  = gb.toString();

        char[][] expectedBoard = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', 'O', ' ', ' '},
            {' ', ' ', ' ', 'O', 'X', ' ', ' '},
            {' ', ' ', 'O', 'X', 'X', ' ', ' '},
            {' ', 'O', 'X', 'X', 'X', ' ', ' '},
            {'O', 'X', 'X', 'X', 'X', ' ', ' '}
        };

        String expected = expectedBoardToString(expectedBoard);

        assertEquals(expected, observed);
    }

    // damn no spamming for loops for this one 🥱
    @Test 
    public void test_checkDiagWin_PlayerX_NoWin_ScatteredTokens_pos3_3()
    {
        GameBoard gb = new GameBoard();

        gb.dropToken('X', 0);

        gb.dropToken('O', 1);
        gb.dropToken('X', 1);

        for (int i = 0; i <= 2; i++) {gb.dropToken('O', 2);}
        gb.dropToken('X', 2);

        for (int i = 0; i <= 2; i++) {gb.dropToken('X', 3);}
        gb.dropToken('O', 3);
        
        gb.dropToken('X', 4);

        gb.dropToken('O', 5);
        gb.dropToken('X', 5);

        gb.dropToken('O', 6);
        gb.dropToken('X', 6);

        String observed = gb.toString();

        char[][] expectedBoard = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', 'X', 'O', ' ', ' ', ' '},
            {' ', ' ', 'O', 'X', ' ', ' ', ' '},
            {' ', 'X', 'O', 'X', ' ', 'X', 'X'},
            {'X', 'O', 'O', 'X', 'X', 'O', 'O'},
        };

        String expected = expectedBoardToString(expectedBoard);

        assertEquals(expected, observed);
    }
    /*
     * The following tests are for the checkTie method.
     *
     * test_checkTie_empty_false
     * test_checkTie_full_true
     * test_checkTie_halfFull_false
     * test_checkTie_PlayerXWin_false
     *
     * - Ryan Chen
     */

    //Tests for checkTie (4 tests)
    @Test
    public void test_checkTie_empty_false()
    {
        /*
        char[][] expectedBoard = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        */
        GameBoard gb = new GameBoard();
        assertEquals(false, gb.checkTie());
    }

    @Test
    public void test_checkTie_full_true()
    {

        char[][] expectedBoard = {
                {'X', 'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'X', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'X', 'X', 'O', 'X'},
                {'O', 'O', 'O', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'O', 'X', 'X', 'X', 'X'}
        };

        GameBoard gb = new GameBoard();

        // Drop the tokens into the board
        for (int col = 0; col < board[0].length; col++) { // For each column
            int dropRow = board.length - 1; // Start from the bottom row

            for (int row = expectedBoard.length - 1; row >= 0; row--) { // Traverse expectedBoard from bottom to top
                if (expectedBoard[row][col] != ' ') {
                    board[dropRow][col] = expectedBoard[row][col];
                    dropRow--; // Move up to the next available slot
                }
            }
            assertEquals(true, gb.checkTie());
        }


        assertEquals(true, gb.checkTie());
    }

    @Test
    public void test_checkTie_halfFull_false(){

        char[][] expectedBoard = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', 'O', 'O', 'O', 'X', 'X', 'O'},
                {'O', 'X', 'X', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'X', 'O', 'X', 'O', 'O'},
                {'X', 'O', 'X', 'O', 'O', 'X', 'X'}
        };

        GameBoard gb = new GameBoard();
        for (int col = 0; col < board[0].length; col++) { // For each column
            int dropRow = board.length - 1; // Start from the bottom row

            for (int row = expectedBoard.length - 1; row >= 0; row--) { // Traverse expectedBoard from bottom to top
                if (expectedBoard[row][col] != ' ') {
                    board[dropRow][col] = expectedBoard[row][col];
                    dropRow--; // Move up to the next available slot
                }
            }
        }
        assertEquals(false, gb.checkTie());
    }

    @Test
    public void test_checkTie_PlayerXWin_false()
    {

        char[][] expectedBoard = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', 'X', 'X', 'X', 'X', 'X', ' '}
        };

        GameBoard gb = new GameBoard();
        for (int col = 0; col < board[0].length; col++) { // For each column
            int dropRow = board.length - 1; // Start from the bottom row

            for (int row = expectedBoard.length - 1; row >= 0; row--) { // Traverse expectedBoard from bottom to top
                if (expectedBoard[row][col] != ' ') {
                    board[dropRow][col] = expectedBoard[row][col];
                    dropRow--; // Move up to the next available slot
                }
            }
        }
        assertEquals(false, gb.checkTie());
    }

    /*
    *The following tests are for the whatsAtPos method.
    * test_whatsAtPos_markerX_pos8_2
    * test_whatsAtPos_empty_pos4_1
    * test_whatsAtPos_markerO_pos3_4
    * test_whatsAtPos_marker)_pos8_6
    * test_whatsAtPos_markerO_pos0_0
    * - Ryan Chen
     */

    //Tests for whatsAtPos (5 tests)
    @Test
    public void test_whatsAtPos_markerX_pos8_2()
    {
        GameBoard gb = new GameBoard();



        char[][] initialBoard = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', ' ', ' ', ' '}
        };


        // Loop from the bottom row to the top row to set up the board
        for (int row = initialBoard.length - 1; row >= 0; row--) {
            for (int col = 0; col < initialBoard[row].length; col++) {
                char token = initialBoard[row][col];
                if (token != ' ') {
                    gb.dropToken(token, col);
                }
            }
        }

        assertEquals('X', gb.whatsAtPos(new BoardPosition(8, 2)));
    }

    @Test
    public void test_whatsAtPos_empty_pos4_1() {

        char[][] expectedBoard = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };

        GameBoard gb = new GameBoard();
        for (int row = initialBoard.length - 1; row >= 0; row--) {
            for (int col = 0; col < initialBoard[row].length; col++) {
                char token = initialBoard[row][col];
                if (token != ' ') {
                    gb.dropToken(token, col);
                }
            }
        }
        assertEquals(' ', gb.whatsAtPos(new BoardPosition(4, 1)));
    }

    @Test
    public void test_whatsAtPos_markerO_pos3_4(){

        char[][] expectedBoard = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', 'O', ' ', ' '},
                {' ', ' ', ' ', ' ', 'X', ' ', ' '},
                {' ', ' ', ' ', ' ', 'O', ' ', ' '},
                {' ', ' ', ' ', ' ', 'X', ' ', ' '},
                {' ', ' ', ' ', ' ', 'O', ' ', ' '},
                {' ', ' ', ' ', ' ', 'X', ' ', ' '}
        };

        GameBoard gb = new GameBoard();
        for (int row = initialBoard.length - 1; row >= 0; row--) {
            for (int col = 0; col < initialBoard[row].length; col++) {
                char token = initialBoard[row][col];
                if (token != ' ') {
                    gb.dropToken(token, col);
                }
            }
        }

        assertEquals('X', gb.whatsAtPos(new BoardPosition(8, 2)));
    }
    }

    @Test
    public void test_WhatsAtPos_markerO_pos8_6() {
        char[][] expectedBoard = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', 'O'}
        };
        GameBoard gb = new GameBoard();
        for (int row = initialBoard.length - 1; row >= 0; row--) {
            for (int col = 0; col < initialBoard[row].length; col++) {
                char token = initialBoard[row][col];
                if (token != ' ') {
                    gb.dropToken(token, col);
                }
            }
        }
        assertEquals('O', gb.whatsAtPos(new BoardPosition(8, 6)));
    }

    @Test
    public void test_whatsAtPos_markerO_pos0_0(){
        char[][] expectedBoard = {
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {'O', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {'O', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {'O', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {'O', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        GameBoard gb = new GameBoard();
        for (int row = initialBoard.length - 1; row >= 0; row--) {
            for (int col = 0; col < initialBoard[row].length; col++) {
                char token = initialBoard[row][col];
                if (token != ' ') {
                    gb.dropToken(token, col);
                }
            }
        }

        assertEquals('X', gb.whatsAtPos(new BoardPosition(0, 0)));
    }


    /* The following tests are for the isPlayerAtPos method.
     * test_isPlayerAtPos_playerO_pos8_0
     * test_isPlayerAtPos_playerX_pos1_2
     * test_isPlayerAtPos_playerX_pos0_0
     * test_isPlayerAtPos_playerO_pos8_6
     * test_isPlayerAtPos_playerX_pos2_3
     *
     * - Adam Niemczura
     */

    //Tests for isPlayerAtPos (5 tests)
    @Test
    public void test_isPlayerAtPos_playerO_pos8_0()
    {
        /*
        char[][] expectedBoard = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', 'O', ' ', ' '}
        };
        */

        GameBoard gb = new GameBoard();
        gb.dropToken('X', 0);
        gb.dropToken('O', 4);

        BoardPosition bp = new BoardPosition(8, 0)

        assertEquals(gb.isPlayerAtPos(bp, 'O'), false)
    }

    @Test
    public void test_isPlayerAtPos_playerX_pos1_2()
    {
        /*
        char[][] grid = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', ' ', ' ', ' '},
                {' ', ' ', 'O', ' ', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', ' ', ' ', ' '},
                {' ', ' ', 'O', ' ', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', ' ', 'O', ' '},
                {' ', ' ', 'O', ' ', ' ', 'X', 'O'},
                {' ', ' ', 'X', ' ', ' ', 'X', 'O'},
                {' ', ' ', 'O', ' ', ' ', 'X', 'O'},
        };
        */

        GameBoard gb = new GameBoard();

        gb.dropToken('O', 2);
        gb.dropToken('X', 2);
        gb.dropToken('O', 2); //
        gb.dropToken('X', 2); //
        gb.dropToken('O', 2);
        gb.dropToken('X', 2);
        gb.dropToken('O', 2); //
        gb.dropToken('X', 2); //

        gb.dropToken('X', 5);
        gb.dropToken('X', 5);
        gb.dropToken('X', 5);
        gb.dropToken('O', 5);

        gb.dropToken('O', 6);
        gb.dropToken('O', 6);
        gb.dropToken('O', 6);

        BoardPosition bp = new BoardPosition(1, 2)

        assertEquals(gb.isPlayerAtPos(bp, 'X'), true)
    }

    @Test
    public void test_isPlayerAtPos_playerX_pos0_0()
    {
        /*
        char[][] grid = {
                {'O', ' ', ' ', ' ', ' ', ' ', ' '},
                {'O', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {'O', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {'O', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {'O', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
        };
        */

        GameBoard gb = new GameBoard();
        gb.dropToken('X', 0);
        gb.dropToken('O', 0);

        gb.dropToken('X', 0);
        gb.dropToken('O', 0);

        gb.dropToken('X', 0);
        gb.dropToken('O', 0);

        gb.dropToken('X', 0);
        gb.dropToken('O', 0);

        gb.dropToken('O', 0);

        BoardPosition bp = new BoardPosition(0, 0)

        assertEquals(gb.isPlayerAtPos(bp, 'X'), false)
    }

    @Test
    public void test_isPlayerAtPos_playerO_pos8_6()
    {
         /*
        char[][] grid = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', 'X'},
        };
        */

        GameBoard gb = new GameBoard();

        gb.dropToken('X', 6);

        BoardPosition bp = new BoardPosition(8, 6)

        assertEquals(gb.isPlayerAtPos(bp, 'O'), false)
    }

    @Test
    public void test_isPlayerAtPos_playerX_pos2_3()
    {
        /*
        char[][] grid = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', ' ', ' ', ' '},
                {' ', ' ', 'O', ' ', ' ', ' ', ' '},
                {' ', ' ', 'O', ' ', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', ' ', ' ', ' '},
                {' ', ' ', 'O', 'X', ' ', ' ', ' '},
        };
        */

        GameBoard gb = new GameBoard();

        gb.dropToken('O', 2);
        gb.dropToken('X', 2);
        gb.dropToken('O', 2);
        gb.dropToken('O', 2);
        gb.dropToken('X', 2);

        gb.dropToken('X', 3);

        BoardPosition bp = new BoardPosition(2, 3)

        assertEquals(gb.isPlayerAtPos(bp, 'X'), false)
    }

    /* The following tests are for the dropToken method.
     * test_dropToken_playerX_column0_regular
     * test_dropToken_playerO_column6_filled
     * test_dropToken_playerX_column3_empty
     * test_dropToken_playerO_column4_Vwin
     * test_dropToken_playerX_column3_Hwin
     *
     * - Adam Niemczura
     */

    //Tests for dropToken (5 tests)
    @Test
    public void test_dropToken_playerX_column0_regular()
    {
        /*
        Initial board set up
        char[][] grid = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', 'X', ' ', 'X'},
                {' ', 'O', ' ', ' ', 'O', ' ', 'O'},
                {' ', 'X', ' ', 'X', 'O', 'X', 'O'},
                {' ', 'X', 'X', 'O', 'O', 'O', 'X'},
        };
        */
        GameBoard gb = new GameBoard();

        gb.dropToken('X', 1);
        gb.dropToken('X', 1);
        gb.dropToken('O', 1);

        gb.dropToken('X', 2);

        gb.dropToken('O', 3);
        gb.dropToken('X', 3);

        gb.dropToken('O', 4);
        gb.dropToken('O', 4);
        gb.dropToken('O', 4);
        gb.dropToken('X', 4);

        gb.dropToken('O', 5);
        gb.dropToken('X', 5);

        gb.dropToken('X', 6);
        gb.dropToken('O', 6);
        gb.dropToken('O', 6);
        gb.dropToken('X', 6);

        gb.dropToken('X', 0); //the one change from pre to post state

        char[][] expectedBoard = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', 'X', ' ', 'X'},
                {' ', 'O', ' ', ' ', 'O', ' ', 'O'},
                {' ', 'X', ' ', 'X', 'O', 'X', 'O'},
                {'X', 'X', 'X', 'O', 'O', 'O', 'X'},
        };

        String observed = gb.toString();

        String expected = expectedBoardToString(expectedBoard);

        assertEquals(expected, observed);
    }

    @Test
    public void test_dropToken_playerO_column6_filled()
    {
        char[][] initialBoard = {
                {'O', 'X', 'O', 'O', 'X', 'O', ' '},
                {'X', 'X', 'O', 'X', 'X', 'X', 'X'},
                {'O', 'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'O', 'X', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'X', 'O', 'X'},
                {'O', 'O', 'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'O', 'X', 'X', 'O', 'O'},
                {'X', 'X', 'O', 'O', 'O', 'O', 'X'},
                {'O', 'O', 'X', 'O', 'O', 'X', 'O'}
        };

        GameBoard gb = new GameBoard();

        // Loop from the bottom row to the top row to set up the board
        for (int row = initialBoard.length - 1; row >= 0; row--) {
            for (int col = 0; col < initialBoard[row].length; col++) {
                char token = initialBoard[row][col];
                if (token != ' ') {
                    gb.dropToken(token, col);
                }
            }
        }

        //the drop we are testing
        gb.dropToken('O', 6);

        char[][] expectedBoard = {
                {'O', 'X', 'O', 'O', 'X', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'X', 'X', 'X'},
                {'O', 'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'O', 'X', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'X', 'O', 'X'},
                {'O', 'O', 'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'O', 'X', 'X', 'O', 'O'},
                {'X', 'X', 'O', 'O', 'O', 'O', 'X'},
                {'O', 'O', 'X', 'O', 'O', 'X', 'O'}
        };

        String observed = gb.toString();

        String expected = expectedBoardToString(expectedBoard);

        assertEquals(expected, observed);

    }

    @Test
    public void test_dropToken_playerX_column3_empty()
    {
        GameBoard gb = new GameBoard();

        gb.dropToken('X', 3);

        char[][] expectedBoard = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', 'X', ' ', ' ', ' '}
        };

        String observed = gb.toString();

        String expected = expectedBoardToString(expectedBoard);

        assertEquals(expected, observed);
    }

    @Test
    public void test_dropToken_playerO_column4_Vwin()
    {
        char[][] initialBoard = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', 'O', ' ', ' '},
                {' ', ' ', ' ', ' ', 'O', ' ', ' '},
                {' ', ' ', ' ', ' ', 'O', ' ', 'X'},
                {'X', 'X', ' ', ' ', 'O', 'X', 'X'}
        };

        GameBoard gb = new GameBoard();

        // Loop from the bottom row to the top row to set up the board
        for (int row = initialBoard.length - 1; row >= 0; row--) {
            for (int col = 0; col < initialBoard[row].length; col++) {
                char token = initialBoard[row][col];
                if (token != ' ') {
                    gb.dropToken(token, col);
                }
            }
        }

        //the drop we are testing
        gb.dropToken('O', 4);

        char[][] expectedBoard = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', 'O', ' ', ' '},
                {' ', ' ', ' ', ' ', 'O', ' ', ' '},
                {' ', ' ', ' ', ' ', 'O', ' ', ' '},
                {' ', ' ', ' ', ' ', 'O', ' ', 'X'},
                {'X', 'X', ' ', ' ', 'O', 'X', 'X'}
        };

        String observed = gb.toString();

        String expected = expectedBoardToString(expectedBoard);

        assertEquals(expected, observed);
    }

    @Test
    public void test_dropToken_playerX_column3_Hwin()
    {
        char[][] initialBoard = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', 'O'},
                {'X', ' ', ' ', ' ', ' ', 'X', 'O'},
                {'X', 'X', 'X', ' ', 'X', 'X', 'X'}
        };

        GameBoard gb = new GameBoard();

        // Loop from the bottom row to the top row to set up the board
        for (int row = initialBoard.length - 1; row >= 0; row--) {
            for (int col = 0; col < initialBoard[row].length; col++) {
                char token = initialBoard[row][col];
                if (token != ' ') {
                    gb.dropToken(token, col);
                }
            }
        }

        //the drop we are testing
        gb.dropToken('X', 3);

        char[][] expectedBoard = {
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', 'O'},
                {'X', ' ', ' ', ' ', ' ', 'X', 'O'},
                {'X', 'X', 'X', 'X', 'X', 'X', 'X'}
        };

        String observed = gb.toString();

        String expected = expectedBoardToString(expectedBoard);

        assertEquals(expected, observed);
    }


    private static String expectedBoardToString(char[][] gb) 
    {
        StringBuilder board = new StringBuilder();
        
        for (int i = 0; i < (MAX_COLUMN); i++) 
        {
            board.append("|").append(i).append("");
        }

        board.append("|\n");

        for (int i = 0; i < (MAX_ROW - 1); i++) 
        {
            for (int j = 0; j < MAX_COLUMN; j++) 
            {
                board.append("|").append(gb[i][j]).append("");
            }
            board.append("|\n");
        }
        return board.toString();
    }
}

public void main() {
}
