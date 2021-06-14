package com.example.employeepayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeepayroll.entity.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

}