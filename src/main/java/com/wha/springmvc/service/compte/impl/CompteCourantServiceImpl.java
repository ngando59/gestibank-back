package com.wha.springmvc.service.compte.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.compte.ICompteCourantDao;
import com.wha.springmvc.model.compte.CompteCourant;
import com.wha.springmvc.service.compte.ICompteCourantService;

@Service
@Transactional
public class CompteCourantServiceImpl implements ICompteCourantService {

	@Autowired
	private ICompteCourantDao dao;

	@Override
	public void save(CompteCourant compte) {
		dao.save(compte);
	}

	@Override
	public CompteCourant findOneById(long id) {
		return dao.findOneById(id);
	}

	@Override
	public List<CompteCourant> findAll() {
		return dao.findAll();
	}

	@Override
	public void update(long id, CompteCourant compte) {
		dao.update(id, compte);
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
	}

}
