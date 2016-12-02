package com.goit.ee.module2.dto;

public class Developers {
    private long id;
    private int age;
    private String firstName;
    private String lastName;
    private int salary;
    private static long count = 0;

    public Developers() {
        id = ++count;
    }

    public Developers(int age, String firstName, String lastName, int salary) {
        id = ++count;
        this.salary = salary;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;

    }
}
