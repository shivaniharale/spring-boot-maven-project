package com.example.employeepayroll.rest;

import com.example.employeepayroll.dto.CourseDTO;
import com.example.employeepayroll.dto.SkillDTO;
import com.example.employeepayroll.entity.Skill;
import com.example.employeepayroll.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/skills")
    public List<SkillDTO> getSkills(){
        return skillService.getSkillsList();
    }



}
