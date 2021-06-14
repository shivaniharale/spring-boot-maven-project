package com.example.employeepayroll.repository;

import java.util.List;
import java.util.Set;

import com.example.employeepayroll.entity.Employee;
import com.example.employeepayroll.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

	public List<Employee> findByFirstName(String firstName);

	public List<Employee> findByPost(String post);

	public List<Employee> findByStatus(String status);

	public List<Employee> findByLastName(String lastName);

	public Employee findByEmployeeNumber(int employeeNumber);

	public Employee findById(int id);

	@Query("SELECT e FROM Employee e WHERE e.firstName=:firstName AND e.lastName=:lastName")
	Employee findByFirstNameLastName(@Param("firstName") String firstName,@Param("lastName") String lastName);

}
