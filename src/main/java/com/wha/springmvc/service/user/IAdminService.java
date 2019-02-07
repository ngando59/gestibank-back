package com.wha.springmvc.service.user;

import java.util.List;

import com.wha.springmvc.model.compte.Compte;
import com.wha.springmvc.model.demande.newclient.DemandeCreationDeCompte;
import com.wha.springmvc.model.demande.oldclient.DemandeClient;
import com.wha.springmvc.model.operation.Operation;
import com.wha.springmvc.model.user.Admin;
import com.wha.springmvc.model.user.Agent;
import com.wha.springmvc.model.user.Client;

public interface IAdminService {
	void save(Admin admin);

	Admin findOneById(long id);

	List<Admin> findAll();

	void update(long id, Admin admin);

	void delete(long id);

	long createAgent(Agent agent);

	void affectationClientToAgent(long idAgent, long idClient);

	void affectationOuvertureCompte(long idDemande, long idAgent);

	List<DemandeCreationDeCompte> listeDemandesCreationCompte();

	List<DemandeCreationDeCompte> listeDemandesAffectees();

	List<DemandeCreationDeCompte> listeDemandesNonAffectees();

	Agent rechercherAgentParNom(String nom);

	Agent rechercherAgentParMatricule(String matricule);

	void updateAgent(Agent agent);

	void updateClient(Client client);

	void updateCompte(Compte compte);

	void updateOperation(Operation operation);

	void updateDemandeClient(DemandeClient demandeClient);

}
