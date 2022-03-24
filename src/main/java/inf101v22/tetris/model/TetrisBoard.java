package inf101v22.tetris.model;

import inf101v22.grid.Coordinate;
import inf101v22.grid.Grid;

import java.awt.*;

public class TetrisBoard extends Grid<Tile> {
    public TetrisBoard (int rows, int cols, Tile tile) {
        super(rows, cols, tile);
    }


    public boolean elementIsOnRow(int row, Tile tile){
        for (int i = 0; i < getCols(); i++) {
            Coordinate newCoordinate = new Coordinate(row, i);
            if(get(newCoordinate) == tile){
            return true;
            }
        }
        return false;
    }


    public void fillRowWithBlankTiles(int a, Tile tile){
        for (int i = 0; i < getCols(); i++) {
            Coordinate newCoordinate = new Coordinate(a, i);
            set(newCoordinate, tile);
        }
    }

    public void copyElementsFromRow(int row, int row2){
        for (int i = 0; i < getCols(); i++) {
            set(new Coordinate(row, i), get(new Coordinate(row2, i)));
        }
    }

    public int removeRow(){
        //int a = this.getRows() - 1;
        int b = this.getRows()-1;
        int removedRows = 0;
        for(int i = this.getRows()-1; i >= 0; i--){
            while(b >= 0 && !elementIsOnRow(b, null)){
                b--;
                removedRows++;
            }
            if(b >= 0){
                copyElementsFromRow(i, b);
                b--;
            }
            else{
                fillRowWithBlankTiles(i, null);
            }
        }
        return removedRows;
    }

    public TetrisBoard (int rows, int cols) {
        super(rows, cols);
    }

    public char[][] toCharArray2d() {
        char[][] resultat = new char[this.getRows()][this.getCols()];
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getCols(); col++) {
                Tile tile = this.get(new Coordinate(row, col));
                char nChar = '-';
                if (tile != null) {
                    nChar = tile.character;
                }
                resultat[row][col] = nChar;
            }
        }
        return resultat;
    }
    public String charArray2dToString(){
        char[][] board = new char[this.getRows()][this.getCols()];

        String string = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                string += board[i][j];
            }
            string += "\n";
        }
        return string;
    }
}
