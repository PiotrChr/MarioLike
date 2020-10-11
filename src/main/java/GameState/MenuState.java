package GameState;

import GameItems.Static.Menu.Quit;
import GameItems.Static.Menu.Start;
import GameItems.TileMap.Background;
import GameItems.Static.Menu.MenuItem;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MenuState extends GameState {

    private Background bg;

    private Font titleFont;
    private Color titleColor;

    private Font menuFont;
    private Color menuColor;
    private Color menuActiveColor;

    private MenuItem currentOption;
    private ArrayList<MenuItem> options;

    public MenuState(GameStateManager gsm) {
        super(gsm);

        try {
            init();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
    public void init() {
        bg = new Background("Background/menubg.gif", 1);
        bg.setVector(-0.1, 0);

        titleColor = new Color(255, 255, 255);
        titleFont = new Font("Times Roman", Font.PLAIN, 12);

        menuFont = new Font("Times Roman", Font.PLAIN, 12);
        menuColor = new Color(255, 255, 255);
        menuActiveColor = new Color(255, 155, 50);

        // Menu options
        options = new ArrayList<>();
        options.add(new Start(0));
        options.add(new Quit(1));

    }

    @Override
    public void update() {
        bg.update();
    }

    @Override
    public void draw(Graphics2D g) {
        bg.draw(g);

        drawTitle(g);
        drawMenu(g);

    }

    public void drawTitle(Graphics2D g) {
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString(Game.gameTitle, 80, 20);
    }

    public void drawMenu(Graphics2D g) {
        g.setFont(menuFont);

        for (MenuItem item: options) {
            if (item.isActive()) {
                g.setColor(menuActiveColor);
            } else {
                g.setColor(menuColor);
            }

            g.drawString(
                    item.getTitle(),
                    80,
                    40 + (item.getPosition() * 20)
            );
        }
    }

    public void selectOption() {
        if (currentOption instanceof Start) {
            // handle start
        }

        if (currentOption instanceof Quit) {
            // handle quit
        }
    }

    @Override
    public void keyPressed(int k) {
        if (k == KeyEvent.VK_ENTER) {
            // confirm
        }

        if (k == KeyEvent.VK_ESCAPE) {
            // back or quit
        }
    }

    @Override
    public void keyReleased(int k) {

    }
}
