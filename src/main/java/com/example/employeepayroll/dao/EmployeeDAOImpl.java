package com.example.employeepayroll.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.employeepayroll.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManager em;
	
//	private SessionFactory sessionFactory;
	
	@Override
	public List<Employee> employeeList() {

		
		Session session=em.unwrap(Session.class);
		
		Query<Employee> query=session.createQuery("from Employee order by lastName",Employee.class);
		
		List<Employee> list=query.getResultList();
		
		return list;
	}

	@Override
	public void saveOrUpdateEmployee(Employee employee) {

		Session session=em.unwrap(Session.class);


		
		session.saveOrUpdate(employee);
		
	}

	@Override
	public Employee getEmployee(int id) {
		Session session=em.unwrap(Session.class);

		
		Employee employee=session.get(Employee.class,id);
			
		if(employee==null) {
			throw new NullPointerException("Invalid input");
		}
		else {
		
		return employee;
		}
	}

	@Override
	public void deleteEmployee(int id) {
		Session session=em.unwrap(Session.class);

		Employee employee=session.get(Employee.class,id);
				
		session.delete(employee);

	}

}
