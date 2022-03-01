package inf101v22.tetris.model;

import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.view.TetrisViewable;

import java.util.Iterator;

public class TetrisModel implements TetrisViewable {
    int row = 15;
    int col = 10;

    @Override
    public int getRows() {
        return row;
    }

    @Override
    public int getCols() {
        return col;
    }

    @Override
    public <Tile> Iterator<CoordinateItem<Tile>> iterator() {
        return null;
    }
}
