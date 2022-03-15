package inf101v22.tetris.model;

import inf101v22.grid.Coordinate;
import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.controller.TetrisControllable;
import inf101v22.tetris.model.piece.PositionedPiece;
import inf101v22.tetris.model.piece.PositionedPieceFactory;
import inf101v22.tetris.view.TetrisViewable;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class TetrisModel implements TetrisViewable, TetrisControllable {

    TetrisBoard tetrisBoard;
    PositionedPiece positionedPiece;
    PositionedPieceFactory positionedPieceFactory;

    public TetrisModel() {
        this.tetrisBoard = new TetrisBoard(15,10);
        this.tetrisBoard.set(new Coordinate(0,0), new Tile(Color.GREEN, 'a'));
        this.tetrisBoard.set(new Coordinate(14,0), new Tile(Color.RED, 'b'));
        this.tetrisBoard.set(new Coordinate(0,9), new Tile(Color.YELLOW, 'c'));
        this.tetrisBoard.set(new Coordinate(14,9), new Tile(Color.BLUE, 'd'));
        this.positionedPieceFactory = new PositionedPieceFactory();
        this.positionedPieceFactory.setCenterColumn(tetrisBoard.getCols());
        this.positionedPiece = positionedPieceFactory.getNextPositionedPiece();
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
        return this.tetrisBoard;
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
    public Iterable<CoordinateItem<Tile>> pieceIterator(){
        return Objects.requireNonNullElseGet(this.positionedPiece, List::of);
    }


    boolean LegalPiece(PositionedPiece positionPiece, TetrisBoard board){
        for (CoordinateItem<Tile> tile: positionPiece) {
            if(!board.isPositionValid(tile.coordinate)) {
                return false;
            }
        }
        return true;
    }

    public boolean setPiece(PositionedPiece pospiece){
        if(LegalPiece(pospiece, this.tetrisBoard)){
            this.positionedPiece = pospiece;
            return true;
        }
        return false;
    }

    @Override
    public boolean moveFallingPiece(int deltaRow, int deltaCol) {
        //PositionedPiece myNewCandidate = positionedPiece.pieceCopy(deltaRow,deltaCol);
        //if (!tetrisBoard.isPositionValid(myNewCandidate.getCoordinate())){
          //  return false;
        //}
        //this.positionedPiece = myNewCandidate;
        //return true;
        return this.setPiece(this.positionedPiece.pieceCopy(deltaRow,deltaCol));
    }



}
