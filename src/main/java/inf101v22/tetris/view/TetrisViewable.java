package inf101v22.tetris.view;

import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.GameScreen;
import inf101v22.tetris.model.Tile;

public interface TetrisViewable {
    /** @return number of rows */
    int getRows();

    /** @return number of columns */
    int getCols();

    Iterable<CoordinateItem<Tile>> iterator();

    Iterable<CoordinateItem<Tile>> pieceIterator();

    GameScreen getGameScreen();



}
