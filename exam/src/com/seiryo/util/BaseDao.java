package com.seiryo.util;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	public void save(T t);
	public void delete(T t);
	public void update(T t);
	public List<T> query();
	public T get(Serializable id);
}
