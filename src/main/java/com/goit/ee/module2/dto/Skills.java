package com.goit.ee.module2.dto;

public class Skills {
    private long id;
    private String name;
    private static long count = 0;

    public Skills() {
        id = ++count;
    }

    public Skills(String name) {
        id = ++count;
        this.name = name;
    }
}
