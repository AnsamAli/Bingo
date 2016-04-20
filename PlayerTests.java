import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.*;

/**
 * unit tests for methods in Player class
 */
public class PlayerTests  {
    public Space[][] playerBoard = new Space[5][5];
    Player player;

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
        playerBoard[2][2] = new Space(2, 2, -1, true);
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

        player = new Player(playerBoard);
    }

    @Test
    public void testVerticalBingo() {
        setUp();
        assertFalse(player.verticalBingo());
        for (Space s : playerBoard[1]) {
            s.markSpace();
        }
        assertTrue(player.verticalBingo());
    }

    @Test
    public void testGetRow() {
        setUp();
        Space[] rowArray = new Space[5];
        rowArray[0] = new Space(0, 1, 10, false);
        rowArray[1] = new Space(1, 1, 27, false);
        rowArray[2] = new Space(2, 1, 42, false);
        rowArray[3] = new Space(3, 1, 55, false);
        rowArray[4] = new Space(4, 1, 64, false);
        Space [] actualRow = player.getRow(1);

        for (int i = 0; i < 5; i++) {
            assertEquals(rowArray[i], actualRow[i]);
        }
    }

    @Test
    public void testHorizontalBingo() {
        setUp();
        assertFalse(player.horizontalBingo());
        for (Space s : player.getRow(1)) {
            s.markSpace();
        }
        assertTrue(player.horizontalBingo());
    }

    @Test
    public void testDiagonalBingo() {
        setUp();
        assertFalse(player.diagonalBingo());
        for (int i = 0; i < 5; i++) {
            playerBoard[i][i].markSpace();
        }
        assertTrue(player.diagonalBingo());
        setUp();
        assertFalse(player.diagonalBingo());
        for (int i = 0; i < 5; i++){
            for (int j = 4; j >= 0; j--){
                playerBoard[i][j].markSpace();
            }
        }
        assertTrue(player.diagonalBingo());
        }



}
