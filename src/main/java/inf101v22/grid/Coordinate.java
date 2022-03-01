package inf101v22.grid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Coordinate<E> implements IGrid{
    public final int row;
    public final int col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;

    }


    @Override
    public int getRows() {
        return row;
    }

    @Override
    public int getCols() {
        return col;
    }

    @Override
    public void set(Coordinate coordinate, Object value) {

    }

    @Override
    public Object get(Coordinate coordinate) {
        return null;
    }

    @Override
    public boolean coordinateIsOnGrid(Coordinate coordinate) {
        return false;
    }


    @Override
    public Iterator iterator() {
        return null;
    }
    // TODO: create this class


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return row == that.row && col == that.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        return "{ " +
                "row=" + "'" + row + "'" +
                ", col=" + "'" + col + "'" +
                " }";
    }
}
