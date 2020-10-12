package GameItems.Static.Menu;

public class About extends MenuItem {
    static final String TITLE = "About";

    public About(int position) {
        super(position);
    }

    public String getTitle() {
        return TITLE;
    }
}
