package com.wha.springmvc.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.demande.newclient.IDemandeCreationDeCompteDao;
import com.wha.springmvc.dao.user.IGuestDao;
import com.wha.springmvc.model.adresse.Adresse;
import com.wha.springmvc.model.demande.newclient.DemandeCreationDeCompte;
import com.wha.springmvc.model.user.Guest;
import com.wha.springmvc.service.user.IGuestService;
import com.wha.springmvc.utils.Commons;
import com.wha.springmvc.utils.Reponse;

@Service
@Transactional
public class GuestServiceImpl implements IGuestService {

	@Autowired
	private IGuestDao daoGuest;

	@Autowired
	private IDemandeCreationDeCompteDao daoCreationDeCompte;

	@Override
	public long save(Guest guest) {
		daoGuest.save(guest);
		return guest.getId();
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
	public long login(String email, String password) {
		Guest guest = daoGuest.findOneByMail(email);
		if (guest != null) {
			if (guest.getMotDePasse().equals(password)) {
				return guest.getId();
			}
		}
		return 0;
	}

	@Override
	public Reponse demandeCreationDeCompte(String motDePasse, String email, String nom, String prenom, String telephone,
			int nbEnfants, String situationMatrimoniale, String rue, String codePostal, String ville, String pays) {
		Guest guest = new Guest(motDePasse, email, nom, prenom, telephone, nbEnfants, situationMatrimoniale);
		Adresse adresse = new Adresse(rue, codePostal, ville, pays);
		DemandeCreationDeCompte demandeCreationDeCompte = new DemandeCreationDeCompte();

		// Vérification que Guest n'a pas déjà un compte
		Guest guestCheck = daoGuest.findOneByMail(email);
		if (guestCheck != null) {
			return Reponse.ALREADY;
		}
		guest.setAdresse(adresse);
		demandeCreationDeCompte.setGuest(guest);
		demandeCreationDeCompte.setNumero(Commons.generate(7));
		if (daoCreationDeCompte.save(demandeCreationDeCompte) != -1) {
			return Reponse.SUCCESS;
		}

		return Reponse.FAILURE;
	}

}
