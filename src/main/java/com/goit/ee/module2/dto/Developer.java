package com.goit.ee.module2.dto;

public class Developer {
    private long id;
    private int age;
    private String firstName;
    private String lastName;
    private int salary;

    public Developer() {
    }

    public Developer(long id, int age, String firstName, String lastName, int salary) {
        this.id = id;
        this.salary = salary;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer = (Developer) o;

        if (id != developer.id) return false;
        if (age != developer.age) return false;
        if (salary != developer.salary) return false;
        if (firstName != null ? !firstName.equals(developer.firstName) : developer.firstName != null) return false;
        return lastName != null ? lastName.equals(developer.lastName) : developer.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + age;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + salary;
        return result;
    }
}
