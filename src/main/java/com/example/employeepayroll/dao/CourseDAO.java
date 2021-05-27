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

//    @Query("SELECT c FROM Course c WHERE c.id=:id")
//    List<Course> findCoursesByEmployeeID(@Param("id") int id);

//	@Query("SELECT c FROM Course c WHERE c.id=?1")
//	List<Course> findCoursesByName(String name);

//    @Query("SELECT c FROM Course c WHERE c.employee=:id")
//    void saveBYId(@Param("id") int id);

}