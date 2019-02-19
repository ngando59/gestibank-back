package com.wha.springmvc.service.user.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.compte.ICompteCourantDao;
import com.wha.springmvc.dao.demande.newclient.IDemandeCreationDeCompteDao;
import com.wha.springmvc.dao.user.IAgentDao;
import com.wha.springmvc.dao.user.IClientDao;
import com.wha.springmvc.model.compte.Compte;
import com.wha.springmvc.model.compte.CompteCourant;
import com.wha.springmvc.model.demande.newclient.DemandeCreationDeCompte;
import com.wha.springmvc.model.demande.oldclient.DemandeChequier;
import com.wha.springmvc.model.user.Agent;
import com.wha.springmvc.model.user.Client;
import com.wha.springmvc.model.user.Guest;
import com.wha.springmvc.service.user.IAgentService;
import com.wha.springmvc.utils.Commons;

@Service
@Transactional
public class AgentServiceImpl implements IAgentService {

	@Autowired
	private IAgentDao dao;

	@Autowired
	private IClientDao clientDao;

	// @Autowired
	// private IGuestDao guestDao;

	@Autowired
	private IDemandeCreationDeCompteDao demandeDao;

	@Autowired
	private ICompteCourantDao compteDao;

	@Override
	public long save(Agent agent) {
		dao.save(agent);
		return agent.getId();
	}

	@Override
	public Agent findOneById(long id) {
		return dao.findOneById(id);
	}

	@Override
	public List<Agent> findAll() {
		return dao.findAll();
	}

	@Override
	public void update(long id, Agent agent) {
		dao.update(id, agent);
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<Compte> chercherCompteParNom(String nom) {
		return null;
	}

	@Override
	public Compte chercherCompteParRib(String rib) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCompte(Compte compte) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateClient(Client client) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Compte createCompte(Compte compte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client chercherClientParCompte(Compte compte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> chercherClientParNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validerDemandeChequier(DemandeChequier demandeChequier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validerDemandeCreationDeCompte(long idDemandeCreationDeCompte) {
		System.out.println("idDemande:" + idDemandeCreationDeCompte);
		DemandeCreationDeCompte demande = demandeDao.findOneById(idDemandeCreationDeCompte);
		Guest guest = demande.getGuest();
		Client client = new Client();
		client.setIdentifiant(guest.getIdentifiant());
		client.setMotDePasse(guest.getMotDePasse());
		client.setEmail(guest.getEmail());
		client.setNom(guest.getNom());
		client.setPrenom(guest.getPrenom());
		client.setTelephone(guest.getTelephone());
		client.setAdresse(guest.getAdresse());
		clientDao.save(client);
		CompteCourant compte = new CompteCourant();
		compte.setClient(client);
		compte.setDateCreation(new Date());
		compteDao.save(compte);
		compte.setRib(Commons.generate(16) + compte.getId());
		compteDao.update(compte.getId(), compte);

		return true;
	}

	@Override
	public List<DemandeCreationDeCompte> listeDemandeDeCreationDeCompte(long idAgent) {
		return dao.listeDemandeDeCreationDeCompte(idAgent);
	}

}
