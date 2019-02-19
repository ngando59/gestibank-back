package com.wha.springmvc.service.user;

import java.util.List;

import com.wha.springmvc.model.user.Client;

public interface IClientService {
	long save(Client client);

	Client findOneById(long id);

	List<Client> findAll();

	void update(long id, Client client);

	void delete(long id);
}
