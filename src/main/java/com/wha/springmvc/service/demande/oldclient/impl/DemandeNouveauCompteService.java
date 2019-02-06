package com.wha.springmvc.service.demande.oldclient.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.demande.oldclient.IDemandeNouveauCompteDao;
import com.wha.springmvc.model.demande.oldclient.DemandeNouveauCompte;
import com.wha.springmvc.service.demande.oldclient.IDemandeNouveauCompteService;

@Service
@Transactional
public class DemandeNouveauCompteService implements IDemandeNouveauCompteService {
	@Autowired
	private IDemandeNouveauCompteDao dao;

	@Override
	public void save(DemandeNouveauCompte demandeClient) {
		dao.save(demandeClient);
	}

	@Override
	public DemandeNouveauCompte findOneById(long id) {
		return dao.findOneById(id);
	}

	@Override
	public List<DemandeNouveauCompte> findAll() {
		return dao.findAll();
	}

	@Override
	public void update(long id, DemandeNouveauCompte demandeClient) {
		dao.update(id, demandeClient);
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
	}

}
