package inf101v22.tetris.view;

import inf101v22.grid.CoordinateItem;

import java.util.Iterator;

public interface TetrisViewable {
    /** @return number of rows */
    int getRows();

    /** @return number of columns */
    int getCols();

    <Tile> Iterator<CoordinateItem<Tile>> iterator();


}
