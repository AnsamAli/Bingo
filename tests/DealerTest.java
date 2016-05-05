package tests;

import bingo.Dealer;
import bingo.Space;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class DealerTest {
    Dealer dealer = new Dealer();
    Space[][] playerBoard = new Space[5][5];

    void setUp() {

        playerBoard[0][0] = new Space(0, 0, 14, false);
        playerBoard[0][1] = new Space(0, 1, 10, false);
        playerBoard[0][2] = new Space(0, 2, 7, false);
        playerBoard[0][3] = new Space(0, 3, 11, false);
        playerBoard[0][4] = new Space(0, 4, 15, false);

        playerBoard[1][0] = new Space(1, 0, 20, false);
        playerBoard[1][1] = new Space(1, 1, 27, false);
        playerBoard[1][2] = new Space(1, 2, 23, false);
        playerBoard[1][3] = new Space(1, 3, 28, false);
        playerBoard[1][4] = new Space(1, 4, 25, false);

        playerBoard[2][0] = new Space(2, 0, 32, false);
        playerBoard[2][1] = new Space(2, 1, 42, false);
        playerBoard[2][2] = new Space(2, 2, 40, true);
        playerBoard[2][3] = new Space(2, 3, 34, false);
        playerBoard[2][4] = new Space(2, 4, 33, false);

        playerBoard[3][0] = new Space(3, 0, 52, false);
        playerBoard[3][1] = new Space(3, 1, 55, false);
        playerBoard[3][2] = new Space(3, 2, 58, false);
        playerBoard[3][3] = new Space(3, 3, 56, false);
        playerBoard[3][4] = new Space(3, 4, 53, false);

        playerBoard[4][0] = new Space(4, 0, 71, false);
        playerBoard[4][1] = new Space(4, 1, 64, false);
        playerBoard[4][2] = new Space(4, 2, 69, false);
        playerBoard[4][3] = new Space(4, 3, 72, false);
        playerBoard[4][4] = new Space(4, 4, 66, false);
    }

    void setupHorizontalBingo() {
        setUp();
        playerBoard[0][3].mark();
        playerBoard[1][3].mark();
        playerBoard[2][3].mark();
        playerBoard[3][3].mark();
        playerBoard[4][3].mark();
    }

    void setupVerticalBingo() {
        setUp();
        playerBoard[2][0].mark();
        playerBoard[2][1].mark();
        playerBoard[2][3].mark();
        playerBoard[2][4].mark();
    }

    void setupForwardDiagonal() {
        setUp();
        playerBoard[0][0].mark();
        playerBoard[1][1].mark();
        playerBoard[3][3].mark();
        playerBoard[4][4].mark();
    }

    void setupBackwardDiagonal() {
        setUp();
        playerBoard[0][4].mark();
        playerBoard[1][3].mark();
        playerBoard[3][1].mark();
        playerBoard[4][0].mark();
    }

    @Test
    public void testGetRow() {
        setUp();

        Space[] getRow = dealer.getRow(1, playerBoard);
        assertEquals(new Space(0, 1, 10, false).toString(), getRow[0].toString());
        assertEquals(new Space(1, 1, 27, false).toString(), getRow[1].toString());
        assertEquals(new Space(2, 1, 42, false).toString(), getRow[2].toString());
        assertEquals(new Space(3, 1, 55, false).toString(), getRow[3].toString());
        assertEquals(new Space(4, 1, 64, false).toString(), getRow[4].toString());
    }

    @Test
    public void testColumn() {
        setUp();

        Space[] getColumn = dealer.getColumn(2, playerBoard);
        assertEquals(new Space(2, 0, 32, false).toString(), getColumn[0].toString());
        assertEquals(new Space(2, 1, 42, false).toString(), getColumn[1].toString());
        assertEquals(new Space(2, 2, 40, true).toString(), getColumn[2].toString());
        assertEquals(new Space(2, 3, 34, false).toString(), getColumn[3].toString());
        assertEquals(new Space(2, 4, 33, false).toString(), getColumn[4].toString());
    }


    @Test
    public void testHasBingo() {
        // horizontal bingo
        setupHorizontalBingo();
        assertTrue(dealer.hasBingo(playerBoard));
        // vertical bingo
        setupVerticalBingo();
        assertTrue(dealer.hasBingo(playerBoard));
        //diagonal bingos
        setupForwardDiagonal();
        assertTrue(dealer.hasBingo(playerBoard));
        setupBackwardDiagonal();
        assertTrue(dealer.hasBingo(playerBoard));
    }

    @Test
    public void testPopulateBoard() {
        Space[][] board = dealer.populateBoard();
        for (Space s : board[0]) {
            System.out.println(s.toString());
            assertTrue(0 < s.id && s.id < 16);

        }
        for (Space s : board[1]) {
            System.out.println(s.toString());
            assertTrue(16 <= s.id && s.id <= 30);
        }
        for (Space s : board[2]) {
            System.out.println(s.toString());
            assertTrue((31 <= s.id && s.id <= 45) || (s.id == -1));
        }
        for (Space s : board[3]) {
            System.out.println(s.toString());
            assertTrue(46 <= s.id && s.id <= 60);
        }
        for (Space s : board[4]) {
            System.out.println(s.toString());
            assertTrue(61 <= s.id && s.id <= 75);
        }
        System.out.println();
    }
}
