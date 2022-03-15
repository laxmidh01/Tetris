package inf101v22.tetris.controller;

public interface TetrisControllable {
    boolean moveFallingPiece(int deltaRow, int deltaCol);

    boolean rotatedBrick(int rotatedRow, int rotatedCol);

}
