package com.wha.springmvc.dao.demande.oldclient;

import java.util.List;

import com.wha.springmvc.model.demande.oldclient.DemandeNouveauCompte;

public interface IDemandeNouveauCompteDao {

	void save(DemandeNouveauCompte demande);

	DemandeNouveauCompte findOneById(long id);

	List<DemandeNouveauCompte> findAll();

	void update(long id, DemandeNouveauCompte newDemandeNouveauCompte);

	void delete(long id);

}
