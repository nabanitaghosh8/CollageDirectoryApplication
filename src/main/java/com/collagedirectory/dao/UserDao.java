package com.collagedirectory.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.collagedirectory.dto.Users;

public class UserDao {
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	public Users findUserByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("select u from Users u where u.username = ?1 and u.password = ?2");
		q.setParameter(1, username);
		q.setParameter(2, password);
		List<Users> list = q.getResultList();
		if (!list.isEmpty()) {
		    return list.get(0);
		}
		return null;
	}
	public Users findById(Long id) {
		return em.find(Users.class, id);
	}
	public void save(Users u) {
		et.begin();
		em.merge(u);
		et.commit();
	}
}
