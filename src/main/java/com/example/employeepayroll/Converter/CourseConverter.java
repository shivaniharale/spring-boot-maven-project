package com.example.employeepayroll.Converter;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import com.example.employeepayroll.dto.CourseDTO;
import com.example.employeepayroll.entity.Course;

@Component
public class CourseConverter {

	public CourseDTO courseEntityToDTO(Course course) {

		CourseDTO dto=new CourseDTO();
		dto.setId(course.getId());
		dto.setCourseName(course.getCourseName());

		return dto;
	}

	public List<CourseDTO> courseEntityToDTO(List<Course> courses) {

		return courses.stream().map(x->courseEntityToDTO(x)).collect(Collectors.toList());

	}


	public Course courseDtoToEntity(CourseDTO dto) {

		Course course=new Course();
		course.setId(dto.getId());
		course.setCourseName(dto.getCourseName());

		return course;
	}

	public List<Course> courseDtoToEntity(List<CourseDTO> dtos) {

		return dtos.stream().map(x->courseDtoToEntity(x)).collect(Collectors.toList());

	}
}
