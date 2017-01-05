package com.goit.ee.module3.dto;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private long cost;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "proj_dev", joinColumns = @JoinColumn(name = "id_proj"), inverseJoinColumns = @JoinColumn(name = "id_dev"))
    private Set<Developer> developers = new HashSet<>();

    public Project() {
    }

    public Project(long id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public void addDevelopers(Set<Developer> developer) {

        developers.addAll(developer);
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
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

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (cost != project.cost) return false;
        return name.equals(project.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (int) (cost ^ (cost >>> 32));
        return result;
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();
        sb.append("Project: \n");
        sb.append("id = ").append(getId() + "; ");
        sb.append("Name: ").append(getName() + "; ");
        sb.append("Cost: ").append(getCost() + "\n");
        developers.forEach(developer -> sb.append("Developer: \n").append("id = ").append(developer.getId() + "; ")
                .append("First Name: ").append(developer.getFirstName() + "; ")
                .append("Last Name: ").append(developer.getLastName() + "; ")
                .append("Age: ").append(developer.getAge() + "; ")
                .append("Salary: ").append(developer.getSalary() + ";\n")
                .append(developer.getSkills() + "\n"));

        return sb.toString();
    }
}
