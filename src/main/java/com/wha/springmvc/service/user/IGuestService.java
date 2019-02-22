package com.wha.springmvc.service.user;

import java.util.List;

import com.wha.springmvc.model.user.Guest;
import com.wha.springmvc.utils.Reponse;

public interface IGuestService extends IUserService {
	long save(Guest guest);

	Guest findOneById(long id);

	List<Guest> findAll();

	void update(long id, Guest guest);

	void delete(long id);

	Reponse demandeCreationDeCompte(String motDePasse, String email, String nom, String prenom, String telephone,
			int nbEnfants, String situationMatrimoniale, String rue, String codePostal, String ville, String pays);

}
