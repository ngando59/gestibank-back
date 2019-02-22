package com.wha.springmvc.dao.user;

import java.util.List;

import com.wha.springmvc.model.user.Guest;

public interface IGuestDao {
	long save(Guest client);

	Guest findOneById(long id);

	Guest findOneByMail(String mail);

	List<Guest> findAll();

	void update(long id, Guest client);

	void delete(long id);

	void upgradeToClient(long idGuest);
}
