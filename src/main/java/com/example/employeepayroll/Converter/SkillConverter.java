package com.example.employeepayroll.Converter;

import com.example.employeepayroll.dto.SkillDTO;
import com.example.employeepayroll.entity.Skill;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SkillConverter {

    public SkillDTO skillEntityToDTO(Skill skill) {

        SkillDTO dto=new SkillDTO();
        dto.setSkillName(skill.getSkillName());

        return dto;
    }

    public List<SkillDTO> skillEntityToDTO(List<Skill> skills) {

        return skills.stream().map(x->skillEntityToDTO(x)).collect(Collectors.toList());
    }


    public Skill skillDtoToEntity(SkillDTO dto) {

        Skill skill=new Skill();
        skill.setSkillName(dto.getSkillName());

        return skill;
    }

    public List<Skill> skillDtoToEntity(List<SkillDTO> dto) {

        return dto.stream().map(x->skillDtoToEntity(x)).collect(Collectors.toList());
    }



}
