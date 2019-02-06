package com.wha.springmvc.service.compte.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.model.adresse.Adresse;
import com.wha.springmvc.model.compte.Compte;
import com.wha.springmvc.service.compte.ICompteService;

@Service
@Transactional
public class CompteRemunereServiceImpl implements ICompteService {

	@Override
	public void save(Compte compte) {
		// TODO Auto-generated method stub

	}

	@Override
	public Adresse findOneById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compte> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(long id, Compte compte) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
