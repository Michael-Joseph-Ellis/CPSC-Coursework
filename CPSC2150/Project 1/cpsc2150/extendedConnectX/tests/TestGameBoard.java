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
 * Adam - dropToken (5), isPlayerAtPos (5)
 */

public class TestGameBoard 
{

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



    //Tests for isPlayerAtPos (5 tests)
    @Test
    public void test_isPlayerAtPos_playerO_pos8_0()
    {
        char[][] customBoard = {
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {'O', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' ', ' ', ' '},
                {'O', ' ', ' ', ' ', ' ', ' ', ' '},
                {'O', ' ', ' ', ' ', ' ', ' ', ' '}
        };
        GameBoard gb = new GameBoard(customBoard);

        //do the code to check if token at pos8_0 is a player token

    }

    //Tests for dropToken (5 tests)
    //* Not added yet

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