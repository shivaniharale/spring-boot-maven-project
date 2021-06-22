package com.example.employeepayroll.dto;

import com.example.employeepayroll.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SkillDTO {

    private String skillName;
    private List<EmployeeDTO> employeeSet;

    public SkillDTO() {
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public List<EmployeeDTO> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(List<EmployeeDTO> employeeSet) {
        this.employeeSet = employeeSet;}


    @Override
    public String toString() {
        return "SkillDTO{" +
                       ", skill='" + skillName + '\'' +
                       '}';
    }
}
