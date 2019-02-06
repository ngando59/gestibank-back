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

import com.wha.springmvc.dao.compte.ICompteDAO;
import com.wha.springmvc.model.compte.Compte;

@Repository
public class CompteDaoImpl implements ICompteDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Compte compte) {
		sessionFactory.getCurrentSession().save(compte);
	}

	@Override
	public Compte findOneById(long id) {
		return sessionFactory.getCurrentSession().get(Compte.class, id);
	}

	@Override
	public List<Compte> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Compte> cq = cb.createQuery(Compte.class);
		Root<Compte> root = cq.from(Compte.class);
		cq.select(root);
		Query<Compte> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, Compte newCompte) {
		Session session = sessionFactory.getCurrentSession();
		Compte compte = session.byId(Compte.class).load(id);
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
		Compte compte = session.byId(Compte.class).load(id);
		session.delete(compte);
	}
}
