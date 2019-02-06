package com.wha.springmvc.dao.compte;

import java.util.List;

import com.wha.springmvc.model.compte.Compte;

public interface ICompteDAO {
	
	void save(Compte compte);

	Compte findOneById(long id);

	List<Compte> findAll();

	void update(long id, Compte newCompte);

	void delete(long id);

}
