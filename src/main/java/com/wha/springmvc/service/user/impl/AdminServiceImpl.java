package com.wha.springmvc.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.demande.newclient.IDemandeCreationDeCompteDao;
import com.wha.springmvc.dao.user.IAdminDao;
import com.wha.springmvc.dao.user.IAgentDao;
import com.wha.springmvc.dao.user.IClientDao;
import com.wha.springmvc.model.compte.Compte;
import com.wha.springmvc.model.demande.newclient.DemandeCreationDeCompte;
import com.wha.springmvc.model.demande.oldclient.DemandeClient;
import com.wha.springmvc.model.operation.Operation;
import com.wha.springmvc.model.user.Admin;
import com.wha.springmvc.model.user.Agent;
import com.wha.springmvc.model.user.Client;
import com.wha.springmvc.service.user.IAdminService;
import com.wha.springmvc.utils.Commons;
import com.wha.springmvc.utils.Reponse;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminDao daoAdmin;

	@Autowired
	private IAgentDao daoAgent;

	@Autowired
	private IClientDao daoClient;

	@Autowired
	private IDemandeCreationDeCompteDao daoCreationDeCompte;

	@Override
	public long save(Admin admin) {
		daoAdmin.save(admin);
		return admin.getId();
	}

	@Override
	public Admin findOneById(long id) {
		return daoAdmin.findOneById(id);
	}

	@Override
	public List<Admin> findAll() {
		return daoAdmin.findAll();
	}

	@Override
	public void update(long id, Admin admin) {
		daoAdmin.update(id, admin);
	}

	@Override
	public void delete(long id) {
		daoAdmin.delete(id);
	}

	/**
	 * Creation d'un Agent
	 */
	@Override
	public Reponse createAgent(Agent agent) {
		// Vérification que Agent n'a pas déjà un compte
		Agent agentCheck = daoAgent.findOneByMail(agent.getEmail());
		if (agentCheck != null) {
			return Reponse.ALREADY;
		}

		String matricule = "A" + Commons.generateNumber(5);
		agent.setMatricule(matricule);

		if (daoAgent.save(agent) != -1) {
			return Reponse.SUCCESS;
		}

		return Reponse.FAILURE;
	}

	/**
	 * Liste des demande d'ouverture de compte
	 */
	@Override
	public List<DemandeCreationDeCompte> listeDemandesCreationCompte() {
		return daoCreationDeCompte.findAll();
	}

	/**
	 * Affectation de demande d'ouverture de compte à un agent
	 */
	@Override
	public void affectationOuvertureCompte(long idDemande, long idAgent) {
		Agent agent = daoAgent.findOneById(idAgent);
		DemandeCreationDeCompte demande = daoCreationDeCompte.findOneById(idDemande);
		agent.addDemandeCreationDeCompte(demande);
		demande.setAgent(agent);
		daoAgent.update(agent.getId(), agent);
		daoCreationDeCompte.update(demande.getId(), demande);
	}

	/**
	 * affecte un client à un agent
	 */
	@Override
	public void affectationClientToAgent(long idAgent, long idClient) {
		Agent agent = daoAgent.findOneById(idAgent);
		Client client = daoClient.findOneById(idClient);
		agent.addClient(client);
		client.setAgent(agent);
		daoAgent.update(agent.getId(), agent);
		daoClient.update(client.getId(), client);
	}

	/**
	 * liste des demandes affectées à un agent
	 */
	@Override
	public List<DemandeCreationDeCompte> listeDemandesAffectees() {
		return daoCreationDeCompte.listeDemandesAffectees();
	}

	/**
	 * liste des demandes non affectées à un agent
	 */
	@Override
	public List<DemandeCreationDeCompte> listeDemandesNonAffectees() {
		return daoCreationDeCompte.listeDemandesNonAffectees();
	}

	/**
	 * Recherche d'un agent par son nom
	 */
	@Override
	public List<Agent> rechercherAgentParNom(String nom) {
		return daoAgent.rechercherAgentParNom(nom);
	}

	@Override
	public Agent rechercherAgentParMatricule(String matricule) {
		return daoAgent.rechercherAgentParMatricule(matricule);
	}

	@Override
	public void updateAgent(Agent agent) {
		daoAgent.update(agent.getId(), agent);
	}

	@Override
	public void updateClient(Client client) {
		daoClient.update(client.getId(), client);
	}

	@Override
	public void updateCompte(Compte compte) {

	}

	@Override
	public void updateOperation(Operation operation) {

	}

	@Override
	public void updateDemandeClient(DemandeClient demandeClient) {

	}

	@Override
	public long login(String email, String password) {
		Admin admin = daoAdmin.findOneByMail(email);
		if (admin != null) {
			if (admin.getMotDePasse().equals(password)) {
				return admin.getId();
			}
		}
		return 0;
	}

}
