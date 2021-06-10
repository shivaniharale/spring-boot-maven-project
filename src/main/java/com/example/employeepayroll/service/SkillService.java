package com.example.employeepayroll.service;


import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.dto.SkillDTO;
import com.example.employeepayroll.entity.Skill;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface SkillService {

    public List<SkillDTO> getSkillsList();

    public List<EmployeeDTO> getEmployeesBySkill(String skill);

}
