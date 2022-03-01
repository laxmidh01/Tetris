package inf101v22.grid;

import java.util.ArrayList;
import java.util.Iterator;

public class Grid<E> implements IGrid<E>{
    int row;
    int col;
    E[][] list;
    E v;

    Coordinate coordinate = new Coordinate(row, col);
    //Iterator iterator = new Iterator();
    ArrayList<E> coordinateItems = new ArrayList<>();

    public Grid(int row, int col, E defaultValue) {
        this.row = row;
        this.col = col;
        this.v = defaultValue;

    }
    public Grid(int row, int col) {
        this(row, col, (E) "x");
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
    public E get(Coordinate coordinate) {
        if(!coordinateIsOnGrid(coordinate)){
            throw new IndexOutOfBoundsException("not");
        }
        return null;
    }


    @Override
    public boolean coordinateIsOnGrid(Coordinate coordinate) {
        if((row >= 0 || row < getRows()) && (col > 0 || col < getCols())){
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
        Iterator<E> iterator = (Iterator<E>) coordinateItems.iterator();
        //for(E element : coordinateItems){
        //}

        return coordinateItems.iterator();
    }
}
