package inf101v22.grid;

import java.util.Iterator;
import java.util.Objects;

public class Coordinate implements IGrid{
    int row;
    int col;

    public Coordinate(int i, int i1) {
    }

    public Coordinate() {
    }


    @Override
    public final int getRows() {
        return row;
    }

    @Override
    public final int getCols() {
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
        return "Coordinate{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
