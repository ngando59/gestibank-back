package com.wha.springmvc.service.user;

import java.util.List;

import com.wha.springmvc.model.user.Utilisateur;

public interface IUserService {
	void save(Utilisateur utilisateur);

	Utilisateur findOneById(long id);

	List<Utilisateur> findAll();

	void update(long id, Utilisateur utilisateur);

	void delete(long id);
}
