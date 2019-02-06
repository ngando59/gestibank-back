package com.wha.springmvc.dao.demande.oldclient;

import java.util.List;

import com.wha.springmvc.model.demande.oldclient.DemandeChequier;

public interface IDemandeChequierDao {

	void save(DemandeChequier demande);

	DemandeChequier findOneById(long id);

	List<DemandeChequier> findAll();

	void update(long id, DemandeChequier newDemandeChequier);

	void delete(long id);

}
