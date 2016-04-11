/**
 * represents a space on the the bingo board
 * identified by it's column [b, i, n, g, and o] and its id.
 * location is determined by the column and row
 */
public class Space {
   int column;
    int row;
    int id;
    boolean marked;

    Space(int column, int row, int id, boolean marked) {
        this.column = column;
        this.row = row;
        this.id = id;
        this.marked = marked;
    }

    public String toString() {
        return "column: " + column + ", row: " + row + " id: " + id + " marked?: " + marked;
    }



}
