package com.wha.springmvc.service.compte;

import java.util.List;

import com.wha.springmvc.model.compte.CompteRemunere;

public interface ICompteRemunereService {
	void save(CompteRemunere compte);

	CompteRemunere findOneById(long id);

	List<CompteRemunere> findAll();

	void update(long id, CompteRemunere newCompte);

	void delete(long id);
}
