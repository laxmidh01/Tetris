package inf101v22.tetris.view;

import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.Tile;

import javax.swing.*;
import java.awt.*;

public class TetrisView extends JComponent{

    TetrisViewable viewable;
    CoordinateItem coordinateItem;
    int l = 3;

    public TetrisView(TetrisViewable viewable) {
        this.viewable = viewable;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        drawTetrisBoard(graphics,l,l,this.getWidth(),this.getHeight(), l);
        //drawPieces(graphics,l,l,this.getWidth(),this.getHeight());
        //this.drawFallingPieceWithRightBottomPadding(canvas, 0, 0, this.getWidth(), this.getHeight());
    }

    public void drawTileWithRightBottomPadding(Graphics graphics, int x, int y, int width, int height, int padding, Color color) {
        graphics.setColor(color);
        graphics.fillRect(x, y, width-padding, height-padding);
    }

    public void drawBoardWithRightBottomPadding(Graphics graphics, int xBoard, int yBoard, int boardWidth,
                                                int boardHeight, int padding, Iterable<CoordinateItem<Tile>> tileiterator) {

        for (CoordinateItem<Tile> coordinateItem: tileiterator) {

            int row = coordinateItem.coordinate.row;
            int col = coordinateItem.coordinate.col;

            Tile tile = coordinateItem.item;
            Color color = Color.BLACK;

            if (tile != null) {
                color = tile.color;
            }
            //                                                                           graphics.setColor(Color.cyan);
            int tileX = xBoard + row * boardWidth / viewable.getRows();
            int tileY = yBoard + col * boardHeight / viewable.getCols();

            int nextTileX = xBoard + (row + 1) * boardWidth / viewable.getRows();
            int nextTileY = yBoard + (col + 1) * boardHeight / viewable.getCols();

            int tileWidth = nextTileX - tileX;
            int tileHeight = nextTileY - tileY;

            //drawBoardWithRightBottomPadding(graphics, xBoard, yBoard, tileWidth, tileHeight, color, tileiterator);

            this.drawTileWithRightBottomPadding(graphics, tileX, tileY, tileWidth, tileHeight, padding, color);

            /* if(tile == null){
            drawTileWithRightBottomPadding(graphics, tileX, tileY, tileWidth, tileHeight, padding, Color.BLACK);
            }
            else{
              drawTileWithRightBottomPadding(graphics, tileX, tileY, boardWidth, boardHeight, padding, tile.color);
            }
            //graphics.fillRect(tileX, tileY+5, tileWidth - 1, tileHeight - 1);
*/

        }

    }

    public void drawTetrisBoard(Graphics graphics, int x, int y, int width, int height, int padding){
        drawBoardWithRightBottomPadding(graphics, x, y, width - padding, height - padding, padding, this.viewable.iterator());
        drawBoardWithRightBottomPadding(graphics, x, y, width - padding, height - padding, padding, this.viewable.pieceIterator());
        //drawBoardWithRightBottomPadding(graphics, x, y, width - padding, height - padding, padding, this.viewable.pieceIterator());
        //drawTileWithRightBottomPadding(graphics, 15, 15, width/14, height/14, padding, Color.green);
        //drawTileWithRightBottomPadding(graphics, 15, height-23, width/14, height/14, padding, Color.green);
        //drawTileWithRightBottomPadding(graphics, width-216, 15, width/14, height/14, padding, Color.green);
        //drawTileWithRightBottomPadding(graphics, width-216, height-23, width/14, height/14, padding, Color.green);
    }


    @Override
    public Dimension getPreferredSize() {
        int width = (30+l)*viewable.getCols()+l;
        int height = (60+l)* viewable.getRows()+l;
        return new Dimension(width, height);
    }

    public void drawPieces(Graphics graphics, int xPiece, int yPiece, int pieceWidth, int pieceHeight){
        for (CoordinateItem<Tile> item : viewable.pieceIterator()) {
            int row = item.coordinate.row;
            int col = item.coordinate.col;

            Tile piecetile = item.item;
            Color color = Color.MAGENTA;
            if (piecetile != null) {
                color = piecetile.color;
            }

            int tileX = xPiece + row * pieceWidth / viewable.getRows();
            int tileY = yPiece + col * pieceHeight / viewable.getCols();

            int nextTileX = xPiece + (row + 1) * pieceWidth / viewable.getRows();
            int nextTileY = yPiece + (col + 1) * pieceHeight / viewable.getCols();

            int pieceTileWidth = nextTileX - tileX;
            int tileHeight = nextTileY - tileY;

            this.drawPieces(graphics, tileX, tileY, pieceTileWidth, tileHeight);
        }
    }


}
