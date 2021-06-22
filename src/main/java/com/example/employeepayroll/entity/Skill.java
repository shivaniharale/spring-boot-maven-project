package com.example.employeepayroll.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "skill_name")
    private String skillName;

    @ManyToMany(fetch=FetchType.LAZY,
            cascade= CascadeType.ALL)
    @JoinTable(
            name="employee_skill",
            joinColumns=@JoinColumn(name="skill_id"),
            inverseJoinColumns=@JoinColumn(name="employee_id")
    )
    private List<Employee> employees;



    public Skill() {

    }

    public Skill(int id, String skill) {
        this.id = id;
        this.skillName = skill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skill) {
        this.skillName = skill;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {

        if (employees == null) {
            employees = new ArrayList<>();
        }
        employees.add(employee);
    }

}
