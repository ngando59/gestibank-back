package com.wha.springmvc.dao.compte;

import java.util.List;

import com.wha.springmvc.model.compte.CompteRemunere;

public interface ICompteRemunereDao {
	void save(CompteRemunere compte);

	CompteRemunere findOneById(long id);

	List<CompteRemunere> findAll();

	void update(long id, CompteRemunere newCompte);

	void delete(long id);
}
