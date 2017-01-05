package com.goit.ee.module3.dto;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
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

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "dev_skills",
            joinColumns = @JoinColumn(name = "id_dev"),
            inverseJoinColumns = @JoinColumn(name = "id_skills"))
    private Set<Skill> skills = new HashSet<>();



    public Developer() {
    }

    public Developer(int age, String firstName, String lastName, int salary) {
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

    public void addSkill(Set<Skill> skill) {

        this.skills.addAll(skill);
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

        if (age != developer.age) return false;
        if (salary != developer.salary) return false;
        if (!firstName.equals(developer.firstName)) return false;
        return lastName.equals(developer.lastName);
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + salary;
        return result;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Developer:" + "\n");
        sb.append("id = ").append(getId() + "; ");
        sb.append("First Name: ").append(getFirstName() + "; ");
        sb.append("Last Name: ").append(getLastName() + "; ");
        sb.append("Age: ").append(getAge() + "; ");
        sb.append("Salary: ").append(getSalary() + ";\n");
        sb.append("Skills: \n");
        skills.forEach(skill -> sb.append("id = ").append(skill.getId() + "  ").append("Name: ").append(skill.getName() + "\n"));
        return sb.toString();
    }
}
