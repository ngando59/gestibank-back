package com.wha.springmvc.dao.adresse;

import java.util.List;

import com.wha.springmvc.model.adresse.Adresse;

public interface IAdresseDao {

	void save(Adresse adresse);

	Adresse findOneById(long id);

	List<Adresse> findAll();

	void update(long id, Adresse newAdresse);

	void delete(long id);
}
