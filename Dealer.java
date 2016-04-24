import java.util.ArrayList;
import java.util.Random;

/**
 * data representation of a dealer who works as a
 * middleman for the server and the player
 */
public class Dealer {
    final static int BMIN = 1;
    final static int BMAX = 15;
    final static int IMIN = 16;
    final static int IMAX = 30;
    final static int NMIN = 31;
    final static int NMAX = 45;
    final static int GMIN = 46;
    final static int GMAX = 60;
    final static int OMIN = 61;
    final static int OMAX = 75;


    ArrayList<Player> players = new ArrayList<>();


    public void distributeBoards() {
        Random random = new Random();
        for (Player p : players) {

            Space[][] newBoard = new Space[5][5];
            // B column
            for (int i = 0; i < 5; i++) {
                newBoard[0][i] = new Space(0, i, random.nextInt(BMAX) + BMIN, false);
            }
            //I column
            for (int i = 0; i < 5; i++) {
                newBoard[1][i] = new Space(1, i, random.nextInt(IMAX - IMIN + 1) + IMIN, false);
            }
            // N column
            for (int i = 0; i < 5; i++) {
                if (i == 2) {
                    newBoard[2][i] = new Space(2, i, -1, true);
                } else {
                    newBoard[2][i] = new Space(2, i, random.nextInt(NMAX - NMIN + 1) + NMIN, false);
                }
            }

            //G column
            for (int i = 0; i < 5; i++) {
                newBoard[3][i] = new Space(3, i, random.nextInt(GMAX - GMIN + 1) + GMIN, false);
            }
            //O column
            for (int i = 0; i < 5; i++) {
                newBoard[4][i] = new Space(4, i, random.nextInt(OMAX - OMIN + 1) + OMIN, false);
            }
            p.board = newBoard;
            //TODO make sure that the same value cannot appear twice on a board
        }

    }

    /**
     * checks if the given player's board wins bingo
     *
     * @param allegedWinner the player claiming to have bingo
     * @return whether or not the player has bingo
     */
    public boolean playerHasBingo(Player allegedWinner) {
        return allegedWinner.hasBingo();
    }


}
