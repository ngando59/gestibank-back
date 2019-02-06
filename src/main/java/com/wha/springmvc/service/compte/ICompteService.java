package com.wha.springmvc.service.compte;

import java.util.List;

import com.wha.springmvc.model.compte.Compte;

public interface ICompteService {
	void save(Compte compte);

	Compte findOneById(long id);

	List<Compte> findAll();

	void update(long id, Compte compte);

	void delete(long id);
}
