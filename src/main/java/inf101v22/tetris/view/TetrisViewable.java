package inf101v22.tetris.view;

import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.Tile;

import java.util.Iterator;

public interface TetrisViewable {
    /** @return number of rows */
    int getRows();

    /** @return number of columns */
    int getCols();

    Iterable<CoordinateItem<Tile>> iterator();

    Iterable<CoordinateItem<Tile>> pieceIterator();



}
