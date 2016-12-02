package com.goit.ee.module2.dto;

public class Companies {
    private long id;
    private String name;
    private String address;
    private static long count = 0;

    public Companies() {
        id = ++count;
    }

    public Companies(String name, String address) {
        id = ++count;
        this.name = name;
        this.address = address;
    }
}
