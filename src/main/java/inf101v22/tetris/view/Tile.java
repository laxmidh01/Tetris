package inf101v22.tetris.view;

import java.awt.*;

public class Tile {
    public final Color color;
    public char character;

    public Tile(Color color) {
        this.color = color;
    }

    public char getCharacter() {
        return character;
    }
}
