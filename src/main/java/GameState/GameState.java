package GameState;

import java.awt.*;

public abstract class GameState {
    GameStateManager gsm;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
    }

    void init() {}

    public abstract void update();

    public abstract void draw(Graphics2D g);

    public abstract void keyPressed(int k);

    public abstract void keyReleased(int k);
}
