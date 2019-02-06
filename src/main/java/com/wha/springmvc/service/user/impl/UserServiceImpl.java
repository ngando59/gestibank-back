package com.wha.springmvc.service.user.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.model.adresse.Adresse;
import com.wha.springmvc.service.adresse.IAdresseService;

@Service
@Transactional
public class UserServiceImpl implements IAdresseService {

	@Override
	public void save(Adresse adresse) {
		// TODO Auto-generated method stub

	}

	@Override
	public Adresse findOneById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Adresse> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(long id, Adresse newAdresse) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
