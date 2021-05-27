package com.example.employeepayroll.dao;

import java.util.List;

import com.example.employeepayroll.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee,Integer> {

	List<Employee> findByPost(String post);

	List<Employee> findByStatus(String status);

	List<Employee> findByLastName(String lastName);

	Employee findByEmployeeNumber(int employeeNumber);

//	@Query("SELECT e FROM Employee e where e.firstName=:firstName")
	List<Employee> findByfirstName(String firstName);

	Employee findById(int id);

	Employee findByEmail(String email);

	Employee findByPhone(String phone);

}
