package com.goit.ee.module2.dto;

public class Customers {
    private long id;
    private String name;
    private String address;
    private static long count = 0;

    public Customers() {
        id = ++count;
    }

    public Customers(String name, String address) {
        id = ++count;
        this.name = name;
        this.address = address;
    }
}
