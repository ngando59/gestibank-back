package com.wha.springmvc.service.demande.oldclient;

import java.util.List;

import com.wha.springmvc.model.adresse.Adresse;
import com.wha.springmvc.model.demande.oldclient.DemandeClient;

public interface IDemandeClientService {
	void save(DemandeClient demandeClient);

	Adresse findOneById(long id);

	List<DemandeClient> findAll();

	void update(long id, DemandeClient demandeClient);

	void delete(long id);
}
