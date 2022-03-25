package inf101v22.tetris;

import javax.swing.*;

import inf101v22.tetris.controller.TetrisController;
import inf101v22.tetris.model.TetrisModel;
import inf101v22.tetris.view.TetrisView;

public class TetrisMain {
    public static final String WINDOW_TITLE = "INF101 Tetris";

    public static void main(String[] args) {
        TetrisModel model = new TetrisModel(15, 10);
        TetrisView view = new TetrisView(model);
        TetrisController tetrisController = new TetrisController(model,view);


        //JComponent view = new TetrisView();
        //JComponent view = new SampleView();
          
        // The JFrame is the "root" application window.
        // We here set som properties of the main window, 
        // and tell it to display our tetrisView
        JFrame frame = new JFrame(WINDOW_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Here we set which component to view in our window
        frame.setContentPane(view);

        // Call these methods to actually display the window
        frame.pack();
        frame.setVisible(true);
    }
    
}
