package inf101v22.tetris.model;

import inf101v22.grid.Coordinate;
import inf101v22.grid.Grid;

public class TetrisBoard extends Grid<Tile> {
    public TetrisBoard (int rows, int cols, Tile tile) { super(rows, cols, tile);}


    public TetrisBoard(int rows, int cols) {
        super(rows, cols);
    }

    public char[][] toCharArray2d() {
        char[][] resultat = new char[this.getRows()][this.getCols()];
        for (int rows = 0; rows < getRows(); rows++) {
            for (int cols = 0; cols < getCols(); cols++) {
                Tile tile = this.get(new Coordinate(rows, cols));
                char myChar = '-';
                if (tile != null) {
                    myChar = tile.character;
                }
                resultat[rows][cols] = myChar;
            }
        }
        return resultat;
    }
        //public char[][] charArray2dToString(){
        //      char[][] board = new char[this.getRows()][this.getCols()];

        //    String string = "";
        //  for (int i = 0; i < board.length; i++) {
        //    for (int j = 0; j < board[i].length; j++) {
        //      string += board[i][j];
        //}
        //string += "\n";
        //}
        //return string;
        //}

}
