package com.wha.springmvc.dao.demande.oldclient.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.wha.springmvc.dao.demande.oldclient.IDemandeChequierDao;
import com.wha.springmvc.model.demande.oldclient.DemandeChequier;

public class DemandeChequierDaoImpl implements IDemandeChequierDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(DemandeChequier demande) {
		sessionFactory.getCurrentSession().save(demande);
	}

	@Override
	public DemandeChequier findOneById(long id) {
		return sessionFactory.getCurrentSession().get(DemandeChequier.class, id);
	}

	@Override
	public List<DemandeChequier> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<DemandeChequier> cq = cb.createQuery(DemandeChequier.class);
		Root<DemandeChequier> root = cq.from(DemandeChequier.class);
		cq.select(root);
		Query<DemandeChequier> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, DemandeChequier newDemandeChequier) {
		Session session = sessionFactory.getCurrentSession();
		DemandeChequier demande = session.byId(DemandeChequier.class).load(id);
		demande.setDateDemande(newDemandeChequier.getDateDemande());
		demande.setTypeDemande(newDemandeChequier.getTypeDemande());
		demande.setIdClient(newDemandeChequier.getIdClient());
		demande.setIdAgent(newDemandeChequier.getIdAgent());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		DemandeChequier demande = session.byId(DemandeChequier.class).load(id);
		session.delete(demande);
	}
}
