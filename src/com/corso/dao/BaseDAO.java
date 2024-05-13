package com.corso.dao;

import java.util.List;

public interface BaseDAO {

	public List<?> all(Class c);

	public Object find(Class c, Integer id);

	public Object find(Class c, String id);
}
