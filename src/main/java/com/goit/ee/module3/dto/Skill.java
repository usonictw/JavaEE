package com.goit.ee.module3.dto;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne()
    @JoinTable(name = "dev_skills", joinColumns = @JoinColumn(name = "id_skills"), inverseJoinColumns = @JoinColumn(name = "id_dev"))
    private Developer developer;


    public Skill() {
    }

    public Skill(long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skill skill = (Skill) o;

        if (id != skill.id) return false;
        return name != null ? name.equals(skill.name) : skill.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id + " " +
                "name='" + name + '\'' +
                '}';
    }
}
