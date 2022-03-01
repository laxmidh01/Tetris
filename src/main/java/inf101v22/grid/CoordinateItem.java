package inf101v22.grid;

import java.util.Iterator;
import java.util.Objects;

public class CoordinateItem<E> implements IGrid{
    public final Coordinate coordinate;
    public final String item;
    int row = 4;
    int col = 2;

    public CoordinateItem(Coordinate coordinate, String item) {
        this.coordinate = coordinate;
        this.item = item;
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

    // TODO: create this class
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinateItem<E> that = (CoordinateItem<E>) o;
        CoordinateItem<String> coordinateItem = new CoordinateItem<>(coordinate, item);
        CoordinateItem<String> coordinateItem1 = new CoordinateItem<>(coordinate, item);
        if(coordinateItem != coordinateItem1){
            return false;
        }
        //if (row != that.row && col == that.col) return false;
        //if (row == that.row && col != that.col) return false;
        //if(coordinateItem.equals(coordinateItem)){
          //  return false;
        //}
        //return true;
        return (row == that.row && col == that.col);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        return "{ coordinate='{ " +
                "row='" + row + "', col='" + col +
                "' }', " + "item='" + item +"' }" ;
    }
}
