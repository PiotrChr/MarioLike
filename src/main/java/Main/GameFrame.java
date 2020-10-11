package Main;

import javax.swing.*;

public class GameFrame extends JFrame {
    GamePanel gamePanel;

    public GameFrame() {
        setContentPane(new GamePanel());
        init();
    }

    void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
    }
}
