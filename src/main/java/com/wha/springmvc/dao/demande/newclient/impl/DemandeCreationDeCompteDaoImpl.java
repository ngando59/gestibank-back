package com.wha.springmvc.dao.demande.newclient.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wha.springmvc.dao.demande.newclient.IDemandeCreationDeCompteDao;
import com.wha.springmvc.model.demande.newclient.DemandeCreationDeCompte;

@Repository
@Transactional
public class DemandeCreationDeCompteDaoImpl implements IDemandeCreationDeCompteDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(DemandeCreationDeCompte demande) {
		sessionFactory.getCurrentSession().save(demande);
		return demande.getId();
	}

	@Override
	public DemandeCreationDeCompte findOneById(long id) {
		return sessionFactory.getCurrentSession().get(DemandeCreationDeCompte.class, id);
	}

	@Override
	public List<DemandeCreationDeCompte> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<DemandeCreationDeCompte> cq = cb.createQuery(DemandeCreationDeCompte.class);
		Root<DemandeCreationDeCompte> root = cq.from(DemandeCreationDeCompte.class);
		cq.select(root);
		Query<DemandeCreationDeCompte> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, DemandeCreationDeCompte newDemandeCreationDeCompte) {
		Session session = sessionFactory.getCurrentSession();
		DemandeCreationDeCompte demande = session.byId(DemandeCreationDeCompte.class).load(id);
		demande.setAgent(newDemandeCreationDeCompte.getAgent());
		demande.setDocuments(newDemandeCreationDeCompte.getDocuments());
		demande.setNumero(newDemandeCreationDeCompte.getNumero());
		demande.setGuest(newDemandeCreationDeCompte.getGuest());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		DemandeCreationDeCompte demande = session.byId(DemandeCreationDeCompte.class).load(id);
		session.delete(demande);
	}

	@Override
	public List<DemandeCreationDeCompte> listeDemandesAffectees() {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "select * from demandecreationdecompte where idAgent is not null";
		List<DemandeCreationDeCompte> result = session.createNativeQuery(sqlQuery, DemandeCreationDeCompte.class)
				.getResultList();
		return result;
	}

	@Override
	public List<DemandeCreationDeCompte> listeDemandesNonAffectees() {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "select * from demandecreationdecompte where idAgent is null";
		List<DemandeCreationDeCompte> result = session.createNativeQuery(sqlQuery, DemandeCreationDeCompte.class)
				.getResultList();
		return result;
	}
}
