package com.example.employeepayroll.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "skill")
    private String skill;

    @ManyToMany
    @JoinTable(name = "employee_skill",
                joinColumns = @JoinColumn(name = "skill_id"),
                inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> employeeSet;

    public Skill() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public List<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(List<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    @Override
    public String toString() {
        return "Skill{" +
                       "id=" + id +
                       ", skill='" + skill + '\'' +
                       ", employeeSet=" + employeeSet +
                       '}';
    }

    public void addEmployee(Employee employee) {

        if(employeeSet== null){
            List<Employee> employeeSet=new ArrayList<>();
        }
        employeeSet.add(employee);
        employee.addSkill(this);

    }
}
