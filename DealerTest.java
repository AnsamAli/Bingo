import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;

public class DealerTest {

    @Test
    public void testDistribute() {
        Player player1 = new Player(new Space[5][5]);
        Player player2 = new Player(new Space[5][5]);
        Dealer dealer = new Dealer();
        ArrayList players = new ArrayList();
        players.add(player1);
        players.add(player2);
        dealer.players = players;

        dealer.distributeBoards();
        for (Player p : dealer.players) {
            System.out.println("Player" + dealer.players.indexOf(p)  + "'s Board");
            for (Space s : p.board[0]) {
                System.out.println(s.toString());
                assertTrue(0 < s.id && s.id < 16);

            }
            for (Space s : p.board[1]) {
                System.out.println(s.toString());
                assertTrue(16 <= s.id && s.id <= 30);
            }
            for (Space s : p.board[2]) {
                System.out.println(s.toString());
                assertTrue((31 <= s.id && s.id <= 45) || (s.id == -1));
            }
            for (Space s : p.board[3]) {
                System.out.println(s.toString());
                assertTrue(46 <= s.id && s.id <= 60);
            }
            for (Space s : p.board[4]) {
                System.out.println(s.toString());
                assertTrue(61 <= s.id && s.id <= 75);
            }
            System.out.println();
        }
    }
}
