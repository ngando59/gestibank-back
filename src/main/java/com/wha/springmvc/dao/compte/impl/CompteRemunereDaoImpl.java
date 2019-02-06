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

import com.wha.springmvc.dao.compte.ICompteRemunereDao;
import com.wha.springmvc.model.compte.CompteRemunere;

@Repository
public class CompteRemunereDaoImpl implements ICompteRemunereDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(CompteRemunere compte) {
		sessionFactory.getCurrentSession().save(compte);
	}

	@Override
	public CompteRemunere findOneById(long id) {
		return sessionFactory.getCurrentSession().get(CompteRemunere.class, id);
	}

	@Override
	public List<CompteRemunere> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<CompteRemunere> cq = cb.createQuery(CompteRemunere.class);
		Root<CompteRemunere> root = cq.from(CompteRemunere.class);
		cq.select(root);
		Query<CompteRemunere> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, CompteRemunere newCompte) {
		Session session = sessionFactory.getCurrentSession();
		CompteRemunere compte = session.byId(CompteRemunere.class).load(id);
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
		CompteRemunere compte = session.byId(CompteRemunere.class).load(id);
		session.delete(compte);
	}
}
