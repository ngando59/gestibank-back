package com.wha.springmvc.service.compte.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.compte.ICompteDAO;
import com.wha.springmvc.model.compte.Compte;
import com.wha.springmvc.service.compte.ICompteService;

@Service
@Transactional
public class CompteCourantServiceImpl implements ICompteService {

	@Autowired
	private ICompteDAO dao;

	@Override
	public void save(Compte compte) {
		dao.save(compte);
	}

	@Override
	public Compte findOneById(long id) {
		return dao.findOneById(id);
	}

	@Override
	public List<Compte> findAll() {
		return dao.findAll();
	}

	@Override
	public void update(long id, Compte compte) {
		dao.update(id, compte);
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
	}

}
