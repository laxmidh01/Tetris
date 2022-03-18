package inf101v22.tetris.model.piece;

import inf101v22.grid.Coordinate;
import inf101v22.tetris.model.TetrisModel;

import java.util.Random;

public class PositionedPieceFactory {
    Random randomGenerator = new Random();
    private int center;


    public void setCenterColumn(int col){
        //this.center = col - getNextPositionedPiece().getWidth()/2;
        this.center = col;
    }

    public PositionedPiece getNextPositionedPiece(){
        int r = randomGenerator.nextInt(PieceShape.STANDARD_TETRIS_PIECES.length);
        PieceShape pieceShape = PieceShape.STANDARD_TETRIS_PIECES[r];
        PositionedPiece p = new PositionedPiece(pieceShape, new Coordinate(0, center - pieceShape.getWidth() / 2));
        return p;

    }
}
