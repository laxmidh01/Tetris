package inf101v22.tetris.view;

import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.GameScreen;
import inf101v22.tetris.model.Tile;

public interface TetrisViewable {
    /** @return number of rows */
    int getRows();

    /** @return number of columns */
    int getCols();

    /**
     * itererer over brettet
     * @return brettet
     */
    Iterable<CoordinateItem<Tile>> iterator();

    /**
     * itererer gjennom brikkene
     * @return brikkene
     */
    Iterable<CoordinateItem<Tile>> pieceIterator();

    /**
     * @return ACTIVE_GAME eller GAME_OVER
     */
    GameScreen getGameScreen();

    /**
     * @return score
     */
    int getScore();



}
