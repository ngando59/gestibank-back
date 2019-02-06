package com.wha.springmvc.service.demande.newclient.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wha.springmvc.model.demande.newclient.DemandeCreationDeCompte;
import com.wha.springmvc.service.demande.newclient.IDemandeCreationDeCompteService;

@Service
@Transactional
public class DemandeCresationDeCompteServiceImpl implements IDemandeCreationDeCompteService {

	@Override
	public void save(DemandeCreationDeCompte demandeCreationDeCompte) {
		// TODO Auto-generated method stub
	}

	@Override
	public DemandeCreationDeCompte findOneById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DemandeCreationDeCompte> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(long id, DemandeCreationDeCompte demandeCreationDeCompte) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
