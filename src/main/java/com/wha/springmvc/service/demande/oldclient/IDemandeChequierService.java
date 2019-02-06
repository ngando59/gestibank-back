package com.wha.springmvc.service.demande.oldclient;

import java.util.List;

import com.wha.springmvc.model.demande.oldclient.DemandeChequier;

public interface IDemandeChequierService {
	void save(DemandeChequier demandeClient);

	DemandeChequier findOneById(long id);

	List<DemandeChequier> findAll();

	void update(long id, DemandeChequier demandeClient);

	void delete(long id);
}
