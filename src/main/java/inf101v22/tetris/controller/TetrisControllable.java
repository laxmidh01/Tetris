package inf101v22.tetris.controller;

import inf101v22.tetris.model.GameScreen;

public interface TetrisControllable {
    boolean moveFallingPiece(int deltaRow, int deltaCol);

    boolean rotatedBrick();

    void dropPiece();

    GameScreen getGameScreen();

    int timer();

    boolean clockTick();

}
