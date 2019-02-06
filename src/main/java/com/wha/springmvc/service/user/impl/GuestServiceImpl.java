package com.wha.springmvc.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.user.IGuestDao;
import com.wha.springmvc.model.user.Guest;
import com.wha.springmvc.service.user.IGuestService;

@Service
@Transactional
public class GuestServiceImpl implements IGuestService {

	@Autowired
	private IGuestDao dao;

	@Override
	public void save(Guest guest) {
		dao.save(guest);
	}

	@Override
	public Guest findOneById(long id) {
		return dao.findOneById(id);
	}

	@Override
	public List<Guest> findAll() {
		return dao.findAll();
	}

	@Override
	public void update(long id, Guest guest) {
		dao.update(id, guest);
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
	}

}
