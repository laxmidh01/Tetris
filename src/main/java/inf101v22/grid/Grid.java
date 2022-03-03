package inf101v22.grid;

import java.util.ArrayList;
import java.util.Iterator;

public class Grid<E> implements IGrid<E>{
    int row;
    int col;
    Object[][] list;
    E v;

    Coordinate coordinate = new Coordinate(row, col);
    //Iterator iterator = new Iterator();
    ArrayList<E> coordinateItems = new ArrayList<>();

    public Grid(int row, int col, E defaultValue) {
        this.row = row;
        this.col = col;
        this.v = defaultValue;
        @SuppressWarnings("unchecked") E[][] array = (E[][]) new Object[row][col];
        list = array;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                list[i][j] = defaultValue;
            }
        }

    }
    public Grid(int row, int col) {
        this(row, col, null);
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
    public void set(Coordinate coordinate, E value) {
       list[coordinate.row][coordinate.col] = value;
    }

    @Override
    public E get(Coordinate coordinate) {
        return (E) list[coordinate.row][coordinate.col];
    }


    @Override
    public boolean coordinateIsOnGrid(Coordinate coordinate) {
        if((coordinate.row >= 0 && coordinate.row < getRows()) && (coordinate.col >= 0 && coordinate.col < getCols())){
            return true;
        }
        return false;
    }

    @Override
    public Iterator<CoordinateItem<E>> iterator() {
        ArrayList<CoordinateItem<E>> coordinateItems = new ArrayList<>();
        //Iterator<E> iterator = (Iterator<E>) coordinateItems.iterator();
        for(int x=0; x < row; x++ ){
            for(int y=0; y < col; y++){
                coordinateItems.add(new CoordinateItem<>(new Coordinate(x, y), (E) list[x][y]));
            }
        }

        return coordinateItems.iterator();
    }
}
