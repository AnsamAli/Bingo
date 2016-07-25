package bingo;

import java.util.ArrayList;
import java.util.Random;

/**
 * Dealer is like a proxy server that distributes the board
 * broadcasts the drawings and checks to make sure the players are not cheating.
 */
public class Dealer implements GameConstants {

    ArrayList<String> drawings = new ArrayList<>();
    public Space [] bingoSection = new Space[5];


    /*----------------------------Methods for populating a board -------------------------*/

    /**
     * generates the bingo board for the player with random numbers generated
     *
     * @return the complete board for a player
     */
    public Space[][] populateBoard() {
        Space[][] newBoard = new Space[GameConstants.BOARD_SIZE][GameConstants.BOARD_SIZE];
        populateColumnB(newBoard);
        populateColumnI(newBoard);
        populateColumnN(newBoard);
        populateColumnG(newBoard);
        populateColumnO(newBoard);
        return newBoard;
    }

    /**
     * generates the space number randomly for a column
     *
     * @param min minimum possible value of a space
     * @param max maximum possible value of a space
     * @return the space number
     */
    public int getId(int min, int max) {
        Random random = new Random();
        int id = random.nextInt((max - min) + 1) + min;
        return id;
    }

    /**
     * Fills each space on the B column of the players board
     *
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
     *
     * @param newBoard the player board being updated.
     */
    public void populateColumnI(Space[][] newBoard) {
        ArrayList<Integer> space_numbers = new ArrayList<>(BOARD_SIZE);

        int id = getId(I_MIN, I_MAX);
        for (int i = 0; i < BOARD_SIZE; i++) {
            while (space_numbers.contains(id)) {
                id = getId(I_MIN, I_MAX);
            }
            space_numbers.add(id);
            newBoard[1][i] = new Space(1, i, id, false);
        }
    }

    /**
     * Fills each space on the N column of the players board
     *
     * @param newBoard the player board being updated.
     */
    public void populateColumnN(Space[][] newBoard) {
        ArrayList<Integer> space_numbers = new ArrayList<>(BOARD_SIZE);

        int id = getId(N_MIN, N_MAX);
        for (int i = 0; i < BOARD_SIZE; i++) {
            while (space_numbers.contains(id)) {
                id = getId(N_MIN, N_MAX);
            }
            space_numbers.add(id);
            if (i == 2) {
                newBoard[2][2] = new Space(2, 2, id, true);
            } else {
                newBoard[2][i] = new Space(2, i, id, false);
            }
        }
    }

    /**
     * Fills each space on the G column of the players board
     *
     * @param newBoard the player board being updated.
     */
    public void populateColumnG(Space[][] newBoard) {
        ArrayList<Integer> space_numbers = new ArrayList<>(BOARD_SIZE);

        int id = getId(G_MIN, G_MAX);
        for (int i = 0; i < BOARD_SIZE; i++) {
            while (space_numbers.contains(id)) {
                id = getId(G_MIN, G_MAX);
            }
            space_numbers.add(id);
            newBoard[3][i] = new Space(3, i, id, false);
        }
    }

    /**
     * Fills each space on the O column of the players board
     *
     * @param newBoard the player board being updated.
     */
    public void populateColumnO(Space[][] newBoard) {
        ArrayList<Integer> space_numbers = new ArrayList<>(BOARD_SIZE);

        int id = getId(O_MIN, O_MAX);
        for (int i = 0; i < BOARD_SIZE; i++) {
            while (space_numbers.contains(id)) {
                id = getId(O_MIN, O_MAX);
            }
            space_numbers.add(id);
            newBoard[4][i] = new Space(4, i, id, false);
        }
    }

    /**
     * sends the generated board to the gui maker
     */
    public void makeBoardGui() {
        BoardGui gui = new BoardGui();
        gui.setUpBoard(populateBoard());
    }
    /*--------------------------Methods for determining whether or not the board has bingo -----------*/

    /**
     * get all the spaces for the given row id
     *
     * @param rowId the id of the row we are trying to
     * @return the row x -> [0,x] [1, x] [2, x]...[4, x]
     */
    public Space[] getRow(int rowId, Space[][] board) {
        Space[] row = new Space[5];
        for (int i = 0; i < board.length; i++) {
            row[i] = board[i][rowId];
        }
        return row;
    }

    /**
     * get all the spaces for the given column id
     *
     * @param columnId the id of the row we are trying to
     * @return the column x -> [x,0] [x, 1] [x, 2]... [x, 5]
     */
    public Space[] getColumn(int columnId, Space[][] board) {
        Space[] column = new Space[5];
        for (int i = 0; i < board.length; i++) {
            column[i] = board[columnId][i];
        }
        return column;
    }

    /**
     * Checks whether a board has bingo
     * @param board the board of the player in question
     * @return whether or not the board has bingo
     */
    public boolean hasBingo(Space[][] board) {
        boolean bingo = false;
        // check for horizontal and vertical bingo
        for (int i = 0; i < BOARD_SIZE; i++) {
            bingo = sectionHasBingo(getRow(i, board)) || sectionHasBingo(getColumn(i, board));
            if (bingo) {
                return true;
            }
        }
            // check for forward bingo
            if (!bingo) {
                Space[] firstDiagonal = new Space[5];
                for (int i = 0; i < 5; i++) {
                    firstDiagonal[i] = board[i][i];
                }
                bingo = allMarked(firstDiagonal);
                // check for backward bingo
                if (!bingo) {
                    Space[] secondDiagonal = new Space[5];
                    for (int i = 0; i < 5; i++) {
                        for (int j = 4; j >= 0; j--) {
                            secondDiagonal[i] = board[i][j];
                        }
                    }
                    bingo = allMarked(secondDiagonal);
                }
            }
        return bingo;
        }



    /**
     * Checks that all the spaces in a section are marked
     * @param section the row, column or diagonal in question
     * @return whether or not the secton has bingo
     */
    public boolean allMarked(Space[] section) {
        boolean isAllMarked = false;
        for (Space s : section) {
            isAllMarked = s.marked;
        }
        return isAllMarked;
    }

    /**
     * Adds sets the section to the bingoSection field
     *
     * @param section the row, column or diagonal in question
     * @return whether or not that section has bingo
     */
    public boolean sectionHasBingo(Space[] section) {
        boolean hasBingo = allMarked(section);

        //add the bingo section to the field
        if (hasBingo) {
            int i = 0;
            for (Space s : section) {
                bingoSection[i] = s;
                i++;
            }
        }
        return hasBingo;
    }

    /**
     * Checks if the spaces in the bingo section matches cards
     * in the drawings
     * @return whether or not the marked spaces are correct
     */
    public boolean markedCorrectedSpaces() {
        boolean isDrawing = false;
        for (Space s : bingoSection) {
            isDrawing = drawings.contains(s);
        }

        return isDrawing;
    }

    /**
     * handles cheaters and winners
     * @param board the board being checked for bingo
     */
    public void checkForBingo(Space[][]board) {
        if (hasBingo(board) && markedCorrectedSpaces()) {
            /* Winner message */
        }
        else {
            /*CHEATER*/
        }
    }


    /*------------------------Drawing method ---------------------------------------------*/

    /**
     * generates random spaces possibly on the board
     *
     * @return the string in the format LetterNum e.g."I29"
     */
    public String drawing() {
        Random random = new Random();
        int drawNumber = random.nextInt(O_MAX - B_MIN + 1) + B_MIN;
        String drawingString = "";
        if (drawNumber < I_MIN) {
            drawingString = "B" + Integer.toString(drawNumber);
        } else if (drawNumber < N_MIN) {
            drawingString = "I" + Integer.toString(drawNumber);
        } else if (drawNumber < G_MIN) {
            drawingString = "N" + Integer.toString(drawNumber);
        } else if (drawNumber < O_MIN) {
            drawingString = "G" + Integer.toString(drawNumber);
        } else {
            drawingString = "O" + Integer.toString(drawNumber);
        }
        drawings.add(drawingString);
        return drawingString;
    }


}
