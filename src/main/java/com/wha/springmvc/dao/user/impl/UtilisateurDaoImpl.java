package com.wha.springmvc.dao.user.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wha.springmvc.dao.user.IUtilisateurDao;
import com.wha.springmvc.model.user.Utilisateur;

@Repository
public class UtilisateurDaoImpl implements IUtilisateurDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Utilisateur utilisateur) {
		sessionFactory.getCurrentSession().save(utilisateur);
	}

	@Override
	public Utilisateur findOneById(long id) {
		return sessionFactory.getCurrentSession().get(Utilisateur.class, id);
	}

	@Override
	public List<Utilisateur> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Utilisateur> cq = cb.createQuery(Utilisateur.class);
		Root<Utilisateur> root = cq.from(Utilisateur.class);
		cq.select(root);
		Query<Utilisateur> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, Utilisateur utilisateur) {
		Session session = sessionFactory.getCurrentSession();
		Utilisateur u = session.byId(Utilisateur.class).load(id);
		u.setIdentifiant(utilisateur.getIdentifiant());
		u.setMotDePasse(utilisateur.getMotDePasse());
		u.setEmail(utilisateur.getEmail());
		u.setNom(utilisateur.getNom());
		u.setPrenom(utilisateur.getPrenom());
		u.setTelephone(utilisateur.getTelephone());
		u.setType(utilisateur.getType());
		u.setAdresse(utilisateur.getAdresse());
		u.setNotifications(utilisateur.getNotifications());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Utilisateur utilisateur = session.byId(Utilisateur.class).load(id);
		session.delete(utilisateur);
	}

}
