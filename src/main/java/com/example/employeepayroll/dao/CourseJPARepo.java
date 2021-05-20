package com.example.employeepayroll.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeepayroll.entity.Course;

public interface CourseJPARepo extends JpaRepository<Course, Integer> {

}
