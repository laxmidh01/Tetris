package tetristest;

import inf101v22.grid.Coordinate;
import inf101v22.tetris.model.TetrisBoard;
import inf101v22.tetris.model.Tile;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CharArrayTest {


    @Test
    void testCharArray2d() {
        TetrisBoard tetrisBoard = new TetrisBoard(3,4);

       tetrisBoard.set(new Coordinate(0,0), new Tile(Color.black, 't'));

        char[][] result = tetrisBoard.toCharArray2d();
        char[][] expected = {
                {'t','-','-','-'},
                {'-','-','-','-'},
                {'-','-','-','-'},
        };

        assertTrue(Arrays.deepEquals(expected,result));
    }

}
