package GameItems.Static.Menu;

public abstract class MenuItem implements IMenuItem {
    public int position;

    public MenuItem(int position) {
        this.position = position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }
}
