package GameItems.Static.Menu;

import java.util.ArrayList;

public class Menu {
    MenuItem activeItem;
    ArrayList<MenuItem> menuItems;

    public Menu() {
        menuItems = new ArrayList<>();

        menuItems.add(new Start(0));
        menuItems.add(new Help(1));
        menuItems.add(new About(2));
        menuItems.add(new Quit(3));

        setActiveItem(menuItems.get(0));
    }

    public boolean isActive(MenuItem item) {
        return item == activeItem;
    }

    public MenuItem getActiveItem() {
        return activeItem;
    }

    public void activateNext() {
        if (activeItem.getPosition() == menuItems.size() - 1) {
            setActiveItem(menuItems.get(0));
            return;
        }

        for (MenuItem menuItem: menuItems) {
            if (menuItem.getPosition() == activeItem.getPosition() + 1) {
                setActiveItem(menuItem);
                return;
            }
        }
    }

    public void activatePrevious() {
        if (activeItem.getPosition() == 0) {
            setActiveItem(menuItems.get(menuItems.size() - 1));
            return;
        }

        for (MenuItem menuItem: menuItems) {
            if (menuItem.getPosition() == activeItem.getPosition() - 1) {
                setActiveItem(menuItem);
            }
        }
    }

    public void setActiveItem(MenuItem menuItem) {
        activeItem = menuItem;
    }

    public ArrayList<MenuItem> getMenu() {
        return menuItems;
    }
}
