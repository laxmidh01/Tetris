package inf101v22.tetris.model.piece;

import inf101v22.grid.Coordinate;
import inf101v22.tetris.model.TetrisModel;

import java.util.Random;

public class PositionedPieceFactory {
    private final Random randomGenerator = new Random();
    private int center;

    public void setCenterColumn(int col){
        this.center = col;
    }

    public PositionedPiece getNextPositionedPiece(){
        PieceShape pieceShape = PieceShape.STANDARD_TETRIS_PIECES[randomGenerator.nextInt(0, PieceShape.STANDARD_TETRIS_PIECES.length-1)];
        Coordinate coordinate = new Coordinate(0, center-pieceShape.getWidth()/2);
        return new PositionedPiece(pieceShape, coordinate);

    }
}
