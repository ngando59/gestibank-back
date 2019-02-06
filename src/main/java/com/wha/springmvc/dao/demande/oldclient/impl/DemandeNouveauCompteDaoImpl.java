package com.wha.springmvc.dao.demande.oldclient.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.wha.springmvc.dao.demande.oldclient.IDemandeNouveauCompteDao;
import com.wha.springmvc.model.demande.oldclient.DemandeNouveauCompte;

public class DemandeNouveauCompteDaoImpl implements IDemandeNouveauCompteDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(DemandeNouveauCompte demande) {
		sessionFactory.getCurrentSession().save(demande);
	}

	@Override
	public DemandeNouveauCompte findOneById(long id) {
		return sessionFactory.getCurrentSession().get(DemandeNouveauCompte.class, id);
	}

	@Override
	public List<DemandeNouveauCompte> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<DemandeNouveauCompte> cq = cb.createQuery(DemandeNouveauCompte.class);
		Root<DemandeNouveauCompte> root = cq.from(DemandeNouveauCompte.class);
		cq.select(root);
		Query<DemandeNouveauCompte> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, DemandeNouveauCompte newDemandeNouveauCompte) {
		Session session = sessionFactory.getCurrentSession();
		DemandeNouveauCompte demande = session.byId(DemandeNouveauCompte.class).load(id);
		demande.setDateDemande(newDemandeNouveauCompte.getDateDemande());
		demande.setTypeDemande(newDemandeNouveauCompte.getTypeDemande());
		demande.setIdClient(newDemandeNouveauCompte.getIdClient());
		demande.setIdAgent(newDemandeNouveauCompte.getIdAgent());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		DemandeNouveauCompte demande = session.byId(DemandeNouveauCompte.class).load(id);
		session.delete(demande);
	}
}
