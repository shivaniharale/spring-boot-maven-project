package com.example.employeepayroll.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.employeepayroll.entity.Details;

@Repository
public class DetailsDAOImpl implements DetailsDAO {

	@Autowired
	private EntityManager em;
	
	@Override
	public List<Details> detailsList() {
		Session session=em.unwrap(Session.class);
		
		Query<Details> query=session.createQuery("from Details order by employeeNumber",Details.class);
		
		List<Details> list=query.getResultList();
		
		return list;
	}

	@Override
	public void saveOrUpdateDetails(Details details) {

		Session session=em.unwrap(Session.class);
		
		session.saveOrUpdate(details);
	}

	@Override
	public Details getDetails(int id){
		Session session=em.unwrap(Session.class);
		
		Details details=session.get(Details.class,id);
		if(details==null) {
			throw new NullPointerException("Invalid input");
		}
		else {
		return details;
		}
	}
	@Override
	public void deleteDetails(int id) {
		Session session=em.unwrap(Session.class);

		Details details=session.get(Details.class,id);
		if(details==null) {
			throw new NullPointerException("Invalid input");
		}
		else {
		session.delete(details);
		}
	}

}
