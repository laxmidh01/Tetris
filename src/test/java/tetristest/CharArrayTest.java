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
        TetrisBoard board = new TetrisBoard(3,4);

        board.set(new Coordinate(0,0), new Tile(Color.black, 't'));

        char[][] res = board.toCharArray2d();
        char[][] expected = {
                {'t','-','-','-'},
                {'-','-','-','-'},
                {'-','-','-','-'},
        };

        assertTrue(Arrays.deepEquals(expected,res));
    }

    @Test
    void testCharArrayToString() {
        char[][] source = {
                {'-','-','-','-'},
                {'-','-','-','-'},
                {'-','t','-','-'},
        };

        String expected = 	"----" +
                "----" +
                "-t--";

//		String actual = TetrisBoard.charArray2dToString(source);

    }




}
