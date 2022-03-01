package inf101v22.tetris.model;

import inf101v22.grid.Grid;
import inf101v22.tetris.view.Tile;

public class TetrisBoard extends Grid<Tile> {

    public TetrisBoard(int row, int col, Tile defaultValue) {
        super(row, col, defaultValue);
    }

}
