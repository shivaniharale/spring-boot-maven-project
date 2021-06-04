package com.example.employeepayroll.rest;

import com.example.employeepayroll.dto.SkillDTO;
import com.example.employeepayroll.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/skills")
    public List<SkillDTO> getSkills(){
        return skillService.getSkillsList();
    }


}
