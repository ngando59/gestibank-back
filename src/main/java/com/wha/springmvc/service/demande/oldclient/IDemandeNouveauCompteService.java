package com.wha.springmvc.service.demande.oldclient;

import java.util.List;

import com.wha.springmvc.model.demande.oldclient.DemandeNouveauCompte;

public interface IDemandeNouveauCompteService {
	void save(DemandeNouveauCompte demandeClient);

	DemandeNouveauCompte findOneById(long id);

	List<DemandeNouveauCompte> findAll();

	void update(long id, DemandeNouveauCompte demandeClient);

	void delete(long id);
}
