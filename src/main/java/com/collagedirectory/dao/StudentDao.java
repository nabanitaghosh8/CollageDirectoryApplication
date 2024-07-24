package com.collagedirectory.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.collagedirectory.dto.StudentProfile;

public class StudentDao {
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	public StudentProfile findbyId(Long id) {
		return em.find(StudentProfile.class, id);
	}
	public void removeStudent(StudentProfile s) {
		et.begin();
		em.remove(s);
		et.commit();
	}
	public void addStudent(StudentProfile s) {
		et.begin();
		em.persist(s);
		et.commit();
	}
	public List<StudentProfile>findAll(){
		Query q=em.createQuery("select s from StudentProfile s");
		return q.getResultList();
	}
}
