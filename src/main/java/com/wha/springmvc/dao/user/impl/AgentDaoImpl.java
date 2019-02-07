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

import com.wha.springmvc.dao.user.IAgentDao;
import com.wha.springmvc.model.user.Agent;

@Repository
public class AgentDaoImpl implements IAgentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Agent agent) {
		sessionFactory.getCurrentSession().save(agent);
		return agent.getId();
	}

	@Override
	public Agent findOneById(long id) {
		return sessionFactory.getCurrentSession().get(Agent.class, id);
	}

	@Override
	public List<Agent> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Agent> cq = cb.createQuery(Agent.class);
		Root<Agent> root = cq.from(Agent.class);
		cq.select(root);
		Query<Agent> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(long id, Agent agent) {
		Session session = sessionFactory.getCurrentSession();
		Agent agent2 = session.byId(Agent.class).load(id);
		agent2.setIdentifiant(agent.getIdentifiant());
		agent2.setMotDePasse(agent.getMotDePasse());
		agent2.setEmail(agent.getEmail());
		agent2.setNom(agent.getNom());
		agent2.setPrenom(agent.getPrenom());
		agent2.setTelephone(agent.getTelephone());
		agent2.setType(agent.getType());
		agent2.setAdresse(agent.getAdresse());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Agent agent = session.byId(Agent.class).load(id);
		session.delete(agent);
	}

}
