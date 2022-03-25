package inf101v22.tetris.controller;

import inf101v22.tetris.model.GameScreen;

public interface TetrisControllable {

    /**
     * Sjekker og rapporterer om det er lov å flytte på brikken
     * @param deltaRow
     * @param deltaCol
     * @return
     */
    boolean moveFallingPiece(int deltaRow, int deltaCol);

    /**
     * Sjekker og rapporterer om det er lov å rotere brikken
     * @return
     */
    boolean rotatedBrick();

    /**
     * Dropper brikken nedover i brettet
     */
    void dropPiece();

    /**
     * @return ACTIVE_GAME eller GAME_OVER
     */
    GameScreen getGameScreen();

    /**
     * kalkulerer tiden for hvor fort brikken skal falle nedover
     * @return tiden
     */
    int getTime();

    /**
     * sjekker om det brikken flyttes nedover hvis ja fester vi brikken
     * ved å kalle på metoden AttachPiece()
     * også kaller vi på metoden getTime()
     */
    void clockTick();

}
