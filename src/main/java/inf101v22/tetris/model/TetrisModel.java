package inf101v22.tetris.model;

import inf101v22.grid.Coordinate;
import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.piece.PositionedPiece;
import inf101v22.tetris.model.piece.PositionedPieceFactory;
import inf101v22.tetris.view.TetrisViewable;

import java.awt.*;

public class TetrisModel implements TetrisViewable {

    TetrisBoard tetrisBoard;
    PositionedPiece positionedPiece;
    PositionedPieceFactory positionedPieceFactory;

    public TetrisModel() {
        tetrisBoard = new TetrisBoard(10,15);
        //this.tetrisBoard.set(new Coordinate(0,0), new Tile(Color.GREEN, 'a'));
        //this.tetrisBoard.set(new Coordinate(0,14), new Tile(Color.RED, 'b'));
        //this.tetrisBoard.set(new Coordinate(9,0), new Tile(Color.YELLOW, 'c'));
        //this.tetrisBoard.set(new Coordinate(9,14), new Tile(Color.BLUE, 'd'));
        this.positionedPieceFactory = new PositionedPieceFactory();
        positionedPieceFactory.setCenterColumn(tetrisBoard.getCols()/2);
        positionedPiece = positionedPieceFactory.getNextPositionedPiece();

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

    //public PositionedPieceFactory positionedPieceFactory(){
      //  positionedPieceFactory.setCenterColumn(tetrisBoard.getCols() - positionedPiece.getWidth()/2);
      //  return positionedPieceFactory;
    //}

    //public PositionedPiece getPositionedPiece() {
      //  PositionedPiece positioned_Piece = PositionedPieceFactory.getNextPositionedPiece();
        //return positioned_Piece;
    //}

    @Override
    public Iterable<CoordinateItem<Tile>> pieceIterator() {
        return positionedPiece;
    }

}
