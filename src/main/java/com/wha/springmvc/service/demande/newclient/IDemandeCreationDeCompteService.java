package com.wha.springmvc.service.demande.newclient;

import java.util.List;

import com.wha.springmvc.model.demande.newclient.DemandeCreationDeCompte;

public interface IDemandeCreationDeCompteService {
	long save(DemandeCreationDeCompte demandeCreationDeCompte);

	DemandeCreationDeCompte findOneById(long id);

	List<DemandeCreationDeCompte> findAll();

	void update(long id, DemandeCreationDeCompte demandeCreationDeCompte);

	void delete(long id);
}
