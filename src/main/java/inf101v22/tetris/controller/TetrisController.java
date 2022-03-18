package inf101v22.tetris.controller;

import inf101v22.tetris.view.TetrisView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TetrisController implements KeyListener, ActionListener {
    TetrisControllable model;
    TetrisView tetrisView;
    public TetrisController(TetrisControllable model, TetrisView tetrisView){
        this.model = model;
        this.tetrisView = tetrisView;
        this.tetrisView.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            // Left arrow was pressed
            model.moveFallingPiece(0, -1);
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            // Right arrow was pressed
            model.moveFallingPiece(0, 1);
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            // Down arrow was pressed
            model.moveFallingPiece(1,0);

        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            // Up arrow was pressed
            model.rotatedBrick();
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE){
            //Space was pressed
            model.dropPiece();
        }
        tetrisView.repaint();
    }


    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
