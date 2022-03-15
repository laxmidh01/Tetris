package inf101v22.tetris.model.piece;

import inf101v22.grid.Coordinate;
import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.TetrisBoard;
import inf101v22.tetris.model.Tile;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PositionedPiece implements Iterable<CoordinateItem<Tile>>{
    Coordinate coordinate;
    PieceShape piece;
    private TetrisBoard board;

    PositionedPiece(PieceShape shape, Coordinate coordinate) {
        this.coordinate = coordinate;
        this.piece = shape;
    }


    public Tile getTile(){
        return this.piece.getTile();
    }

    public PositionedPiece pieceCopy(int deltaRow, int deltaCol){
        return new PositionedPiece(this.piece, new Coordinate(this.coordinate.row + deltaRow, this.coordinate.col+ deltaCol));
    }

    public PositionedPiece CopyRotatedPiece(int rotatedRow, int rotatedCol){
        PieceShape pieceRotate = this.piece.pieceRotate();
        PositionedPiece rotatedPiece = new PositionedPiece(pieceRotate, getCoordinate());

        int centerColPiece = this.piece.getWidth()/2;
        for (int row = 0; row < rotatedPiece.getHeight(); row++) {
            for (int col = 0; col < rotatedPiece.getWidth(); col++) {
                int OldRow = this.getCoordinate().row;
                int OldCol = this.getCoordinate().col;

                int newRow = this.piece.getWidth() - OldCol - 1;
                int newCol = OldRow;

                rotatedPiece.coordinate = new Coordinate(newRow, newCol);
            }

        }
        return rotatedPiece;
    }

    public int getHeight(){
        return piece.getHeight();
    }
    public int getWidth(){
        return piece.getWidth();
    }

    public Coordinate getCoordinate(){
        int col = getHeight();
        int row = getWidth();
        return new Coordinate(row, col);
    }

    @Override
    public Iterator<CoordinateItem<Tile>> iterator() {
        return new Iterator<>() {
            int row = 0;
            int col = 0;

            {
                if (!getCurrentValue()) {
                    this.goToNext();
                }
            }

            @Override
            public boolean hasNext() {
                return this.isWithinBounds() && this.getCurrentValue();
            }

            @Override
            public CoordinateItem<Tile> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Coordinate coordinate = new Coordinate(
                        this.row + PositionedPiece.this.coordinate.row,
                        this.col + PositionedPiece.this.coordinate.col
                );
                CoordinateItem<Tile> coord = new CoordinateItem<>(
                        coordinate,
                        PositionedPiece.this.piece.getTile()
                );
                goToNext();
                return coord;
            }

            private boolean isWithinBounds() {
                return (this.row >= 0 &&
                        this.col >= 0 &&
                        this.row < PositionedPiece.this.piece.getHeight() &&
                        this.col < PositionedPiece.this.piece.getWidth());
            }

            private void goToNext() {
                do {
                    this.col++;
                    if (this.col >= PositionedPiece.this.piece.getWidth()) {
                        this.col = 0;
                        this.row++;
                    }
                } while (this.isWithinBounds() && (!this.getCurrentValue()));
            }

            private boolean getCurrentValue() {
                return PositionedPiece.this.piece.getShape()[this.row][this.col];
            }

        };
    }


    /**
        ArrayList<CoordinateItem<Tile>> list = new ArrayList<>();
        for (int row = 0; row < getHeight(); row++) {
            for (int col = 0; col < getWidth(); col++) {
                Coordinate coordinate = new Coordinate(row + 9/2, col);
                Tile tile = getTile();
                if(shape.getShape()[row][col]) {
                    CoordinateItem<Tile> coordinateItem = new CoordinateItem<>(coordinate, tile);
                    list.add(coordinateItem);
                }
            }
        }
        return list.iterator();
         **/


}
