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

import com.wha.springmvc.dao.operation.IDeditDao;
import com.wha.springmvc.model.operation.Debit;

@Repository
public class DeditDaoImpl implements IDeditDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Debit operation) {
		sessionFactory.getCurrentSession().save(operation);
	}

	@Override
	public Debit findOneById(long id) {
		return sessionFactory.getCurrentSession().get(Debit.class, id);
	}

	@Override
	public List<Debit> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Debit> cq = cb.createQuery(Debit.class);
		Root<Debit> root = cq.from(Debit.class);
		cq.select(root);
		Query<Debit> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, Debit newDebit) {
		Session session = sessionFactory.getCurrentSession();
		Debit operation = session.byId(Debit.class).load(id);
		operation.setType(newDebit.getType());
		operation.setMontant(newDebit.getMontant());
		operation.setDate(newDebit.getDate());
		operation.setLibelle(newDebit.getLibelle());
		operation.setIdCompte(newDebit.getIdCompte());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Debit operation = session.byId(Debit.class).load(id);
		session.delete(operation);
	}
}
