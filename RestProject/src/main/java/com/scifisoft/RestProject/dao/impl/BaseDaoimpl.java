package com.scifisoft.RestProject.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

import com.scifisoft.RestProject.dao.BaseDao;

public class BaseDaoimpl<E> implements BaseDao<E> {
	private final Class<E> entityClass;
	public Session session;
	@PersistenceContext
	private EntityManager entityManager;

	public BaseDaoimpl() {
		this.entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public Session getSession() {
		session = this.entityManager.unwrap(Session.class);
		if (session.getTransaction().isActive()) {
			return session;
		}
		session.beginTransaction();
		return session;
	}

	@Override
	public void saveOrUpdate(E entity) {
		session = getSession();
		session.saveOrUpdate(entity);

	}

	@Override
	public boolean deleteById(Class<?> type, Serializable id) {
		session = getSession();
		Object persistencInstance = session.load(type, id);
		if (persistencInstance != null) {
			session.delete(persistencInstance);
			return true;
		}
		return false;
	}

	@Override
	public void deleteAll() {
		List<E> entities = findAll();
		for (E entity : entities) {
			session.delete(entity);
		}

	}

	@Override
	public List<E> findAll() {
		session = getSession();
		return session.createCriteria(this.entityClass).list();
	}

	@Override
	public E findById(Serializable id) {
		session = getSession();
		return session.get(this.entityClass, id);
	}

}
