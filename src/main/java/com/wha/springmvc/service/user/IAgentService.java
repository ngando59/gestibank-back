package com.wha.springmvc.service.user;

import java.util.List;

import com.wha.springmvc.model.compte.Compte;
import com.wha.springmvc.model.demande.newclient.DemandeCreationDeCompte;
import com.wha.springmvc.model.demande.oldclient.DemandeChequier;
import com.wha.springmvc.model.user.Agent;
import com.wha.springmvc.model.user.Client;

public interface IAgentService extends IUserService {
	long save(Agent agent);

	Agent findOneById(long id);

	List<Agent> findAll();

	void update(long id, Agent agent);

	void delete(long id);

	List<Compte> chercherCompteParNom(String nom);

	Compte chercherCompteParRib(String rib);

	boolean updateCompte(Compte compte);

	boolean updateClient(Client client);

	Compte createCompte(Compte compte);

	Client chercherClientParCompte(Compte compte);

	List<Client> chercherClientParNom(String nom);

	List<DemandeCreationDeCompte> listeDemandeDeCreationDeCompte(long idAgent);

	boolean validerDemandeChequier(DemandeChequier demandeChequier);

	boolean validerDemandeCreationDeCompte(long idDemandeCreationDeCompte);

}
