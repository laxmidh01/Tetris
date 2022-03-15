package inf101v22.grid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grid<E> implements IGrid<E>{
    int row;
    int col;
    //Object[][] list;
    List<List<E>> board;
    E v;
    public Grid(int row, int col, E defaultValue) {
        this.row = row;
        this.col = col;
        this.board = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<E> rows = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                rows.add(defaultValue);
            }
            this.board.add(rows);
        }
    }
    /*public Grid(int row, int col, E defaultValue) {
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

    }*/
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
        if (!coordinateIsOnGrid(coordinate)) {
            throw new IndexOutOfBoundsException("Out of bounds");
        }
        this.board.get(coordinate.row).set(coordinate.col, value);
    }

    @Override
    public E get(Coordinate coordinate) {
        if (!coordinateIsOnGrid(coordinate)) {
            throw new IndexOutOfBoundsException("Out of bounds");
        }
        return this.board.get(coordinate.row).get(coordinate.col);
    }


    @Override
    public boolean coordinateIsOnGrid(Coordinate coordinate) {
        return (coordinate.row >= 0 && coordinate.row < getRows()) && (coordinate.col >= 0 && coordinate.col < getCols());
    }

    @Override
    public Iterator<CoordinateItem<E>> iterator() {
        List<CoordinateItem<E>> coordinateItems = new ArrayList<>();
        //Iterator<E> iterator = (Iterator<E>) coordinateItems.iterator();
        for(int x=0; x < row; x++ ){
            for(int y=0; y < col; y++){
                Coordinate here = new Coordinate(x, y);
                coordinateItems.add(new CoordinateItem<>(here, this.get(here)));
            }
        }

        return coordinateItems.iterator();
    }
}
