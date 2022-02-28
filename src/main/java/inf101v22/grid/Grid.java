package inf101v22.grid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Grid implements IGrid{
    int row;
    int col;

    Coordinate coordinate = new Coordinate();
    //Iterator iterator = new Iterator();
    ArrayList<CoordinateItem> coordinateItems = new ArrayList<>();

    public Grid(int i, int i1) {
    }
    public Grid(int i, int i1, double v) {
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
        if(!coordinateIsOnGrid(coordinate)){
            throw new IndexOutOfBoundsException("not");
        }
        else{
            get(coordinate);
        }

    }

    @Override
    public Object get(Coordinate coordinate) {
        if(!coordinateIsOnGrid(coordinate)){
            throw new IndexOutOfBoundsException("not");
        }
        return coordinate;
    }


    @Override
    public boolean coordinateIsOnGrid(Coordinate coordinate) {
        if((row >= 0 || row < getRows()) && (col >= 0 || col < getCols())){
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return row == that.row && col == that.col;
    }

    @Override
    public Iterator iterator() {
        //ArrayList<CoordinateItem> coordinateItems = new ArrayList<>();
        Iterator<CoordinateItem> iterator = coordinateItems.iterator();

        return iterator;
    }
}
