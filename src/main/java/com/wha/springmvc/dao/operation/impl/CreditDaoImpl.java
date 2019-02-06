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

import com.wha.springmvc.dao.operation.ICreditDao;
import com.wha.springmvc.model.operation.Credit;

@Repository
public class CreditDaoImpl implements ICreditDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Credit operation) {
		sessionFactory.getCurrentSession().save(operation);
	}

	@Override
	public Credit findOneById(long id) {
		return sessionFactory.getCurrentSession().get(Credit.class, id);
	}

	@Override
	public List<Credit> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Credit> cq = cb.createQuery(Credit.class);
		Root<Credit> root = cq.from(Credit.class);
		cq.select(root);
		Query<Credit> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, Credit newCredit) {
		Session session = sessionFactory.getCurrentSession();
		Credit operation = session.byId(Credit.class).load(id);
		operation.setType(newCredit.getType());
		operation.setMontant(newCredit.getMontant());
		operation.setDate(newCredit.getDate());
		operation.setLibelle(newCredit.getLibelle());
		operation.setIdCompte(newCredit.getIdCompte());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Credit operation = session.byId(Credit.class).load(id);
		session.delete(operation);
	}
}
