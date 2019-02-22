package com.wha.springmvc.dao.user;

import java.util.List;

import com.wha.springmvc.model.user.Client;

public interface IClientDao {
	long save(Client client);

	Client findOneById(long id);

	Client findOneByMail(String mail);

	List<Client> findAll();

	void update(long id, Client client);

	void delete(long id);
}
