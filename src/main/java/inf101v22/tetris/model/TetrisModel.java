package inf101v22.tetris.model;

import inf101v22.grid.Coordinate;
import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.view.TetrisViewable;

import java.awt.*;

public class TetrisModel implements TetrisViewable {

    TetrisBoard tetrisBoard;
    TetrisBoard pieceboard;

    public TetrisModel() {
        tetrisBoard = new TetrisBoard(10,15);
        this.tetrisBoard.set(new Coordinate(0,0), new Tile(Color.GREEN, 'a'));
        this.tetrisBoard.set(new Coordinate(0,14), new Tile(Color.PINK, 'b'));
        this.tetrisBoard.set(new Coordinate(9,0), new Tile(Color.CYAN, 'c'));
        this.tetrisBoard.set(new Coordinate(9,14), new Tile(Color.YELLOW, 'd'));
    }

    @Override
    public int getRows() {
        return tetrisBoard.getRows();
    }

    @Override
    public int getCols() {
        return tetrisBoard.getCols();
    }

    @Override
    public Iterable<CoordinateItem<Tile>> iterator() {
        return tetrisBoard;
    }


    @Override
    public Iterable<CoordinateItem<Tile>> pieceiterator() {
        return null;
    }
}
