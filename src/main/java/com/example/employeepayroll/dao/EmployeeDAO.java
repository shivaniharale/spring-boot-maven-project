package com.example.employeepayroll.dao;

import java.util.List;

import com.example.employeepayroll.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeDAO extends JpaRepository<Employee,Integer> {

	@Query("SELECT e FROM Employee e where e.post=:post")
	List<Employee> findByPost(@Param("post")String post);

	@Query("SELECT e FROM Employee e where e.status=:status")
	List<Employee> findByStatus(@Param("status")String status);

	@Query("SELECT e FROM Employee e where e.lastName=:lastName")
	List<Employee> findByLastName(@Param("lastName")String lastName);

	@Query("SELECT e FROM Employee e where e.employeeNumber=:employeeNumber")
	Employee findByEmployeeNumber(@Param("employeeNumber")int employeeNumber);

	@Query("SELECT e FROM Employee e where e.firstName=:firstName")
	List<Employee> findByfirstName(@Param("firstName")String firstName);

	@Query("SELECT e FROM Employee e where e.id=:id")
	Employee findById(@Param("id")int id);



}
