package com.example.employeepayroll.Converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import com.example.employeepayroll.dto.DetailsDTO;
import com.example.employeepayroll.entity.Details;

@Component
public class DetailsConverter {

	public DetailsDTO detailsEntityToDTO(Details details) {
		
		  DetailsDTO dto=new DetailsDTO();
		  
		  dto.setId(details.getId());
		  dto.setEmployeeNumber(details.getEmployeeNumber());
		  dto.setSalary(details.getSalary());
		  dto.setPost(details.getPost());
		  dto.setStatus(details.getStatus());
		  
	return dto;		
}

public List<DetailsDTO> detailsEntityToDTO(List<Details> details) {

	return details.stream().map(x->detailsEntityToDTO(x)).collect(Collectors.toList());
	
}

public Details detailsDtoToEntity(DetailsDTO dto) {
			
	 Details details=new Details();
	  
	 details.setId(dto.getId());
	 details.setEmployeeNumber(dto.getEmployeeNumber());
	 details.setSalary(dto.getSalary());
	 details.setPost(dto.getPost());
	 details.setStatus(dto.getStatus());

	return details;
}

public List<Details> detailsDtoToEntity(List<DetailsDTO> dtos) {
	
	return dtos.stream().map(x->detailsDtoToEntity(x)).collect(Collectors.toList());

}
	

}
