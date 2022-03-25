package inf101v22.tetris.view;

import inf101v22.grid.CoordinateItem;
import inf101v22.tetris.model.GameScreen;
import inf101v22.tetris.model.Tile;

import javax.swing.*;
import java.awt.*;

public class TetrisView extends JComponent{
    {this.setFocusable(true);}


    TetrisViewable viewable;
    int pad = 2;
    int border = 5;

    public TetrisView(TetrisViewable viewable) {
        this.viewable = viewable;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        drawTetrisBoard(graphics,border,border,getWidth()-2*border,getHeight()-2*border, pad);

        if(viewable.getGameScreen() == GameScreen.GAME_OVER){
            Color transparentColor = new Color(220, 28, 167, 128);
            graphics.setColor(transparentColor);

            graphics.fillRect(0, 0, getWidth(), getHeight());

            graphics.setColor(Color.WHITE);

            Font myFont = new Font("SansSerif", Font.BOLD, 30);
            graphics.setFont(myFont);

            GraphicHelperMethods.drawCenteredString(graphics, "GAME OVER", 0, 0, getWidth(), getHeight());
            GraphicHelperMethods.drawCenteredString(graphics, "Score: " + viewable.getScore(), 0, 0, getWidth(), getHeight() - 100);

        }
        //drawPieces(graphics,l,l,this.getWidth(),this.getHeight());
        //this.drawFallingPieceWithRightBottomPadding(canvas, 0, 0, this.getWidth(), this.getHeight());
    }

    public void drawTileWithRightBottomPadding(Graphics graphics, int x, int y, int width, int height, int padding, Color color) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(x, y, width, height);

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
            //graphics.setColor(Color.cyan);
            int X = xBoard + col * boardWidth / viewable.getCols();
            int Y = yBoard + row * boardHeight/ viewable.getRows();

            int nextX = xBoard + (col + 1) * boardWidth / viewable.getCols();
            int nextY = yBoard + (row + 1) * boardHeight / viewable.getRows();

            int bWidth = nextX - X;
            int bHeight = nextY - Y;

            this.drawTileWithRightBottomPadding(graphics, X, Y, bWidth, bHeight, padding, color);

        }

    }

    public void drawTetrisBoard(Graphics graphics, int x, int y, int width, int height, int padding){
        graphics.setColor(Color.WHITE);
        graphics.fillRect(x, y, width + padding, height + padding);
        drawBoardWithRightBottomPadding(graphics, x, y, width, height, padding, this.viewable.iterator());
        drawBoardWithRightBottomPadding(graphics, x, y, width, height, padding, this.viewable.pieceIterator());

    }


    @Override
    public Dimension getPreferredSize() {
        int boardWidth = this.viewable.getCols() * (25 + border) + pad;
        int boardHeight = this.viewable.getRows() * (25 + border) + pad;
        //int width = (30+l)*viewable.getCols()+l;
        int width = boardWidth + pad * 10;
        //int height = (60+l)* viewable.getRows()+l;
        int height = boardHeight + pad * 10;
        return new Dimension(width, height);
    }


}
