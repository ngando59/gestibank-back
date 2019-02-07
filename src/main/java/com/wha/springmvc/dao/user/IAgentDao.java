package com.wha.springmvc.dao.user;

import java.util.List;

import com.wha.springmvc.model.compte.Compte;
import com.wha.springmvc.model.user.Agent;
import com.wha.springmvc.model.user.Client;

public interface IAgentDao {
	long save(Agent agent);

	Agent findOneById(long id);

	List<Agent> findAll();

	void update(long id, Agent agent);

	void delete(long id);
	
	Client chercherClientParCompte(Compte compte);
	
	List<Client> chercherClientParNom(String nom);
}
