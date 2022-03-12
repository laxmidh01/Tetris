package inf101v22.tetris.model.piece;

import inf101v22.grid.Coordinate;
import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.Tile;

import java.util.ArrayList;
import java.util.Iterator;

public class PositionedPiece implements Iterable<CoordinateItem<Tile>>{

    Coordinate corner_left;
    PieceShape brick;


    public Tile getTile(){
        return brick.tile;
    }

    public int getHeight(){
        return brick.getHeight();
    }
    public int getWidth(){
        return brick.getWidth();
    }

    public Coordinate getCoordinate(){
        int row = getHeight();
        int col = getWidth();
        return new Coordinate(row, col);
    }
    public PositionedPiece(PieceShape brick, Coordinate corner_left){
        this.brick = brick;
        this.corner_left = corner_left;
    }

    @Override
    public Iterator<CoordinateItem<Tile>> iterator() {
        ArrayList<CoordinateItem<Tile>> list = new ArrayList<>();
        for (int row = 0; row < getHeight(); row++) {
            for (int col = 0; col < getWidth(); col++) {
                Coordinate coordinate = new Coordinate(row, col);
                Tile tile = getTile();
                if(brick.getShape()[row][col]) {
                    CoordinateItem<Tile> coordinateItem = new CoordinateItem(coordinate, tile);
                    list.add(coordinateItem);
                }
            }
        }
        return list.iterator();
    }

}
