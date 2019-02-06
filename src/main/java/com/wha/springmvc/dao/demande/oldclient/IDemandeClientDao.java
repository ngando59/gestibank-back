package com.wha.springmvc.dao.demande.oldclient;

import java.util.List;

import com.wha.springmvc.model.demande.newclient.DemandeClient;

public interface IDemandeClientDao {

	void save(DemandeClient demande);

	DemandeClient findOneById(long id);

	List<DemandeClient> findAll();

	void update(long id, DemandeClient newDemandeClient);

	void delete(long id);

}
