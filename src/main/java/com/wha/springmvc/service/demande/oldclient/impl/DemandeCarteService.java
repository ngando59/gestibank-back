package com.wha.springmvc.service.demande.oldclient.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.demande.oldclient.IDemandeCarteDao;
import com.wha.springmvc.model.demande.oldclient.DemandeCarte;
import com.wha.springmvc.service.demande.oldclient.IDemandeCarteService;

@Service
@Transactional
public class DemandeCarteService implements IDemandeCarteService {

	@Autowired
	private IDemandeCarteDao dao;

	@Override
	public void save(DemandeCarte demandeClient) {
		dao.save(demandeClient);
	}

	@Override
	public DemandeCarte findOneById(long id) {
		return dao.findOneById(id);
	}

	@Override
	public List<DemandeCarte> findAll() {
		return dao.findAll();
	}

	@Override
	public void update(long id, DemandeCarte demandeClient) {
		dao.update(id, demandeClient);
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
	}

}
