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
    int time = 2000;
    int pieceCount = 1;
    int score = 0;



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


    //for loop som kjører gjennom alle rutene på brettet
    //har to if-statements, den første sjekker om brikken er på brettet, hvis ikke returener den false
    //den andre sjekker om ruten er ledig, at det ikke er en annen brikke/element i ruten, hvis ikke returnerer den false
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

    //lar brikken bevege på seg hvis det er lovlig
    @Override
    public boolean moveFallingPiece(int deltaRow, int deltaCol) {
        PositionedPiece myNewCandidate = positionedPiece.pieceCopy(deltaRow,deltaCol);
        if (LegalPiece(myNewCandidate)){
            this.positionedPiece = myNewCandidate;
            return true;
        }
        return false;
    }


    //roterer brikken hvis det er lovlig
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
    }

    //sjekker om spillet er over og om det er lovlig
    //hvis ikke spillet er over og det er lovliog kommer en ny brikke på brettet
    public void newFallingPiece(){
        PositionedPiece newFallingPiece = positionedPieceFactory.getNextPositionedPiece();
        pieceCount += 1;
        if(!LegalPiece(newFallingPiece)){
            gameScreen = GameScreen.GAME_OVER;
            return;
        }
        this.positionedPiece = newFallingPiece;
    }
    //går gjennom alle rutene og passer på at den brikken som blir lagt ned holder seg på brikken
    //kjører newFallingPiece
    public void AttachPiece(){
        for(CoordinateItem<Tile> tile: positionedPiece) {
            this.tetrisBoard.set(tile.coordinate, tile.item);
        }
        score += tetrisBoard.removeRow();
        newFallingPiece();
    }

    //dropper brikken ned, fjerner fulle rader og kjører AttachPiece
    @Override
    public void dropPiece() {
       while (moveFallingPiece(1,0));
       AttachPiece();
       tetrisBoard.removeRow();
    }

    @Override
    public int getTime() {
        time = (int) (time*Math.pow(0.98, pieceCount));
        return time;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void clockTick() {
        if(!moveFallingPiece(1,0)){
            AttachPiece();
        }
        getTime();
    }

}
