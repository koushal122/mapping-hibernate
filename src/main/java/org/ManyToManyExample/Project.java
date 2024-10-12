package org.ManyToManyExample;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Project {
    @Id
    private int id;
    private String projectName;

    @ManyToMany(mappedBy = "projects", cascade = CascadeType.ALL)
    List<Emp> employees;

    public Project() {
    }

    public Project(int id, String projectName, List<Emp> employees) {
        this.id = id;
        this.projectName = projectName;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Emp> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Emp> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", employees=" + employees +
                '}';
    }
}
