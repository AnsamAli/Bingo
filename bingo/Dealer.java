package bingo;

import java.util.ArrayList;
import java.util.Random;

/**
 * Dealer is like a proxy server that distributes the board
 * broadcasts the drawings and checks to make sure the players are not cheating.
 */
public class Dealer implements GameConstants {

    /**
     * generates the bingo board for the player with random numbers generated
     * @return the complete board for a player
     */
    public Space[][] populateBoard() {
        Space[] [] newBoard = new Space[GameConstants.BOARD_SIZE][GameConstants.BOARD_SIZE];
        populateColumnB(newBoard);
        populateColumnI(newBoard);
        populateColumnN(newBoard);
        populateColumnG(newBoard);
        populateColumnO(newBoard);
        return newBoard;
    }

    /**
     * generates the space number randomly for a column
     * @return the space number
     */
    public int getId(int min, int max) {
        Random random = new Random();
        int id = random.nextInt((max - min) + 1) + min;
        return id;
    }
    /**
     * Fills each space on the B column of the players board
     * @param newBoard the player board being updated.
     */
    public void populateColumnB(Space[][] newBoard) {
        ArrayList<Integer> space_numbers = new ArrayList<>(BOARD_SIZE);

        for (int i = 0; i < BOARD_SIZE; i++) {
            int id = getId(B_MIN, B_MAX);
            while (space_numbers.contains(id)) {
               id = getId(B_MIN, B_MAX);
            }
            space_numbers.add(id);
            newBoard[0][i] = new Space(0, i, id, false);

        }
    }


    /**
     * Fills each space on the I column of the players board
     * @param newBoard the player board being updated.
     */
    public void populateColumnI(Space[][] newBoard) {
        ArrayList<Integer> space_numbers = new ArrayList<>(BOARD_SIZE);

        int id = getId(I_MIN, I_MAX);
        for (int i = 0; i < BOARD_SIZE; i++) {
            while(space_numbers.contains(id)) {
                id = getId(I_MIN, I_MAX);
            }
            space_numbers.add(id);
            newBoard[1][i] = new Space(1, i, id, false);
        }
    }

    /**
     * Fills each space on the N column of the players board
     * @param newBoard the player board being updated.
     */
    public void populateColumnN(Space[][] newBoard) {
        ArrayList<Integer> space_numbers = new ArrayList<>(BOARD_SIZE);


        for (int i = 0; i < BOARD_SIZE; i++) {
            int id = getId(N_MIN, N_MAX);
            if (i != 2) {
                while (space_numbers.contains(id)) {

                    id = getId(N_MIN, N_MAX);
                }
                newBoard[2][i] = new Space(2, i, id, false);
            }
            else {
                id = -1;
                newBoard[2][i] = new Space(2, i, id, true);
            }
        }
    }

    /**
     * Fills each space on the G column of the players board
     * @param newBoard the player board being updated.
     */
    public void populateColumnG(Space[][] newBoard) {
        ArrayList<Integer> space_numbers = new ArrayList<>(BOARD_SIZE);

        int id = getId(G_MIN, G_MAX);
        for (int i = 0; i < BOARD_SIZE; i++) {
            while(space_numbers.contains(id)) {
                id = getId(G_MIN, G_MAX);
            }
            space_numbers.add(id);
            newBoard[3][i] = new Space(3, i, id, false);
        }
    }

    /**
     * Fills each space on the O column of the players board
     * @param newBoard the player board being updated.
     */
    public void populateColumnO(Space[][] newBoard) {
        ArrayList<Integer> space_numbers = new ArrayList<>(BOARD_SIZE);

        int id = getId(O_MIN, O_MAX);
        for (int i = 0; i < BOARD_SIZE; i++) {
            while(space_numbers.contains(id)) {
                id = getId(O_MIN, O_MAX);
            }
            space_numbers.add(id);
            newBoard[4][i] = new Space(4, i, id, false);
        }
    }

}
