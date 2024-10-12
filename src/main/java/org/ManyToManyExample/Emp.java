package org.ManyToManyExample;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Emp {
    @Id
    private int id;
    private String name;
    //CascadeType.ALL means we insert Emp object to db then hibernate will take of inserting project if
    //emp object have project list.
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Emp_Project",
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    List<Project> projects;

    public Emp() {
    }

    public Emp(int id, String name, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", projects=" + projects +
                '}';
    }
}
