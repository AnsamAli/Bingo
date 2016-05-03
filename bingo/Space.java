package bingo;

/**
 * represents a space on the the bingo board
 * identified by it's column [b, i, n, g, and o] and its id.
 * location is determined by the column and row
 */
public class Space {
    public int column;
    public int row;
    public int id;
    public boolean marked;

    Space(int column, int row, int id, boolean marked) {
        this.column = column;
        this.row = row;
        this.id = id;
        this.marked = marked;
    }

    @Override
   public String toString() {
        return "column: " + column + ", row: " + row + ", id: " + id + ", marked?: " + marked;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        Space s1 = (Space) o;
        Space s2 = (Space) o;
        return s1.column == s2.column &&
            s1.row == s2.row &&
            s1.id == s2.id &&
            s1.marked == s2.marked;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(this.toString());
    }




}
