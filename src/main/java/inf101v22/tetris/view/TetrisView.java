package inf101v22.tetris.view;

import inf101v22.grid.CoordinateItem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class TetrisView extends JComponent implements TetrisViewable {
    int row;
    int col;
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
    }

    @Override
    public Dimension getPreferredSize() {
        int width = 500;
        int height = 750;
        return new Dimension(width, height);
    }


    @Override
    public int getRows() {
        return 0;
    }

    @Override
    public int getCols() {
        return 0;
    }

    @Override
    public Iterator<CoordinateItem<Tile>> iterator() {
        ArrayList<CoordinateItem<Tile>> coordinateItems = new ArrayList<>();

        Iterator<CoordinateItem<Tile>> iterator = coordinateItems.iterator();

        return iterator;
    }


}
