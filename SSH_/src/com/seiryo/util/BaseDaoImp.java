package com.seiryo.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDaoImp<T> extends HibernateDaoSupport implements BaseDao<T>{
	private Class<T> beanClass;
	public BaseDaoImp(){
			Type type = this.getClass().getGenericSuperclass();
			if(type instanceof ParameterizedType){
				ParameterizedType parameterizedType = (ParameterizedType) type;
				beanClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
			}
	}
	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public List<T> query() {
		return this.getHibernateTemplate().find("from "+ beanClass.getName());
	}

	@Override
	public T get(Serializable id) {
		return (T) this.getHibernateTemplate().get(beanClass, id);
	}

}
