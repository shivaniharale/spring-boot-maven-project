package com.example.employeepayroll.service;

import com.example.employeepayroll.Converter.EmployeeConverter;
import com.example.employeepayroll.Converter.SkillConverter;
import com.example.employeepayroll.entity.Employee;
import com.example.employeepayroll.entity.Skill;
import com.example.employeepayroll.repository.EmployeeRepo;
import com.example.employeepayroll.repository.SkillRepo;
import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.dto.SkillDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepo skillRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private SkillConverter skillConverter;

    @Autowired
    private EmployeeConverter employeeConverter;


    @Override
    public List<SkillDTO> getSkillsList() {
        return skillConverter.skillEntityToDTO(skillRepo.findAll());
    }

    @Override
    public List<EmployeeDTO> getEmployeesBySkill(String skill) {
        Skill skill1=skillRepo.findBySkill(skill);
        return employeeConverter.employeeEntityToDTO(skill1.getEmployeeSet());
    }

    @Override
    public ResponseEntity<?> saveEmployeeSkill(Skill skill) {
        return ResponseEntity.ok(skillRepo.save(skill));
    }

}
