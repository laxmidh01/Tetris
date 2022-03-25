package tetristest;

import inf101v22.grid.Coordinate;
import inf101v22.tetris.model.TetrisBoard;
import inf101v22.tetris.model.TetrisModel;
import inf101v22.tetris.model.Tile;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TetrisTest {
    TetrisBoard board;
    TetrisModel model;


    @Test
    void boardTest(){
            board = new TetrisBoard(9, 12);
            assertEquals(9, board.getRows());
            assertEquals(12, board.getCols());
    }
    @Test
    void testCharArray2d() {
        board = new TetrisBoard(3, 4);
        board.set(new Coordinate(0, 0), new Tile(Color.black, 't'));

        char[][] result = board.toCharArray2d();
        char[][] expected = {
                {'t', '-', '-', '-'},
                {'-', '-', '-', '-'},
                {'-', '-', '-', '-'},
        };

        assertTrue(Arrays.deepEquals(expected, result));
    }

    @Test
    void testTime(){
        model = new TetrisModel(5, 7);
        int expected = (int) (2000*0.98);
        int answer = model.getTime();

        assertEquals(expected, answer);
    }

    @Test
    void testScore(){
        model = new TetrisModel(3, 4);
        int expected = 0;
        int answer = model.getScore();

        assertEquals(expected, answer);
    }

}

