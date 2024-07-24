package com.collagedirectory.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.collagedirectory.dto.Department;

public class DepartmentDao {
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	public void addDepartment(Department d) {
		et.begin();
		em.merge(d);
		et.commit();
	}
}
