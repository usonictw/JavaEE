package com.goit.ee.module2.menu;

/**
 * Created by PC on 10.12.2016.
 */
public abstract class MenuEntry {

    private String title;

    public MenuEntry(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract void run();
}
