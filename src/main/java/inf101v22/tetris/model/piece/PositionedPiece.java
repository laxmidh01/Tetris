package inf101v22.tetris.model.piece;

import inf101v22.grid.Coordinate;
import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.Tile;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PositionedPiece implements Iterable<CoordinateItem<Tile>>{
    public Coordinate coordinate;
    public PieceShape piece;
    //private TetrisBoard board;

    PositionedPiece(PieceShape shape, Coordinate coordinate) {
        this.coordinate = coordinate;
        this.piece = shape;
    }


    public Tile getTile(){
        return this.piece.getTile();
    }

    public int getHeight(){
        return piece.getHeight();
    }

    public int getWidth(){
        return piece.getWidth();
    }

    public PositionedPiece pieceCopy(int deltaRow, int deltaCol){
        return new PositionedPiece(this.piece, new Coordinate(this.coordinate.row + deltaRow, this.coordinate.col+ deltaCol));
    }

    public PositionedPiece CopyRotatedPiece(){
        PieceShape pieceRotate = this.piece.pieceRotate();
        PositionedPiece rotatedPiece = new PositionedPiece(pieceRotate, this.coordinate);

        int centerColPiece = piece.getWidth()/2;
        int centerRowPiece = piece.getHeight()/2;

        int centeredThisRow = this.piece.getHeight()/2;
        int centeredThisCol =  this.piece.getWidth()/2;

        return rotatedPiece.pieceCopy(centeredThisRow-centerRowPiece, centeredThisCol-centerColPiece);
    }


    // objekt i denne klassen representerer en brikke med en posisjon
    @Override
    public Iterator<CoordinateItem<Tile>> iterator() {
        return new Iterator<>() {
            int row;
            int col;

            @Override
            public boolean hasNext() {
                while (bounds() && !PositionedPiece.this.piece.getShape()[row][col]) {
                    increaseValue();
                }
                return (bounds() && PositionedPiece.this.piece.getShape()[row][col]);
            }

            private void increaseValue() {
                //øker verdien av kolonne
                col++;
                //hvis kolonnen er større eller lik bredden av brikken setter vi kolonnen lik 0
                //øker verdien av rad
                if (col >= PositionedPiece.this.piece.getWidth()) {
                    this.col = 0;
                    row++;
                }
            }

            //sjekker om rad og kolonne er på brettet
            //returner true hvis vi er på brettet og false hvis ikke
            private boolean bounds() {
                return (row >= 0 && col >= 0 && row < PositionedPiece.this.piece.getHeight() && col < PositionedPiece.this.piece.getWidth());
            }

            @Override
            public CoordinateItem<Tile> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Coordinate coordinate = new Coordinate(row + PositionedPiece.this.coordinate.row, col + PositionedPiece.this.coordinate.col);

                do {
                    increaseValue();
                } while (bounds() && !PositionedPiece.this.piece.getShape()[row][col]);

                CoordinateItem<Tile> tile = new CoordinateItem<>(coordinate, PositionedPiece.this.piece.getTile());
                return tile;
            }
        };
    }


}
