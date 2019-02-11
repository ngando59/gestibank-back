package com.wha.springmvc.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.demande.newclient.IDemandeCreationDeCompteDao;
import com.wha.springmvc.dao.user.IGuestDao;
import com.wha.springmvc.model.demande.newclient.DemandeCreationDeCompte;
import com.wha.springmvc.model.demande.newclient.Document;
import com.wha.springmvc.model.user.Guest;
import com.wha.springmvc.service.user.IGuestService;

@Service
@Transactional
public class GuestServiceImpl implements IGuestService {

	@Autowired
	private IGuestDao daoGuest;

	@Autowired
	private IDemandeCreationDeCompteDao daoCreationDeCompte;

	@Override
	public void save(Guest guest) {
		daoGuest.save(guest);
	}

	@Override
	public Guest findOneById(long id) {
		return daoGuest.findOneById(id);
	}

	@Override
	public List<Guest> findAll() {
		return daoGuest.findAll();
	}

	@Override
	public void update(long id, Guest guest) {
		daoGuest.update(id, guest);
	}

	@Override
	public void delete(long id) {
		daoGuest.delete(id);
	}

	@Override
	public long demandeCreationDeCompte(long idGuest, DemandeCreationDeCompte demande, List<Document> documents) {
		Guest guest = daoGuest.findOneById(idGuest);
		demande.setDocuments(documents);
		demande.setGuest(guest);
		long id = daoCreationDeCompte.save(demande);
		return id;
	}

}
