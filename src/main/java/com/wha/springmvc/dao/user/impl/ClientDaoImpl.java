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

import com.wha.springmvc.dao.user.IClientDao;
import com.wha.springmvc.model.user.Client;

@Repository
public class ClientDaoImpl implements IClientDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Client client) {
		sessionFactory.getCurrentSession().save(client);
		return client.getId();
	}

	@Override
	public Client findOneById(long id) {
		return sessionFactory.getCurrentSession().get(Client.class, id);
	}

	@Override
	public List<Client> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Client> cq = cb.createQuery(Client.class);
		Root<Client> root = cq.from(Client.class);
		cq.select(root);
		Query<Client> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, Client client) {
		Session session = sessionFactory.getCurrentSession();
		Client client2 = session.byId(Client.class).load(id);
		client2.setIdentifiant(client.getIdentifiant());
		client2.setMotDePasse(client.getMotDePasse());
		client2.setEmail(client.getEmail());
		client2.setNom(client.getNom());
		client2.setPrenom(client.getPrenom());
		client2.setTelephone(client.getTelephone());
		client2.setType(client.getType());
		client2.setAdresse(client.getAdresse());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Client client = session.byId(Client.class).load(id);
		session.delete(client);
	}

}
