package com.wha.springmvc.service.adresse.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.adresse.IAdresseDao;
import com.wha.springmvc.model.adresse.Adresse;
import com.wha.springmvc.service.adresse.IAdresseService;

@Service
@Transactional
public class AdresseServiceImpl implements IAdresseService {

	@Autowired
	private IAdresseDao dao;

	@Override
	public long save(Adresse adresse) {
		dao.save(adresse);
		return adresse.getId();
	}

	@Override
	public Adresse findOneById(long id) {
		return dao.findOneById(id);
	}

	@Override
	public List<Adresse> findAll() {
		return dao.findAll();
	}

	@Override
	public void update(long id, Adresse newAdresse) {
		dao.update(id, newAdresse);
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
	}

}
