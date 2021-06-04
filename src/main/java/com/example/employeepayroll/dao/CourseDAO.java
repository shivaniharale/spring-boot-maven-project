package com.example.employeepayroll.dao;

import com.example.employeepayroll.dto.CourseDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeepayroll.entity.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDAO extends JpaRepository<Course, Integer> {

}