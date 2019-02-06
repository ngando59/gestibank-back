package com.wha.springmvc.dao.demande.oldclient.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.wha.springmvc.dao.demande.oldclient.IDemandeClientDao;
import com.wha.springmvc.model.demande.newclient.DemandeClient;

public class DemandeClientDaoImpl implements IDemandeClientDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(DemandeClient demande) {
		sessionFactory.getCurrentSession().save(demande);
	}

	@Override
	public DemandeClient findOneById(long id) {
		return sessionFactory.getCurrentSession().get(DemandeClient.class, id);
	}

	@Override
	public List<DemandeClient> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<DemandeClient> cq = cb.createQuery(DemandeClient.class);
		Root<DemandeClient> root = cq.from(DemandeClient.class);
		cq.select(root);
		Query<DemandeClient> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, DemandeClient newDemandeClient) {
		Session session = sessionFactory.getCurrentSession();
		DemandeClient demande = session.byId(DemandeClient.class).load(id);
		demande.setDateDemande(newDemandeClient.getDateDemande());
		demande.setTypeDemande(newDemandeClient.getTypeDemande());
		demande.setIdClient(newDemandeClient.getIdClient());
		demande.setIdAgent(newDemandeClient.getIdAgent());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		DemandeClient demande = session.byId(DemandeClient.class).load(id);
		session.delete(demande);
	}
}
