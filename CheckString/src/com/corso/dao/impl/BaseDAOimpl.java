package com.corso.dao.impl;

import com.corso.dao.BaseDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public abstract class BaseDAOimpl implements BaseDAO {

	@PersistenceContext
	EntityManager manager;


	@Override
	public  List<?> all(Class c) {
		String jpql = "from " + c.getClass().getSimpleName();
		Query q =  manager.createQuery(jpql,c);
		@SuppressWarnings("unchecked")
		List<?> l = q.getResultList();
		return l;
	}


	@Override
	public Object find(Class c, Integer id) {
		Object o = manager.find(c, id);
		return o;
	}

	@Override
	public Object find(Class c, String id) {
		Object o = manager.find(c, id);
		return o;
	}
}
