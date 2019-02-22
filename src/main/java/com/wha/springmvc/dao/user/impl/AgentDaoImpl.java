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
import com.wha.springmvc.model.demande.newclient.DemandeCreationDeCompte;
import com.wha.springmvc.model.user.Agent;

@Repository
public class AgentDaoImpl implements IAgentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Agent agent) {
		return (long) sessionFactory.getCurrentSession().save(agent);
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
		agent2.setMotDePasse(agent.getMotDePasse());
		agent2.setEmail(agent.getEmail());
		agent2.setNom(agent.getNom());
		agent2.setPrenom(agent.getPrenom());
		agent2.setTelephone(agent.getTelephone());
		agent2.setAdresse(agent.getAdresse());
		agent2.setMatricule(agent.getMatricule());
		agent2.setDebutEmbauche(agent.getDebutEmbauche());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Agent agent = session.byId(Agent.class).load(id);
		session.delete(agent);
	}

	@Override
	public List<Agent> rechercherAgentParNom(String nom) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "select * from utilisateur where nom like '%" + nom + "%' and DTYPE = 'agent'";
		List<Agent> result = session.createNativeQuery(sqlQuery, Agent.class).getResultList();
		return result;
	}

	@Override
	public Agent rechercherAgentParMatricule(String matricule) {
		Session session = sessionFactory.getCurrentSession();
		Agent result = null;
		String sqlString = "select * from utilisateur where matricule = '" + matricule + "'";
		Query<Agent> query = session.createNativeQuery(sqlString, Agent.class);
		if (query.getResultList().size() != 0)
			result = query.getSingleResult();
		return result;
	}

	@Override
	public List<DemandeCreationDeCompte> listeDemandeDeCreationDeCompte(long idAgent) {
		Session session = sessionFactory.getCurrentSession();
		String sqlQuery = "select * from demandecreationdecompte where idAgent = " + idAgent;
		List<DemandeCreationDeCompte> result = session.createNativeQuery(sqlQuery, DemandeCreationDeCompte.class)
				.getResultList();
		return result;
	}

	@Override
	public Agent findOneByMail(String mail) {
		Session session = sessionFactory.getCurrentSession();
		Agent agent = null;
		String sqlString = "select * from utilisateur where email = '" + mail + "'";
		Query<Agent> query = session.createNativeQuery(sqlString, Agent.class);
		if (query.getResultList().size() != 0)
			agent = query.getSingleResult();
		return agent;
	}

}
