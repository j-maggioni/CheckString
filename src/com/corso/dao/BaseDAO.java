package com.corso.dao;

import com.corso.bean.Bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public interface BaseDAO {

	public List<?> all(Class c);

	public Object find(Class c, Integer id);

	public Object find(Class c, String id);
}
