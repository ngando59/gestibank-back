package com.wha.springmvc.service.user;

import java.util.Date;
import java.util.List;

import com.wha.springmvc.model.adresse.Adresse;
import com.wha.springmvc.model.compte.Compte;
import com.wha.springmvc.model.demande.newclient.DemandeCreationDeCompte;
import com.wha.springmvc.model.demande.oldclient.DemandeClient;
import com.wha.springmvc.model.operation.Operation;
import com.wha.springmvc.model.user.Admin;
import com.wha.springmvc.model.user.Agent;
import com.wha.springmvc.model.user.Client;
import com.wha.springmvc.model.user.TypeUtilisateur;

public interface IAdminService {
	void save(Admin admin);

	Admin findOneById(long id);

	List<Admin> findAll();

	void update(long id, Admin admin);

	void delete(long id);

	long createAgent(String identifiant, String motDePasse, String email, String nom, String prenom, String telephone,
			TypeUtilisateur type, Adresse adresse, String matricule, Date debutEmbauche);

	boolean affectationAgentToClient(Agent agent, Client client);

	boolean affectationOuvertureCompte(DemandeCreationDeCompte demande, Agent agent);

	List<DemandeCreationDeCompte> listeDemandesCreationCompte();

	List<DemandeCreationDeCompte> listeDemandesAffectees();

	List<DemandeCreationDeCompte> listeDemandesNonAffectees();

	Agent rechercherAgentParNom(String nom);

	Agent rechercherAgentParMatricule(String matricule);

	boolean updateAgent(Agent agent);

	boolean updateClient(Client client);

	boolean updateCompte(Compte compte);

	boolean updateOperation(Operation operation);

	boolean updateDemandeClient(DemandeClient demandeClient);

}
