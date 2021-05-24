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


	Logger log=Logger.getLogger(getClass().getName());

	public CourseDTO courseEntityToDTO(Course course) {

		CourseDTO dto=new CourseDTO();

		log.info("COURSE::::E TO D"+course.toString());

		dto.setId(course.getId());
		dto.setCourseName(course.getCourseName());

//		ModelMapper mapper=new ModelMapper();
//		CourseDTO dto=mapper.map(course,CourseDTO.class);
//		mapper.getConfiguration()
//		  .setMatchingStrategy(MatchingStrategies.STRICT);
//
		return dto;
	}

	public List<CourseDTO> courseEntityToDTO(List<Course> course) {

		return course.stream().map(x->courseEntityToDTO(x)).collect(Collectors.toList());

	}


	public Course courseDtoToEntity(CourseDTO dto) {

		Course course=new Course();

		log.info("COURSE::::D TO E"+dto.toString());


		course.setId(dto.getId());
		course.setCourseName(dto.getCourseName());

//		ModelMapper mapper=new ModelMapper();
//		Course course=mapper.map(dto,Course.class);
//		mapper.getConfiguration()
//		  .setMatchingStrategy(MatchingStrategies.STRICT);

		return course;
	}

	public List<Course> courseDtoToEntity(List<CourseDTO> dtos) {

		return dtos.stream().map(x->courseDtoToEntity(x)).collect(Collectors.toList());

	}




}
