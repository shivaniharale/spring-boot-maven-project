package com.example.employeepayroll.dao;

import java.util.List;

import com.example.employeepayroll.entity.Details;


public interface DetailsDAO {

public List<Details> detailsList();
	
	public void saveOrUpdateDetails(Details details);

	public Details getDetails(int id);
	
	public void deleteDetails(int id);
	
}
