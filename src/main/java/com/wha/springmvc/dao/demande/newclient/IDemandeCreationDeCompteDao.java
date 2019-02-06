package com.wha.springmvc.dao.demande.newclient;

import java.util.List;

import com.wha.springmvc.model.demande.oldclient.DemandeCreationDeCompte;

public interface IDemandeCreationDeCompteDao {

	void save(DemandeCreationDeCompte demande);

	DemandeCreationDeCompte findOneById(long id);

	List<DemandeCreationDeCompte> findAll();

	void update(long id, DemandeCreationDeCompte newDemandeCreationDeCompte);

	void delete(long id);

}
