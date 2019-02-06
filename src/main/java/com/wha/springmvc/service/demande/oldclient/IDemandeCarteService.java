package com.wha.springmvc.service.demande.oldclient;

import java.util.List;

import com.wha.springmvc.model.demande.oldclient.DemandeCarte;

public interface IDemandeCarteService {
	void save(DemandeCarte demandeClient);

	DemandeCarte findOneById(long id);

	List<DemandeCarte> findAll();

	void update(long id, DemandeCarte demandeClient);

	void delete(long id);
}
