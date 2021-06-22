package com.example.employeepayroll.rest;

import com.example.employeepayroll.dto.CourseDTO;
import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.dto.SkillDTO;
import com.example.employeepayroll.entity.Employee;
import com.example.employeepayroll.entity.Skill;
import com.example.employeepayroll.repository.EmployeeRepo;
import com.example.employeepayroll.repository.SkillRepo;
import com.example.employeepayroll.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @Autowired
    SkillRepo skillRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("/skill/{skillName}")
    public List<EmployeeDTO> getEmployeesBySkill(@PathVariable String skillName){
        return skillService.getEmployeesBySkill(skillName);
    }

    @GetMapping("/skills")
    public List<SkillDTO> getSkills(){
        return skillService.getSkillsList();
    }

    @PostMapping("/skills/{id}")
    public ResponseEntity<?> saveSkills(@PathVariable int id,@RequestBody List<SkillDTO> skills)
    {
        return skillService.saveEmployeeSkill(id,skills);

    }


}
