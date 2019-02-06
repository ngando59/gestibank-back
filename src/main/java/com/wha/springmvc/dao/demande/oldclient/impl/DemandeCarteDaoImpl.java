package com.wha.springmvc.dao.demande.oldclient.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.wha.springmvc.dao.demande.oldclient.IDemandeCarteDao;
import com.wha.springmvc.model.demande.oldclient.DemandeCarte;

public class DemandeCarteDaoImpl implements IDemandeCarteDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(DemandeCarte demande) {
		sessionFactory.getCurrentSession().save(demande);
	}

	@Override
	public DemandeCarte findOneById(long id) {
		return sessionFactory.getCurrentSession().get(DemandeCarte.class, id);
	}

	@Override
	public List<DemandeCarte> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<DemandeCarte> cq = cb.createQuery(DemandeCarte.class);
		Root<DemandeCarte> root = cq.from(DemandeCarte.class);
		cq.select(root);
		Query<DemandeCarte> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, DemandeCarte newDemandeCarte) {
		Session session = sessionFactory.getCurrentSession();
		DemandeCarte demande = session.byId(DemandeCarte.class).load(id);
		demande.setDateDemande(newDemandeCarte.getDateDemande());
		demande.setTypeDemande(newDemandeCarte.getTypeDemande());
		demande.setIdClient(newDemandeCarte.getIdClient());
		demande.setIdAgent(newDemandeCarte.getIdAgent());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		DemandeCarte demande = session.byId(DemandeCarte.class).load(id);
		session.delete(demande);
	}
}
