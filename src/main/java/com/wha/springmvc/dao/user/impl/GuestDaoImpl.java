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

import com.wha.springmvc.dao.user.IGuestDao;
import com.wha.springmvc.model.user.Guest;

@Repository
public class GuestDaoImpl implements IGuestDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Guest guest) {
		sessionFactory.getCurrentSession().save(guest);
		return guest.getId();
	}

	@Override
	public Guest findOneById(long id) {
		return sessionFactory.getCurrentSession().get(Guest.class, id);
	}

	@Override
	public List<Guest> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Guest> cq = cb.createQuery(Guest.class);
		Root<Guest> root = cq.from(Guest.class);
		cq.select(root);
		Query<Guest> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, Guest guest) {
		Session session = sessionFactory.getCurrentSession();
		Guest guest2 = session.byId(Guest.class).load(id);
		guest2.setIdentifiant(guest.getIdentifiant());
		guest2.setMotDePasse(guest.getMotDePasse());
		guest2.setEmail(guest.getEmail());
		guest2.setNom(guest.getNom());
		guest2.setPrenom(guest.getPrenom());
		guest2.setTelephone(guest.getTelephone());
		guest2.setType(guest.getType());
		guest2.setAdresse(guest.getAdresse());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Guest guest = session.byId(Guest.class).load(id);
		session.delete(guest);
	}

}
