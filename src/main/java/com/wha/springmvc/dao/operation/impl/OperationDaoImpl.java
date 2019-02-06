package com.wha.springmvc.dao.operation.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wha.springmvc.dao.operation.IOperationDAO;
import com.wha.springmvc.model.operation.Operation;

@Repository
public class OperationDaoImpl implements IOperationDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Operation operation) {
		sessionFactory.getCurrentSession().save(operation);
	}

	@Override
	public Operation findOneById(long id) {
		return sessionFactory.getCurrentSession().get(Operation.class, id);
	}

	@Override
	public List<Operation> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Operation> cq = cb.createQuery(Operation.class);
		Root<Operation> root = cq.from(Operation.class);
		cq.select(root);
		Query<Operation> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, Operation newOperation) {
		Session session = sessionFactory.getCurrentSession();
		Operation operation = session.byId(Operation.class).load(id);
		operation.setType(newOperation.getType());
		operation.setMontant(newOperation.getMontant());
		operation.setDate(newOperation.getDate());
		operation.setLibelle(newOperation.getLibelle());
		operation.setIdCompte(newOperation.getIdCompte());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Operation operation = session.byId(Operation.class).load(id);
		session.delete(operation);
	}
}
