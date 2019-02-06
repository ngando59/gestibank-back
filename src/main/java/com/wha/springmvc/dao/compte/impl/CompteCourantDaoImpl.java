package com.wha.springmvc.dao.compte.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wha.springmvc.dao.compte.ICompteCourantDao;
import com.wha.springmvc.model.compte.CompteCourant;

@Repository
public class CompteCourantDaoImpl implements ICompteCourantDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(CompteCourant compte) {
		sessionFactory.getCurrentSession().save(compte);
	}

	@Override
	public CompteCourant findOneById(long id) {
		return sessionFactory.getCurrentSession().get(CompteCourant.class, id);
	}

	@Override
	public List<CompteCourant> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<CompteCourant> cq = cb.createQuery(CompteCourant.class);
		Root<CompteCourant> root = cq.from(CompteCourant.class);
		cq.select(root);
		Query<CompteCourant> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, CompteCourant newCompte) {
		Session session = sessionFactory.getCurrentSession();
		CompteCourant compte = session.byId(CompteCourant.class).load(id);
		compte.setRib(newCompte.getRib());
		compte.setTypeCompte(newCompte.getTypeCompte());
		compte.setDateCreation(newCompte.getDateCreation());
		compte.setClient(newCompte.getClient());
		compte.setOperations(newCompte.getOperations());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		CompteCourant compte = session.byId(CompteCourant.class).load(id);
		session.delete(compte);
	}
}
