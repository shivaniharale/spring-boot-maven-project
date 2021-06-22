package com.example.employeepayroll.repository;

import com.example.employeepayroll.entity.Employee;
import com.example.employeepayroll.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepo extends JpaRepository<Skill,Integer> {

    public Skill findBySkillName(String skill);

}
