package Main;

import GameState.GameStateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable, KeyListener {
    GameStateManager gsm;

    public final static int WIDTH = 640;
    public final static int HEIGHT = 480;
    public final static int SCALE = 2;

    private Thread thread;
    private int FPS = 60;
    private boolean isRunning;
    private long targetTime = 1000 / FPS;

    private BufferedImage image;
    private Graphics2D g;


    GamePanel() {
        super();
        gsm = new GameStateManager();
    }

    public void runGame() {
        isRunning = true;
    }

    public void stopGame() {
        isRunning = false;
    }

    public void init() {
        setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
//        g = (Graphics2D) g;

        gsm = new GameStateManager();
        runGame();
    }

    public void draw() {
        gsm.draw(g);
    }

    public void drawToScreen() {
        Graphics g2 = getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }

    public void update() {
        gsm.update();
    }

    public void run() {
        init();

        long start;
        long elapsed;
        long wait;

        while (isRunning) {
            start = System.nanoTime();

            update();
            draw();
            drawToScreen();

            elapsed = start - System.nanoTime();
            wait = targetTime - elapsed / 1000000;

            try {
                Thread.sleep(wait);
            } catch(Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        gsm.keyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        gsm.keyReleased(e.getKeyCode());
    }

    public void addNotify() {
        super.addNotify();

        if (thread == null) {
            thread = new Thread(this);
            addKeyListener(this);
            thread.start();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
