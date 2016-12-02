package com.goit.ee.module2.dto;

public class Projects {
    private long id;
    private String name;
    private int cost;
    private static long count = 0;

    public Projects() {
        id = ++count;
    }

    public Projects(String name, int cost) {
        id = ++count;
        this.name = name;
        this.cost = cost;
    }
}
