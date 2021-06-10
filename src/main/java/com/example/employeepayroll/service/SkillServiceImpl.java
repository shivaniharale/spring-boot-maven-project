package com.example.employeepayroll.service;

import com.example.employeepayroll.Converter.SkillConverter;
import com.example.employeepayroll.dao.EmployeeDAO;
import com.example.employeepayroll.dao.SkillDAO;
import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.dto.SkillDTO;
import com.example.employeepayroll.entity.Employee;
import com.example.employeepayroll.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillDAO skillDAO;

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private SkillConverter skillConverter;


    @Override
    public List<SkillDTO> getSkillsList() {
        return skillConverter.skillEntityToDTO(skillDAO.findAll());
    }

    @Override
    public List<EmployeeDTO> getEmployeesBySkill(String skill) {
        return null;
    }

}
