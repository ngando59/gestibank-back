package com.wha.springmvc.service.demande.newclient.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.dao.demande.newclient.IDemandeCreationDeCompteDao;
import com.wha.springmvc.model.demande.newclient.DemandeCreationDeCompte;
import com.wha.springmvc.service.demande.newclient.IDemandeCreationDeCompteService;
import com.wha.springmvc.utils.Commons;

@Service
@Transactional
public class DemandeCresationDeCompteServiceImpl implements IDemandeCreationDeCompteService {

	@Autowired
	private IDemandeCreationDeCompteDao dao;

	@Override
	public long save(DemandeCreationDeCompte demandeCreationDeCompte) {
		dao.save(demandeCreationDeCompte);
		String numero = Commons.generate(10) + demandeCreationDeCompte.getId();
		demandeCreationDeCompte.setNumero(numero);
		return demandeCreationDeCompte.getId();
	}

	@Override
	public DemandeCreationDeCompte findOneById(long id) {
		return dao.findOneById(id);
	}

	@Override
	public List<DemandeCreationDeCompte> findAll() {
		return dao.findAll();
	}

	@Override
	public void update(long id, DemandeCreationDeCompte demandeCreationDeCompte) {
		dao.update(id, demandeCreationDeCompte);
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
	}

}
