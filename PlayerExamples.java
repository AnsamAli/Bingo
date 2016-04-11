import org.junit.Test;

public class PlayerExamples {
    Space [][] sampleBoard = new Space[5][5];
    Player player = new Player(sampleBoard);

    public void setUp() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                sampleBoard[i][j] = new Space(i, j, 0, false);
            }
        }

    }



    @Test
    public void testGetRow() {
        setUp();


        System.out.println("Actual:");
        for (Space s : player.getRow(2)) {
            System.out.println(s.toString());
        }

    }

}
