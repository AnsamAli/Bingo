/**
 * representation of a player who is playing bingo
 */
public class Player {
    /* The first represents from the column, second the row*/
    Space[][] board = new Space[5][5];

    public Player(Space [] [] board) {
        this.board = board;
    }

    /**
     *
     * @return whether or not the players board has the qualifications for bingo
     */
    boolean hasBingo() {
        return horizontalBingo() || verticalBingo() || diagonalBingo();
    }

    /**
     * @return whether or not the player's board has any horizontal bingos
     */
    public boolean horizontalBingo() {
        boolean bingo = false;
        for (int i = 0; i < 5; i++) {
            bingo = allMarked(getRow(i));
            if (bingo) {
                break;
            }
        }
        return bingo;
     }
    //TODO abstract with above into one method
    public boolean verticalBingo() {
        boolean bingo = false;
        for (int i = 0; i < 5; i++) {
            bingo = allMarked(getComlum(i));
            if( bingo) {
                break;
            }
        }
        return bingo;
    }

    /**
     * @return whether or not the player has a horizontal bingo
     */
    public boolean diagonalBingo() {
        boolean bingo;
        // get first diagonal
        Space [] firstDiagonal = new Space[5];
        for (int i = 0; i < 5; i++) {
            firstDiagonal[i] = board[i][i];
        }
        bingo = allMarked(firstDiagonal);

        if (!bingo) {
          Space[] secondDiagonal = new Space[5];
          for (int i = 0; i < 5; i++) {
              for (int j = 4; j >= 0; j--) {
                  secondDiagonal[i] = board[i][j];
              }
          }
            bingo = allMarked(secondDiagonal);
        }
        return bingo;
    }

    /**
     * get all the spaces for the given row id
     * @param rowId the id of the row we are trying to
     * @return the row x -> [0,x] [1, x] [2, x]...[4, x]
     */
    public Space[] getRow(int rowId) {
        Space [] row = new Space[5];
        for (int i = 0; i < board.length; i++) {
            row[i] = board[i][rowId];
        }
        return row;
    }

    /**
     * get all the spaces for the given column id
     * @param columnId the id of the row we are trying to
     * @return the column x -> [x,0] [x, 1] [x, 2]... [x, 5]
     */
    public Space[] getComlum(int columnId) {
        Space [] column = new Space[5];
        for (int i = 0; i < board.length; i++) {
            column[i] = board[columnId][i];
        }
        return column;
    }

    /**
     * checks to see if all the spaces in a row or column are marked
     * @param spaceArr
     * @return whether all the spaces are marked
     */
    public boolean allMarked (Space [] spaceArr) {
        boolean isAllMarked = false;
        for (Space s: spaceArr) {
            isAllMarked = s.marked;
        }
        return isAllMarked;
    }
}
