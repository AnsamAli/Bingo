package tests;

import bingo.Dealer;
import bingo.Space;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class DealerTest {

    @Test
    public void testPopulateBoard() {

        Dealer dealer = new Dealer();

        Space [][] board = dealer.populateBoard();
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
