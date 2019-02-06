package com.wha.springmvc.dao.demande.oldclient;

import java.util.List;

import com.wha.springmvc.model.demande.oldclient.DemandeCarte;

public interface IDemandeCarteDao {

	void save(DemandeCarte demande);

	DemandeCarte findOneById(long id);

	List<DemandeCarte> findAll();

	void update(long id, DemandeCarte newDemandeCarte);

	void delete(long id);

}
