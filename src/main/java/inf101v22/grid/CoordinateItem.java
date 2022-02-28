package inf101v22.grid;

import java.util.Iterator;
import java.util.Objects;

public class CoordinateItem<E> implements IGrid{
    public Coordinate coordinate;
    public String item;
    

    int row;
    int col;

    public CoordinateItem(Coordinate coordinate, E item) {
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
    public final Object get(Coordinate coordinate) {
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
        CoordinateItem<?> that = (CoordinateItem<?>) o;
        return row == that.row && col == that.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        return "CoordinateItem{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
