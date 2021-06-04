package com.example.employeepayroll.dto;

import com.example.employeepayroll.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SkillDTO {

    private int id;
    private String skill;
    private List<EmployeeDTO> employeeSet;

    public SkillDTO() {
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

    public List<EmployeeDTO> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(List<EmployeeDTO> employeeSet) {
        this.employeeSet = employeeSet;}


    @Override
    public String toString() {
        return "SkillDTO{" +
                       "id=" + id +
                       ", skill='" + skill + '\'' +
                       '}';
    }
}
