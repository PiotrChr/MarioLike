package GameItems.Static.Menu;

public class Quit extends MenuItem {
    static final String TITLE = "Quit";

    public Quit(int position) {
        super(position);
    }

    public String getTitle() {
        return TITLE;
    }
}
