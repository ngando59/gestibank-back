package com.wha.springmvc.dao.user;

import java.util.List;

import com.wha.springmvc.model.demande.newclient.DemandeCreationDeCompte;
import com.wha.springmvc.model.user.Agent;

public interface IAgentDao {
	long save(Agent agent);

	Agent findOneById(long id);

	List<Agent> findAll();

	void update(long id, Agent agent);

	void delete(long id);

	List<Agent> rechercherAgentParNom(String nom);

	Agent rechercherAgentParMatricule(String matricule);

	List<DemandeCreationDeCompte> listeDemandeDeCreationDeCompte(long idAgent);
}
