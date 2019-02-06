package com.wha.springmvc.dao.user;

import java.util.List;

import com.wha.springmvc.model.user.Utilisateur;

public interface IUtilisateurDao {

	void save(Utilisateur utilisateur);

	Utilisateur findOneById(long id);

	List<Utilisateur> findAll();

	void update(long id, Utilisateur utilisateur);

	void delete(long id);
}
