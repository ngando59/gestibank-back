package com.wha.springmvc.service.adresse;

import java.util.List;

import com.wha.springmvc.model.adresse.Adresse;

public interface IAdresseService {
	long save(Adresse adresse);

	Adresse findOneById(long id);

	List<Adresse> findAll();

	void update(long id, Adresse newAdresse);

	void delete(long id);

}
