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
	public void save(Admin admin) {
		daoAdmin.save(admin);
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
	 * Creer un Agent
	 */
	@Override
	public long createAgent(Agent agent) {
		return daoAgent.save(agent);
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

	@Override
	public void affectationOuvertureCompte(long idDemande, long idAgent) {
		Agent agent = daoAgent.findOneById(idAgent);
		DemandeCreationDeCompte demande = daoCreationDeCompte.findOneById(idDemande);
		agent.addDemandeCreationDeCompte(demande);
		demande.setAgent(agent);
		daoAgent.update(agent.getId(), agent);
		daoCreationDeCompte.update(demande.getId(), demande);
	}

	@Override
	public List<DemandeCreationDeCompte> listeDemandesCreationCompte() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DemandeCreationDeCompte> listeDemandesAffectees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DemandeCreationDeCompte> listeDemandesNonAffectees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agent rechercherAgentParNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agent rechercherAgentParMatricule(String matricule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAgent(Agent agent) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateClient(Client client) {

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

}
