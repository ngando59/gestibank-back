package com.wha.springmvc.service.compte;

import java.util.List;

import com.wha.springmvc.model.compte.CompteCourant;

public interface ICompteCourantService {
	void save(CompteCourant compte);

	CompteCourant findOneById(long id);

	List<CompteCourant> findAll();

	void update(long id, CompteCourant newCompte);

	void delete(long id);
}
