package inf101v22.tetris.model.piece;

import inf101v22.tetris.model.Tile;

import java.awt.*;
import java.util.Arrays;

public class PieceShape {
    private  boolean[][] shape;
    private final Tile tile;

    private PieceShape(Tile tile, boolean[][] shape){
        this.tile = tile;
        this.shape = shape;
    }

    public int getWidth() {
        return shape[0].length;
    }

    public int getHeight() {
        return shape.length;
    }
    public Tile getTile() {
        return tile;
    }

    public boolean[][] getShape(){
        return shape;
    }

    static final PieceShape O = new PieceShape(
            new Tile (Color.RED, 'o'),
            //O
            new boolean[][]{
                    { true,  true },
                    {  true,  true}
            }
    );


    static final PieceShape T = new PieceShape(
            new Tile(Color.GREEN, 't'),
            //T
            new boolean[][] {
                    {  true,  true,  true },
                    { false,  true, false }
            }
    );

    static final PieceShape S = new PieceShape(
            new Tile(Color.BLUE, 's'),
            // S
            new boolean[][] {
                    { false,  true,  true },
                    {  true,  true, false }
            }
    );
    static final PieceShape Z = new PieceShape(
            new Tile(Color.MAGENTA,'z'),
            // Z
            new boolean[][] {
                    {  true,  true, false },
                    { false,  true,  true }
            }
    );
    static final PieceShape I = new PieceShape(
            new Tile(Color.YELLOW, 'i'),
            // I
            new boolean[][] {
                    { true,  true,  true, true }
            }
    );
    static final PieceShape J = new PieceShape(
            new Tile(Color.cyan, 'j'),
            // J
            new boolean[][] {
                    { true, false, false },
                    { true, true,  true }
            }
    );
    static final PieceShape L = new PieceShape(
            new Tile(Color.pink, 'l'),
            // L
            new boolean[][] {
                    { false, false,  true },
                    {  true,  true,  true }
            }
    );
    static final PieceShape[] STANDARD_TETRIS_PIECES = { T, S, Z, I, J, L, O };

    public PieceShape pieceRotate(){
        boolean[][] rotatePiece = new boolean[getWidth()][getHeight()];
        for (int j = 0; j < getHeight(); j++) {
            for (int i = 0; i < getWidth(); i++) {
                rotatePiece[i][j] = shape[j][(getWidth()-i)-1];
            }
        }
        this.shape = rotatePiece;
        return new PieceShape(tile, rotatePiece);
    }
}
