package GameState;

import GameItems.Static.Menu.Menu;
import GameItems.Static.Menu.MenuItem;
import GameItems.Static.Menu.*;
import GameItems.TileMap.Background;
import Main.Game;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {

    private Background bg;

    private Font titleFont;
    private Color titleColor;

    private Font menuFont;
    private Color menuColor;
    private Color menuActiveColor;

    private Menu menu;

    public MenuState(GameStateManager gsm) {
        super(gsm);

        try {
            init();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
    public void init() {
        bg = new Background("/Backgrounds/menubg1.gif", 1);
        bg.setVector(0.1, 0);

        titleColor = new Color(255, 255, 255);
        titleFont = new Font("Times Roman", Font.PLAIN, 12);

        menuFont = new Font("Times Roman", Font.PLAIN, 12);
        menuColor = new Color(255, 255, 255);
        menuActiveColor = new Color(255, 155, 50);

        menu = new Menu();
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

        for (MenuItem item: menu.getMenu()) {
            if (menu.isActive(item)) {
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

    public void handleQuit() {
        System.exit(0);
    }

    public void handleStart() {}

    public void handleHelp() {}

    public void handleAbout() {}

    public void handleOption(MenuItem menuItem) {
        if (menuItem instanceof Start) {
            handleStart();
        }

        if (menuItem instanceof Quit) {
            handleQuit();
        }

        if (menuItem instanceof Help) {
            handleHelp();
        }

        if (menuItem instanceof About) {
            handleAbout();
        }
    }

    @Override
    public void keyPressed(int k) {
        if (k == KeyEvent.VK_ENTER) {
            handleOption(menu.getActiveItem());
        }

        if (k == KeyEvent.VK_ESCAPE) {
            handleQuit();
        }

        if (k == KeyEvent.VK_UP) {
            menu.activatePrevious();
        }

        if (k == KeyEvent.VK_DOWN) {
            menu.activateNext();
        }
    }

    @Override
    public void keyReleased(int k) {

    }
}
