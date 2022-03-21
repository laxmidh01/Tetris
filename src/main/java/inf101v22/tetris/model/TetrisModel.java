package inf101v22.tetris.model;

import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.controller.TetrisControllable;
import inf101v22.tetris.model.piece.PositionedPiece;
import inf101v22.tetris.model.piece.PositionedPieceFactory;
import inf101v22.tetris.view.TetrisViewable;


public class TetrisModel implements TetrisViewable, TetrisControllable {

    private TetrisBoard tetrisBoard;
    private PositionedPiece positionedPiece;
    private PositionedPieceFactory positionedPieceFactory;
    private GameScreen gameScreen = GameScreen.ACTIVE_GAME;


    public TetrisModel(int row, int col) {
        this.tetrisBoard = new TetrisBoard(row, col, null);
        //this.tetrisBoard.set(new Coordinate(0,0), new Tile(Color.GREEN, 'a'));
        //this.tetrisBoard.set(new Coordinate(14,0), new Tile(Color.RED, 'b'));
        //this.tetrisBoard.set(new Coordinate(0,9), new Tile(Color.YELLOW, 'c'));
        //this.tetrisBoard.set(new Coordinate(14,9), new Tile(Color.BLUE, 'd'));
        this.positionedPieceFactory = new PositionedPieceFactory();
        this.positionedPieceFactory.setCenterColumn(tetrisBoard.getCols() / 2);
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

    @Override
    public Iterable<CoordinateItem<Tile>> pieceIterator(){
        //tester bare ut høyden til piecen
        //System.out.println("position" + positionedPiece.getHeight());
        return positionedPiece;
    }

    @Override
    public GameScreen getGameScreen() {
        return gameScreen;
    }


    boolean LegalPiece(PositionedPiece positionPiece){
        for (CoordinateItem<Tile> tile: positionPiece){
            //tester ut posisjonen til brikken for hver gang den beveger seg
            //System.out.println(tile.coordinate);
            if(!(tetrisBoard.coordinateIsOnGrid(tile.coordinate))){
                return false;
            }
            if (tetrisBoard.get(tile.coordinate) != null) {
                return false;
            }
        }
        return true;
    }
/*
    public boolean setPiece(PositionedPiece positionPiece){
        if(LegalPiece(positionPiece, this.tetrisBoard)){
            this.positionedPiece = positionPiece;
            return true;
        }
        return false;
    }
*/

    @Override
    public boolean moveFallingPiece(int deltaRow, int deltaCol) {
        PositionedPiece myNewCandidate = positionedPiece.pieceCopy(deltaRow,deltaCol);
        if (LegalPiece(myNewCandidate)){
            this.positionedPiece = myNewCandidate;
            return true;
        }
        return false;
    }


    @Override
    public boolean rotatedBrick() {
        PositionedPiece rotate = positionedPiece.CopyRotatedPiece();
        // for løkke er kun for testing
        //for (CoordinateItem<Tile> tile: rotate){
          // System.out.println(tile.coordinate);
        //}
        if (LegalPiece(rotate)){
            this.positionedPiece = rotate;
            return true;
        }
        return false;
        /*
        PositionedPiece rotatedPiece = positionedPiece.CopyRotatedPiece();
        PositionedPiece rotatedPiece = positionedPiece.pieceCopy(rotatedRow, rotatedCol);
        if(tetrisBoard.coordinateIsOnGrid(new Coordinate(rotatedRow, rotatedCol)));

         */
       //if(positionedPiece.getHeight() >= tetrisBoard.getRows()) {
         //   return this.setPiece(this.positionedPiece.CopyRotatedPiece(rotatedRow, rotatedCol));
             //return false;
       //}

        //if(LegalPiece(this.positionedPiece, this.tetrisBoard)){
        //   return this.setPiece(this.positionedPiece.CopyRotatedPiece());
        //}
        //for (CoordinateItem<Tile> tile: rotatedPiece) {
          //  if(!tetrisBoard.coordinateIsOnGrid(tile.coordinate)){
            //    return false;
            //}
            //if(tetrisBoard.get(tile.coordinate) != null){
              //  return false;
            //}

        //}
        //this.positionedPiece = rotatedPiece;
        //return true;

        //return this.setRotatedPiece(this.positionedPiece.CopyRotatedPiece());
        //return this.setPiece(this.positionedPiece.pieceCopy());
    }

    public void newFallingPiece(){
        PositionedPiece newFallingPiece = positionedPieceFactory.getNextPositionedPiece();
        if(!LegalPiece(newFallingPiece)){
            gameScreen = GameScreen.GAME_OVER;
            return;
        }
        this.positionedPiece = newFallingPiece;
    }

    public void AttachPiece(){
        for (CoordinateItem<Tile> tile: positionedPiece) {
            this.tetrisBoard.set(tile.coordinate, tile.item);
        }
        newFallingPiece();
    }

    @Override
    public void dropPiece() {
       while (moveFallingPiece(1,0)){
       }
       AttachPiece();
    }

}
