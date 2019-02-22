package com.wha.springmvc.dao.adresse.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wha.springmvc.dao.adresse.IAdresseDao;
import com.wha.springmvc.model.adresse.Adresse;

@Repository
public class AdresseDaoImpl implements IAdresseDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Adresse adresse) {
		sessionFactory.getCurrentSession().save(adresse);
	}

	@Override
	public Adresse findOneById(long id) {
		return sessionFactory.getCurrentSession().get(Adresse.class, id);
	}

	@Override
	public List<Adresse> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Adresse> cq = cb.createQuery(Adresse.class);
		Root<Adresse> root = cq.from(Adresse.class);
		cq.select(root);
		Query<Adresse> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, Adresse newAdresse) {
		Session session = sessionFactory.getCurrentSession();
		Adresse adresse = session.byId(Adresse.class).load(id);
		adresse.setRue(newAdresse.getRue());
		adresse.setCodePostal(newAdresse.getCodePostal());
		adresse.setVille(newAdresse.getVille());
		adresse.setPays(newAdresse.getPays());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Adresse adresse = session.byId(Adresse.class).load(id);
		session.delete(adresse);
	}
}
