package com.wha.springmvc.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.user.IClientDao;
import com.wha.springmvc.model.user.Client;
import com.wha.springmvc.service.user.IClientService;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDao dao;

	@Override
	public long save(Client client) {
		dao.save(client);
		return client.getId();
	}

	@Override
	public Client findOneById(long id) {
		return dao.findOneById(id);
	}

	@Override
	public List<Client> findAll() {
		return dao.findAll();
	}

	@Override
	public void update(long id, Client client) {
		dao.update(id, client);
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
	}

}
