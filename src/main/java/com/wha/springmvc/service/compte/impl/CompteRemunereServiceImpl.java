package com.wha.springmvc.service.compte.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.compte.ICompteRemunereDao;
import com.wha.springmvc.model.compte.CompteRemunere;
import com.wha.springmvc.service.compte.ICompteRemunereService;

@Service
@Transactional
public class CompteRemunereServiceImpl implements ICompteRemunereService {

	@Autowired
	private ICompteRemunereDao dao;

	@Override
	public void save(CompteRemunere compte) {
		dao.save(compte);
	}

	@Override
	public CompteRemunere findOneById(long id) {
		return dao.findOneById(id);
	}

	@Override
	public List<CompteRemunere> findAll() {
		return dao.findAll();
	}

	@Override
	public void update(long id, CompteRemunere compte) {
		dao.update(id, compte);
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
	}

}
