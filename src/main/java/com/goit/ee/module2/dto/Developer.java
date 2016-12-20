package com.goit.ee.module2.dto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "age")
    private int age;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "salary")
    private int salary;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "dev_skills", joinColumns = @JoinColumn(name = "id_dev"), inverseJoinColumns = @JoinColumn(name = "id_skills"))
    private Set<Skill> skills = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private Project project;

    public Developer() {
    }

    public Developer(long id, int age, String firstName, String lastName, int salary) {
        this.id = id;
        this.salary = salary;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public void addSkill(Skill skill) {

        this.skills.add(skill);
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
