package inf101v22.grid;

import java.util.Iterator;
import java.util.Objects;

public class CoordinateItem<E> implements IGrid{
    public final Coordinate coordinate;
    public final E item;


    public CoordinateItem(Coordinate coordinate, E item) {
        this.coordinate = coordinate;
        this.item = item;
    }

    @Override
    public int getRows() {
        return coordinate.row;
    }

    @Override
    public int getCols() {
        return coordinate.col;
    }

    @Override
    public void set(Coordinate coordinate, Object value) {
    }

    @Override
    public E get(Coordinate coordinate) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinateItem<?> that = (CoordinateItem<?>) o;
        return Objects.equals(coordinate, that.coordinate) && Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate.row, coordinate.col);
    }

    @Override
    public String toString() {
        return "{ coordinate='{ row='" + coordinate.row + "', col='" +coordinate.col +
                "' }', " + "item='" + item +"' }" ;
    }
}
