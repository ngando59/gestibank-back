package com.wha.springmvc.service.demande.oldclient.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.demande.oldclient.IDemandeChequierDao;
import com.wha.springmvc.model.demande.oldclient.DemandeChequier;
import com.wha.springmvc.service.demande.oldclient.IDemandeChequierService;

@Service
@Transactional
public class DemandeChequierService implements IDemandeChequierService {

	@Autowired
	private IDemandeChequierDao dao;

	@Override
	public void save(DemandeChequier demandeClient) {
		dao.save(demandeClient);
	}

	@Override
	public DemandeChequier findOneById(long id) {
		return dao.findOneById(id);
	}

	@Override
	public List<DemandeChequier> findAll() {
		return dao.findAll();
	}

	@Override
	public void update(long id, DemandeChequier demandeClient) {
		dao.update(id, demandeClient);
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
	}

}
